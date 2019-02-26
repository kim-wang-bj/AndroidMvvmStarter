package wq.android.mvvm.java.starter.network.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Data;


/**
 * @author Wang Qi
 */
@Data
@Builder
public class BaseResponse<T> {

    @Expose
    @SerializedName("code")
    private ResponseCode code;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("value")
    private T data;
}
