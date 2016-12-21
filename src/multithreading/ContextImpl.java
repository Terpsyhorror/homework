package multithreading;

/**
 * Created by daryatretakova on 22.12.16.
 */
public class ContextImpl implements Context {

    private volatile Integer completedCount;
    private volatile Integer size;
    private volatile Integer isInterrupted;
    private volatile Integer failedCount;

    public ContextImpl(Integer completedCount, Integer size, Integer isInterrupted, Integer failedCount) {
        this.completedCount = completedCount;
        this.size = size;
        this.isInterrupted = isInterrupted;
        this.failedCount = failedCount;
    }

    @Override
    public int getCompletedTaskCount() {
        return completedCount;
    }

    @Override
    public int getFailedTaskCount() {
        return failedCount;
    }

    @Override
    public int getInterruptedTaskCount() {
        return size - completedCount - failedCount;
    }

    @Override
    public void interrupt() {
        synchronized (ExecutionManager.class) {
            isInterrupted = 1;
        }
    }

    @Override
    public boolean isFinished() {
        return size == completedCount + failedCount;
    }
}
