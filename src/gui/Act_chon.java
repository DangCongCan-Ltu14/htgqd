package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import convert.Tinh;
import data.Sql;

public class Act_chon implements ActionListener {
	App ap;

	public Act_chon(App s) {
		ap = s;
	}

	static String[] name = { "ten uv", "ki nang", "phong van", "bang cap", "truong hoc", "trinh do nn", "suc khoe",
			"diem test", "luong mong muon", "thoi gian hop dong ", "kinh nghiem" };

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
				v = Integer.parseInt(at[7]);
			}
		} catch (Exception ex) {
			// TODO: handle exception
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
//		sq.chontest(at[Tinh.test], bt[Tinh.test]);
		sq.chonkn(at[Tinh.exp], bt[Tinh.exp]);
		sq.chonluong(at[Tinh.luong], bt[Tinh.luong]);
		sq.chonnn(at[Tinh.language], bt[Tinh.language]);
//		sq.chonsk(at[Tinh.heal], bt[Tinh.heal]);
		sq.chontg(at[Tinh.tg], bt[Tinh.tg]);
		sq.get();
		tt.parse(sq);
		int[] mg = tt.ketqua();
		String[][] kq = createtable(sq, mg, v);
		JTable tb = new JTable(kq, name);
		ap.showk(tb);
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
