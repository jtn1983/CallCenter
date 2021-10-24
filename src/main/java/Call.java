import java.util.Date;

public class Call {
    private Date callTime;

    public Call(Date callTime) {
        this.callTime = callTime;
    }

    public Date getCallDate() {
        return callTime;
    }

    @Override
    public String toString() {
        return "Call{" +
                "callId=" + callTime +
                '}';
    }
}
