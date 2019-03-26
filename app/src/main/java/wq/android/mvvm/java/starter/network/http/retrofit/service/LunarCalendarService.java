package wq.android.mvvm.java.starter.network.http.retrofit.service;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import wq.android.mvvm.java.common.network.retrofit.RetrofitResponse;
import wq.android.mvvm.java.starter.network.entity.LunarDate;

/**
 * https://www.sojson.com/open/api/lunar/json.shtml?date=2019-03-01
 *
 * @author Wang Qi
 */
public interface LunarCalendarService {

    /**
     * Request lunar date.
     *
     * @param date 2019-03-01
     * @return
     */
    @GET("json.shtml")
    Observable<RetrofitResponse<LunarDate>> requestLunarDate(@Query("date") String date);
}
