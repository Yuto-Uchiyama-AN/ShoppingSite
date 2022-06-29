package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.SweetBean;
import jp.co.aforce.parameter.MemberInfo;
import jp.co.aforce.parameter.ProductInfo;
import jp.co.aforce.servlet.Number;


public class SweetDAO extends DAO {

	public List<SweetBean> search(String keyword)
			throws Exception {
		List<SweetBean> list = new ArrayList<>();

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from product_info where name like ?");
		st.setString(1, "%"+keyword+"%");
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			SweetBean p = new SweetBean();
			p.setId(rs.getString("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			p.setInfo(rs.getString("info"));
			p.setImgname(rs.getString("imgname"));
			list.add(p);
		}

		st.close();
		con.close();
		return list;
	}

	public int insert(SweetBean sweetbean) throws Exception{
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"insert into product_info values(?,?, ?, ?, ?)");

		st.setString(1,Number.time());
		st.setString(2, sweetbean.getName());
		st.setInt(3, sweetbean.getPrice());
		st.setString(4, sweetbean.getInfo());
		st.setString(5, sweetbean.getImgname());
		int line = st.executeUpdate();

		st.close();
		con.close();
		return line;


	}

	public SweetBean findById(String id) throws Exception {

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from product_info where id = ?");
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		SweetBean p = null;
		while(rs.next()) {
			p = new SweetBean();
			p.setId(rs.getString("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			p.setInfo(rs.getString("info"));
			p.setImgname(rs.getString("imgname"));
		}

		return p;
	}

	public void update(SweetBean bean) throws SQLException, Exception {

		Connection con = getConnection();

		String sql =
				"update "
				+ ProductInfo.product_info
				+ " set "
				+ ProductInfo.ID + " = ?,"
				+ ProductInfo.NAME + " = ?,"
				+ ProductInfo.PRICE + " = ?,"
				+ ProductInfo.INFO + " = ?,"
				+ ProductInfo.IMGNAME + " = ?"
				+ " where "
				+ ProductInfo.ID + " = ?";
				;

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bean.getId());
		st.setString(2, bean.getName());
		st.setInt(3, bean.getPrice());
		st.setString(4, bean.getInfo());
		st.setString(5, bean.getImgname());
		st.setString(6, bean.getId());

		st.executeUpdate();

		st.close();
		con.close();
	}

	public void delete(String memberId) throws Exception {
		Connection con = getConnection();

		String sql =
				"delete"
				+ " from "
				+ " product_info "
				+ " where "
				+ MemberInfo.ID
				+ " = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberId);

		st.executeUpdate();

		st.close();
		con.close();
	}



}
