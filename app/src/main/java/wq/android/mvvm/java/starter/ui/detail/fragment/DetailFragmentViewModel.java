package wq.android.mvvm.java.starter.ui.detail.fragment;

import android.util.Log;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.data.DataManager;
import wq.android.mvvm.java.starter.ui.base.BaseViewModel;

/**
 * @author wangqi
 */
public class DetailFragmentViewModel extends BaseViewModel {

    private final DataManager dataManager;

    @Inject
    public DetailFragmentViewModel(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void loadData() {
        dataManager.loadData();
        Log.d("test", this.getClass().getSimpleName() + ": " + this.hashCode() +
                " DataManager: " + dataManager.hashCode());
    }
}
