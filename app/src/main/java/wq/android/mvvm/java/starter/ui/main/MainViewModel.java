package wq.android.mvvm.java.starter.ui.main;

import javax.inject.Inject;

import wq.android.mvvm.java.common.network.retrofit.RetrofitManager;
import wq.android.mvvm.java.starter.core.base.BaseViewModel;
import wq.android.mvvm.java.starter.data.DataManager;

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
