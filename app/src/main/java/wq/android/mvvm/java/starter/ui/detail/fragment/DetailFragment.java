package wq.android.mvvm.java.starter.ui.detail.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;

import wq.android.mvvm.java.starter.BR;
import wq.android.mvvm.java.starter.R;
import wq.android.mvvm.java.starter.core.BaseFragment;
import wq.android.mvvm.java.starter.databinding.FragmentDetailBinding;

/**
 * @author Wang Qi
 */
public class DetailFragment
        extends BaseFragment<FragmentDetailBinding, DetailFragmentViewModel>
        implements DetailFragmentNavigator {

    public static DetailFragment newInstance() {
        Bundle args = new Bundle();
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getViewModel().loadData();
        getBinding().button.setOnClickListener(v -> getViewModel().handleCloseEvent());
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_detail;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public void finishActivity() {
        getActivity().finish();
    }
}
