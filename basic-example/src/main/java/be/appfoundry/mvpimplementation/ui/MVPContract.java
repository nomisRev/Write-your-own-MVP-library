package be.appfoundry.mvpimplementation.ui;

import be.appfoundry.mvpimplementation.model.DataObject;

public interface MVPContract {
    interface MainView {
        void showData(DataObject dataObject);
    }

    interface MainPresenter {
        void getData();
        void attachView(MainView view);
        void detachView();
    }
}
