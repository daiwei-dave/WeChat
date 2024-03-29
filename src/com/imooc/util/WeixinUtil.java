package com.imooc.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.imooc.menu.Button;
import com.imooc.menu.ClickButton;
import com.imooc.menu.Menu;
import com.imooc.menu.ViewButton;
import com.imooc.po.AccessToken;
import com.imooc.trans.Data;
import com.imooc.trans.Parts;
import com.imooc.trans.Symbols;
import com.imooc.trans.TransResult;

import net.sf.json.JSONObject;

/**
 * 微信工具类
 * 
 * @author Administrator
 *
 */
public class WeixinUtil {
	private static final String APPID = "wx561380ddd6f8733d";
	private static final String APPSECRET = "d4624c36b6795d1d99dcf0547af5443d";
	private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	private static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	private static final String QUERY_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	private static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	/**
	 * get请求
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public static JSONObject doGetStr(String url) throws ParseException,
			IOException {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		JSONObject jsonObject = null;
		HttpResponse httpResponse = client.execute(httpget);
		HttpEntity entity = httpResponse.getEntity();
		if (entity != null) {
			String result = EntityUtils.toString(entity, "utf-8");
			jsonObject = JSONObject.fromObject(result);
		}
		return jsonObject;
	}

	/**
	 * POST请求
	 * 
	 * @param url
	 * @param outStr
	 * @return
	 * @throws IOException
	 */
	public static JSONObject doPostStr(String url, String outStr)
			throws IOException {
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		JSONObject jsonObject = null;
		httpPost.setEntity(new StringEntity(outStr, "utf-8"));
		HttpResponse response = client.execute(httpPost);
		String result = EntityUtils.toString(response.getEntity(), "utf-8");
		jsonObject = JSONObject.fromObject(result);
		return jsonObject;
	}

	/**
	 * 获取accessToken
	 * 
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static AccessToken getAccessToken() throws ParseException,
			IOException {
		AccessToken token = new AccessToken();
		String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace(
				"APPSECRET", APPSECRET);
		JSONObject jsonObject = doGetStr(url);
		if (jsonObject != null) {
			token.setToken(jsonObject.getString("access_token"));
			token.setExpiresIn(jsonObject.getInt("expires_in"));
		}
		return token;
	}

	/**
	 * 文件上传
	 * 
	 * @param filePath
	 * @param accessToken
	 * @param type
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws KeyManagementException
	 */
	public static String upload(String filePath, String accessToken, String type)
			throws IOException, NoSuchAlgorithmException,
			NoSuchProviderException, KeyManagementException {
		File file = new File(filePath);
		if (!file.exists() || !file.isFile()) {
			throw new IOException("文件不存在");
		}

		String url = UPLOAD_URL.replace("ACCESS_TOKEN", accessToken).replace(
				"TYPE", type);

		URL urlObj = new URL(url);
		// 连接
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();

		con.setRequestMethod("POST");
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false);

		// 设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");

