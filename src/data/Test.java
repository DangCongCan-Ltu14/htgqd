package data;

import java.sql.Connection;
import java.sql.ResultSet;

public class Test {

	public static void main(String[] args) {
	String sql = " select cvbc(bangcap) from ungvien" ;
	try {
		Connection con = Conn.getConn();
		ResultSet rs = con.createStatement().executeQuery(sql);
		rs.last();
		System.out.println(rs.getRow());
	} catch (Exception e) {
		System.err.println(e);
	}

	}

}
