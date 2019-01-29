package wq.android.mvvm.java.starter.ui.detail;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.core.BaseViewModel;

/**
 * @author wangqi
 */
public class DetailViewModel extends BaseViewModel<DetailActivity> {

    private final DetailDataManager mDataManager;

    @Inject
    public DetailViewModel(DetailDataManager dataManager) {
        this.mDataManager = dataManager;
    }

    public void loadDetail() {
        mDataManager.log();
    }
}
