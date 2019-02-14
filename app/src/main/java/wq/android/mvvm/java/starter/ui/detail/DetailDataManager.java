package wq.android.mvvm.java.starter.ui.detail;

import android.util.Log;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.data.DataManager;
import wq.android.mvvm.java.starter.di.annotation.scope.ActivityScope;

/**
 * @author wangqi
 */
@ActivityScope
public class DetailDataManager {


    private final DataManager mDataManager;

    @Inject
    public DetailDataManager(DataManager dataManager) {
        mDataManager = dataManager;
        Log.i("test", mDataManager.toString());
        Log.i("test", this.toString());
    }

    public void loadData() {
        mDataManager.loadData();
    }

}
