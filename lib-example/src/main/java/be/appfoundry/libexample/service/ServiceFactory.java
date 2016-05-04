package be.appfoundry.libexample.service;

import android.support.annotation.NonNull;

public final class ServiceFactory {
    private static DataService dataService;

    private ServiceFactory() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public static synchronized DataService provideDataService() {
        if (dataService == null) {
            dataService = new DataServiceImpl();
        }
        return dataService;
    }
}
