package com.imooc.test;

import java.io.IOException;




import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import net.sf.json.JSONObject;

import org.apache.http.ParseException;

import com.imooc.po.AccessToken;
import com.imooc.util.WeixinUtil;

public class WeixinTest {

	public static void main(String[] args) {
		try {
			AccessToken token=WeixinUtil.getAccessToken();
			System.out.println("Ʊ��:"+token.getToken());
			System.out.println("��Чʱ��:"+token.getExpiresIn());
			//����ͼƬ��mediaId
//			String path="D:/yinxiong.jpg";
//			String mediaId=null;
//			try {
//				mediaId = WeixinUtil.upload(path, token.getToken(), "thumb");
//			} catch (KeyManagementException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (NoSuchAlgorithmException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (NoSuchProviderException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(mediaId);
			//���Բ˵������ɹ����
			String menu=JSONObject.fromObject(WeixinUtil.initMenu()).toString();
			int result=WeixinUtil.createMenu(token.getToken(),menu);
			if(result==0){
				System.out.println("�����˵��ɹ�");
			}else{
				System.out.println("�����룺"+result);
			}
			//���Բ˵���ѯ�ӿ�
//			JSONObject jsonObject= WeixinUtil.queryMenu(token.getToken());
//			System.out.println(jsonObject);
//			String result=WeixinUtil.translate("����");
//			System.out.println(result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
