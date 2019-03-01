package wq.android.mvvm.java.starter.network.http.retrofit.service;

import android.util.ArrayMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import wq.android.mvvm.java.starter.network.entity.OkayApiResponse;

/**
 * @author Wang Qi
 */
public interface OkayApiService {

    @GET(".")
    Observable<OkayApiResponse<ArrayMap>> request(@Query("service") String service, @Query("app_key") String appKey, @Query("sign") String sign);
}
