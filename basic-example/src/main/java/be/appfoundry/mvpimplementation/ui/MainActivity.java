package be.appfoundry.mvpimplementation.ui;

import android.os.Bundle;
import android.widget.TextView;
import be.appfoundry.mvpimplementation.BasicMvpApp;
import be.appfoundry.mvpimplementation.R;
import be.appfoundry.mvpimplementation.core.ThreadFactory;
import be.appfoundry.mvpimplementation.model.DataObject;

public class MainActivity extends BaseActivity implements MVPContract.MainView {

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
}
