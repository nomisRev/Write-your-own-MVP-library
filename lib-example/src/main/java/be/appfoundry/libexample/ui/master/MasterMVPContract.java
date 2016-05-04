package be.appfoundry.libexample.ui.master;

import be.appfoundry.libexample.lib.BaseMVPContract;
import be.appfoundry.libexample.model.DataObject;

public interface MasterMVPContract {
    interface MasterView extends BaseMVPContract.BaseMvpView {
        void showData(DataObject dataObject);
    }

    interface MasterPresenter extends BaseMVPContract.BasePresenter<MasterView> {
        void getData();
    }
}
