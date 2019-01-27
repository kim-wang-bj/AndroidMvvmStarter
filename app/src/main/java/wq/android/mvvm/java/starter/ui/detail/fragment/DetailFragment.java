package wq.android.mvvm.java.starter.ui.detail.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import wq.android.mvvm.java.starter.R;
import wq.android.mvvm.java.starter.databinding.FragmentDetailBinding;
import wq.android.mvvm.java.starter.ui.base.BaseFragment;

/**
 * @author wangqi
 */
public class DetailFragment extends BaseFragment<FragmentDetailBinding, DetailFragmentViewModel> {

    public static DetailFragment newInstance() {
        Bundle args = new Bundle();
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getViewModel().loadData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_detail;
    }
}
