package hotel.ui.ui_windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hotel.services.ReservationService;
import hotel.services.impl.ReservationServiceImpl;


/***
 * ����� ��� ���������� ������
 * @author Roman
 *
 */

public class BookingWindow extends JFrame {
    private ReservationService reservationService = new ReservationServiceImpl();	
    private JLabel noLab;
    private JLabel classLab;
    private JLabel placesLab;
    private JLabel floorLab;
    
    private JLabel dateBookLab = new JLabel("���� ����������: ");
    //private JTextField dateF = new JTextField();
    private DatePickerUI dateF = new DatePickerUI();
    
    private JLabel dateELab = new JLabel("���� �����: ");
    //private JTextField dateE = new JTextField();
    private DatePickerUI dateE = new DatePickerUI();
    
    private JLabel daysLab = new JLabel("ʳ������ ���: ");
    private JComboBox<Integer> days = new JComboBox<Integer>();
    
    private JButton bookBut = new JButton("�����������");
    private JButton cancBut = new JButton("���������");
    
    private JPanel panel = new JPanel();
    
    private JLabel firstName = new JLabel("��'�: ");
    private JTextField fName = new JTextField();
    
    private JLabel surName = new JLabel("�������: ");
    private JTextField sName = new JTextField();
    
    private JLabel patronimic = new JLabel("�� �������: ");
    private JTextField patName = new JTextField();
    
    
    public BookingWindow(int no, String klas, int places, int floor) {
	noLab = new JLabel("�����: "+no);
	classLab = new JLabel("����: "+klas);
	placesLab = new JLabel("̳���: "+places);
	floorLab = new JLabel("������: "+floor);
	
	
	fName.setToolTipText("����");
	sName.setToolTipText("������");
	patName.setToolTipText("��������");
	
	
	//if needed
	/*
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh mm");
		Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());
		dateF.setText(dateFormat.format(timeNow));
	 */
	//if needed
	
	this.setLocation(650,100);
	
	//this.setSize(500,400);
	this.setTitle("����������� �����");
	
	
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
	
	panel.add(days);
	
	panel.add(firstName);
	panel.add(fName);
	
	panel.add(surName);
	panel.add(sName);
	
	panel.add(patronimic);
	panel.add(patName);
	
	
	
	//panel.add(a.getJDatePicker());
	
	panel.add(bookBut);
	panel.add(cancBut);
	
	bookBut.addActionListener(new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//��������
		//��� ��������� ���� ������ ���������� �����
		//����� �������� ��� � ����� � ���������� �� ��
		
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
