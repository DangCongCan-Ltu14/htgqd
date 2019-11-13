package convert;

import java.util.Arrays;
import java.util.List;

public class Point {
	public static List<String> uni = Arrays.asList("hust", "ptit", "neu", "bon ba");// hoi xoay dap xoay

	public static int rkinhnghiem() {
		return (int) (Math.random() * 10);
	}
	public static int rtg() {
		return (int) (Math.random() * 10);
	}
	public static int rluong() {
		return ((int) (Math.random() * 20)+1) * 1000000;
	}

	public static int rtest() {
		return (int) (Math.random() * 20);
	}

	public static final String[] nn = { "A1", "A2", "B1", "B2", "C1", "C2" };

	public static String reng() {
		int s = (int) (Math.random() * 6);
		return nn[s];
	}

	public static int engl(String a) {
		if (a.equals("A1"))
			return 1;
		if (a.equals("A2"))
			return 2;
		if (a.equals("B1"))
			return 3;
		if (a.equals("B2"))
			return 4;
		if (a.equals("C1"))
			return 5;
		if (a.equals("C2"))
			return 6;
		return 0;
	}

	static final String[] mder = { "THCS", "THPT", "Dai hoc", "Thac si", "Tien si" };

	public static String rdegreee() {
		int s = (int) (Math.random() * 5);
		return mder[s];
	}

	public static int degree(String a) {
		if (a.equals("THCS"))
			return 1;
		if (a.equals("THPT"))
			return 2;
		if (a.equals("Dai hoc"))
			return 4;
		if (a.equals("Thac si"))
			return 6;
		if (a.equals("Tien si"))
			return 10;
		return 0;
	}

	static final String[] pv = { "thuong", "kha", "tot", "uu" };;

	public static String rinterview() {
		int s = (int) (Math.random() * 4);
		return pv[s];
	}

	public static int interview(String a) {
		if (a.equals("thuong"))
			return 1;
		if (a.equals("kha"))
			return 2;
		if (a.equals("tot"))
			return 3;
		if (a.equals("uu"))
			return 5;
		return 0;
	}

	static final String[] skill = { "thuong", "kha", "tot" };

	public static String rskill() {
		int s = (int) (Math.random() * 3);
		return skill[s];
	}

	public static int skill(String a) {
		if (a.equals("thuong"))
			return 1;
		if (a.equals("kha"))
			return 2;
		if (a.equals("tot"))
			return 3;
		return 0;
	}

	static final String[] heal = { "thuong", "kha", "tot" };

	public static String rheal() {
		int s = (int) (Math.random() * 3);
		return heal[s];
	}

	public static int health(String a) {
		if (a.equals("thuong"))
			return 1;
		if (a.equals("kha"))
			return 2;
		if (a.equals("tot"))
			return 4;
		return 0;
	}

	public static String rschool() {
		return "hust";
	}

	public static int school(String a) {
		boolean c = uni.contains(a);
		if (c) {
			return 2;
		}
		return 1;
	}
}
