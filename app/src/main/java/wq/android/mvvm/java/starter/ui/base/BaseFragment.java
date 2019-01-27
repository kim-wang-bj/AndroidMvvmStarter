package wq.android.mvvm.java.starter.ui.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * @author wangqi
 */
public abstract class BaseFragment<B extends ViewDataBinding, VM extends ViewModel> extends DaggerFragment {
    private B binding;

    @Inject
    VM viewModel;

    @Nullable
    @Override
    public final View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return binding.getRoot();
    }

    @LayoutRes
    public abstract int getLayoutId();

    public B getBinding() {
        return binding;
    }

    public VM getViewModel() {
        return viewModel;
    }
}
