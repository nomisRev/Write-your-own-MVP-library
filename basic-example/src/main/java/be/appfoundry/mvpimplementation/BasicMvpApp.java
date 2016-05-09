package be.appfoundry.mvpimplementation;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class BasicMvpApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // LeakCanary Impl

    public static void watch(Context context) {
        BasicMvpApp application = (BasicMvpApp) context.getApplicationContext();
        if (application.refWatcher != null) {
            application.refWatcher.watch(context);
        }
    }

    @Nullable
    private RefWatcher refWatcher;
}
