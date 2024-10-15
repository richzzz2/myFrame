package com.richz.frame.entity.vo;

import com.richz.frame.constant.RspCode;


public class ResponseData  {

    private String result_code;
    private String msg;
    private Object data;

    public String getResult_code(){return result_code;}
    public void   setResult_code(){this.result_code = result_code;}
    public String getMsg(){return msg;}
    public void   setMsg(){this.msg=msg;}
    public Object getData(){return data;}
    public void   setData(){this.data= data;}
    public ResponseData() {

    }
    public ResponseData(Object data) {
        this.result_code= RspCode.SUCCESS_CODE;
        this.msg = RspCode.OPER_SUCCESS;
        this.data = data;
    }
    public ResponseData(String result_code, String msg) {
        this.result_code= result_code;
        this.msg = msg;
    }

    public ResponseData(String result_code, String msg, String data) {
        this.result_code = result_code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 默认的成功
     * @return
     */
    public ResponseData success(){
        return new ResponseData (RspCode.SUCCESS_CODE, RspCode.OPER_SUCCESS);
    }

    /**
     * 默认的失败
     * @return
     */
    public ResponseData error(){
        return new ResponseData (RspCode.FAIL_CODE,RspCode.OPER_FAILD);
    }
    public static ResponseData error(String code, String msg){
        return new ResponseData (code,msg);
    }

    /**
     * 成功 + 返回的成功信息
     * @param data
     * @return
     */
    public static ResponseData success(String data){
        return new ResponseData (RspCode.SUCCESS_CODE,RspCode.OPER_SUCCESS,data);
    }


}
