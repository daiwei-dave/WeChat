package com.imooc.po;
/*
 * 图文消息实列对象
 */
import java.util.List;

public class NewsMessage extends BaseMessage {
	private int ArticleCount;//消息体的大小或长度
	private List<News> Articles;//一个图文消息体的集合
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<News> getArticles() {
		return Articles;
	}
	public void setArticles(List<News> articles) {
		Articles = articles;
	}
}
