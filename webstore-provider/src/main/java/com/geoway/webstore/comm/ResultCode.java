package com.geoway.webstore.comm;

import com.geoway.webstore.util.R;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.http.HttpStatus;

/**
 * @author Lencho
 * @create 2021-08-18 20:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultCode {

    private Integer code;

    private String message;


    public static ResultCode SUCCESS() {
        return new ResultCode(200, "成功");
    }

    public static ResultCode BAD_REQUEST() {
        return new ResultCode(400, "Bad Request");
    }

    public static ResultCode error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static ResultCode error(int code, String msg) {
        return new ResultCode(code, msg);
    }

    public static ResultCode error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

}
