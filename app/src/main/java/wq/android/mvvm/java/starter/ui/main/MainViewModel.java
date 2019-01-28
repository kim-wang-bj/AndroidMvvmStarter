package wq.android.mvvm.java.starter.ui.main;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.core.BaseViewModel;
import wq.android.mvvm.java.starter.data.ApiService;

/**
 * @author wangqi
 */
public class MainViewModel extends BaseViewModel<MainActivityNavigator> {
    private final ApiService mApiService;

    @Inject
    public MainViewModel(ApiService mApiService) {
        this.mApiService = mApiService;
    }
}
