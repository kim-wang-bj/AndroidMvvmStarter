package wq.android.mvvm.java.starter.core;

import androidx.lifecycle.ViewModel;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author wangqi
 */
public abstract class BaseViewModel<N> extends ViewModel {

    private WeakReference<N> mNavigator;
    private CompositeDisposable mCompositeDisposable;


    public final void init(N navigator) {
        mCompositeDisposable = new CompositeDisposable();
        mNavigator = new WeakReference<>(navigator);
    }

    public N getNavigator() {
        return mNavigator == null ? null : mNavigator.get();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    @Override
    protected void onCleared() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }
}
