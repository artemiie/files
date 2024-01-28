/**
 * Correct lazy initialization
 */
public class Singleton {
    private static class SingletonHolder {
        public static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    private Singleton;
}

/**
 * Lazy Thread Safe Singleton for interview
 */

public class Singleton {
    private static volatile Singleton instance;
    private static final Object lock = new Object();

    public static Singleton getInstance() {
        Singleton result = instance;
        if (result != null) {
            return result;
        }

        synchronized (lock) {
            if (instance == null) {
                return instance = new Singleton();
            }
            return instance;
        }
    }
}