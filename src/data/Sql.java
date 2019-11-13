package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sql {
	String[][] a = null;

	public Sql() {
		get();
	}

	public String[][] geta() {
		return a;
	}

	public static final int exp = 10, luong = 8, skill = 1, bc = 3, tg = 9, language = 5, pv = 2, heal = 6, truong = 4,
			test = 7;

	private void get() {
		try {
			Connection con = Conn.getConn();
			String sql = "select name ,kinang,phongvan,bangcap,truonghoc,ngoaingu,suckhoe   ,test,luong,thoigian,kinhnghiem from ungvien, pv "
					+ " where ungvien.id=pv.id";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.last();
			int h = rs.getRow();
			a = new String[h][11];
			rs.beforeFirst();
			int i = 0;
			while (rs.next()) {
				for (int j = 0; j < 11; j++) {
					a[i][j] = rs.getString(j + 1);
				}
				
				i++;
			}
			st.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}
}
