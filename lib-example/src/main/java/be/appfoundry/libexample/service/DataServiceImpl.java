package be.appfoundry.libexample.service;

import android.support.annotation.NonNull;
import be.appfoundry.libexample.model.DataObject;

public class DataServiceImpl implements DataService {

    public static final String MASTER_STRING = "masterString";
    public static final String DETAIL_STRING = "detailString";

    private final DataObject masterObject;
    private final DataObject detailObject;

    public DataServiceImpl() {
        this.masterObject = new DataObject(MASTER_STRING);
        this.detailObject = new DataObject(DETAIL_STRING);
    }

    @NonNull
    @Override
    public DataObject getMasterObject() {
        return masterObject;
    }

    @NonNull
    @Override
    public DataObject getDetailObject() {
        return detailObject;
    }
}