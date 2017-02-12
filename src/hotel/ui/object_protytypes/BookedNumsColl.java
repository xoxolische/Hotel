package hotel.ui.object_protytypes;

import java.util.ArrayList;

/*
 * Клас, що повртає колекцію номерів
 * Прототип DAO
 */

public class BookedNumsColl {
	
	private ArrayList<BookedNumber> bookNums;
	
	
	public BookedNumsColl() {
		bookNums = new ArrayList<BookedNumber>();
		fillList();
		
		//System.out.println("List is filled!");
	}
	
	public ArrayList<BookedNumber> getList() {
		return bookNums;
	}
	
	private void fillList() {
		bookNums.add(new BookedNumber(403, "Lux", 2, 4));
		bookNums.add(new BookedNumber(403, "Lux", 2, 4));
		bookNums.add(new BookedNumber(403, "Lux", 2, 4));
		bookNums.add(new BookedNumber(403, "Lux", 2, 4));
		
		bookNums.add(new BookedNumber(403, "Lux", 2, 4));
		bookNums.add(new BookedNumber(403, "Lux", 2, 4));
		bookNums.add(new BookedNumber(403, "Lux", 2, 4));
		bookNums.add(new BookedNumber(403, "Lux", 2, 4));
		
		bookNums.add(new BookedNumber(403, "Lux", 2, 4));
		bookNums.add(new BookedNumber(403, "Lux", 2, 4));
		bookNums.add(new BookedNumber(403, "Lux", 2, 4));
		bookNums.add(new BookedNumber(403, "Lux", 2, 4));
		
		bookNums.add(new BookedNumber(403, "Lux", 2, 4));
		bookNums.add(new BookedNumber(403, "Lux", 2, 4));
		bookNums.add(new BookedNumber(403, "Lux", 2, 4));
	}

}
