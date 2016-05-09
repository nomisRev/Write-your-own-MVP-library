package be.appfoundry.mvpimplementation.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import be.appfoundry.mvpimplementation.BasicMvpApp;
import be.appfoundry.mvpimplementation.R;
import be.appfoundry.mvpimplementation.core.ThreadFactory;
import be.appfoundry.mvpimplementation.model.DataObject;

public class MainActivity extends AppCompatActivity implements MVPContract.MainView {

    private MVPContract.MainPresenter presenter;
    private TextView dataView;

    @Override
    protected void onCreate(final Bundle savedState) {
        super.onCreate(savedState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter();
        presenter.attachView(this);

        dataView = (TextView) findViewById(R.id.data_view);

        ThreadFactory.provideNewThread(() -> presenter.getData()).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
        BasicMvpApp.watch(this);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // MainView Impl

    @Override
    public void showData(final DataObject dataObject) {
        runOnUiThreadIfAlive(() -> dataView.setText(dataObject.getDataString()));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // All the things on other threads!

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
