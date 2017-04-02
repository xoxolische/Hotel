package ui_windows;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.GuestDAO;
import dao.ServiceDAO;
import ui_table_models.ClientDemoTableModel;
import ui_table_models.FreeNumberTableModel;
import ui_table_models.OccupiedNumberTableModel;
import ui_table_models.ServicesTableModel;
import vo.ClientServiceInfo;
import vo.Individual;

/***
 * ������� ���� ���������� � ���������� ���������:
 * 
 * ������ - ����������� �� ����� ������ � ����� �� ����� ��� ���
 * 
 * ����� ��� �볺��� - ����������� �������� ���������� ��� �볺���
 * (������ ������, �� �� �������; ����� ��� �����, �� �� �������;
 * ���� ����� �� ����� �� �������� ���� �� ������)
 * 
 * �������� ������� - ����������� ������ ������, �� ������� ������,
 * �� ������� ���� �� ���
 * ����������� ��������� ���������� �������
 * 
 * @author Roman
 *
 */


public class MainWindow extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JTabbedPane tabbedPane = new JTabbedPane();
	
		
	//����� ��� �볺���
	private JPanel totPanel = new JPanel();
	
	//--
	
	private JTable clientTable = new JTable();
	private JScrollPane clientScroller = new JScrollPane(clientTable);
		
	private JLabel servLab = new JLabel("�������");
	String[] servicesArr = {"Service���������", "Service", "Service", "Service", "Service"};
	private JList<String> servicesList = new JList<String>(servicesArr);
	
	private JLabel sumLabel = new JLabel("���� �� ������: ");
	private JLabel sumLabelVal = new JLabel("1000");
	private JScrollPane listScroller = new JScrollPane(servicesList);
	
	//--
	
	private JLabel clLab = new JLabel("��������");
	String[] clArr = {"Client���������", "Client", "Client", "Client", "Client"};

		
	//�������� �������
	private JPanel servPn = new JPanel();
	private JPanel surnPn = new JPanel();
	private JPanel servSurnPn = new JPanel();
	
	//--
	
	private JLabel servLab2 = new JLabel("�������");
		
	private JTable servicesTable = new JTable();
	private JScrollPane servPricScroller = new JScrollPane(servicesTable);
	
	//--
	
	private JLabel surnLab = new JLabel("�������: ");
	private JTextField surnField = new JTextField();
	private JComboBox<String> clientSurns = new JComboBox<String>();
	private JComboBox<Integer> servQuant = new JComboBox<Integer>();
	private JButton confButt = new JButton("��������");
	
	
	//������
	private JPanel totNumsPanel = new JPanel();
	
	private JPanel occNumsPn = new JPanel();
	private JPanel bookedNumsPn = new JPanel();
	private JPanel freeNumsPn = new JPanel();

	private JPanel bookedNumsInfoPn = new JPanel();
	
	//--
	
	private JLabel occNumsLb = new JLabel("�������");
	private JLabel bookedNumsLb = new JLabel("�����������");
	private JLabel freeNumsLb = new JLabel("³���");
	
	private JButton bookNo = new JButton("�����������");
	
	//������� � ��������
	private JTable occNumsTable = new JTable();
	private JScrollPane occNumsScroll = new JScrollPane(occNumsTable);
	
	private JTable bookedNumsTable = new JTable();
	private JScrollPane bookedNumsScroll = new JScrollPane(bookedNumsTable);
	
	private JTable freeNumsTable = new JTable();
	private JScrollPane freeNumsScroll = new JScrollPane(freeNumsTable);
	
	
	public MainWindow() throws SQLException {
		
		this.setLocation(100,100);
		this.setSize(900,330);
		this.setTitle("������� ����");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
			
		//������ "�˲���� � ���������"
		totPanel.setLayout(new BoxLayout(totPanel, BoxLayout.Y_AXIS));
		listScroller.setPreferredSize(listScroller.getPreferredSize());
		
		totPanel.add(clLab);
		
		ClientDemoTableModel clModel = new ClientDemoTableModel();
		clientTable.setModel(clModel);
		
		clientScroller.setPreferredSize(clientScroller.getPreferredSize());
		totPanel.add(clientScroller);
		
		totPanel.add(Box.createGlue());
		
		totPanel.add(listScroller);
		
		//���������� ������ ������ ������� �� ��������� ������� �볺���
		clientTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			
			@Override
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
				
				if (event.getValueIsAdjusting() && clientTable.getSelectedRow() != -1) {
					//System.out.println(clientTable.getValueAt(clientTable.getSelectedRow(), 0));
					
					/*String clName = clientTable.getValueAt(clientTable.getSelectedRow(), 0).toString();
					
					if(clName != null) {
						ServiceDAO servDao = new ServiceDAO();
						
						try {
							ArrayList<ClientServiceInfo> services = servDao.getServicesByClient(clName);
							
							if(services.size() != 0) {
								String[] dets = new String[services.size()];
								
								for(int i=0; i<services.size(); i++) {
									dets[i] = services.get(i).toString();
								}
								
								servicesList.setListData(dets);
							}
							else {
								System.out.println("Arr List size = 0");
							}
						} catch (SQLException e) {
							System.out.println(e.getMessage());
							e.printStackTrace();
						}
					}*/
					
					/*String[] dets = new String[clientTable.getColumnCount()];
					
					for(int i=0; i<dets.length; i++) {
						dets[i] = (clientTable.getValueAt(clientTable.getSelectedRow(), i).toString());
					}*/
					
				}	
	        }
	    });
		
		
		//������ "�������� �������"
		
		//Top side
		servSurnPn.setLayout(new BoxLayout(servSurnPn, BoxLayout.Y_AXIS));
		
		servPn.setLayout(new BoxLayout(servPn, BoxLayout.Y_AXIS));
		servPn.add(servLab2);
		
		//���������� ������� � ��
		/*ServicesTableModel servModel;
		try {
			servModel = new ServicesTableModel();
			servicesTable.setModel(servModel);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}*/
		
		servPricScroller.setPreferredSize(servPricScroller.getPreferredSize());
		servPn.add(servPricScroller);
		
		servPn.add(Box.createVerticalGlue());
		
		servSurnPn.add(servPn);
		
		
		
		//Bottom side
		surnPn.setLayout(new BoxLayout(surnPn, BoxLayout.X_AXIS));
		surnPn.add(surnLab);
		
		/*surnField.setMaximumSize(new Dimension(200, 30));
		surnPn.add(surnField);*/
		
		
		//Filling from DB
		/*GuestDAO gDao = new GuestDAO();
		ArrayList<Individual> clSurns = gDao.getAllGuests();
		
		for(Individual item : clSurns) {
			clientSurns.addItem(item.getName());
		}*/
		
		//Hand-made filling
		for(int i=1; i<=20; i++) {
			clientSurns.addItem("Ivanov");
		}
		
		//Filling from DB
		/*GuestDAO gDao = new GuestDAO();
		
		ArrayList<Individual> guests = gDao.getAllGuests();
		
		for(Individual guest : guests) {
			clientSurns.addItem(guest.getName());
		}*/
		
		for(int i=1; i<=10; i++) {
			servQuant.addItem(i);
		}
		
		clientSurns.setMaximumSize(new Dimension(200, 30));
		surnPn.add(clientSurns);
		
		servQuant.setMaximumSize(new Dimension(50, 30));
		surnPn.add(servQuant);
		
		surnPn.add(confButt);
		
		servSurnPn.add(surnPn);
		
		//ϳ��������� ���������� �������
		confButt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				/*String clientName = (String) clientSurns.getSelectedItem();
				int quantity = (int) servQuant.getSelectedItem();
				String servName = null;
				
				if(servicesTable.getSelectedRow() != -1)
					servName = servicesTable.getValueAt(servicesTable.getSelectedRow(), 0).toString();
				
				if(servName != null) {
					ServiceDAO sDao = new ServiceDAO();
					try {
						sDao.orderServiceByClient(clientName, quantity, servName);
						
						JOptionPane.showMessageDialog(null, "���������� ������");
					} catch (SQLException e) {
						System.out.println("SQLEx: "+e.getMessage());
						e.printStackTrace();
					}
				}*/
				
			}
		});
		
		
		//������ "������"
		
		totNumsPanel.setLayout(new BoxLayout(totNumsPanel, BoxLayout.X_AXIS));
		
		//Left side (Occupied numbers)
		occNumsPn.setLayout(new BoxLayout(occNumsPn, BoxLayout.Y_AXIS));
		
		occNumsPn.add(occNumsLb);
		
		
		//���������� ������� ������� ������
		/*BookedNumsColl numsColl = new BookedNumsColl();
		ArrayList<BookedNumber> bookedNums = numsColl.getList();
		
		numsModel = new NumberTableModel(bookedNums);
		occNumsTable.setModel(numsModel);*/
		//---
		
		//���������� ������� from Database
		/*try {
			OccupiedNumberTableModel occNumsModel = new OccupiedNumberTableModel();
			occNumsTable.setModel(occNumsModel);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}*/
		
		occNumsScroll.setPreferredSize(occNumsScroll.getPreferredSize());
		occNumsPn.add(occNumsScroll);		
		
		totNumsPanel.add(occNumsPn);
		totNumsPanel.add(Box.createHorizontalGlue());
				
		//---------------
		
		//Middle side (Booked numbers)
		
		bookedNumsPn.setLayout(new BoxLayout(bookedNumsPn, BoxLayout.Y_AXIS));
		
		bookedNumsPn.add(bookedNumsLb);
		
	
		//���������� ������� ������� ������		
		/*numsModel = new NumberTableModel(bookedNums);
		bookedNumsTable.setModel(numsModel);*/
		//---
		
		//���������� ������� from Database
		/*try {
			BookedNumberTableModel bookNumsModel = new BookedNumberTableModel();
			bookedNumsTable.setModel(bookNumsModel);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}*/
		
		bookedNumsScroll.setPreferredSize(bookedNumsScroll.getPreferredSize());
		bookedNumsPn.add(bookedNumsScroll);
		
		bookedNumsInfoPn.setLayout(new BoxLayout(occNumsPn, BoxLayout.Y_AXIS));
					
		
		totNumsPanel.add(bookedNumsPn);
		totNumsPanel.add(Box.createHorizontalGlue());
		
		//---------------------
		
		//Right side (free Numbers)
		freeNumsPn.setLayout(new BoxLayout(freeNumsPn, BoxLayout.Y_AXIS));
		
		freeNumsPn.add(freeNumsLb);
	
		//���������� ������� ������� ������
		/*numsModel = new NumberTableModel(bookedNums);
		freeNumsTable.setModel(numsModel);*/
		//---
		
		//���������� ������� from Database
		/*try {
			FreeNumberTableModel freeNumsModel = new FreeNumberTableModel();
			freeNumsTable.setModel(freeNumsModel);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}*/
		
		freeNumsScroll.setPreferredSize(freeNumsScroll.getPreferredSize());
		freeNumsPn.add(freeNumsScroll);
		
		freeNumsPn.add(bookNo);
		totNumsPanel.add(freeNumsPn);
		
		
		tabbedPane.addTab("������", totNumsPanel);
		tabbedPane.addTab("����� ��� �볺���", totPanel);
		tabbedPane.addTab("�������� �������", servSurnPn);
		
		this.add(tabbedPane);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) throws SQLException {
		MainWindow window = new MainWindow();
	}

}
