package convert;

import java.util.ArrayList;

import data.Sql;

public class Tinh {
	private int[] mg = new int[7];
	public double trongso[];
	public static final int exp = 0, luong = 1, skill = 2, bc = 4, tg = 5, language = 6, pv = 3, heal = 7, truong = 8,
			test = 9;
	public double[] all = new double[10];
	public int[][] cost;
	
	public int getlength() {
		return cost.length;
	}

	public Tinh(double[] k) {
		trongso = k;
		setluong("5000000");
	}

	public double geti(int i) {
		return gettest(i) + getbc(i) + getexp(i) + gettruong(i) + gettg(i) + getlang(i) + getluong(i) + getheal(i)
				+ getpv(i) + getskill(i);
	}

	private double gettest(int i) {
		int d = test;
		return (trongso[d] * cost[i][d]) / all[d];
	}

	private double gettruong(int i) {
		int d = truong;
		return (trongso[d] * cost[i][d]) / all[d];
	}

	private double getheal(int i) {
		int d = heal;
		return (trongso[d] * cost[i][d]) / all[d];
	}

	private double getpv(int i) {
		return getn(i, pv);
	}

	private double getlang(int i) {
		return getn(i, language);
	}

	private double getbc(int i) {
		return getn(i, bc);
	}

	private double gettg(int i) {
		return getn(i, tg);
	}

	private double getskill(int i) {
		return getn(i, skill);
	}

	private double getluong(int i) {
		return getn(i, luong);
	}

	private double getexp(int i) {
		return getn(i, exp);
	}

	private double getn(int i, int exp) {
		if (mg[exp] == 0) {
			return trongso[exp] * cost[i][exp] / all[exp];
		} else {
			double k = Math.abs(mg[exp] - cost[i][exp]) + 1;
			return trongso[exp] / k;
		}
	}

	/**
	 * chuyen doi kieundu lieu , tinh mau cua topsis
	 * 
	 * @param sq
	 */
	public void parse(Sql sq) {
		String[][] cop = sq.geta();
		int l = cop.length;
		cost = new int[l][10];
		for (int i = 0; i < l; i++) {
			int c = Point.degree(cop[i][Sql.bc]);
			cost[i][bc] = c;
			if (all[bc] < c)
				all[bc] = c;

			c = Point.skill(cop[i][Sql.skill]);
			cost[i][skill] = c;
			if (all[skill] < c)
				all[skill] = c;

			c = Integer.parseInt(cop[i][Sql.luong]) / 1000;
			cost[i][luong] = c;
			if (all[luong] < c)
				all[luong] = c;

			c = Integer.parseInt(cop[i][Sql.exp]);
			cost[i][exp] = c;
			if (all[exp] < c)
				all[exp] = c;

			c = Integer.parseInt(cop[i][Sql.tg]);
			cost[i][tg] = c;
			if (all[tg] < c)
				all[tg] = c;

			c = Point.engl(cop[i][Sql.language]);
			cost[i][language] = c;
			if (all[language] < c)
				all[language] = c;

			c = Point.interview(cop[i][Sql.pv]);
			cost[i][pv] = c;
			if (all[pv] < c)
				all[pv] = c;

			c = Point.health(cop[i][Sql.heal]);
			cost[i][heal] = c;
			if (all[heal] < c)
				all[heal] = c;

			c = Point.school(cop[i][Sql.truong]);
			cost[i][truong] = c;
			if (all[truong] < c)
				all[truong] = c;

			c = Integer.parseInt(cop[i][Sql.test]);
			cost[i][test] = c;
			if (all[test] < c)
				all[test] = c;
		}
		for (int i = 0; i < all.length; i++) {
			all[i] = all[i] + 1;
		}
	}

	public void parsed(Sql sq) {
		String[][] cop = sq.geta();
		int l = cop.length;
		cost = new int[l][10];
		for (int i = 0; i < l; i++) {
			int c = Point.degree(cop[i][Sql.bc]);
			cost[i][bc] = c;
			all[bc] = all[bc] + c * c;

			c = Point.skill(cop[i][Sql.skill]);
			cost[i][skill] = c;
			all[skill] = all[skill] + c * c;

			c = Integer.parseInt(cop[i][Sql.luong]) / 1000;
			cost[i][luong] = c;
			all[luong] = all[luong] + c * c;

			c = Integer.parseInt(cop[i][Sql.exp]);
			cost[i][exp] = c;
			all[exp] = all[exp] + c * c;

			c = Integer.parseInt(cop[i][Sql.tg]);
			cost[i][tg] = c;
			all[tg] = all[tg] + c * c;

			c = Point.engl(cop[i][Sql.language]);
			cost[i][language] = c;
			all[language] = all[language] + c * c;

			c = Point.interview(cop[i][Sql.pv]);
			cost[i][pv] = c;
			all[pv] = all[pv] + c * c;

			c = Point.health(cop[i][Sql.heal]);
			cost[i][heal] = c;
			all[heal] = all[heal] + c * c;

			c = Point.school(cop[i][Sql.truong]);
			cost[i][truong] = c;
			all[truong] = all[truong] + c * c;

			c = Integer.parseInt(cop[i][Sql.test]);
			cost[i][test] = c;
			all[test] = all[test] + c * c;
		}
		for (int i = 0; i < all.length; i++) {
			all[i] = Math.sqrt(all[i]) + 1;
		}
	}

	public void setpv(String s) {
		int d = Point.engl(s);
		mg[pv] = d;
	}

	public boolean setluong(String a) {
		try {
			int s = Integer.parseInt(a) / 1000;
			mg[luong] = s;
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public boolean setexp(String a) {
		try {
			int s = Integer.parseInt(a);
			mg[exp] = s;
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public void setlang(String s) {
		int d = Point.engl(s);
		mg[language] = d;
	}

	public void setbc(String s) {
		mg[bc] = Point.degree(s);
	}

	public void setkynang(String s) {
		mg[skill] = Point.skill(s);
	}

	public boolean settg(String a) {
		try {
			int s = Integer.parseInt(a);
			mg[tg] = s;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public int[] ketqua() {
		int h = cost.length;
		ArrayList<Node> ar = new ArrayList<Node>();
		if (h > 0) {
			ar.add(new Node(0, 10));
			ar.add(new Node(0, -10));
		}
		for (int i = 0; i < h; i++) {
			double s = geti(i);
			int k = where(s, ar);
			ar.add(k + 1, new Node(i, s));
		}
		int[] s = new int[h];
		System.out.println(h);
		for (int i = 1; i <= h; i++) {
			s[i - 1] = ar.get(i).vt;
			ar.get(i).pr();
		}
		return s;
	}

	int where(double s, ArrayList<Node> ar) {
		int d = 0, c = ar.size() - 1;
		int g = 0;
		while (d < c) {
			g = (d + c) / 2;
			if (d == g || c == g)
				break;
			double p = ar.get(g).gt;
			if (s < p) {
				d = g;
			} else if (s > p) {
				c = g;
			} else
				return g;
		}
		return g;
	}
}
