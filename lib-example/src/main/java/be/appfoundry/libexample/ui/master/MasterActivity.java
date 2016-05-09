package be.appfoundry.libexample.ui.master;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;
import be.appfoundry.libexample.R;
import be.appfoundry.libexample.core.ThreadFactory;
import be.appfoundry.libexample.lib.BaseMvpActivity;
import be.appfoundry.libexample.model.DataObject;
import be.appfoundry.libexample.ui.detail.DetailActivity;

public class MasterActivity extends BaseMvpActivity<MasterMVPContract.MasterPresenter>
    implements MasterMVPContract.MasterView {

    private TextView dataView;

    @Override
    @NonNull
    protected MasterMVPContract.MasterPresenter createPresenter() {
        return new MasterPresenterImpl();
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedState) {
        super.onCreate(savedState);
        setContentView(R.layout.master_activity);
        dataView = (TextView) findViewById(R.id.data_view);

        initButton();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ThreadFactory.provideNewThread(() -> presenter.getData()).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initButton() {
        final Button detailButton = (Button) findViewById(R.id.detail_button);
        //noinspection ConstantConditions
        detailButton.setOnClickListener(v -> launchDetailActivity());
    }

    private void launchDetailActivity() {
        final Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void showData(final DataObject dataObject) {
        runOnUiThreadIfAlive(() -> dataView.setText(dataObject.getDataString()));
    }
}
