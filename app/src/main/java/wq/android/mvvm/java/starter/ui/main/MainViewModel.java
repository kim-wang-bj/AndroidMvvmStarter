package wq.android.mvvm.java.starter.ui.main;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.core.BaseViewModel;
import wq.android.mvvm.java.starter.data.DataManager;

/**
 * @author Wang Qi
 */
public class MainViewModel extends BaseViewModel<MainActivityNavigator> {
    private final DataManager mApiService;

    @Inject
    public MainViewModel(DataManager dataManager) {
        this.mApiService = dataManager;
    }
}
