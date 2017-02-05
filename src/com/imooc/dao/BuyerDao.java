package com.imooc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;

import com.imooc.util.DBHelper;

import entity.Buyer;
import entity.Seller;


public class BuyerDao {
	/**
	 * ���������ݵ����ݿ�
	 * 
	 * @param g
	 * @throws Exception
	 */
	public static void addBuyer(Buyer b) throws Exception {
		// �������ݿ�
		Connection conn = DBHelper.getConnection();
		// sql���
		String sql = "" + "insert into buyer"
				+ "(book_name,author,publishing_company,buyer_name,phone)"
				+ "values(?,?,?,?,?)";
		// Ԥ����sql���
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, b.getBook_name());
		ptmt.setString(2, b.getZuozhe_name());
		ptmt.setString(3, b.getChubanshe_name());
		ptmt.setString(4, b.getBuyer_name());
		ptmt.setString(5, b.getPhone());
		// ִ��sql���
		ptmt.execute();
	}

	/**
	 * ��ѯ���ݿ�ͨ���û���
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public static Seller selectBookByBook_name(String book_name)
			throws Exception {
		Seller m = null;
		// �������ݿ�
		Connection conn = DBHelper.getConnection();
		// sql���
		String sql = "" + "select * from maifang where book_name=?";
		// Ԥ����sql���
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, book_name);
		// ִ��sql��ѯ���ؽ����
		ResultSet rs = ptmt.executeQuery();
		// ��װ��ѯ��Ľ��
		while (rs.next()) {
			m = new Seller();
			m.setBook_name(rs.getString("book_name"));
			m.setZuozhe_name(rs.getString("zuozhe_name"));
			m.setChubanshe_name(rs.getString("chubanshe_name"));

		}
		return m;
	}
}
