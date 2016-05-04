package be.appfoundry.mvpimplementation.service;

import android.support.annotation.NonNull;
import be.appfoundry.mvpimplementation.model.DataObject;

public interface DataService {
    @NonNull
    DataObject getDataObject();
}
