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
			System.out.println("票据:"+token.getToken());
			System.out.println("有效时间:"+token.getExpiresIn());
			//测试图片的mediaId
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
			//测试菜单创建成功与否
			String menu=JSONObject.fromObject(WeixinUtil.initMenu()).toString();
			int result=WeixinUtil.createMenu(token.getToken(),menu);
			if(result==0){
				System.out.println("创建菜单成功");
			}else{
				System.out.println("错误码："+result);
			}
			//测试菜单查询接口
//			JSONObject jsonObject= WeixinUtil.queryMenu(token.getToken());
//			System.out.println(jsonObject);
//			String result=WeixinUtil.translate("足球");
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
