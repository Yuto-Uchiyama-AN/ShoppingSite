package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.MemberBean;
import jp.co.aforce.bean.RoleBean;
import jp.co.aforce.parameter.MemberAccess;
import jp.co.aforce.parameter.MemberInfo;

public class MemberDAO extends DAO {


	public String search(String id, String password) throws Exception {

		Connection con = getConnection();
		String sql = "select ACCESS from member_access"
				+ " where "
				+ MemberInfo.ID + " = ?"
				+ " and "
				+ MemberInfo.PASSWORD + " = ?"
				;

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.setString(2, password);


		ResultSet rs = st.executeQuery();

		String access = "";
		while(rs.next()) {
			access = rs.getString("ACCESS");
		}
		st.close();
		con.close();

		return access;
	}


	public void insert(MemberBean bean) throws SQLException, Exception {

		Connection con = getConnection();

		String sql = "insert into member_info values(? ,?, ?)";


		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bean.getId());
		st.setString(2, bean.getName());
		st.setString(3, bean.getPassword());

		st.executeUpdate();

		st.close();
		con.close();

	}

	public void insertRole(RoleBean bean) throws SQLException, Exception {

		Connection con = getConnection();

		String sql = "insert into member_access values(?, ?, ?)";


		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bean.getId());
		st.setString(2, bean.getRole());
		st.setString(3, bean.getPassword());

		st.executeUpdate();

		st.close();
		con.close();

	}


	public void update(MemberBean bean) throws SQLException, Exception {

		Connection con = getConnection();

		String sql =
				"update "
				+ MemberInfo.member_info
				+ " set "
				+ MemberInfo.ID + " = ?,"
				+ MemberInfo.NAME + " = ?,"
				+ MemberInfo.PASSWORD + " = ?"
				+ " where "
				+ MemberInfo.ID + " = ?";
				;

		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bean.getId());
		st.setString(2, bean.getName());
		st.setString(3, bean.getPassword());
		st.setString(4, bean.getId());

		st.executeUpdate();

		st.close();
		con.close();
	}

	public void delete(String memberId) throws Exception {
		Connection con = getConnection();

		String sql =
				"delete"
				+ " from "
				+ " member_info "
				+ " where "
				+ MemberInfo.ID
				+ " = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberId);

		st.executeUpdate();

		st.close();
		con.close();
	}

	public void delete2(String memberId) throws Exception {
		Connection con = getConnection();

		String sql =
				"delete"
				+ " from "
				+ " member_access "
				+ " where "
				+ MemberAccess.ID
				+ " = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, memberId);

		st.executeUpdate();

		st.close();
		con.close();
	}


	public int search(String id, String name, String password)
			throws Exception {

		Connection con = getConnection();

		PreparedStatement st;
		st = con.prepareStatement(
				"select count(*) from member_info where id=? and name=? and password=? ");
		st.setString(1, id);
		st.setString(2, name);
		st.setString(3, password);
		ResultSet rs = st.executeQuery();


		int count = 0;
		while (rs.next()) {

			count = rs.getInt("count(*)");

		}
		st.close();
		con.close();
		return count;
	}

	public List<MemberBean> search(String keyword)
			throws Exception {
		List<MemberBean> list = new ArrayList<>();

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from member_info where name like ?");
		st.setString(1, "%"+keyword+"%");
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			MemberBean p = new MemberBean();
			p.setId(rs.getString("id"));
			p.setName(rs.getString("name"));
			p.setPassword(rs.getString("password"));
			list.add(p);
		}

		st.close();
		con.close();
		return list;
	}

	public MemberBean findById(String id) throws Exception {

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from member_info where id = ?");
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		MemberBean p = null;
		while(rs.next()) {
			p = new MemberBean();
			p.setId(rs.getString("id"));
			p.setName(rs.getString("name"));
			p.setPassword(rs.getString("password"));

		}

		return p;
	}

	public RoleBean findById2(String id) throws Exception {

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from member_access where id = ?");
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		RoleBean p = null;
		while(rs.next()) {
			p = new RoleBean();
			p.setId(rs.getString("id"));
			p.setRole(rs.getString("role"));
			p.setPassword(rs.getString("password"));

		}

		return p;
	}

	}







