package com.neuedu.model;

import java.io.Serializable;
/**
 * 封装一个公共的返回对象，用于向http客户端返回提示信息
 * @author 罗星华
 *
 */
public class Result implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2185762215482340474L;
	
	private boolean result = false;
	
	private String info = "失败";

	
	public Result() {
		super();
	}

	public Result(boolean result, String info) {
		super();
		this.result = result;
		this.info = info;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Result [result=" + result + ", info=" + info + "]";
	}
	
	

}
