package com.zqy.ms.user.util;

import java.util.HashMap;

/**
 * ResponseBody构造器。一般用于ajax、rest等类型的Web服务
 */
@SuppressWarnings("serial")
public class RestResponse extends HashMap<String, Object> {
    public static RestResponse success(){
        return success("成功");
    }
    public static RestResponse success(String message){
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess(true);
        restResponse.setMessage(message);
        return restResponse;
    }

    public static RestResponse failure(String message){
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess(false);
        restResponse.setMessage(message);
        return restResponse;
    }


    public RestResponse setSuccess(Boolean success) {
        if (success != null) put("success", success);
        return this;
    }

    public RestResponse setMessage(String message) {
        if (message != null) put("message", message);
        return this;
    }

    public RestResponse setData(Object data) {
        if (data != null) put("data", data);
        return this;
    }

}
