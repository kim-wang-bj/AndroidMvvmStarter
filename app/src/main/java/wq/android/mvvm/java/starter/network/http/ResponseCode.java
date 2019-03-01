package wq.android.mvvm.java.starter.network.http;

/**
 * @author Wang Qi
 */

public enum ResponseCode {

    /**
     * codes for http response.
     */
    OK(200), UNKNOWN(-1);

    private int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public static ResponseCode valueOf(Integer code) {
        if (code != null) {
            for (ResponseCode e : ResponseCode.values()) {
                if (e.code == code) {
                    return e;
                }
            }
        }
        return UNKNOWN;
    }

    public int getCode() {
        return code;
    }
}
