package hotel.ui.ui_table_models;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import hotel.dao.HotelRoomDao;
import hotel.model.BookedNumberInfo;
import hotel.services.HotelRoomService;
import hotel.services.impl.HotelRoomServiceImpl;

/***
 * 
 * ������ ������� ��� ������������� ������
 * @author Roman
 *
 */

public class BookedNumberTableModel extends AbstractTableModel {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private ArrayList <BookedNumberInfo> numsIndividual;
    private ArrayList <BookedNumberInfo> numsLegalEntity;
    
    private ArrayList<BookedNumberInfo> nums;
    
    private HotelRoomService hotelRoomService = new HotelRoomServiceImpl();
    
    public BookedNumberTableModel() throws SQLException {
	//Service must be called instead of direct call of dao.
	/*
		HotelRoomDAO roomDao = new HotelRoomDAO();
		numsIndividual = roomDao.getBookedNumbersDetailsIndividal();
		numsLegalEntity = roomDao.getBookedNumbersDetailsLegalEntity();
	 */
	
	
	numsIndividual = hotelRoomService.getAllBookedNumbersDetailsIndividual();
	numsLegalEntity = hotelRoomService.getAllBookedNumbersDetailsLegalEntity();
	
	//numsIndividual = roomDao.getBookedNumbersDetailsIndividal();
	//numsLegalEntity = roomDao.getBookedNumbersDetailsLegalEntity();
	
	nums = new ArrayList<BookedNumberInfo>();
	
	for(BookedNumberInfo item : numsIndividual) {
	    nums.add(item);
	}
	
	for(BookedNumberInfo item : numsLegalEntity) {
	    nums.add(item);
	}
	
    }
    
    @Override
    public int getColumnCount() {
	return 8;
    }
    
    @Override
    public int getRowCount() {
	return numsIndividual.size() + numsLegalEntity.size();
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
	BookedNumberInfo number = nums.get(rowIndex);
	
	switch (columnIndex) {
	case 0: return number.getNoNumber(); 
	case 1: return number.getNoClass(); 
	case 2: return number.getNoCapacity();
	case 3: return number.getNoFloor();
	
	case 4: return number.getBookingDate();
	case 5: return number.getGuestArrivalDate();
	case 6: return number.getDaysNum();
	case 7: return number.getName();
	
	default: return 0;
	}
    }
    
    @Override
    public String getColumnName(int column) {
	switch (column) {
	case 0: return "�����"; 
	case 1: return "����"; 
	case 2: return "�-�� ����";
	case 3: return "������";
	
	case 4: return "���� ����������";
	case 5: return "���� ���������";
	case 6: return "�-�� ����";
	case 7: return "�������";
	
	default: return "0";
	}
	
    }
    
}
