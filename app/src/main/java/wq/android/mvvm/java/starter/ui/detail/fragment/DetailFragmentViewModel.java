package wq.android.mvvm.java.starter.ui.detail.fragment;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import wq.android.mvvm.java.starter.R;
import wq.android.mvvm.java.starter.core.BaseViewModel;
import wq.android.mvvm.java.starter.di.annotation.scope.FragmentScope;
import wq.android.mvvm.java.starter.ui.detail.DetailDataManager;

/**
 * @author Wang Qi
 */
@FragmentScope
public class DetailFragmentViewModel extends BaseViewModel<DetailFragmentNavigator> implements View.OnClickListener {

    private final DetailDataManager mDataManager;
    private MutableLiveData<String> mCurrentTime = new MutableLiveData<>();
    private DateFormat mDataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Inject
    public DetailFragmentViewModel(DetailDataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    public void loadData() {
        mDataManager.loadData();
        mCurrentTime.postValue(mDataFormat.format(new Date()));
        getCompositeDisposable().add(Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(c -> mCurrentTime.postValue(mDataFormat.format(new Date()))));
    }

    public LiveData<String> getCurrentTime() {
        return mCurrentTime;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_close:
                getNavigator().finishActivity();
                break;
            default:
        }
    }
}
