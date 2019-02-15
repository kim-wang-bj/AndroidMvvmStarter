package wq.android.mvvm.java.starter.data;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.di.annotation.scope.AppScope;

/**
 * @author Wang Qi
 */
@AppScope
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
