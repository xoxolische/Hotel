package object_protytypes;

import java.util.ArrayList;

/*
 * ����, �� ������� �������� ������, ��
 * ��������� ����������� (�� ������� ���)
 * �������� DAO
 */

public class FreeSoonNumsColl {
	
	private ArrayList<BookedNumber> freeNums;
	
	public FreeSoonNumsColl() {
		freeNums = new ArrayList<BookedNumber>();
		
		fillList();
	}
	
	
	public ArrayList<BookedNumber> getList() {
		return freeNums;
	}
	
	private void fillList() {
		freeNums.add(new BookedNumber(200, "****", 1, 2));
		freeNums.add(new BookedNumber(200, "****", 1, 2));
		freeNums.add(new BookedNumber(200, "****", 1, 2));
		freeNums.add(new BookedNumber(200, "****", 1, 2));
		freeNums.add(new BookedNumber(200, "****", 1, 2));
		freeNums.add(new BookedNumber(200, "****", 1, 2));
		freeNums.add(new BookedNumber(200, "****", 1, 2));
		freeNums.add(new BookedNumber(200, "****", 1, 2));
		freeNums.add(new BookedNumber(200, "****", 1, 2));
		freeNums.add(new BookedNumber(200, "****", 1, 2));
		freeNums.add(new BookedNumber(200, "****", 1, 2));
		freeNums.add(new BookedNumber(200, "****", 1, 2));
		freeNums.add(new BookedNumber(200, "****", 1, 2));
		freeNums.add(new BookedNumber(200, "****", 1, 2));
		freeNums.add(new BookedNumber(200, "****", 1, 2));
		freeNums.add(new BookedNumber(200, "****", 1, 2));
	}

}
