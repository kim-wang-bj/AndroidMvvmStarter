package wq.android.mvvm.java.starter.ui.main;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.data.ApiService;
import wq.android.mvvm.java.starter.ui.base.BaseViewModel;

public class MainViewModel extends BaseViewModel {
    private final ApiService apiService;

    @Inject
    public MainViewModel(ApiService apiService) {
        this.apiService = apiService;
    }
}
