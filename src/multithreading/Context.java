package multithreading;

/**
 * Created by daryatretakova on 21.12.16.
 */
public interface Context {
    int getCompletedTaskCount();
    int getFailedTaskCount();
    int getInterruptedTaskCount();
    void interrupt();
    boolean isFinished();
}
