package wq.android.mvvm.java.starter.core.base;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

/**
 * @author Wang Qi
 */
final class ViewModelPassThroughFactory implements ViewModelProvider.Factory {

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
