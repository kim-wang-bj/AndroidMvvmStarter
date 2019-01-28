package wq.android.mvvm.java.starter.core;

import android.arch.lifecycle.ViewModel;

import java.lang.ref.WeakReference;

/**
 * @author wangqi
 */
public class BaseViewModel<N> extends ViewModel {

    private WeakReference<N> mNavigator;

    public void setNavigator(N navigator) {
        mNavigator = new WeakReference<>(navigator);
    }

    public N getNavigator() {
        return mNavigator == null ? null : mNavigator.get();
    }
}
