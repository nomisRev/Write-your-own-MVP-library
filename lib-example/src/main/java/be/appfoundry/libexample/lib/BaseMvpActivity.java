package be.appfoundry.libexample.lib;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseMvpActivity<P extends BaseMVPContract.BasePresenter> extends AppCompatActivity
    implements BaseMVPContract.BaseMvpView {

    protected P presenter;

    protected abstract
    @NonNull
    P createPresenter();

    @Override
    protected void onCreate(@Nullable final Bundle savedState) {
        super.onCreate(savedState);
        presenter = createPresenter();
        //noinspection unchecked
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}