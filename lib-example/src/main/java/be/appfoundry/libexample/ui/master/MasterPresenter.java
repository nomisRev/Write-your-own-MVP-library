package be.appfoundry.libexample.ui.master;

import be.appfoundry.libexample.lib.BasePresenter;
import be.appfoundry.libexample.service.DataService;
import be.appfoundry.libexample.service.ServiceFactory;

public class MasterPresenter extends BasePresenter<MasterMVPContract.MasterView>
    implements MasterMVPContract.MasterPresenter {

    private final DataService dataService;

    MasterPresenter() {
        dataService = ServiceFactory.provideDataService();
    }

    @Override
    public void getData() {
        if (isViewAttached()) {
            view.showData(dataService.getMasterObject());
        }
    }
}
