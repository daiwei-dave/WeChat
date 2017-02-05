package com.imooc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;


import com.imooc.util.DBHelper;

import entity.Seller;


public class SellerDao {
	/**
	 * �����������ݵ����ݿ�
	 * 
	 * @param g
	 * @throws Exception
	 */
	public static void addMaiFang(Seller m) throws Exception {
		// �������ݿ�
		Connection conn = DBHelper.getConnection();
		// sql���
		String sql = "" + "insert into maifang"
				+ "(book_name,zuozhe_name,chubanshe_name,phone,maifang_name)"
				+ "values(" + "?,?,?,?,?)";
		// Ԥ����sql���
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, m.getBook_name());
		ptmt.setString(2, m.getZuozhe_name());
		ptmt.setString(3, m.getChubanshe_name());
		ptmt.setString(4, m.getPhone());
		ptmt.setString(5, m.getMaifang_name());
		// ִ��sql���
		ptmt.execute();
	}

	/**
	 * ��ѯ�鼮ͨ������
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
/**
 * ͨ����ѯ��������list����
 * @param book_name
 * @return
 * @throws Exception
 */
	public static List<Seller> selectBooksByBook_name(String book_name)
			throws Exception {
		// �������ݿ�
		Connection conn = DBHelper.getConnection();
		// sql��䣨�ؼ��ֲ�ѯ��
		String sql = "" + "select * from maifang where book_name like ?";
		// Ԥ����sql���
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, "%"+book_name+"%");
		//����list����
		List<Seller> gs = new ArrayList<Seller>();
		Seller g = null;
		// ִ��sql��ѯ���ؽ����
		ResultSet rs = ptmt.executeQuery();
		while (rs.next()) {
			g = new Seller();
			g.setBook_name(rs.getString("book_name"));
			g.setZuozhe_name(rs.getString("zuozhe_name"));
			g.setChubanshe_name(rs.getString("chubanshe_name"));
			gs.add(g);
		}
		return gs;
	}
}
