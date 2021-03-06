package wq.android.mvvm.java.starter.ui.detail;

import javax.inject.Inject;

import wq.android.mvvm.java.common.dagger.annotation.ActivityScope;
import wq.android.mvvm.java.starter.core.base.BaseViewModel;

/**
 * @author Wang Qi
 */
@ActivityScope
public class DetailViewModel extends BaseViewModel<DetailActivity> {

    private final DetailDataManager mDataManager;

    @Inject
    public DetailViewModel(DetailDataManager dataManager) {
        this.mDataManager = dataManager;
    }

    public void loadDetail() {
        //mDataManager.loadData();
    }
}
