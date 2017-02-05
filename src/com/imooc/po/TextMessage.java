package com.imooc.po;
/*
 * 文本消息对象
 */
public class TextMessage extends BaseMessage{
	
	private String Content;//文本内容
	private String MsgId;
	
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
	
}
