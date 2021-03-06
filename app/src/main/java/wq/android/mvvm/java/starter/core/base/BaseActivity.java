package wq.android.mvvm.java.starter.core.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import wq.android.mvvm.java.common.dagger.annotation.ActivityScope;

/**
 * @author Wang Qi
 */
public abstract class BaseActivity<B extends ViewDataBinding, VM extends BaseViewModel> extends DaggerAppCompatActivity {

    private B mBinding;

    @Inject
    @ActivityScope
    VM mViewModel;

    @Override
    final protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mBinding.setVariable(getBindingVariable(), mViewModel);
        mBinding.setLifecycleOwner(this);
        mViewModel.init(this);
        ViewModelProviders.of(this, ViewModelPassThroughFactory.newInstance(mViewModel))
                .get(mViewModel.getClass().getName(), mViewModel.getClass());
        onActivityCreated(savedInstanceState);
    }

    /**
     * Called after onCreate()
     *
     * @param savedInstanceState
     */
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
