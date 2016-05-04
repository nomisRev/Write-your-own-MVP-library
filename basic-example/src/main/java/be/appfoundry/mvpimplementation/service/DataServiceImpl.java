package be.appfoundry.mvpimplementation.service;

import android.support.annotation.NonNull;
import be.appfoundry.mvpimplementation.model.DataObject;

public class DataServiceImpl implements DataService {

    private final DataObject dataObject;

    public DataServiceImpl() {
        this.dataObject = new DataObject();
        dataObject.setDataString("Fake dataObject");
    }

    @NonNull
    public DataObject getDataObject() {
        return dataObject;
    }
}
