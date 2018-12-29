package com.zwp.common.filter;

public class ResultMsg<T> {

	private String errcode;
	private String errmsg;
	private T t;
	public ResultMsg(String errcode, String errmsg, T t) {
		this.errcode =errcode;
		this.errmsg = errmsg;
		this.t =t;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	
}
