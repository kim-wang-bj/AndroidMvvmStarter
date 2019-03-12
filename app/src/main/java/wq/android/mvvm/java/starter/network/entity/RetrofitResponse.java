package wq.android.mvvm.java.starter.network.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Value;

/**
 * @author Wang Qi
 */
@Value
public class RetrofitResponse<T> {
    @Expose
    @SerializedName("status")
    private Integer status;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("data")
    private T data;

    public enum Status {

        /**
         * codes for http response.
         */
        OK(200),
        UNKNOWN(-1);

        private int code;

        Status(int code) {
            this.code = code;
        }

        public static Status valueOf(Integer code) {
            if (code != null) {
                for (Status e : Status.values()) {
                    if (e.code == code) {
                        return e;
                    }
                }
            }
            return UNKNOWN;
        }

        public int value() {
            return code;
        }
    }
}
