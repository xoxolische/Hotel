package hotelPomin.ui_windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/***
 * ����� ��� ������ ���� � ������
 * @author Roman
 *
 */

public class CancelBookingWindow extends JFrame {
	
	private JPanel panel = new JPanel();
	
	private JLabel noNum;
	private JLabel surname;
	
	private JLabel reasonLab = new JLabel("������� ������: ");
	private JComboBox<String> reasons = new JComboBox<String>();
	
	private JButton confirm = new JButton("��");
	private JButton cancel = new JButton("���������");
	
	public CancelBookingWindow(int no, String surn) {
		
		this.setLocation(650,430);
		this.setSize(500,140);
		this.setTitle("������ ���������� � ������");
		
		noNum = new JLabel("�����: "+no);
		surname = new JLabel("�������/�����: "+surn);
		
		panel.setLayout(new GridLayout(0, 2, 0, 10));
		
		panel.add(noNum);
		panel.add(surname);
		
		panel.add(reasonLab);
		
		reasons.addItem("��������� �볺���");
		reasons.addItem("³����� �볺���");
		reasons.addItem("³�������� �볺���");
		
		panel.add(reasons);
		
		panel.add(confirm);
		panel.add(cancel);
		
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//��������
				//�� ���������� �� ���������� ����� ��� ����������
				//��������� ������ � ��
				
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		this.add(panel);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		CancelBookingWindow wind = new CancelBookingWindow(100, "Ivanov");
	}

}
