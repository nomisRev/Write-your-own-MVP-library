package be.appfoundry.mvpimplementation.ui;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @NonNull private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());

    private boolean isAlive;

    //Don't change the views on the main thread before onResume or after onPause()
    @Override
    protected void onResume() {
        super.onResume();
        isAlive = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isAlive = false;
    }

    protected boolean isAlive(){
        return isAlive;
    }

    protected void runOnUiThreadIfAlive(@NonNull final Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper() && isAlive) {
            runnable.run();
        } else {
            MAIN_HANDLER.post(() -> {
                if (isAlive) {
                    runnable.run();
                }
            });
        }
    }
}
