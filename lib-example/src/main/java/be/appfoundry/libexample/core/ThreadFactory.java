package be.appfoundry.libexample.core;

import android.support.annotation.NonNull;

public class ThreadFactory {

    private ThreadFactory() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public static Thread provideNewThread(Runnable r) {
        return new Thread(r);
    }
}
