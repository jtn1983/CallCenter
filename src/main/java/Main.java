public class Main {
    public static final int CALL_CENTER_CAPACITY = 6;
    public static final int CALL_INTERRUPT = 1000;
    public static final int HANDLE_INTERRUPT = 3000;

    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter(CALL_CENTER_CAPACITY, CALL_INTERRUPT, HANDLE_INTERRUPT);
        Thread genCall = new Thread(null, callCenter::generateCall);
        Thread handleCall = new Thread(null, callCenter::handleCall);

        genCall.start();
        handleCall.start();
    }
}
