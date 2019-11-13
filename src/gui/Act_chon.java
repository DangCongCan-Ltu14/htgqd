package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import convert.Tinh;
import data.Sql;

public class Act_chon implements ActionListener {
	App ap;

	public Act_chon(App s) {
		ap = s;
	}

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
		tt.parse(sq);
		
	}

	private void pr(int[][] a) {
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
