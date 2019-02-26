package wq.android.mvvm.java.starter.network.retrofit;

/**
 * @author Wang Qi
 */
public class RetrofitException extends RuntimeException{

    private BaseResponse mBaseResponse;

    public RetrofitException(BaseResponse baseResponse) {
        this.mBaseResponse = baseResponse;
    }

    @Override
    public String getMessage() {
        return mBaseResponse.getMessage();
    }

    public ResponseCode getCode() {
        return mBaseResponse.getCode();
    }

    public BaseResponse getResponse() {
        return mBaseResponse;
    }
}
