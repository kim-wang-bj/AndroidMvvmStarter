package wq.android.mvvm.java.starter.ui.detail.fragment;

import android.util.Log;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.core.BaseViewModel;
import wq.android.mvvm.java.starter.data.DataManager;

/**
 * @author wangqi
 */
public class DetailFragmentViewModel extends BaseViewModel<DetailFragmentNavigator> {

    private final DataManager mDataManager;

    @Inject
    public DetailFragmentViewModel(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    public void loadData() {
        mDataManager.loadData();
        Log.d("test", this.getClass().getSimpleName() + ": " + this.hashCode() +
                " DataManager: " + mDataManager.hashCode());
    }

    public void handleCloseEvent() {
        getNavigator().close();
    }
}
