package wq.android.mvvm.java.starter.ui.detail;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.core.BaseViewModel;
import wq.android.mvvm.java.starter.data.ApiService;

/**
 * @author wangqi
 */
public class DetailViewModel extends BaseViewModel<DetailActivity> {

    private final ApiService mApiService;

    @Inject
    public DetailViewModel(ApiService apiService) {
        this.mApiService = apiService;
    }

    public void loadDetail() {
        mApiService.loadData();
    }
}
