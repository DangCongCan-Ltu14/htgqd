package gui;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import convert.Tinh;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class App extends JFrame {
	String[] mg = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" };
	int[] list = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

	public static void main(String[] args) {
		new App();
	}

	void setbox(JComboBox<Integer> p) {
		for (int s : list) {
			p.addItem(s);
		}
	}

	void setbox(JComboBox<String> p, String[] d) {
		for (String s : d) {
			p.addItem(s);
		}
	}

	public App() {
		menu();
		inits();
		initk();
		shows();
	}

	private void menu() {
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(750, 500);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

	}

	protected void showk() {
		panel.setVisible(false);
		ketqua.setVisible(true);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(ketqua, GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(ketqua, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE).addContainerGap()));

		getContentPane().setLayout(groupLayout);
	}

	protected void initk() {
		ketqua = new JPanel();
		ketqua.setVisible(false);
		JScrollPane scrollPane = new JScrollPane();

		JButton btnBack = new JButton("back");
		GroupLayout gl_ketqua = new GroupLayout(ketqua);
		gl_ketqua.setHorizontalGroup(gl_ketqua.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_ketqua.createSequentialGroup().addContainerGap(581, Short.MAX_VALUE)
						.addComponent(btnBack).addGap(25)));
		gl_ketqua.setVerticalGroup(gl_ketqua.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ketqua.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(btnBack).addContainerGap(13, Short.MAX_VALUE)));

		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		ketqua.setLayout(gl_ketqua);

	}

	protected void shows() {
		panel.setVisible(true);
		ketqua.setVisible(true);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE).addContainerGap()));
		getContentPane().setLayout(groupLayout);

	}

	protected void inits() {
		panel = new JPanel();
		panel.setVisible(false);
		JLabel lblMucLuong = new JLabel("muc luong");

		JLabel lblDoUuTien = new JLabel("do uu tien");

		t_luong = new JTextField();
		t_luong.setColumns(10);

		JLabel lblBangCap = new JLabel("bang cap");
		String[] bc = { "", "THCS", "THPT", "Dai hoc", "Thac si", "Tien si" };

		t_bangcap = new JComboBox<String>();
		setbox(t_bangcap, bc);
		c_luong = new JComboBox<Integer>();
		setbox(c_luong);
		c_bangcap = new JComboBox<Integer>();
		setbox(c_bangcap);
		JLabel lblGiaTri = new JLabel("gia tri");

		JLabel lblKinhNghiem = new JLabel("kinh nghiem");

		t_kinhnghiem = new JTextField();
		t_kinhnghiem.setColumns(10);

		c_kinhnghiem = new JComboBox<Integer>();
		setbox(c_kinhnghiem);
		JLabel lblNgoaiNgu = new JLabel("ngoai ngu");
		String[] nn = { "", "A1", "A2", "B1", "B2", "C1", "C2" };
		t_ngoaingu = new JComboBox<String>();
		setbox(t_ngoaingu, nn);
		c_ngoaingu = new JComboBox<Integer>();
		setbox(c_ngoaingu);
		JLabel lblThoiGianLv = new JLabel("thoi gian lv");

		JLabel lblSucKhoe = new JLabel("suc khoe");

		JLabel lblTruongHoc = new JLabel("truong hoc");

		t_thoigian = new JTextField();
		t_thoigian.setColumns(10);

		c_thoigian = new JComboBox<Integer>();
		setbox(c_thoigian);
		JLabel lblKiNangMem = new JLabel("ki nang mem");

		JLabel lblPhongVan = new JLabel("phong van");

		JLabel lblBaiTest = new JLabel("bai test");

		JLabel lblGiaTri_1 = new JLabel("gia tri");

		JLabel lblDoUuTien_1 = new JLabel("do uu tien");

		c_suckhoe = new JComboBox<Integer>();
		setbox(c_suckhoe);

		c_truong = new JComboBox<Integer>();
		setbox(c_truong);
		String[] skill = { "", "thuong", "kha", "tot" };
		t_kinang = new JComboBox<String>();
		setbox(t_kinang, skill);
		c_kinang = new JComboBox<Integer>();
		setbox(c_kinang);
		String[] pv = { "", "thuong", "kha", "tot", "uu" };
		t_phongvan = new JComboBox<String>();
		setbox(t_phongvan, pv);
		c_phongvan = new JComboBox<Integer>();
		setbox(c_phongvan);

		c_test = new JComboBox<Integer>();
		setbox(c_test);

		JButton btnSend = new JButton("send");
		btnSend.addActionListener(new Act_chon(this));
		JLabel lblSoLuong = new JLabel("so luong");

		t_soluong = new JTextField();
		t_soluong.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, gl_panel
						.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
								.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblDoUuTien)
										.addComponent(lblGiaTri).addComponent(lblDoUuTien_1))
								.addGap(26)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(c_suckhoe, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(c_luong, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(t_luong, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
										.addComponent(lblMucLuong).addComponent(lblSucKhoe)))
								.addComponent(lblGiaTri_1))
						.addGap(45)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(c_bangcap, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblBangCap)
										.addComponent(t_bangcap, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblTruongHoc, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 98,
												Short.MAX_VALUE)
										.addComponent(c_truong, Alignment.LEADING, 0, 98, Short.MAX_VALUE)))
						.addGap(37)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(c_kinang, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(t_kinang, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(c_kinhnghiem, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(t_kinhnghiem, 0, 0, Short.MAX_VALUE)
								.addComponent(lblKinhNghiem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(lblKiNangMem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGap(36)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(c_phongvan, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(t_ngoaingu, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(c_ngoaingu, 0, 81, Short.MAX_VALUE).addComponent(lblNgoaiNgu)
								.addComponent(lblPhongVan)
								.addComponent(t_phongvan, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(36)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false).addComponent(lblBaiTest)
								.addComponent(t_thoigian, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
								.addComponent(lblThoiGianLv)
								.addComponent(c_thoigian, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(c_test, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(12))
						.addGroup(Alignment.TRAILING,
								gl_panel.createSequentialGroup().addComponent(btnSend).addContainerGap())
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblSoLuong).addContainerGap(642,
								Short.MAX_VALUE))
						.addGroup(gl_panel
								.createSequentialGroup().addComponent(t_soluong, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(584, Short.MAX_VALUE)))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblMucLuong)
								.addComponent(lblBangCap).addComponent(lblKinhNghiem).addComponent(lblNgoaiNgu))
						.addComponent(lblThoiGianLv, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(t_luong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(t_bangcap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGiaTri, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(t_kinhnghiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(t_ngoaingu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(t_thoigian, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addComponent(lblDoUuTien)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(c_luong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(c_bangcap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(c_kinhnghiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(c_ngoaingu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(c_thoigian, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(66)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblSucKhoe)
						.addComponent(lblTruongHoc).addComponent(lblKiNangMem).addComponent(lblPhongVan)
						.addComponent(lblBaiTest))
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblGiaTri_1)
								.addComponent(t_kinang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(t_phongvan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(18).addComponent(lblDoUuTien_1))
								.addGroup(gl_panel.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(c_phongvan, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(c_test, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(c_suckhoe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(c_truong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(c_kinang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(61).addComponent(lblSoLuong).addGap(18)
				.addComponent(t_soluong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE).addComponent(btnSend)
				.addContainerGap()));
		panel.setLayout(gl_panel);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8669611747002447526L;
	private JPanel panel;
	private JTable table;
	private JPanel ketqua;
	private JComboBox<Integer> c_luong;
	private JComboBox<Integer> c_bangcap;
	private JComboBox<Integer> c_kinhnghiem;
	private JComboBox<Integer> c_thoigian;
	private JComboBox<Integer> c_ngoaingu;
	private JComboBox<Integer> c_suckhoe;
	private JComboBox<Integer> c_truong;
	private JComboBox<Integer> c_kinang;
	private JComboBox<Integer> c_phongvan;
	private JComboBox<Integer> c_test;

	private JTextField t_luong;
	private JComboBox<String> t_bangcap;
	private JTextField t_kinhnghiem;
	private JComboBox<String> t_ngoaingu;
	private JComboBox<String> t_kinang;
	private JComboBox<String> t_phongvan;
	private JTextField t_soluong;
	private JTextField t_thoigian;

	protected String[] getgt() {
		String[] res = new String[8];
		res[Tinh.luong] = t_luong.getText();
		res[Tinh.bc] = (String) t_bangcap.getSelectedItem();
		res[Tinh.skill] = (String) t_kinang.getSelectedItem();
		res[Tinh.pv] = (String) t_phongvan.getSelectedItem();
		res[Tinh.exp] = t_kinhnghiem.getText();
		res[Tinh.language] = (String) t_ngoaingu.getSelectedItem();
		res[Tinh.tg] = t_thoigian.getText();
		res[7] = t_soluong.getText();
		return res;
	}

	protected int[] getarr() {
		int[] res = new int[10];
		res[Tinh.exp] = (int) c_kinhnghiem.getSelectedItem();
		res[Tinh.bc] = (int) c_bangcap.getSelectedItem();
		res[Tinh.luong] = (int) c_luong.getSelectedItem();
		res[Tinh.tg] = (int) c_thoigian.getSelectedItem();
		res[Tinh.language] = (int) c_ngoaingu.getSelectedItem();
		res[Tinh.heal] = (int) c_suckhoe.getSelectedItem();
		res[Tinh.truong] = (int) c_truong.getSelectedItem();
		res[Tinh.skill] = (int) c_kinang.getSelectedItem();
		res[Tinh.pv] = (int) c_phongvan.getSelectedItem();
		res[Tinh.test] = (int) c_test.getSelectedItem();
		return res;
	}
}
