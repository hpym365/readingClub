package com.eocchain.core.result;

import com.eocchain.core.constant.CodeConstant;

import java.io.Serializable;

/**
 * @Author: Haben
 * @Description:
 * @Date: 2017-08-25 11:40
 * @Version: 1.0
 **/
public class Result implements Serializable {

    private String resCode;
    private String resMsg;
    private Boolean success;

    private Object data;

    public static Result success(String resMsg, Object data) {
        return new Result(CodeConstant.SUCC, resMsg, true, data);
    }


    public static Result failed(String resMsg) {
        return new Result(CodeConstant.FAIL, resMsg, false, null);
    }

    @Override
    public String toString() {
        return "Result{" +
                "resCode='" + resCode + '\'' +
                ", resMsg='" + resMsg + '\'' +
                ", success=" + success +
                ", data=" + data +
                '}';
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result(String resCode, String resMsg, Boolean success, Object data) {
        this.resCode = resCode;
        this.resMsg = resMsg;
        this.success = success;
        this.data = data;
    }
}
