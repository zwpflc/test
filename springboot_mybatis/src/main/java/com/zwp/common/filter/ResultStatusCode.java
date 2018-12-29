package com.zwp.common.filter;

public enum ResultStatusCode {

	OK("200","OK"), PERMISSION_DENIED("401","DENY ACCESS");

	
	 private ResultStatusCode(String errcode, String errmsg) {
		this.errcode = errcode;
		this.errmsg = errmsg;
	}
	String errcode;
     String errmsg;
      
	public String getErrcode() {
		return errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
    


}
