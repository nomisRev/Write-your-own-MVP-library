package be.appfoundry.mvpimplementation.ui;

import be.appfoundry.mvpimplementation.service.DataService;
import be.appfoundry.mvpimplementation.service.ServiceFactory;
import be.appfoundry.mvpimplementation.ui.MVPContract.MainPresenter;
import be.appfoundry.mvpimplementation.ui.MVPContract.MainView;

public class MainPresenterImpl implements MainPresenter {

    private MainView view;
    private final DataService dataService;

    public MainPresenterImpl() {
        dataService = ServiceFactory.provideDataService();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private boolean isViewAttached() {
        return view != null;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // MainPresenter Impl

    @Override
    public void getData() {
        if (isViewAttached()) {
            view.showData(dataService.getDataObject());
        }
    }

    @Override
    public void attachView(final MainView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }
}
