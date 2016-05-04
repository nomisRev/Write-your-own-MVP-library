package be.appfoundry.libexample.ui.master;

import be.appfoundry.libexample.model.DataObject;

public class MockMasterView implements MasterMVPContract.MasterView {

    public DataObject dataObject;

    @Override
    public void showData(DataObject dataObject) {
        this.dataObject = dataObject;
    }
}
