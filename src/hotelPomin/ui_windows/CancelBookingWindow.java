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
 * Форма для зняття броні з номеру
 * @author Roman
 *
 */

public class CancelBookingWindow extends JFrame {
	
	private JPanel panel = new JPanel();
	
	private JLabel noNum;
	private JLabel surname;
	
	private JLabel reasonLab = new JLabel("Причина зняття: ");
	private JComboBox<String> reasons = new JComboBox<String>();
	
	private JButton confirm = new JButton("ОК");
	private JButton cancel = new JButton("Скасувати");
	
	public CancelBookingWindow(int no, String surn) {
		
		this.setLocation(650,430);
		this.setSize(500,140);
		this.setTitle("Зняття бронювання з номеру");
		
		noNum = new JLabel("Номер: "+no);
		surname = new JLabel("Прізвище/назва: "+surn);
		
		panel.setLayout(new GridLayout(0, 2, 0, 10));
		
		panel.add(noNum);
		panel.add(surname);
		
		panel.add(reasonLab);
		
		reasons.addItem("Поселення клієнта");
		reasons.addItem("Відмова клієнта");
		reasons.addItem("Відсутність клієнта");
		
		panel.add(reasons);
		
		panel.add(confirm);
		panel.add(cancel);
		
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//Заглушка
				//По натисненню має видалитися запис про бронювання
				//вказаного номера в БД
				
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
