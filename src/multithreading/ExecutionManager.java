package multithreading;

/**
 * Created by daryatretakova on 21.12.16.
 */
public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}
