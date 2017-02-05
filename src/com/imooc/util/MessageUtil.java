package com.imooc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;











import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;










import com.imooc.po.Image;
import com.imooc.po.ImageMessage;
import com.imooc.po.Music;
import com.imooc.po.MusicMessage;
import com.imooc.po.News;
import com.imooc.po.NewsMessage;
import com.imooc.po.TextMessage;
import com.thoughtworks.xstream.XStream;

public class MessageUtil {
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_NEWS = "news";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_MUSIC = "music";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVNET = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	public static final String MESSAGE_SCANCODE= "scancode_push";
	/**
	 * xml转为map集合
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String,String> map=new HashMap<String, String>();
		SAXReader reader=new SAXReader();
		//从request中获取输入流
		InputStream ins=request.getInputStream();
		Document doc=reader.read(ins);
		Element root=doc.getRootElement();
		List<Element> list=root.elements();
		for (Element element : list) {
			map.put(element.getName(), element.getText());
		}
		ins.close();
		return map;
	}
	/*
	 * 将文本消息对象转为xml
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage){
		XStream xstream=new XStream();
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	/**
	 * 组装文本消息
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
	public static String initText(String toUserName,String fromUserName,String content){
		TextMessage text=new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		return textMessageToXml(text);
	}
	/*
	 * 关注成功后的主菜单
	 * @return
	 */
	public static String menuText(){
		StringBuffer sb=new StringBuffer();
		sb.append("欢迎您的关注，请按照菜单提示进行操作：\n\n");
		sb.append("1、代维所在的学校\n");
		sb.append("2、代维所学的专业\n");
	//	sb.append("3、词组翻译\n\n");
		sb.append("3、慕课网介绍（图文版）\n\n");
		sb.append("4、回复图片\n");
		sb.append("回复？调出此菜单。");
		return sb.toString();
		
	}
	/*
	 * 回复1
	 */
	
	public static String firstMenu(){
		StringBuffer sb=new StringBuffer();
		sb.append("代维所在的学校是成都理工");
		return sb.toString();
	}
	/*
	 * 回复2
	 */
	public static String secondMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("代维所学的专业是通信工程");
	//	sb.append("慕课网课程涵盖前端开发、PHP、Html5、Android、iOS、Swift等IT前沿技术语言，包括基础课程、实用案例、高级分享三大类型，适合不同阶段的学习人群。以纯干货、短视频的形式为平台特点，为在校学生、职场白领提供了一个迅速提升技能、共同分享进步的学习平台。");
		return sb.toString();
	}
	/*
	 * 图文消息转为xml
	 * @param newsMessage
	 * @return
	 */
	public static String NewsMessageToXml(NewsMessage newsMessage){
		XStream xstream=new XStream();
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new News().getClass());
		return xstream.toXML(newsMessage);
	}
	/**
	 * 图片消息转为xml
	 * @param imageMessage
	 * @return
	 */
	public static String ImageMessageToXml(ImageMessage imageMessage){
		XStream xstream=new XStream();
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}
	/**
	 * 组装图文消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initNewsMessage(String toUserName,String fromUserName){
		String message=null;
		List<News> newsList=new ArrayList<News>();
		NewsMessage newsMessage=new NewsMessage();
		//消息体对象属性实列化
		News news=new News();
		news.setTitle("慕课网介绍");
		news.setDescription("慕课网是垂直的互联网IT技能免费学习网站。");
		news.setPicUrl("http://119.29.143.41/WeChat/image/imooc.jpg");
		news.setUrl("www.imooc.com");
		//添加进消息体集合
		newsList.add(news);
		//图文消息对象属性实列化
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MESSAGE_NEWS);
		newsMessage.setArticles(newsList);
		newsMessage.setArticleCount(newsList.size());
		//转为xml格式
		message=NewsMessageToXml(newsMessage);
		return message;
	}
	/**
	 * 组装图片消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initImageMessage(String toUserName,String fromUserName){
		String message=null;
		Image image=new Image();
		image.setMediaId("9ijC6eIGVYJl8Qil8mpz2c1e9rCQeAQXp_wPrf2fW0kxIJlBRC5UKPc7V52FJ-Si");
		ImageMessage imageMessage=new ImageMessage();
		imageMessage.setFromUserName(toUserName);
		imageMessage.setToUserName(fromUserName);
		imageMessage.setMsgType(MESSAGE_IMAGE);
		imageMessage.setCreateTime(new Date().getTime());
		imageMessage.setImage(image);
		message=ImageMessageToXml(imageMessage);
		return message;
	}
	/**
	 * 音乐消息转为xml
	 * @param musicMessage
	 * @return
	 */
	public static String MusicMessageToXml(MusicMessage musicMessage){
		XStream xstream=new XStream();
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}
	/**
	 * 组装音乐消息
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initMusicMessage(String toUserName,String fromUserName){
		String message=null;
		Music music=new Music();
		//音乐消息对象初始化
		music.setThumbMediaId("9ijC6eIGVYJl8Qil8mpz2c1e9rCQeAQXp_wPrf2fW0kxIJlBRC5UKPc7V52FJ-Si");
		music.setTitle("see you again");
		music.setDescription("速7片尾曲");
		music.setMusicURL("https://mywechat111.duapp.com/WeChat/resource/See You Again.mp3");
		music.setHQMusicUrl("https://mywechat111.duapp.com/WeChat/resource/See You Again.mp3");
		MusicMessage musicMessage=new MusicMessage();
		musicMessage.setFromUserName(toUserName);
		musicMessage.setToUserName(fromUserName);
		musicMessage.setMsgType(MESSAGE_MUSIC);
		musicMessage.setCreateTime(new Date().getTime());
		musicMessage.setMusic(music);
		message=MusicMessageToXml(musicMessage);
		return message;
	}
}
