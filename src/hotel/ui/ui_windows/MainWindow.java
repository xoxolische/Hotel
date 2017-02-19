package hotel.ui.ui_windows;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import hotel.dao.impl.ConnectionFactory;
import hotel.services.HotelRoomService;
import hotel.services.impl.HotelRoomServiceImpl;
import hotel.ui.models.BookingInfoModel;
import hotel.ui.models.ClientTableModel;
import hotel.ui.models.NumberTableModel;
import hotel.ui.object_protytypes.BookedNumber;
import hotel.ui.object_protytypes.BookedNumsColl;
import hotel.ui.object_protytypes.BookingInfoItem;
import hotel.ui.object_protytypes.BookingInfoItemColl;
import hotel.ui.object_protytypes.Client;
import hotel.ui.object_protytypes.ClientColl;
import hotel.ui.object_protytypes.FreeSoonNumsColl;
import hotel.ui.object_protytypes.SearchNumResColl;

/***
 * ������� ���� ���������� � ���������� ���������:
 * ������ - �� ��������� ����������� ���������� ��� ����������� ������
 * 
 * ���������� - �� ��������� ������ ����� �������� �� ��������� �� ����������� ����
 * 
 * ���������� ��� ���������� - ����������� ���������� ��� ����������� ������,
 * ��������� �������� ���� �� �������� �� ������, � ����� ����� ����������
 * 
 * �볺��� - ����������� ������ �볺���, �� ���������� � �����, � �����
 * ������, �볺���, �� ������ �� ������� ��
 * 
 * @author Roman
 *
 */


public class MainWindow extends JFrame {
    
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    
    private static final long serialVersionUID = 1L;
    
    private JPanel numsPanel = new JPanel();
    
    //������ ������ ������
    private JPanel bookingSearchPanel = new JPanel();
    
    private JLabel classLab = new JLabel("����: ");
    private JComboBox<String> classes = new JComboBox<String>();
    
    private JLabel floorLab = new JLabel("������: ");
    private JComboBox<Integer> floors = new JComboBox<Integer>();
    
    private JLabel placesLab = new JLabel("ʳ������ ����: ");
    private JComboBox<Integer> places = new JComboBox<Integer>();
    
    private JButton searchNo = new JButton("�����");
    
    
    JLabel labNum = new JLabel("Nums Panel");
    
    private JButton bookedNums = new JButton("����������� ������");
    private JButton freeNums = new JButton("��������� �����������");
    
    private NumberTableModel numsModel;/* = new NumberTableModel();*/
    private JTable numsTable = new JTable();
    private JTable bookingSearch = new JTable();
    
    private JButton bookNo = new JButton("�����������");
    
    
    private JTextArea arae = new JTextArea("bgjvgvgvtytyc");
    JScrollPane scrollPane = new JScrollPane(arae);
    
    
    //Booking info
    private JPanel infoBookPanel = new JPanel();
    private JButton infoBook = new JButton("���������� ��� ����������");
    private JButton checkBook = new JButton("��������� ����������");
    
    private JTable bookInfoTable = new JTable();
    
    private BookingInfoModel bookInfoModel;
    
    JTabbedPane tabbedPane = new JTabbedPane();
    
    
    //��������
    private JPanel clientsPanel = new JPanel();
    //private JTextArea tableRes = new JTextArea("bhyrefyueygrufygeyygfu");
    private JTable tableRes = new JTable();
    
    private JScrollPane paneClient = new JScrollPane(tableRes);
    
    private JButton movedOff = new JButton("����� �� ������� ��");
    private JButton currClients = new JButton("��������");
    
