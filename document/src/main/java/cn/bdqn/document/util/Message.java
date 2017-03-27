package cn.bdqn.document.util;

public class Message {
	
	public static final int ERROR=0;
	public static final int SUCCESS=1;
	
	
	//消息状态，0：错误信息,1：成功信息
	private int status;
	//消息内容
	private String content;
	//模块名称
	private String module;
	//模块路径
	private String path;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	public Message(int status, String content, String module, String path) {
		super();
		this.status = status;
		this.content = content;
		this.module = module;
		this.path = path;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	

}
