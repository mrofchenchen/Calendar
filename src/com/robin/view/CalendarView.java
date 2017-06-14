package com.robin.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CalendarView extends JFrame{
	private static final long serialVersionUID = 1L;
	private JLabel shijian;
	private JButton riqi;
	private JPanel panel = new JPanel();
	private JLabel[][] b = new JLabel[6][7];
	private JButton[][] yue = new JButton[3][4];
	private Map<Integer, String> xq;
	private JButton ny;
	private JButton jia;
	private JButton jian;
	private JPanel p;
	private JPanel p1;
	private JPanel rl;
	private boolean pd = false;

	private void intnp1() {
		int a = 1;
		for (int i = 0; i < yue.length; i++)
			for (int j = 0; j < yue[i].length; j++) {
				yue[i][j] = new JButton();
				yue[i][j].setBorderPainted(false);
				yue[i][j].addActionListener(new sj());
				yue[i][j].setBackground(Color.lightGray);
				yue[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				yue[i][j].setFont(new Font("华文行楷", Font.PLAIN, 14));
				yue[i][j].setText(a + "月");
				a++;
				p1.add(yue[i][j]);
			}
	}

	class sj implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for (int j = 0; j < yue[0].length; j++)
				if (e.getSource() == yue[0][j])
					shez(0, j);
			for (int j = 0; j < yue[1].length; j++)
				if (e.getSource() == yue[1][j])
					shes(1, j);
			for (int j = 0; j < yue[2].length; j++)
				if (e.getSource() == yue[2][j])
					shed(2, j);
		}
	}

	private void shes(int c, int d) {
		if (ny.getText().length() == 9) {
			ny.setText(yue[c][d].getText());
			int m = 1;
			for (int i = 0; i < yue.length; i++)
				for (int j = 0; j < yue[i].length; j++) {
					yue[i][j].setText(m + "月");
					m++;
				}
		} else if (yue[c][d].getText().length() <= 3) {
			p.remove(p1);
			p.repaint(0);
			p.add("Center", rl);
			p.repaint(0);
			pd = false;
			String m = ny.getText();
			char[] n = m.toCharArray();
			int yy = Integer
					.valueOf(String.valueOf(n[0]) + String.valueOf(n[1]) + String.valueOf(n[2]) + String.valueOf(n[3]));
			for (int i = 0; i < b.length; i++)
				for (int j = 0; j < b[i].length; j++) {
					b[i][j].setText("");
				}
			d = d + 5;

			setb(yy, d);
			ny.setText(yy + "年" + d + "月");
		}

	}

	private void shed(int c, int d) {
		if (ny.getText().length() == 9) {
			ny.setText(yue[c][d].getText());
			int m = 1;
			for (int i = 0; i < yue.length; i++)
				for (int j = 0; j < yue[i].length; j++) {
					yue[i][j].setText(m + "月");
					m++;
				}
		} else if (yue[c][d].getText().length() <= 3) {
			p.remove(p1);
			p.repaint(0);
			p.add("Center", rl);
			p.repaint(0);
			pd = false;
			String m = ny.getText();
			char[] n = m.toCharArray();
			int yy = Integer
					.valueOf(String.valueOf(n[0]) + String.valueOf(n[1]) + String.valueOf(n[2]) + String.valueOf(n[3]));
			for (int i = 0; i < b.length; i++)
				for (int j = 0; j < b[i].length; j++) {
					b[i][j].setText("");
				}
			d = d + 9;

			setb(yy, d);
			ny.setText(yy + "年" + d + "月");
		}
	}

	private void shez(int c, int d) {

		if (ny.getText().length() == 9) {
			ny.setText(yue[c][d].getText());
			int m = 1;
			for (int i = 0; i < yue.length; i++)
				for (int j = 0; j < yue[i].length; j++) {
					yue[i][j].setText(m + "月");
					m++;
				}
		} else if (yue[c][d].getText().length() <= 3) {
			p.remove(p1);
			p.repaint(0);
			p.add("Center", rl);
			p.repaint(0);
			pd = false;
			String m = ny.getText();
			char[] n = m.toCharArray();
			int yy = Integer
					.valueOf(String.valueOf(n[0]) + String.valueOf(n[1]) + String.valueOf(n[2]) + String.valueOf(n[3]));
			for (int i = 0; i < b.length; i++)
				for (int j = 0; j < b[i].length; j++) {
					b[i][j].setText("");
				}
			d = d + 1;

			setb(yy, d);
			ny.setText(yy + "年" + d + "月");
		}
	}

	private void hj() {
		String m = ny.getText();
		char[] n = m.toCharArray();
		int yy = Integer.valueOf(
				String.valueOf(n[0]) + String.valueOf(n[1]) + String.valueOf(n[2]) + String.valueOf(n[3])) + 12;
		int yy1 = Integer
				.valueOf(String.valueOf(n[5]) + String.valueOf(n[6]) + String.valueOf(n[7]) + String.valueOf(n[8])) + 1;

		for (int i = 0; i < yue.length; i++)
			for (int j = 0; j < yue[i].length; j++) {
				yue[i][j].setText(yy1 + "");
				yy1++;
			}
		ny.setText(yy + "-" + (yy1 - 1));

	}

	private void hhj() {
		String m = ny.getText();
		char[] n = m.toCharArray();
		int yyx = Integer
				.valueOf(String.valueOf(n[0]) + String.valueOf(n[1]) + String.valueOf(n[2]) + String.valueOf(n[3]));
		int yy = yyx - 12;
		int yy1 = Integer.valueOf(
				String.valueOf(n[5]) + String.valueOf(n[6]) + String.valueOf(n[7]) + String.valueOf(n[8])) - 12;
		if (yyx >= 1912) {
			for (int i = 0; i < yue.length; i++)
				for (int j = 0; j < yue[i].length; j++) {
					yue[i][j].setText(yy + "");
					yy++;
				}
			ny.setText((yy - 12) + "-" + yy1);
		} else {
			int t = 1900;
			for (int i = 0; i < yue.length; i++)
				for (int j = 0; j < yue[i].length; j++) {
					yue[i][j].setText(t + "");
					t++;
				}
			ny.setText((t - 12) + "-" + (t - 1));
		}

	}

	public CalendarView() {
		setResizable(false);
		setBackground(Color.LIGHT_GRAY);
		setTitle("\u65E5\u5386");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBounds(200, 100, 385, 516);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		URL rll = getClass().getResource("rll.png");
		setIconImage(Toolkit.getDefaultToolkit().getImage(rll));
		int sz[] = { 1, 2, 3, 4, 5, 6, 7 };
		String zw[] = { "日", "一", "二", "三", "四", "五", "六" };
		xq = new HashMap<Integer, String>();
		for (int i = 0; i < sz.length; i++) {
			xq.put(sz[i], zw[i]);
		}

		shijian = new JLabel("");
		shijian.setVerticalAlignment(SwingConstants.BOTTOM);
		shijian.setFont(new Font("华文行楷", Font.BOLD, 34));
		shijian.setHorizontalAlignment(SwingConstants.LEFT);
		shijian.setBounds(28, 10, 184, 49);
		getContentPane().add(shijian);
		riqi = new JButton("");
		riqi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pd == true) {
					int m = 1;
					p.remove(p1);
					p.repaint(0);
					p.add("Center", rl);
					p.repaint(0);
					pd = false;
					for (int i = 0; i < yue.length; i++)
						for (int j = 0; j < yue[i].length; j++) {
							yue[i][j].setText(m + "月");
							m++;
						}

				}
				for (int i = 0; i < b.length; i++)
					for (int j = 0; j < b[i].length; j++) {
						b[i][j].setText("");
					}
				setb(gety(), getm());
				ny.setText(gety() + "年" + getm() + "月");
			}
		});
		riqi.setHorizontalAlignment(SwingConstants.LEFT);
		riqi.setBackground(Color.LIGHT_GRAY);
		riqi.setBorderPainted(false);
		riqi.setVerticalAlignment(SwingConstants.TOP);
		riqi.setFont(new Font("华文行楷", Font.PLAIN, 18));
		riqi.setBounds(10, 59, 234, 29);
		riqi.setText(getda());
		getContentPane().add(riqi);
		intn();
		setb(gety(), getm());

		ny = new JButton(gety() + "年" + getm() + "月");
		ny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (pd == false) {
					String a = ny.getText();
					char[] b = a.toCharArray();
					int yy = Integer.valueOf(
							String.valueOf(b[0]) + String.valueOf(b[1]) + String.valueOf(b[2]) + String.valueOf(b[3]));
					ny.setText(yy + "");
					p.remove(rl);
					p.repaint(0);
					p.add("Center", p1);
					p.repaint(0);
					pd = true;
				} else if (ny.getText().length() == 4) {
					String a = ny.getText();
					char[] b = a.toCharArray();
					int yy = Integer.valueOf(
							String.valueOf(b[0]) + String.valueOf(b[1]) + String.valueOf(b[2]) + String.valueOf(b[3]));
					int c = yy;
					for (int i = 0; i < yue.length; i++)
						for (int j = 0; j < yue[i].length; j++) {
							yue[i][j].setText(yy + "");
							yy++;

						}
					ny.setText(c + "-" + (yy - 1));
				}

			}
		});
		ny.setForeground(Color.BLACK);
		ny.setFont(new Font("华文行楷", Font.PLAIN, 18));
		ny.setBackground(Color.LIGHT_GRAY);
		ny.setBorderPainted(false);
		ny.setBounds(104, 125, 177, 49);
		getContentPane().add(ny);

		jia = new JButton("\u25B2");
		jia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ny.getText().length() > 4 && ny.getText().length() <= 8) {
					for (int i = 0; i < b.length; i++)
						for (int j = 0; j < b[i].length; j++) {
							b[i][j].setText("");
						}

					String a = ny.getText();
					char[] b = a.toCharArray();

					int yy = Integer.valueOf(
							String.valueOf(b[0]) + String.valueOf(b[1]) + String.valueOf(b[2]) + String.valueOf(b[3]));

					if (String.valueOf(b[6]).equals("月")) {
						int s = Integer.valueOf(String.valueOf(b[5])) + 1;
						ny.setText(yy + "年" + s + "月");
						setb(yy, s);

					} else if (Integer.valueOf(String.valueOf(b[6])) < 2) {
						int s = Integer.valueOf(String.valueOf(b[5]) + String.valueOf(b[6])) + 1;
						ny.setText(yy + "年" + s + "月");
						setb(yy, s);
					} else {
						yy = yy + 1;
						int s = 1;
						ny.setText(yy + "年" + s + "月");
						setb(yy, s);

					}

				} else if (ny.getText().length() == 4) {
					String a = ny.getText();
					char[] b = a.toCharArray();

					int yy = Integer.valueOf(
							String.valueOf(b[0]) + String.valueOf(b[1]) + String.valueOf(b[2]) + String.valueOf(b[3]));
					ny.setText(yy + 1 + "");

				} else if (ny.getText().length() == 9) {
					hj();
				}

			}
		});
		jia.setFont(new Font("微软雅黑", Font.BOLD, 11));
		jia.setBackground(Color.LIGHT_GRAY);
		jia.setBorderPainted(false);
		jia.setBounds(278, 125, 45, 49);
		getContentPane().add(jia);

		jian = new JButton("\u25BC");
		jian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ny.getText().length() > 4 && ny.getText().length() <= 8 && !ny.getText().equals("1900年1月")) {
					for (int i = 0; i < b.length; i++)
						for (int j = 0; j < b[i].length; j++) {
							b[i][j].setText("");
						}
					String a = ny.getText();
					char[] b = a.toCharArray();
					int yy = Integer.valueOf(
							String.valueOf(b[0]) + String.valueOf(b[1]) + String.valueOf(b[2]) + String.valueOf(b[3]));
					if (String.valueOf(b[5]).equals("1") && String.valueOf(b[6]).equals("月")) {
						int s = 12;
						yy = yy - 1;
						ny.setText(yy + "年" + s + "月");
						setb(yy, s);
					} else if (String.valueOf(b[6]).equals("月")) {
						int s = Integer.valueOf(String.valueOf(b[5])) - 1;
						ny.setText(yy + "年" + s + "月");
						setb(yy, s);
					} else {
						int s = Integer.valueOf(String.valueOf(b[5]) + String.valueOf(b[6])) - 1;
						ny.setText(yy + "年" + s + "月");
						setb(yy, s);
					}
				} else if (ny.getText().length() == 4 && !ny.getText().equals("1900")) {
					String a = ny.getText();
					char[] b = a.toCharArray();
					int yy = Integer.valueOf(
							String.valueOf(b[0]) + String.valueOf(b[1]) + String.valueOf(b[2]) + String.valueOf(b[3]));
					ny.setText(yy - 1 + "");

				} else if (ny.getText().length() == 9) {
					hhj();
				}
			}
		});
		jian.setFont(new Font("微软雅黑", Font.BOLD, 11));
		jian.setBackground(Color.LIGHT_GRAY);
		jian.setBorderPainted(false);
		jian.setBounds(59, 125, 45, 49);
		getContentPane().add(jian);

		p = new JPanel();
		p.setBackground(Color.LIGHT_GRAY);
		p.setBounds(0, 173, 381, 304);
		getContentPane().add(p);
		p.setLayout(new BorderLayout(0, 0));

		p1 = new JPanel();
		p1.setBackground(Color.LIGHT_GRAY);
		p1.setLayout(new GridLayout(3, 4, 1, 1));
		intnp1();

		rl = new JPanel();
		p.add(rl);
		rl.setBackground(Color.LIGHT_GRAY);
		rl.setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"    \u65E5       \u4E00       \u4E8C       \u4E09        \u56DB       \u4E94       \u516D");
		lblNewLabel.setBounds(0, 0, 379, 32);
		rl.add(lblNewLabel);
		lblNewLabel.setFont(new Font("华文行楷", Font.PLAIN, 18));
		panel.setBounds(0, 35, 379, 269);
		rl.add(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(new GridLayout(6, 7, 0, 0));
		setVisible(true);
		run();

	}

	public void run() {
		while (true) {
			shijian.setText(getTime());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private String getTime() {
		Calendar calendar = new GregorianCalendar();
		int hour = calendar.get(Calendar.HOUR_OF_DAY); // 获得当前小时
		int minute = calendar.get(Calendar.MINUTE); // 获得当前分钟
		int second = calendar.get(Calendar.SECOND); // 获得当前秒
		return format(hour) + ":" + format(minute) + ":" + format(second);// 返回格式化的字符串
	}

	private String getda() {
		Calendar calendar = new GregorianCalendar();
		int y = calendar.get(Calendar.YEAR);
		int m = calendar.get(Calendar.MONTH) + 1;
		int r = calendar.get(Calendar.DATE);
		int q = calendar.get(Calendar.DAY_OF_WEEK);

		String qq = String.valueOf(xq.get(q));
		return y + "年" + m + "月" + r + "日" + "，" + "星期" + qq;// 返回格式化的字符串
	}

	private int getm() {
		Calendar calendar = new GregorianCalendar();
		int m = calendar.get(Calendar.MONTH) + 1;
		return m;
	}

	private int gety() {
		Calendar calendar = new GregorianCalendar();
		int y = calendar.get(Calendar.YEAR);
		return y;
	}

	private void intn() {
		for (int i = 0; i < b.length; i++)// 添加按钮
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = new JLabel();
				b[i][j].setBackground(Color.lightGray);
				b[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				b[i][j].setFont(new Font("华文行楷", Font.PLAIN, 14));
				b[i][j].setText("");
				panel.add(b[i][j]);
			}
	}

	private void setb(int year, int moon) {
		int sum = 0;

		for (int i = 1990; i < year; i++) {
			if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
				sum += 366;
			} else {
				sum += 365;
			}
		}

		for (int i = 1; i < moon; i++) {
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				if (i == 2) {
					sum += 29;
				} else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
					sum += 31;
				} else {
					sum += 30;
				}
			} else {
				if (i == 2) {
					sum += 28;
				} else if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
					sum += 31;
				} else {
					sum += 30;
				}
			}
		}
		sum += 1;
		int work = sum % 7;
		if (moon == 1 || moon == 3 || moon == 5 || moon == 7 || moon == 8 || moon == 10 || moon == 12) {
			for (int i = 0; i < work; i++)
				b[0][i].setText("");
			int n = 1, m = 31;
			for (int f = work; f < 7; f++) {
				b[0][f].setText(n + "");
				n++;
			}
			for (int i = 1; i < b.length; i++)
				for (int j = 0; j < b[i].length; j++) {
					if (n <= m) {
						b[i][j].setText(n + "");
						n++;
					}
				}

		} else if (moon == 2) {
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				for (int i = 0; i < work; i++)
					b[0][i].setText("");
				int n = 1, m = 29;
				for (int f = work; f < 7; f++) {
					b[0][f].setText(n + "");
					n++;
				}
				for (int i = 1; i < b.length; i++)
					for (int j = 0; j < b[i].length; j++) {
						if (n <= m) {
							b[i][j].setText(n + "");
							n++;
						}
					}
			} else {
				for (int i = 0; i < work; i++)
					b[0][i].setText("");
				int n = 1, m = 28;
				for (int f = work; f < 7; f++) {
					b[0][f].setText(n + "");
					n++;
				}
				for (int i = 1; i < b.length; i++)
					for (int j = 0; j < b[i].length; j++) {
						if (n <= m) {
							b[i][j].setText(n + "");
							n++;
						}
					}
			}
		} else {
			for (int i = 0; i < work; i++)
				b[0][i].setText("");
			int n = 1, m = 30;
			for (int f = work; f < 7; f++) {
				b[0][f].setText(n + "");
				n++;
			}
			for (int i = 1; i < b.length; i++)
				for (int j = 0; j < b[i].length; j++) {
					if (n <= m) {
						b[i][j].setText(n + "");
						n++;
					}
				}
		}

	}

	private String format(int number) {
		return number < 10 ? "0" + number : "" + number;// 如果数字小于10就在其前面加0补齐
	}

	public static void main(String args[]) {
		new CalendarView();
	}
}
