package ui_windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/***
 * ����� ��� ���������� ������
 * @author Roman
 *
 */

public class BookingWindow extends JFrame {
	
	private JLabel noLab;
	private JLabel classLab;
	private JLabel palcesLab;
	private JLabel floorLab;
	
	private JLabel dateBookLab = new JLabel("���� ����������: ");
	private JTextField dateF = new JTextField();
	
	private JLabel dateELab = new JLabel("���� �����: ");
	private JTextField dateE = new JTextField();
	
	private JLabel daysLab = new JLabel("ʳ������ ���: ");
	private JComboBox<Integer> days = new JComboBox<Integer>();
	
	private JButton bookBut = new JButton("�����������");
	private JButton cancBut = new JButton("���������");
	
	private JPanel panel = new JPanel();
	
	
	
	public BookingWindow(int no, String klas, int places, int floor) {
		noLab = new JLabel("�����: "+no);
		classLab = new JLabel("����: "+klas);
		palcesLab = new JLabel("̳���: "+places);
		floorLab = new JLabel("������: "+floor);
		
		
		this.setLocation(650,100);
		this.setSize(500,200);
		this.setTitle("����������� �����");

		
		//Using Grid Layout
		panel.setLayout(new GridLayout(0,2,0,5));
		
		panel.add(noLab);
		panel.add(palcesLab);
		panel.add(classLab);
		panel.add(floorLab);
		
		panel.add(dateBookLab);
		panel.add(dateF);
		
		panel.add(dateELab);
		panel.add(dateE);
		
		panel.add(daysLab);
		
		for(int i=1; i<=31; i++) {
			days.addItem(i);
		}
		
		panel.add(days);
		
		panel.add(bookBut);
		panel.add(cancBut);
		
		bookBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//��������
				//��� ��������� ���� ������ ���������� �����
				//����� �������� ��� � ����� � ���������� �� ��
			}
		});
		
		cancBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		this.add(panel);
	}
	
	public static void main(String[] args) {
		BookingWindow bookWind = new BookingWindow(112, "***", 2, 1);
		bookWind.setVisible(true);
	}

}
