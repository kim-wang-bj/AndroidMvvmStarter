package wq.android.mvvm.java.starter.data;

import android.annotation.SuppressLint;
import android.util.Log;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.dagger.annotation.scope.AppScope;
import wq.android.mvvm.java.starter.network.http.retrofit.RetrofitManager;
import wq.android.mvvm.java.starter.network.http.retrofit.service.LunarCalendarService;

/**
 * @author Wang Qi
 */
@AppScope
public class DataManager {

    private RetrofitManager mRetrofitManager;

    @Inject
    public DataManager(RetrofitManager retrofitManager) {
        this.mRetrofitManager = retrofitManager;
    }

    @SuppressLint("CheckResult")
    public void loadData() {
        LunarCalendarService service = mRetrofitManager.getService(LunarCalendarService.class);
        service.requestLunarDate("2019-03-01").subscribe(response -> {
            response.getData();
        }, throwable -> {
            Log.e("test", throwable.getMessage());
        });
    }
}
