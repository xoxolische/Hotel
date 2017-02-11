package object_protytypes;

import java.util.ArrayList;

/*
 * Клас, що повертає колекцію номерів, що
 * незабаром звільняються (за декілька днів)
 * Прототип DAO
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
