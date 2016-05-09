package be.appfoundry.libexample.lib;

public interface BaseMVPContract {
    interface BaseMvpView { }

    interface BasePresenter<V extends BaseMvpView> {
        void attachView(V view);

        void detachView();
    }
}
