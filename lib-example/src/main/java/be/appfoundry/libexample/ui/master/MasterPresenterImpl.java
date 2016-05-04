package be.appfoundry.libexample.ui.master;

import be.appfoundry.libexample.lib.BasePresenter;
import be.appfoundry.libexample.service.DataService;
import be.appfoundry.libexample.service.ServiceFactory;

public class MasterPresenterImpl extends BasePresenter<MasterMVPContract.MasterView>
    implements MasterMVPContract.MasterPresenter {

    private final DataService dataService;

    MasterPresenterImpl() {
        dataService = ServiceFactory.provideDataService();
    }

    @Override
    public void getData() {
        if (isViewAttached()) {
            view.showData(dataService.getMasterObject());
        }
    }
}
