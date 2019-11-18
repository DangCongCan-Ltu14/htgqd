package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import convert.Point;

public class Sql {
	String[][] a = null;
	String sk = "";
	String stg = "";
	String skn = "";
	String sbc = "", snn = "", sluong = "";
	String stest = "";

	public String[][] geta() {
		return a;
	}

	public void chontest(String s, String b) {
		if (b.equals(""))
			return;
		if (b.equals("bang")) {
			stest = " test = " + s + " ";
		} else if (b.equals("hon")) {
			stest = " test >= " + s + " ";
		} else

		{
			stest = " test <= " + s + " ";
		}
		stest = " and " + stest;
	}

	public void chonsk(String a, String b) {
		if (a.equals("") || b.equals(""))
			return;
		int s = Point.health(a);
		if (b.equals("bang")) {
			sk = " cvsk(suckhoe) = " + s + " ";
		} else if (b.equals("hon")) {
			sk = " cvsk(suckhoe) >= " + s + " ";
		} else

		{
			sk = " cvsk(suckhoe) <= " + s + " ";
		}
		sk = " and " + sk;
	}

	public void chonbc(String a, String b) {
		if (a.equals("") || b.equals(""))
			return;
		int s = Point.degree(a);
		if (b.equals("bang")) {
			sbc = " cvbc(bangcap) = " + s + " ";
		} else if (b.equals("hon")) {
			sbc = " cvbc(bangcap) >= " + s + " ";
		} else

		{
			sbc = " cvbc(bangcap) <= " + s + " ";
		}
		sbc = " and " + sbc;
	}

	public void chonnn(String a, String b) {
		if (a.equals("") || b.equals(""))
			return;
		int s = Point.engl(a);
		if (b.equals("bang")) {
			snn = " cvnn(ngoaingu) = " + s + " ";
		} else if (b.equals("hon")) {
			snn = " cvnn(ngoaingu) >= " + s + " ";
		} else

		{
			snn = " cvnn(ngoaingu) <= " + s + " ";
		}
		snn = " and " + snn;
	}

	public void chonkn(String a, String b) {
		if (a.equals("") || b.equals(""))
			return;
		if (b.equals("bang")) {
			skn = " kinhnghiem = " + a + " ";
		} else if (b.equals("hon")) {
			skn = " kinhnghiem >= " + a + " ";
		} else

		{
			skn = " kinhnghiem <= " + a + " ";
		}
		skn = " and " + skn;
	}

	public void chonluong(String a, String b) {
		if (a.equals("") || b.equals(""))
			return;
		if (b.equals("bang")) {
			sluong = " luong = " + a + " ";
		} else if (b.equals("hon")) {
			sluong = " luong >= " + a + " ";
		} else

		{
			sluong = " luong <= " + a + " ";
		}
		sluong = " and " + sluong;

	}

	public void chontg(String a, String b) {
		if (a.equals("") || b.equals(""))
			return;
		if (b.equals("bang")) {
			stg = " thoigian = " + a + " ";
		} else if (b.equals("hon")) {
			stg = " thoigian >= " + a + " ";
		} else

		{
			stg = " thoigian <= " + a + " ";
		}
		stg = " and" + stg;
	}

	public static final int exp = 10, luong = 8, skill = 1, bc = 3, tg = 9, language = 5, pv = 2, heal = 6, truong = 4,
			test = 7;
	String lsql = "select name,kinang,phongvan,bangcap,truonghoc,ngoaingu,suckhoe ,test,luong,thoigian,kinhnghiem from ungvien, pv "
			+ " where ungvien.id=pv.id ";

	private String gsql() {
		String po = String.format("%s%s%s%s%s%s%s%s", lsql, sk, skn, stest, sbc, sluong, snn, stg);
		//System.out.println(po);
		return po;
	}

	public String[][] get() {
		try {
			Connection con = Conn.getConn();

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(gsql());
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
			return a;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}

	}
}
