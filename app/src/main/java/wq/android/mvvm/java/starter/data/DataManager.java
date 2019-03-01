package wq.android.mvvm.java.starter.data;

import android.annotation.SuppressLint;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.dagger.annotation.scope.AppScope;
import wq.android.mvvm.java.starter.network.http.retrofit.RetrofitManager;
import wq.android.mvvm.java.starter.network.http.retrofit.service.OkayApiService;

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
        OkayApiService okayapiService = mRetrofitManager.getService(OkayApiService.class);
        okayapiService.request("App.Hello.World", "35683338D9CBB2AFF90EE700202D5E90", "F26BBF055EDFAD7472402C61613F1970", "aaa")
                .subscribe(response -> response.getData(),
                        throwable -> throwable.getMessage());
    }
}
