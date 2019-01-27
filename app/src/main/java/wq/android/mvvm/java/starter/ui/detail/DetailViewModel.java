package wq.android.mvvm.java.starter.ui.detail;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.data.ApiService;
import wq.android.mvvm.java.starter.ui.base.BaseViewModel;

/**
 * @author wangqi
 */
public class DetailViewModel extends BaseViewModel {

    private final ApiService apiService;

    @Inject
    public DetailViewModel(ApiService apiService) {
        this.apiService = apiService;
    }

    public void loadDetail() {
        apiService.loadData();
    }
}
