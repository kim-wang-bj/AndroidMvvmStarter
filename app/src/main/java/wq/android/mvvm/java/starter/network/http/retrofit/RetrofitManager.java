package wq.android.mvvm.java.starter.network.http.retrofit;

import android.util.ArrayMap;

import java.util.Map;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.dagger.annotation.scope.AppScope;

/**
 * @author Wang Qi
 */
@AppScope
public class RetrofitManager {

    private static final Map<Class<?>, Object> mServiceCache = new ArrayMap<>(0);

    @Inject
    public RetrofitManager() {
    }

    public <T> T getService(Class<T> clazz) {
        Object service = mServiceCache.get(clazz);
        if (service == null) {
            service = RetrofitFactory.get(RetrofitConfig.serviceUrlMap().get(clazz)).create(clazz);
            mServiceCache.put(clazz, service);
        }
        return (T) service;
    }

}
