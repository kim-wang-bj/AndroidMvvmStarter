package wq.android.mvvm.java.starter.ui.detail;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.core.BaseViewModel;
import wq.android.mvvm.java.starter.data.DataManager;

/**
 * @author wangqi
 */
public class DetailViewModel extends BaseViewModel<DetailActivity> {

    private final DataManager mDataManager;

    @Inject
    public DetailViewModel(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    public void loadDetail() {
        mDataManager.loadData();
    }
}
