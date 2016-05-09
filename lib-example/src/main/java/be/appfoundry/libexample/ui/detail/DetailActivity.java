package be.appfoundry.libexample.ui.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import be.appfoundry.libexample.R;
import be.appfoundry.libexample.core.ThreadFactory;
import be.appfoundry.libexample.lib.BaseMvpActivity;
import be.appfoundry.libexample.model.DataObject;

public class DetailActivity extends BaseMvpActivity<DetailMVPContract.DetailPresenter>
    implements DetailMVPContract.DetailView {

    private TextView dataView;
    private LinearLayout contentView;

    @NonNull
    @Override
    protected DetailMVPContract.DetailPresenter createPresenter() {
        return new DetailPresenterImpl();
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedState) {
        super.onCreate(savedState);
        setContentView(R.layout.detail_activity);
        dataView = (TextView) findViewById(R.id.data_view);
        contentView = (LinearLayout) findViewById(R.id.content_view);

        initButton();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ThreadFactory.provideNewThread(() -> presenter.getDetailData()).start();
    }

    private void initButton() {
        final Button showSnackbarButton = (Button) findViewById(R.id.show_snackbar);
        //noinspection ConstantConditions

        showSnackbarButton.setOnClickListener(v -> showSnackbar());
    }

    private void showSnackbar() {
        runOnUiThreadIfAlive(
            () -> Snackbar.make(contentView, "Snackbar shown", Snackbar.LENGTH_LONG).show());
    }

    @Override
    public void showData(final DataObject dataObject) {
        runOnUiThreadIfAlive(() -> dataView.setText(dataObject.getDataString()));
    }
}
