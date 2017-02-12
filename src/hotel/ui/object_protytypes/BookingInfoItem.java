package hotel.ui.object_protytypes;
/*
 * �������� �������������� ������, ��� �����
 * ������������� � ������� ����������
 */

public class BookingInfoItem {
	
	private int bookedNo;
	private String fio;
	private String bookingDate;
	
	public BookingInfoItem(int bookedNo, String fio, String bookingDate) {
		this.bookedNo = bookedNo;
		this.fio = fio;
		this.bookingDate = bookingDate;
	}

	public int getBookedNo() {
		return bookedNo;
	}

	public String getFio() {
		return fio;
	}

	public String getBookingDate() {
		return bookingDate;
	}
	
	

}
