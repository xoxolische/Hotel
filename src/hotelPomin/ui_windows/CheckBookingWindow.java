package hotelPomin.ui_windows;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;


/***
 * Форма для перевірки броні за прізвищем фіз. особи
 * або за назвою юридичної особи
 * @author Roman
 *
 */

public class CheckBookingWindow extends JFrame {
	
	private JPanel panel = new JPanel();
	
	private JLabel fioLab = new JLabel("Прізвище/назва: ");
	private JTextField fio = new JTextField();
	
	private JTable tableRes = new JTable();
	private JScrollPane pane = new JScrollPane(tableRes);
	
	private JButton ok = new JButton("OK");
	private JButton cancBooking = new JButton("Зняти бронювання");
	
	public CheckBookingWindow() {		
		this.setLocation(650,100);
		this.setSize(500,330);
		this.setTitle("Перевірка бронювання");
		
		
		panel.setLayout(new GridBagLayout());
		
		//Контейнер, на який додаються компоненти
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 0.5;
		c.weighty = 0.5;
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		
		panel.add(fioLab, c);
		
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		
		panel.add(fio, c);

		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		c.ipady = 160;
		panel.add(pane, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 2;
		c.ipady = 0;
		panel.add(ok, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		panel.add(cancBooking, c);
		
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				/*BookingInfoItemColl numsColl = new BookingInfoItemColl();
				ArrayList<BookingInfoItem> bookedNums = numsColl.getList();
				
				System.out.println("Size: "+bookedNums.size());
				
				BookingInfoModel bookInfoModel = new BookingInfoModel(bookedNums);
				
				bookInfoModel = new BookingInfoModel(bookedNums);
				
				tableRes.setModel(bookInfoModel);*/
				
			}
		});
		
		cancBooking.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int rowInd = tableRes.getSelectedRow();
				
				String[] selVals = new String[2];
				
				if(rowInd != -1) {
					for(int i=0; i<tableRes.getColumnCount()-1; i++) {
						selVals[i] = ""+tableRes.getValueAt(rowInd, i);
					}
					
					int numNo = Integer.parseInt(selVals[0]);
					String surn = selVals[1];
					
					CancelBookingWindow cancBookWind = new CancelBookingWindow(numNo, surn);
					
				}
				
			}
		});
	
		
		this.add(panel);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		CheckBookingWindow check = new CheckBookingWindow();
	}

}
