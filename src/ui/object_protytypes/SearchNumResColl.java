package object_protytypes;

import java.util.ArrayList;

/*
 * ����, �� ������� �������� ������ �� ��������� ������
 * ������� �� �������� ������������ ���������
 * �������� DAO
 */

public class SearchNumResColl {
	
	private ArrayList<BookedNumber> srchResNums;
	
	public SearchNumResColl() {
		srchResNums = new ArrayList<BookedNumber>();
		
		fillList();
	}
	
	
	private void fillList() {
		srchResNums.add(new BookedNumber(111, "*****", 1, 1));
		srchResNums.add(new BookedNumber(222, "****", 2, 2));
		
		srchResNums.add(new BookedNumber(111, "*****", 1, 1));
		srchResNums.add(new BookedNumber(222, "****", 2, 2));
		
		srchResNums.add(new BookedNumber(111, "*****", 1, 1));
		srchResNums.add(new BookedNumber(222, "****", 2, 2));
		
		srchResNums.add(new BookedNumber(111, "*****", 1, 1));
		srchResNums.add(new BookedNumber(222, "****", 2, 2));
		
		srchResNums.add(new BookedNumber(111, "*****", 1, 1));
		srchResNums.add(new BookedNumber(222, "****", 2, 2));
		
		srchResNums.add(new BookedNumber(111, "*****", 1, 1));
		srchResNums.add(new BookedNumber(222, "****", 2, 2));
		
		srchResNums.add(new BookedNumber(111, "*****", 1, 1));
		srchResNums.add(new BookedNumber(222, "****", 2, 2));
		
		srchResNums.add(new BookedNumber(111, "*****", 1, 1));
		srchResNums.add(new BookedNumber(222, "****", 2, 2));
	}


	public ArrayList<BookedNumber> getList() {
		return srchResNums;
	}

}
