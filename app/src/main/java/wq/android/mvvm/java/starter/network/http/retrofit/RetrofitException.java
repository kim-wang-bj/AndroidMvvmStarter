package wq.android.mvvm.java.starter.network.http.retrofit;

import wq.android.mvvm.java.starter.network.entity.Response;

/**
 * @author Wang Qi
 */
public class RetrofitException extends RuntimeException {

    private Response mResponse;

    public RetrofitException(Response response) {
        this.mResponse = response;
    }

    @Override
    public String getMessage() {
        return mResponse.getMessage();
    }

    public Integer getCode() {
        return mResponse.getCode();
    }

    public Response getResponse() {
        return mResponse;
    }
}
