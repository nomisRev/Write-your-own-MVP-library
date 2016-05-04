package be.appfoundry.libexample.ui.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;
import be.appfoundry.libexample.R;
import be.appfoundry.libexample.lib.BaseMvpActivity;
import be.appfoundry.libexample.model.DataObject;

public class DetailActivity extends BaseMvpActivity<DetailMVPContract.DetailPresenter>
    implements DetailMVPContract.DetailView {

    private TextView dataView;

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
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getDetailData();
    }

    @Override
    public void showData(final DataObject dataObject) {
        dataView.setText(dataObject.getDataString());
    }

}
