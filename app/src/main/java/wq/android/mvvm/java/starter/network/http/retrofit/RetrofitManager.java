package wq.android.mvvm.java.starter.network.http.retrofit;

import android.util.ArrayMap;

import java.util.Map;

import javax.inject.Inject;

import wq.android.mvvm.java.starter.dagger.annotation.scope.AppScope;
import wq.android.mvvm.java.starter.network.http.retrofit.service.LunarCalendarService;

/**
 * @author Wang Qi
 */
@AppScope
public class RetrofitManager {

    private static final Map<Class<?>, Object> mServiceCache = new ArrayMap<>();
    private static final Map<Class<?>, String> mBaseUrlMap = new ArrayMap<>();

    static {
        mBaseUrlMap.put(LunarCalendarService.class, "https://www.sojson.com/open/api/lunar/");
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
