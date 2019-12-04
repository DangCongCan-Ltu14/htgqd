package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

import convert.Tinh;
import data.Sql;

public class Act_chon implements ActionListener {
	App ap;

	public Act_chon(App s) {
		ap = s;
	}

	static String[] name = { "Hang", "ten uv", "ki nang", "phong van", "bang cap", "truong hoc", "NN", "suc khoe",
			"TEST", "Luong Yeu Cau", "TG", "KN" };

	public void actionPerformed(ActionEvent e) {
		int[] ts = ap.getarr();
		String[] at = ap.getgt();
		double d = 0;
		for (int k : ts) {
			d = d + k;
		}
		d = 1.0 / d;
		double[] h = new double[ts.length];
		for (int i = 0; i < h.length; i++) {
			h[i] = d * ts[i];
		}

		Tinh tt = new Tinh(h);
		tt.setbc(at[Tinh.bc]);
		boolean s;
		int v = 40;
		try {
			if (!at[10].equals("")) {
				v = Integer.parseInt(at[10]);
			}
		} catch (Exception ex) {
			return;
		}
		if (!at[Tinh.exp].equals(""))

		{
			s = tt.setexp(at[Tinh.exp]);
			if (!s) {
				System.out.println("loi nk");
				return;
			}
		}
		if (!at[Tinh.tg].equals("")) {
			s = tt.settg(at[Tinh.tg]);
			if (!s) {
				System.out.println("loi nt");
				return;
			}
		}
		if (!at[Tinh.luong].equals(""))

		{
			s = tt.setexp(at[Tinh.luong]);
			if (!s) {
				System.out.println("loi nl");
				return;
			}
		}
		tt.setkynang(at[Tinh.skill]);
		tt.setlang(at[Tinh.language]);
		tt.setpv(at[Tinh.pv]);
		Sql sq = new Sql();
		String[] bt = ap.getkieu();

		sq.chonbc(at[Tinh.bc], bt[Tinh.bc]);
		// sq.chontest(at[Tinh.test], bt[Tinh.test]);
		sq.chonkn(at[Tinh.exp], bt[Tinh.exp]);
		sq.chonluong(at[Tinh.luong], bt[Tinh.luong]);
		sq.chonnn(at[Tinh.language], bt[Tinh.language]);
		// sq.chonsk(at[Tinh.heal], bt[Tinh.heal]);
		sq.chontg(at[Tinh.tg], bt[Tinh.tg]);
		sq.get();
		tt.parse(sq);
		int[] mg = tt.ketqua();
		String[][] kq = createtable(sq, mg, v);
		Object[][] sd = cvObj(kq);
		JTable tb = new JTable(sd, name);
		TableColumn cl = tb.getColumn("KN");
		cl.setPreferredWidth(10);
		cl = tb.getColumn("NN");
		cl.setPreferredWidth(10);
		cl = tb.getColumn("TG");
		cl.setPreferredWidth(10);
		cl = tb.getColumn("TEST");
		cl.setPreferredWidth(15);
		cl = tb.getColumn("Hang");
		cl.setPreferredWidth(15);
		cl = tb.getColumn("suc khoe");
		cl.setPreferredWidth(25);
		ap.showk(tb);
	}

	private Object[][] cvObj(String[][] kq) {
		int x = kq.length;
		int y = kq[0].length;
		Object[][] res = new Object[x][y + 1];
		for (int i = 0; i < x; i++) {
			res[i][0] = i + 1;
			for (int j = 0; j < y; j++) {
				res[i][j + 1] = kq[i][j];
			}
		}
		return res;
	}

	private String[][] createtable(Sql sq, int[] mg, int v) {

		int k = mg.length;
		if (k > v)
			k = v;
		String[][] ss = sq.geta();
		String[][] res = new String[k][];
		for (int i = 0; i < k; i++) {
			res[i] = ss[mg[i]];
		}
		return res;
	}

	void pr(int[][] a) {
		// TODO Auto-generated method stub
		for (int[] s : a) {
			for (int p : s)
				System.out.print(p + "  ");
			System.out.println();
		}
	}

	static void pr(Object[][] a) {
		for (Object[] s : a) {
			for (Object p : s)
				System.out.print(p + "  ");
			System.out.println();
		}
	}
}
