package wq.android.mvvm.java.starter.network.http.retrofit.service;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 * APIs from https://openweathermap.org/api
 *
 * @author Wang Qi
 */
public interface OpenWeatherService {

    /**
     * @param city
     * @return
     */
    @FormUrlEncoded
    @GET("weather")
    Observable<Response<Object>> getWeatherByCity(@Field("q") String city);
}
