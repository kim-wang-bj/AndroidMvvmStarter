package wq.android.mvvm.java.starter.network.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Value;

/**
 * @author Wang Qi
 */
@Value
public class Response<T> {
    @Expose
    @SerializedName("ret")
    private Integer code;

    @Expose
    @SerializedName("msg")
    private String message;

    @Expose
    @SerializedName("value")
    private T data;
}
