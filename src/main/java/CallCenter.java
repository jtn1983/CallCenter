import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;

public class CallCenter {
    private int callCenterCapacity;
    private int callInterrupt;
    private int handleInterrupt;

    public CallCenter(int callCenterCapacity, int callInterrupt, int handleInterrupt) {
        this.callCenterCapacity = callCenterCapacity;
        this.callInterrupt = callInterrupt;
        this.handleInterrupt = handleInterrupt;
    }

    public Comparator<Call> comparator = new Comparator<Call>() {
        @Override
        public int compare(Call o1, Call o2) {
            return (o1.getCallDate().compareTo(o2.getCallDate()));
        }
    };

    private final PriorityBlockingQueue<Call> calls = new PriorityBlockingQueue<>(1, comparator);

    public void generateCall() {
        for (int i = 0; i < callCenterCapacity; i++) {
            Call newCall = new Call(new Date());
            calls.add(newCall);
            System.out.println("Поступил звонок " + newCall.getCallDate());
            try {
                Thread.sleep(callInterrupt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleCall() {
        while (true) {
            System.out.println("Сейчас в очереди " + calls.size() + " звонков");
            try {
                Thread.sleep(handleInterrupt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (calls.isEmpty()) {
                break;
            }
            System.out.println("Звонок, поступивший " + calls.poll().getCallDate() + " обработан");
        }
    }
}
