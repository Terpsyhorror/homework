package multithreading;

/**
 * Created by daryatretakova on 22.12.16.
 */
public class RunnableWithCounter implements Runnable{
    private volatile Integer completedCount;
    private  volatile Runnable runnable;
    private  volatile Integer failedCount;

    public RunnableWithCounter(Integer integer, Integer failedCount, Runnable runnable) {
        this.completedCount = integer;
        this.runnable = runnable;
        this.failedCount = failedCount;
    }

    @Override
    public void run() {
        try {
            runnable.run();
            synchronized (ExecutionManager.class) {
                completedCount += 1;
            }
        }
        catch (Exception e) {
            synchronized (ExecutionManager.class) {
                failedCount += 1;
            }
        }

    }
}
