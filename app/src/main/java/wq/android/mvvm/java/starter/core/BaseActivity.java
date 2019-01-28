package wq.android.mvvm.java.starter.core;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * @author wangqi
 */
public abstract class BaseActivity<B extends ViewDataBinding, VM extends BaseViewModel> extends DaggerAppCompatActivity {

    private B mBinding;

    @Inject
    VM mViewModel;

    @Override
    final protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mBinding.setVariable(getBindingVariable(), mViewModel);
        mViewModel.setNavigator(this);
        onActivityCreated(savedInstanceState);
    }

    protected abstract void onActivityCreated(Bundle savedInstanceState);

    @LayoutRes
    protected abstract int getLayoutId();

    public abstract int getBindingVariable();

    protected B getBinding() {
        return mBinding;
    }

    protected VM getViewModel() {
        return mViewModel;
    }
}