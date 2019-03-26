package wq.android.mvvm.java.starter.network.http.retrofit;

import android.util.ArrayMap;

import java.util.Map;

import wq.android.mvvm.java.common.network.retrofit.RetrofitService;
import wq.android.mvvm.java.starter.network.http.retrofit.service.LunarCalendarService;

/**
 * @author Wang Qi
 * @date 2019-03-13
 */
public class RetrofitManager {
    private static Map<Class<?>, RetrofitService.Builder> mRetrofitServiceMap = new ArrayMap<>(0);

    static {
        mRetrofitServiceMap.put(LunarCalendarService.class, RetrofitService.builder()
                .basUrl("https://www.sojson.com/open/api/lunar/")
                .serviceClass(LunarCalendarService.class));
    }

    public static <T> T getService(Class<?> clazz) {
        return RetrofitService.get(mRetrofitServiceMap.get(clazz));
    }
}
