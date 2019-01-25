package wq.android.mvvm.java.starter.ui.main;

import android.content.Intent;
import android.os.Bundle;

import wq.android.mvvm.java.starter.R;
import wq.android.mvvm.java.starter.databinding.ActivityMainBinding;
import wq.android.mvvm.java.starter.ui.base.BaseActivity;
import wq.android.mvvm.java.starter.ui.detail.DetailActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    protected void onActivityCreated(Bundle savedInstanceState) {
        getBinding().button.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, DetailActivity.class)));
        getViewModel().toString();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}
