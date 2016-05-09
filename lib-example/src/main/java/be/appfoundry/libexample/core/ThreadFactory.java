package be.appfoundry.libexample.core;

import android.support.annotation.NonNull;

public final class ThreadFactory {

    private ThreadFactory() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public static Thread provideNewThread(Runnable runnable) {
        return new Thread(runnable);
    }
}
