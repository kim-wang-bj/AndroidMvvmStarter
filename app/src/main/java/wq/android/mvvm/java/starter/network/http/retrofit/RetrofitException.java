package wq.android.mvvm.java.starter.network.http.retrofit;

import wq.android.mvvm.java.starter.network.entity.RetrofitResponse;

/**
 * @author Wang Qi
 */
public class RetrofitException extends RuntimeException {

    private RetrofitResponse mRetrofitResponse;

    public RetrofitException(RetrofitResponse retrofitResponse) {
        this.mRetrofitResponse = retrofitResponse;
    }

    @Override
    public String getMessage() {
        return mRetrofitResponse.getMessage();
    }

    public Integer getStatus() {
        return mRetrofitResponse.getStatus();
    }

    public RetrofitResponse getResponse() {
        return mRetrofitResponse;
    }
}
