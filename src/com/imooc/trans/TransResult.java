package com.imooc.trans;

public class TransResult {
	private String form;//·­ÒëÔ´ÓïÑÔ
	private String to;//ÒëÎÄÓïÑÔ
	private Data data;
	private String errno;//´íÎóÂë
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public String getErrno() {
		return errno;
	}
	public void setErrno(String errno) {
		this.errno = errno;
	}
	
}