    public MainWindow() {
	
	HotelRoomService hotelRoomService = new HotelRoomServiceImpl();
	
	
	this.setLocation(100,100);
	this.setSize(500,330);
	this.setTitle("������� ����");
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	//������ "������"
	//numsPanel config
	numsPanel.setLayout(new GridBagLayout());
	
	//���������, �� ���� ��������� ����������
	GridBagConstraints c = new GridBagConstraints();
	
	JScrollPane pane = new JScrollPane(numsTable);
	
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridwidth = 2;
	c.gridx = 0;
	c.gridy = 0;
	
	c.ipady = 160;
	
	numsPanel.add(pane, c);
	
	
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridwidth = 1;
	c.weightx = 0.5;
	
	c.ipady = 0;
	
	c.gridx = 0;
	c.gridy = 1;
	
	//������, ������, ����, �����
	//c.insets = new Insets(10, 10, 20, 10);
	
	numsPanel.add(bookedNums, c);
	
	
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridwidth = 1;
	
	c.ipady = 0;
	
	//c.weightx = 0.5;
	c.gridx = 1;
	c.gridy = 1;
	
	numsPanel.add(freeNums, c);
	
	
	//Adding action listeners'
	bookedNums.addActionListener(new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
		
		//���������, �� ����������� ��������
		//� �������������� ��������
		
		//���������� �������� ������ "����������� ������"
		//���� ����� ��� ������� ���������� ��������
		//� �������������� �������� ������
		BookedNumsColl numsColl = new BookedNumsColl();
		ArrayList<BookedNumber> bookedNums = numsColl.getList();
		
		//System.out.println("Size: "+bookedNums.size());
		
		//
		numsModel = new NumberTableModel(hotelRoomService.bookedRooms());
		//
		
		//numsModel = new NumberTableModel(bookedNums);
		numsTable.setModel(numsModel);
	    }
	});
	
	
	freeNums.addActionListener(new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
		
		//���������, �� ����������� ��������
		//� ��������, �� ��������� �����������
		
		//���������� �������� ������ "��������� �����������"
		//���� ����� ��� ������� ���������� ��������
		//� �������� ������, �� ��������� �����������
		
		//Analogue DAO
		FreeSoonNumsColl numsColl = new FreeSoonNumsColl();
		ArrayList<BookedNumber> freeNums = numsColl.getList();
		
		//System.out.println("Size: "+freeNums.size());
		
		//
		numsModel = new NumberTableModel(hotelRoomService.freeRooms());
		//
		
		//numsModel = new NumberTableModel(freeNums);
		numsTable.setModel(numsModel);
		
		/*System.out.println("Table cols num: "+numsModel.getColumnCount());
				System.out.println("Table rows num: "+numsModel.getRowCount());*/
	    }
	});
	
	
	
	//������ "����������"
	//bookingPanel config
	
	//bookingSearchPanel config
	bookingSearchPanel.setLayout(new GridBagLayout());
	
	final GridBagConstraints bookingSearchCont = new GridBagConstraints();
	
	
	if (shouldFill) { 
	    bookingSearchCont.fill = GridBagConstraints.HORIZONTAL; 
	} 
	
	
	//adding Label Class
	bookingSearchCont.fill = GridBagConstraints.HORIZONTAL;
	bookingSearchCont.gridwidth = 1;
	bookingSearchCont.gridx = 0;
	bookingSearchCont.gridy = 0;
	bookingSearchCont.weightx = 0.5;
	
	bookingSearchCont.insets = new Insets(5,0,0,0);
	bookingSearchPanel.add(classLab, bookingSearchCont);
	
	//adding comboBox Classes
	bookingSearchCont.fill = GridBagConstraints.HORIZONTAL;
	bookingSearchCont.gridx = 1;
	bookingSearchCont.gridy = 0;
	
	classes.addItem("�� �������");
	classes.addItem("*");
	classes.addItem("**");
	classes.addItem("***");
	classes.addItem("*****");
	classes.addItem("******");
	
	bookingSearchPanel.add(classes, bookingSearchCont);
	
	//adding Label Floor
	bookingSearchCont.fill = GridBagConstraints.HORIZONTAL;
	bookingSearchCont.gridx = 0;
	bookingSearchCont.gridy = 2;
	bookingSearchPanel.add(floorLab, bookingSearchCont);
	
	//adding comboBox Floors
	bookingSearchCont.fill = GridBagConstraints.HORIZONTAL;
	bookingSearchCont.gridx = 1;
	bookingSearchCont.gridy = 2;
	
	
	floors.addItem(1);
	floors.addItem(2);
	floors.addItem(3);
	floors.addItem(4);
	floors.addItem(5);
	
	bookingSearchPanel.add(floors, bookingSearchCont);
	
	//adding Label placesNum
	bookingSearchCont.fill = GridBagConstraints.HORIZONTAL;
	bookingSearchCont.gridx = 0;
	bookingSearchCont.gridy = 3;
	bookingSearchPanel.add(placesLab, bookingSearchCont);
	
	//ading comboBox places
	bookingSearchCont.fill = GridBagConstraints.HORIZONTAL;
	bookingSearchCont.gridx = 1;
	bookingSearchCont.gridy = 3;
	
	places.addItem(1);
	places.addItem(2);
	
	bookingSearchPanel.add(places, bookingSearchCont);
	
	//adding button Search
	bookingSearchCont.fill = GridBagConstraints.HORIZONTAL;
	bookingSearchCont.gridwidth = 2;
	bookingSearchCont.gridx = 0;
	bookingSearchCont.gridy = 4;
	//bookingSearchCont.weightx = 0.0;
	bookingSearchPanel.add(searchNo, bookingSearchCont);
	
	
	//Adding result set table
	JScrollPane paneRes = new JScrollPane(bookingSearch);
	bookingSearchCont.fill = GridBagConstraints.HORIZONTAL;
	bookingSearchCont.gridwidth = 2;
	bookingSearchCont.gridx = 0;
	bookingSearchCont.gridy = 5;
	bookingSearchCont.ipady = 80;
	
	bookingSearchPanel.add(paneRes, bookingSearchCont);
	
	//Adding button "Book a number"
	bookingSearchCont.fill = GridBagConstraints.HORIZONTAL;
	bookingSearchCont.gridx = 0;
	bookingSearchCont.gridy = 6;
	bookingSearchCont.ipady = 0;
	
	bookNo.setEnabled(false);
	bookingSearchPanel.add(bookNo, bookingSearchCont);
	
	
	searchNo.addActionListener(new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
		//���������, �� ����������� ��������
		//� �������� - ������������ ������ �����������
		
		//���������� �������� ������ "�����"
		//���� ����� ��� ������� ���������� ��������
		//� ��������, �� ���������� ��������� ������������ �����������
		
		
		SearchNumResColl numsColl = new SearchNumResColl();
		ArrayList<BookedNumber> bookedNums = numsColl.getList();
		
		//������ ������ "�����������"
		if(bookedNums.size() != 0) {
		    bookNo.setEnabled(true);
		}
		
		//System.out.println("Size: "+bookedNums.size());
		
		numsModel = new NumberTableModel(bookedNums);
		bookingSearch.setModel(numsModel);
	    }
	});
	
	bookNo.addActionListener(new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
		
		int rowInd = bookingSearch.getSelectedRow();
		
		//����� ������� ������, ��������� ������������
		String[] selVals = new String[4];
		if(rowInd != -1) {
		    for(int i=0; i<bookingSearch.getColumnCount(); i++) {
			selVals[i] = ""+bookingSearch.getValueAt(rowInd, i);
			//System.out.println("Selected value: "+value);
		    }
		    
		    int numNo = Integer.parseInt(selVals[0]);
		    String classNo = selVals[1];
		    int placesNo = Integer.parseInt(selVals[2]);
		    int floorNo = Integer.parseInt(selVals[3]);
		    
		    BookingWindow bookWind = new BookingWindow(numNo, classNo, placesNo, floorNo);
		    bookWind.setVisible(true);
		    
		}
		
	    }
	});
	
	
	//������ "�������ֲ� ��� ����������"
	infoBookPanel.setLayout(new GridBagLayout());
	//���������, �� ���� ��������� ����������
	GridBagConstraints infoBookCont = new GridBagConstraints();
	
	//Adding table with booked numbers
	JScrollPane infoPane = new JScrollPane(bookInfoTable);
	
	infoBookCont.fill = GridBagConstraints.HORIZONTAL;
	
	infoBookCont.weightx = 0.5; //??
	infoBookCont.weighty = 0.5;
	
	infoBookCont.gridwidth = 2;
	infoBookCont.gridx = 0;
	infoBookCont.gridy = 0;
	
	infoBookCont.ipady = 160;
	
	infoBookPanel.add(infoPane, infoBookCont);
	
	
	//Adding button "Book a number"
	infoBookCont.fill = GridBagConstraints.HORIZONTAL;
	infoBookCont.gridwidth = 1;
	infoBookCont.gridx = 0;
	infoBookCont.gridy = 1;
	
	infoBookCont.ipady = 0;
	
	infoBookPanel.add(infoBook, infoBookCont);
	
	
	//Adding button "Check booking"
	infoBookCont.fill = GridBagConstraints.HORIZONTAL;
	infoBookCont.gridx = 1;
	infoBookCont.gridy = 1;
	
	infoBookPanel.add(checkBook, infoBookCont);
	
	
	infoBook.addActionListener(new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		
		//���������, �� ����������� �������� � �������������� ��������
		
		BookingInfoItemColl numsColl = new BookingInfoItemColl();
		ArrayList<BookingInfoItem> bookedNums = numsColl.getList();
		
		//System.out.println("Size: "+bookedNums.size());
		
		bookInfoModel = new BookingInfoModel(bookedNums);
		bookInfoTable.setModel(bookInfoModel);
		
	    }
	});
	
	checkBook.addActionListener(new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		/*CheckBookingWindow check = */new CheckBookingWindow();
	    }
	});
	
	
	
	//������ "�˲����"
	clientsPanel.setLayout(new GridBagLayout());
	
	GridBagConstraints clientCont = new GridBagConstraints();
	
	clientCont.weightx = 0.5;
	clientCont.weighty = 0.5;
	
	//Adding table of results
	clientCont.fill = GridBagConstraints.HORIZONTAL;
	clientCont.gridwidth = 2;
	clientCont.gridx = 0;
	clientCont.gridy = 0;
	clientCont.ipady = 160;
	
	
	clientsPanel.add(paneClient, clientCont);
	
	clientCont.fill = GridBagConstraints.HORIZONTAL;
	clientCont.gridwidth = 1;
	clientCont.gridx = 0;
	clientCont.gridy = 1;
	clientCont.ipady = 0;
	
	clientsPanel.add(movedOff, clientCont);
	
	
	clientCont.fill = GridBagConstraints.HORIZONTAL;
	clientCont.gridx = 1;
	clientCont.gridy = 1;
	
	clientsPanel.add(currClients, clientCont);
	
	
	movedOff.addActionListener(new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
		
		ClientColl clColl = new ClientColl();
		ArrayList<Client> clients = clColl.getList();
		
		ClientTableModel clModel = new ClientTableModel(clients);
		
		tableRes.setModel(clModel);
	    }
	});
	
	tabbedPane.addTab("������", numsPanel);
	tabbedPane.addTab("����������", bookingSearchPanel);
	tabbedPane.addTab("���������� ��� ����������", infoBookPanel);
	tabbedPane.addTab("�볺���", clientsPanel);
	
	this.add(tabbedPane);
	this.setVisible(true);
	
    }
    
    public static void main(String[] args) {
	MainWindow window = new MainWindow();
    }
    
}
