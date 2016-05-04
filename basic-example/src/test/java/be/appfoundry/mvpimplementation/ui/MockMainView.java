package be.appfoundry.mvpimplementation.ui;

import be.appfoundry.mvpimplementation.model.DataObject;
import be.appfoundry.mvpimplementation.ui.MVPContract.MainView;

public class MockMainView implements MainView {

    public DataObject dataObject;

    @Override
    public void showData(DataObject dataObject) {
        this.dataObject = dataObject;
    }
}
