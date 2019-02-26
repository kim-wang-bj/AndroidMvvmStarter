package wq.android.mvvm.java.starter.network.retrofit;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.di.annotation.scope.AppScope;

/**
 * @author Wang Qi
 */
@AppScope
public class RetrofitManager {

    @Inject
    public RetrofitManager() {
        RetrofitFactory.get("http://baidu.com");
    }

}
