package com.imooc.trans;
/**
 * 词语解释
 * @author Administrator
 *
 */
public class Parts {
	private String part;
	private String[] means;//翻译后的结果
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String[] getMeans() {
		return means;
	}
	public void setMeans(String[] means) {
		this.means = means;
	}
}
