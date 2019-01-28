package wq.android.mvvm.java.starter.data;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author wangqi
 */
@Singleton
public class DataManager {
    private final ApiService mApiService;

    @Inject
    public DataManager(ApiService mApiService) {
        this.mApiService = mApiService;
    }

    public void loadData() {
        mApiService.loadData();
    }
}
