package be.appfoundry.libexample.lib;

public abstract class BasePresenter<V extends BaseMVPContract.BaseMvpView>
    implements BaseMVPContract.BasePresenter<V> {

    protected V view;

    protected boolean isViewAttached() {
        return view != null;
    }

    @Override
    public void attachView(final V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }
}