package wq.android.mvvm.java.starter.network.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Value;

/**
 * @author Wang Qi
 */
@Value
public class OkayApiResponse<T> {

    @Expose
    @SerializedName("code")
    private Integer ret;

    @Expose
    @SerializedName("message")
    private String msg;

    @Expose
    @SerializedName("value")
    private T data;
}
