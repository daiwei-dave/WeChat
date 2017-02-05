package com.imooc.menu;
/**
 * view类型菜单
 * @author Administrator
 *
 */
public class ViewButton extends Button {
	//网页链接，用户点击菜单可打开链接
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
