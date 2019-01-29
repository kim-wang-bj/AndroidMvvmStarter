package wq.android.mvvm.java.starter.core;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

/**
 * @author wangqi
 */
public final class ViewModelPassThroughFactory implements ViewModelProvider.Factory {

    private ViewModel mViewModel;

    private ViewModelPassThroughFactory(ViewModel viewModel) {
        mViewModel = viewModel;
    }

    public final static ViewModelPassThroughFactory newInstance(ViewModel viewModel) {
        return new ViewModelPassThroughFactory(viewModel);
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) mViewModel;
    }
}
