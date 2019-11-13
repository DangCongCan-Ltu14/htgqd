package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import convert.Point;

public class Insert {
	public static void main(String[] args) {

		try {
			Connection con = Conn.getConn();
			int d = 10;
			ins(con,d);
			inspv(con);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void inspv(Connection con) {
		String sql = "select id from ungvien ";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.beforeFirst();
			sql = "insert into pv (id , test , kinang , phongvan , ngaypv) values (?,?,?,?,?)";
			long ti = System.currentTimeMillis();
			Date dte = new Date(ti);
			String k = dte.toString();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(5, k);
			while (rs.next()) {
				ps.setInt(1, rs.getInt(1));
				ps.setInt(2, Point.rtest());
				ps.setString(3, Point.rskill());
				ps.setString(4, Point.rinterview());
				ps.executeUpdate();
			}
			ps.close();
			st.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void ins(Connection con, int d) {

		String sql = "insert into ungvien (name , suckhoe , bangcap , luong,thoigian , ngoaingu , truonghoc , kinhnghiem, id) values (?,?,?,?,?,?,?,?,?)";
		try {

			PreparedStatement ps = con.prepareStatement(sql);
			for (int i = 0; i < d; i++) {
				String s = "uv " + i;
				ps.setString(1, s);
				ps.setString(2, Point.rheal());
				ps.setString(3, Point.rdegreee());
				ps.setInt(4, Point.rluong());
				ps.setInt(5, Point.rtg());
				ps.setString(6, Point.reng());
				ps.setString(7, Point.rschool());
				ps.setInt(8, Point.rkinhnghiem());
				ps.setInt(9,i+1);
				ps.executeUpdate();
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}