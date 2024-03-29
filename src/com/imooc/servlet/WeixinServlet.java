package com.imooc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.imooc.po.TextMessage;
import com.imooc.util.CheckUtil;
import com.imooc.util.MessageUtil;

/**
 * 处理请求
 */
public class WeixinServlet extends HttpServlet {
	
    public WeixinServlet() {
        super();
      
    }
    /**
	 * 接入验证
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String signature=request.getParameter("signature");
		String timestamp=request.getParameter("timestamp");
		String nonce=request.getParameter("nonce");
		String echostr=request.getParameter("echostr");
		PrintWriter out=response.getWriter();
		if(CheckUtil.checkSignature(signature, timestamp, nonce)){
			out.print(echostr);
		}
	}
	/**
	 * 消息的接收与响应
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		try {
			Map<String, String>map=MessageUtil.xmlToMap(request);
			String fromUserName=map.get("FromUserName");
			String toUserName=map.get("ToUserName");
			String msgType=map.get("MsgType");
			String content=map.get("Content");
			
			String message=null;
			if(MessageUtil.MESSAGE_TEXT.equals(msgType)){
				if("1".equals(content)){
					message=MessageUtil.initText(toUserName, fromUserName, MessageUtil.firstMenu());
				}else if("2".equals(content)){
					message=MessageUtil.initText(toUserName, fromUserName, MessageUtil.secondMenu());
				}else if("?".equals(content)||"？".equals(content)){
					message=MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}else if("3".equals(content)){
					message=MessageUtil.initNewsMessage(toUserName, fromUserName);
				}else if("4".equals(content)){
					message=MessageUtil.initImageMessage(toUserName, fromUserName);
				}else if("5".equals(content)){
					message=MessageUtil.initMusicMessage(toUserName, fromUserName);
				}
				
			}else if(MessageUtil.MESSAGE_EVNET.equals(msgType)){
				String eventType=map.get("Event");
				if(MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)){
					message=MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}else if(MessageUtil.MESSAGE_CLICK.equals(eventType)){
					message=MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}else if(MessageUtil.MESSAGE_VIEW.equals(eventType)){
					String url=map.get("EventKey");
					message=MessageUtil.initText(toUserName, fromUserName, url);			
				}else if(MessageUtil.MESSAGE_SCANCODE.equals(eventType)){
					String key=map.get("EventKey");
					message=MessageUtil.initText(toUserName, fromUserName, key);
				}
				
			}else if(MessageUtil.MESSAGE_LOCATION.equals(msgType)){
				String label=map.get("Label");
				message=MessageUtil.initText(toUserName, fromUserName, label);
			}
			System.out.println(message);
			out.print(message);
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
	
	}

}
