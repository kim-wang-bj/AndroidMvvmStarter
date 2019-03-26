package wq.android.mvvm.java.starter.data;

import android.annotation.SuppressLint;
import android.util.Log;

import wq.android.mvvm.java.common.dagger.annotation.AppScope;
import wq.android.mvvm.java.starter.network.http.retrofit.RetrofitManager;
import wq.android.mvvm.java.starter.network.http.retrofit.service.LunarCalendarService;

/**
 * @author Wang Qi
 */
@AppScope
public class DataManager {

    @SuppressLint("CheckResult")
    public void loadData() {
        LunarCalendarService service = RetrofitManager.getService(LunarCalendarService.class);
        service.requestLunarDate("2019-03-01").subscribe(response -> {
            response.getData();
        }, throwable -> {
            Log.e("test", throwable.getMessage());
        });
    }
}
