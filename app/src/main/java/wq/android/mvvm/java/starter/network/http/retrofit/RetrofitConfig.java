package wq.android.mvvm.java.starter.network.http.retrofit;

import android.util.ArrayMap;

import java.util.Map;

import wq.android.mvvm.java.starter.network.http.retrofit.service.LunarCalendarService;

/**
 * @author Wang Qi
 * @date 2019-03-13
 */
public class RetrofitConfig {
    private static final Map<Class<?>, String> mBaseUrlMap = new ArrayMap<>(0);

    static {
        mBaseUrlMap.put(LunarCalendarService.class, "https://www.sojson.com/open/api/lunar/");
    }

    public static Map<Class<?>, String> serviceUrlMap() {
        return mBaseUrlMap;
    }
}
