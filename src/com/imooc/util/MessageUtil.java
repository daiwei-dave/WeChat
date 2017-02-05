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
	 * xmlתΪmap����
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String,String> map=new HashMap<String, String>();
		SAXReader reader=new SAXReader();
		//��request�л�ȡ������
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
	 * ���ı���Ϣ����תΪxml
	 * @param textMessage
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage){
		XStream xstream=new XStream();
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	/**
	 * ��װ�ı���Ϣ
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
	 * ��ע�ɹ�������˵�
	 * @return
	 */
	public static String menuText(){
		StringBuffer sb=new StringBuffer();
		sb.append("��ӭ���Ĺ�ע���밴�ղ˵���ʾ���в�����\n\n");
		sb.append("1����ά���ڵ�ѧУ\n");
		sb.append("2����ά��ѧ��רҵ\n");
	//	sb.append("3�����鷭��\n\n");
		sb.append("3��Ľ�������ܣ�ͼ�İ棩\n\n");
		sb.append("4���ظ�ͼƬ\n");
		sb.append("�ظ��������˲˵���");
		return sb.toString();
		
	}
	/*
	 * �ظ�1
	 */
	
	public static String firstMenu(){
		StringBuffer sb=new StringBuffer();
		sb.append("��ά���ڵ�ѧУ�ǳɶ���");
		return sb.toString();
	}
	/*
	 * �ظ�2
	 */
	public static String secondMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("��ά��ѧ��רҵ��ͨ�Ź���");
	//	sb.append("Ľ�����γ̺���ǰ�˿�����PHP��Html5��Android��iOS��Swift��ITǰ�ؼ������ԣ����������γ̡�ʵ�ð������߼������������ͣ��ʺϲ�ͬ�׶ε�ѧϰ��Ⱥ���Դ��ɻ�������Ƶ����ʽΪƽ̨�ص㣬Ϊ��Уѧ����ְ�������ṩ��һ��Ѹ���������ܡ���ͬ���������ѧϰƽ̨��");
		return sb.toString();
	}
	/*
	 * ͼ����ϢתΪxml
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
	 * ͼƬ��ϢתΪxml
	 * @param imageMessage
	 * @return
	 */
	public static String ImageMessageToXml(ImageMessage imageMessage){
		XStream xstream=new XStream();
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}
	/**
	 * ��װͼ����Ϣ
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initNewsMessage(String toUserName,String fromUserName){
		String message=null;
		List<News> newsList=new ArrayList<News>();
		NewsMessage newsMessage=new NewsMessage();
		//��Ϣ���������ʵ�л�
		News news=new News();
		news.setTitle("Ľ��������");
		news.setDescription("Ľ�����Ǵ�ֱ�Ļ�����IT�������ѧϰ��վ��");
		news.setPicUrl("http://119.29.143.41/WeChat/image/imooc.jpg");
		news.setUrl("www.imooc.com");
		//��ӽ���Ϣ�弯��
		newsList.add(news);
		//ͼ����Ϣ��������ʵ�л�
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MESSAGE_NEWS);
		newsMessage.setArticles(newsList);
		newsMessage.setArticleCount(newsList.size());
		//תΪxml��ʽ
		message=NewsMessageToXml(newsMessage);
		return message;
	}
	/**
	 * ��װͼƬ��Ϣ
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
	 * ������ϢתΪxml
	 * @param musicMessage
	 * @return
	 */
	public static String MusicMessageToXml(MusicMessage musicMessage){
		XStream xstream=new XStream();
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}
	/**
	 * ��װ������Ϣ
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initMusicMessage(String toUserName,String fromUserName){
		String message=null;
		Music music=new Music();
		//������Ϣ�����ʼ��
		music.setThumbMediaId("9ijC6eIGVYJl8Qil8mpz2c1e9rCQeAQXp_wPrf2fW0kxIJlBRC5UKPc7V52FJ-Si");
		music.setTitle("see you again");
		music.setDescription("��7Ƭβ��");
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
