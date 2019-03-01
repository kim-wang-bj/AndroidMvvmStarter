package wq.android.mvvm.java.starter.network.http.retrofit;

import android.util.ArrayMap;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.dagger.annotation.scope.AppScope;
import wq.android.mvvm.java.starter.network.http.retrofit.service.OkayApiService;
import wq.android.mvvm.java.starter.network.http.retrofit.service.OpenWeatherService;

/**
 * @author Wang Qi
 */
@AppScope
public class RetrofitManager {

    private static final ArrayMap<Class<?>, Object> mServiceCache = new ArrayMap<>();
    private static final ArrayMap<Class<?>, String> mBaseUrlMap = new ArrayMap<>();

    static {
        mBaseUrlMap.put(OpenWeatherService.class, "https://api.openweathermap.org/data/2.5/");
        mBaseUrlMap.put(OkayApiService.class, "http://hb9.api.okayapi.com/");
    }

    @Inject
    public RetrofitManager() {
    }

    public <T> T getService(Class<T> clazz) {
        Object service = mServiceCache.get(clazz);
        if (service == null) {
            service = RetrofitFactory.get(mBaseUrlMap.get(clazz)).create(clazz);
            mServiceCache.put(clazz, service);
        }
        return (T) service;
    }

}
