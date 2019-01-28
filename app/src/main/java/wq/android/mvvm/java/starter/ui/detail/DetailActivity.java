package wq.android.mvvm.java.starter.ui.detail;

import android.os.Bundle;

import wq.android.mvvm.java.starter.BR;
import wq.android.mvvm.java.starter.R;
import wq.android.mvvm.java.starter.core.BaseActivity;
import wq.android.mvvm.java.starter.databinding.ActivityDetailBinding;
import wq.android.mvvm.java.starter.ui.detail.fragment.DetailFragment;

/**
 * @author wangqi
 */
public class DetailActivity extends BaseActivity<ActivityDetailBinding, DetailViewModel> implements DetailActivityNavigator {

    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
        getViewModel().loadDetail();
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, DetailFragment.newInstance())
                    .commitAllowingStateLoss();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

}
