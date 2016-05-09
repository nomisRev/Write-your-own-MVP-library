package be.appfoundry.mvpimplementation.core;

import android.support.annotation.NonNull;

public final class ThreadFactory {

    private ThreadFactory() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public static Thread provideNewThread(Runnable runna) {
        return new Thread(runna);
    }
}
