package be.appfoundry.mvpimplementation.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import be.appfoundry.mvpimplementation.R;
import be.appfoundry.mvpimplementation.model.DataObject;

public class MainActivity extends AppCompatActivity implements MVPContract.MainView {

    private MVPContract.MainPresenter presenter;
    private TextView dataView;

    @Override
    protected void onCreate(final Bundle savedState) {
        super.onCreate(savedState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenterImpl();
        presenter.attachView(this);

        dataView = (TextView) findViewById(R.id.data_view);
        presenter.getData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // MainView Impl

    @Override
    public void showData(final DataObject dataObject) {
        dataView.setText(dataObject.getDataString());
    }
}
