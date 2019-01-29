package wq.android.mvvm.java.starter.ui.detail.fragment;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import wq.android.mvvm.java.starter.core.BaseViewModel;
import wq.android.mvvm.java.starter.data.DataManager;

/**
 * @author wangqi
 */
public class DetailFragmentViewModel extends BaseViewModel<DetailFragmentNavigator> {

    private final DataManager mDataManager;
    private MutableLiveData<String> mCurrentTime = new MutableLiveData<>();
    private DateFormat mDataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Inject
    public DetailFragmentViewModel(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    public void loadData() {
        mDataManager.loadData();
        mCurrentTime.postValue(mDataFormat.format(new Date()));
        getCompositeDisposable().add(Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(c -> mCurrentTime.postValue(mDataFormat.format(new Date()))));
    }

    public void handleCloseEvent() {
        getNavigator().finishActivity();
    }

    public LiveData<String> getCurrentTime() {
        return mCurrentTime;
    }
}
