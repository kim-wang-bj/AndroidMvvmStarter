package wq.android.mvvm.java.common.network.retrofit;

import android.util.ArrayMap;

import java.util.Map;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Wang Qi
 * @date 2019/03/26
 */
@Builder(builderClassName = "Builder")
@Getter
public class RetrofitService {
    private Class<?> serviceClass;
    private String basUrl;
    @lombok.Builder.Default
    private ResponseInterceptor responseInterceptor = new DefaultRetrofitResponseInterceptor();

    private static final Map<Class<?>, Object> mServiceCache = new ArrayMap<>(0);

    public static <T> T get(RetrofitService.Builder builder) {
        RetrofitService retrofitService = builder.build();
        Class<?> serviceClass = retrofitService.getServiceClass();
        Object service = mServiceCache.get(serviceClass);
        if (service == null) {
            service = RetrofitFactory.get(retrofitService).create(serviceClass);
            mServiceCache.put(serviceClass, service);
        }
        return (T) service;
    }

    public interface ResponseInterceptor {
        /**
         * interceptor for retrofit response.
         *
         * @param retrofitResponse
         */
        void onResponse(RetrofitResponse<?> retrofitResponse);
    }
}
