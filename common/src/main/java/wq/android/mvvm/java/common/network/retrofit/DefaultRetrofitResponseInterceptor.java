package wq.android.mvvm.java.common.network.retrofit;

/**
 * @author Wang Qi
 * @date 2019/03/26
 */
public class DefaultRetrofitResponseInterceptor implements RetrofitService.ResponseInterceptor {
    @Override
    public void onResponse(RetrofitResponse<?> retrofitResponse) {
        if (retrofitResponse.getStatus() != RetrofitResponse.Status.OK.value()) {
            throw new RetrofitException(retrofitResponse);
        }
    }
}
