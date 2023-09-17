package com.house.springboot.component;


public class SysResult {
	//表示状态码的数字
	private Integer code;
	//携带详细信息的字符串
	private String msg;
	//携带的各种数据
	private Object data;
	//准备一个封装数据的构造方法
	public SysResult(Integer code,String msg,Object data){
		this.code=code;
		this.msg=msg;
		this.data=data;
	}
	public SysResult() {
		// TODO Auto-generated constructor stub
	}
	//有可能返回的只有code,msg,没有data
	//编写静态方法,获取具有参数数据的SysResult,失败做准备
	public static SysResult build(Integer code
			,String msg,Object data){
		return new SysResult(code, msg, data);
	}//绝大部分时候不会出现失败
	//编写一个返回成功数据的静态方法,status=200的 msg固定="ok"
	public static SysResult ok(){
		return new SysResult(200, "ok", null);
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer status) {
		this.code = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
