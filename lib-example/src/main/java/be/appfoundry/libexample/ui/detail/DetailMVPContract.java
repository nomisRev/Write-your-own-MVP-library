package be.appfoundry.libexample.ui.detail;

import be.appfoundry.libexample.lib.BaseMVPContract;
import be.appfoundry.libexample.model.DataObject;

public interface DetailMVPContract {
    interface DetailView extends BaseMVPContract.BaseMvpView {
        void showData(DataObject dataObject);
    }
    interface DetailPresenter extends BaseMVPContract.BasePresenter<DetailView> {
        void getDetailData();
    }
}
