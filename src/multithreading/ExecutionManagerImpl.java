package multithreading;

/**
 * Created by daryatretakova on 22.12.16.
 */
public class ExecutionManagerImpl implements ExecutionManager {

    private volatile Integer isInterrupted;
    private volatile Integer completedCount;
    private volatile Integer failedCount;

    public ExecutionManagerImpl() {
        isInterrupted = 0;
        completedCount = 0;
        failedCount = 0;
    }

    @Override
    public Context execute(Runnable callback, Runnable... tasks) {
        for (Runnable runnable : tasks) {
            if (isInterrupted == 0) {
                Thread thread = new Thread(new RunnableWithCounter(completedCount, failedCount, runnable));
                thread.start();
            }
        }
        return new ContextImpl(completedCount, tasks.length, isInterrupted, failedCount);
    }
}
