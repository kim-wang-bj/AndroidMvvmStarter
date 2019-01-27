package wq.android.mvvm.java.starter.ui.base;

import android.arch.lifecycle.ViewModel;
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
public abstract class BaseActivity<B extends ViewDataBinding, VM extends ViewModel> extends DaggerAppCompatActivity {

    private B binding;

    @Inject
    VM viewModel;

    @Override
    final protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        onActivityCreated(savedInstanceState);
    }

    protected abstract void onActivityCreated(Bundle savedInstanceState);

    @LayoutRes
    protected abstract int getLayoutId();

    protected B getBinding() {
        return binding;
    }

    protected VM getViewModel() {
        return viewModel;
    }
}
