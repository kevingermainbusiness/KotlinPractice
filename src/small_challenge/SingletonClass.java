package small_challenge;

public class SingletonClass {

    private static SingletonClass INSTANCE;

    private SingletonClass() {
    }

    public static SingletonClass getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonClass.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonClass();
                }
            }
        }
        return INSTANCE;
    }
}
