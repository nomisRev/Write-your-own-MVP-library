package be.appfoundry.libexample.ui.detail;

import be.appfoundry.libexample.model.DataObject;

public class MockDetailView implements DetailMVPContract.DetailView{
    public DataObject dataObject;

    @Override
    public void showData(DataObject dataObject) {
        this.dataObject = dataObject;
    }
}
