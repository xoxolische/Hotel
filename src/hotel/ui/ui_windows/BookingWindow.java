package hotel.ui.ui_windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import hotel.services.ClientService;
import hotel.services.ReservationService;
import hotel.services.impl.ClientServiceImpl;
import hotel.services.impl.ReservationServiceImpl;
import hotel.ui.models.ClientTableModel;


/***
 * Форма для бронювання номеру
 * @author Roman
 *
 */

public class BookingWindow extends JFrame {
    private ReservationService reservationService = new ReservationServiceImpl();
    private ClientService clientService = new ClientServiceImpl();
    private JLabel noLab;
    private JLabel classLab;
    private JLabel placesLab;
    private JLabel floorLab;
    
      
    private JLabel dateBookLab = new JLabel("Дата бронювання: ");
    //private JTextField dateF = new JTextField();
    private DatePickerUI dateF = new DatePickerUI();
    
    private JLabel dateELab = new JLabel("Дата заїзду: ");
    //private JTextField dateE = new JTextField();
    private DatePickerUI dateE = new DatePickerUI();
    
    private JLabel daysLab = new JLabel("Кількість днів: ");
    private JComboBox<Integer> days = new JComboBox<Integer>();
    
    private JButton bookBut = new JButton("Забронювати");
    private JButton cancBut = new JButton("Скасувати");
    
    private JPanel panel = new JPanel();    
    
    public BookingWindow(int no, String klas, int places, int floor) {	
	noLab = new JLabel("Номер: "+no);
	classLab = new JLabel("Клас: "+klas);
	placesLab = new JLabel("Місць: "+places);
	floorLab = new JLabel("Поверх: "+floor);
	
	
	//if needed
	/*
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh mm");
		Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
		dateF.setText(dateFormat.format(timeNow));
	 */
	//if needed
	
	this.setLocation(650,100);
	
	//this.setSize(500,400);
	this.setTitle("Забронювати номер");
	
	
	//Using Grid Layout
	panel.setLayout(new GridLayout(0,2,0,5));
	
	panel.add(noLab);
	panel.add(placesLab);
	panel.add(classLab);
	panel.add(floorLab);
	
	panel.add(dateBookLab);
	panel.add(dateF.getJDatePicker());
	
	panel.add(dateELab);
	panel.add(dateE.getJDatePicker());
	
	panel.add(daysLab);
	
	
	for(int i=1; i<=31; i++) {
	    days.addItem(i);
	}
	
	//panel.add(paneClient);
	panel.add(days);
	
	
	
	//panel.add(a.getJDatePicker());
	
	panel.add(bookBut);
	panel.add(cancBut);
	
	
	
	bookBut.addActionListener(new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//Заглушка
		//При натисненні цієї кнпоки бронюється номер
		//тобто беруться дані з форми і заносяться до БД
		
		System.out.println(dateF.getModel().getValue());
		System.out.println(dateF.getModel().getDay());
		System.out.println(dateF.getModel().getMonth());
		System.out.println(dateF.getModel().getYear());
		
		reservationService.createReservation(no, dateF.getModel().getValue(), dateE.getModel().getValue());
	    }
	});
	
	cancBut.addActionListener(new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
		setVisible(false);
		
	    }
	});
	
	this.add(panel);
	this.pack();
    }
    
    public static void main(String[] args) {
	BookingWindow bookWind = new BookingWindow(112, "***", 2, 1);
	bookWind.setVisible(true);
    }
    
}
