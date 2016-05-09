package be.appfoundry.libexample.lib;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseMvpActivity<P extends BaseMVPContract.BasePresenter> extends AppCompatActivity
    implements BaseMVPContract.BaseMvpView {
    @NonNull private static final Handler MAIN_THREAD_HANDLER = new Handler(Looper.getMainLooper());

    protected P presenter;
    private boolean isAlive;

    protected abstract
    @NonNull
    P createPresenter();

    @Override
    protected void onCreate(@Nullable final Bundle savedState) {
        super.onCreate(savedState);
        presenter = createPresenter();
        //noinspection unchecked
        presenter.attachView(this);
    }

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    protected void runOnUiThreadIfAlive(@NonNull Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper() && isAlive) {
            runnable.run();
        } else {
            MAIN_THREAD_HANDLER.post(() -> {
                if (isAlive) {
                    runnable.run();
                }
            });
        }
    }
}