package wq.android.mvvm.java.starter.ui.detail;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.data.ApiService;
import wq.android.mvvm.java.starter.ui.base.BaseViewModel;

public class DetailViewModel extends BaseViewModel {

    ApiService apiService;

    @Inject
    public DetailViewModel(ApiService apiService) {
        this.apiService = apiService;
    }

    public void loadDetail() {
        apiService.loadData();
    }
}
