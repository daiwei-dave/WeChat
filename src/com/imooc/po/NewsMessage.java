package com.imooc.po;
/*
 * ͼ����Ϣʵ�ж���
 */
import java.util.List;

public class NewsMessage extends BaseMessage {
	private int ArticleCount;//��Ϣ��Ĵ�С�򳤶�
	private List<News> Articles;//һ��ͼ����Ϣ��ļ���
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
