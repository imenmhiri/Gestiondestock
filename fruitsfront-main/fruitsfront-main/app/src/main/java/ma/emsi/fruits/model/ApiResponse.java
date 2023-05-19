package ma.emsi.fruits.model;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {


    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String msg;

    public ApiResponse(boolean error, String msg) {
        this.error = error;
        this.msg = msg;
    }

    public boolean isError() {
        return error;
    }

    public String getMsg() {
        return msg;
    }
}
