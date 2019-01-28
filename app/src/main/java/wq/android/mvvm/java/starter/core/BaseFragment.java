package wq.android.mvvm.java.starter.core;

import android.content.Context;
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
public abstract class BaseFragment<B extends ViewDataBinding, VM extends BaseViewModel> extends DaggerFragment {
    private B mBinding;

    @Inject
    VM mViewModel;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mViewModel.setNavigator(this);
    }

    @Nullable
    @Override
    public final View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mBinding.setVariable(getBindingVariable(), mViewModel);
        return mBinding.getRoot();
    }

    @LayoutRes
    public abstract int getLayoutId();

    public abstract int getBindingVariable();

    public B getBinding() {
        return mBinding;
    }

    public VM getViewModel() {
        return mViewModel;
    }
}