		// 设置边界
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary="
				+ BOUNDARY);

		StringBuilder sb = new StringBuilder();
		sb.append("--");
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
				+ file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");

		byte[] head = sb.toString().getBytes("utf-8");

		// 获得输出流
		OutputStream out = new DataOutputStream(con.getOutputStream());
		// 输出表头
		out.write(head);

		// 文件正文部分
		// 把文件已流文件的方式 推入到url中
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();

		// 结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线

		out.write(foot);

		out.flush();
		out.close();

		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		String result = null;
		try {
			// 定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		JSONObject jsonObj = JSONObject.fromObject(result);
		System.out.println(jsonObj);
		String typeName = "media_id";
		if (!"image".equals(type)) {
			typeName = type + "_media_id";
		}
		String mediaId = jsonObj.getString(typeName);
		return mediaId;
	}

	/**
	 * 组装菜单
	 * 
	 * @return
	 */
	public static Menu initMenu() {
		Menu menu = new Menu();
		// Click类型菜单属性实例化
		ClickButton button11 = new ClickButton();
		button11.setName("调出主菜单");
		button11.setType("click");
		button11.setKey("11");
		// view类型菜单属性实例化
		// 二级view类型菜单之用户注册与登陆
		ViewButton button21 = new ViewButton();
		button21.setName("用户注册与登陆");
		button21.setType("view");
		button21.setUrl("http://119.29.143.41/WeChat/log.jsp");
		// 二级view类型菜单之二手书交易
		ViewButton button22 = new ViewButton();
		button22.setName("二手书交易");
		button22.setType("view");
		button22.setUrl("http://119.29.143.41/WeChat/exchange/buy.jsp");
		// 添加二级菜单到功能菜单
		Button button2 = new Button();
		button2.setName("用户模块");
		button2.setSub_button(new Button[] { button21, button22 });
		// 二级功能菜单之扫码
		ClickButton button31 = new ClickButton();
		button31.setName("扫码");
		button31.setType("scancode_push");
		button31.setKey("31");
		// 二级功能菜单之查看地理位置
		ClickButton button32 = new ClickButton();
		button32.setName("查看地理位置");
		button32.setType("location_select");
		button32.setKey("32");
		// 添加二级菜单到功能菜单
		Button button = new Button();
		button.setName("功能菜单");
		button.setSub_button(new Button[] { button31, button32 });
		// 添加一级菜单
		menu.setButton(new Button[] { button11, button2, button });
		return menu;
	}

	/**
	 * 创建菜单接口
	 * 
	 * @param token
	 * @param menu
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static int createMenu(String token, String menu)
			throws ParseException, IOException {
		int result = 0;
		String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doPostStr(url, menu);
		if (jsonObject != null) {
			result = jsonObject.getInt("errcode");
		}
		return result;
	}

	/**
	 * 创建查询接口
	 * 
	 * @param token
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static JSONObject queryMenu(String token) throws ParseException,
			IOException {
		String url = QUERY_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doGetStr(url);
		return jsonObject;
	}

	/**
	 * 删除菜单接口
	 * 
	 * @param token
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static int deleteMenu(String token) throws ParseException,
			IOException {
		String url = DELETE_MENU_URL.replace("ACCESS_TOKEN", token);
		JSONObject jsonObject = doGetStr(url);
		int result = 0;
		if (jsonObject != null) {
			result = jsonObject.getInt("errcode");
		}
		return result;
	}

	/**
	 * 翻译方法
	 * 
	 * @param source
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public static String translate(String source) throws ParseException,
			IOException {
		String url = "http://api.fanyi.baidu.com/api/trans/vip/translate?q=KEYWORD&from=auto&to=auto&appid=2015063000000001&salt=1435660288&sign=f89f9594663708c1605f3d736d01d2d4";
		url = url.replace("KEYWORD", URLEncoder.encode(source, "utf-8"));
		JSONObject jsonObject = doGetStr(url);
		// Object obj = jsonObject.get("data");
		String errno = jsonObject.getString("errno");
		StringBuffer dst = new StringBuffer();
		if ("0".equals(errno)) {
			TransResult transResult = (TransResult) JSONObject.toBean(
					jsonObject, TransResult.class);
			Data data = transResult.getData();
			Symbols symbols = data.getSymbols()[1];
			String phzh = symbols.getPh_zh() == null ? "" : "中文拼音:"
					+ symbols.getPh_zh() + "\n";
			String phen = symbols.getPh_en() == null ? "" : "英式英标："
					+ symbols.getPh_en() + "\n";
			String pham = symbols.getPh_am() == null ? "" : "美式英标："
					+ symbols.getPh_am() + "\n";
			dst.append(phzh + phen + pham);
			Parts[] parts = symbols.getParts();
			String pat = null;
			for (Parts part : parts) {
				pat = (part.getPart() != null && "".equals(part.getPart())) ? "["
						+ part.getPart() + "]"
						: "";
				String[] means = part.getMeans();
				dst.append(pat);
				for (String mean : means) {
					dst.append(mean + ";");
				}
			}
		}
		return dst.toString();
	}
}
