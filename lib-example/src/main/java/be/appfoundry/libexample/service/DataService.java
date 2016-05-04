package be.appfoundry.libexample.service;

import android.support.annotation.NonNull;
import be.appfoundry.libexample.model.DataObject;

public interface DataService {
    @NonNull
    DataObject getMasterObject();

    @NonNull
    DataObject getDetailObject();
}
