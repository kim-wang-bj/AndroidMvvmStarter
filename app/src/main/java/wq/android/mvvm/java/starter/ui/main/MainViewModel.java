package wq.android.mvvm.java.starter.ui.main;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.core.BaseViewModel;
import wq.android.mvvm.java.starter.data.DataManager;
import wq.android.mvvm.java.starter.network.http.retrofit.RetrofitManager;

/**
 * @author Wang Qi
 */
public class MainViewModel extends BaseViewModel<MainActivityNavigator> {
    private final DataManager mApiService;
    private final RetrofitManager mRetrofitManager;

    @Inject
    public MainViewModel(DataManager dataManager, RetrofitManager retrofitManager) {
        this.mApiService = dataManager;
        this.mRetrofitManager = retrofitManager;
    }
}
