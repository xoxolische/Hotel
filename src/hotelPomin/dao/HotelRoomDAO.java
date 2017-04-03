package hotelPomin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import hotelPomin.vo.BookedNumberInfo;
import hotelPomin.vo.HotelRoom;
import hotelPomin.vo.OccupiedNumberInfo;



public class HotelRoomDAO {

	private Connection conn;
	private Statement statem;
	private ResultSet resSet;
	private String sql;

	// Інформація про заселені номери готелю
	public ArrayList<OccupiedNumberInfo> getOccupiedNumbersDetails()
			throws SQLException {

		ArrayList<OccupiedNumberInfo> occNums = new ArrayList<OccupiedNumberInfo>();

		DbAccess acc = new DbAccess();
		conn = acc.connectionDb();

		if (conn != null) {

			statem = conn.createStatement();

			/*
			 * sql =
			 * "SELECT rnumber, rclass, capacity, rfloor, arrival_date, departure_date, individual.name"
			 * + "FROM hotel_room, guest, individual" +
			 * "WHERE hotel_room.id = guest.id_hotel_room AND" +
			 * "guest.id_individual = individual.id";
			 */

			sql = "SELECT rnumber, rclass, capacity, rfloor, arrival_date, departure_date, individual.name FROM hotel_room, guest, individual WHERE hotel_room.id = guest.id_hotel_room AND guest.id_individual = individual.id";

			statem.execute(sql);

			resSet = statem.getResultSet();

			while ((resSet != null) && (resSet.next())) {

				int noNum = resSet.getInt("rnumber");
				int noClass = resSet.getInt("rclass");
				int noCap = resSet.getInt("capacity");
				int noFloor = resSet.getInt("rfloor");

				Date arrDate = resSet.getDate("arrival_date");
				Date depDate = resSet.getDate("departure_date");

				String gName = resSet.getString("name");

				OccupiedNumberInfo occNum = new OccupiedNumberInfo();

				occNum.setGuestArrivalDate(arrDate);
				occNum.setGuestDepartureDate(depDate);
				occNum.setGuestName(gName);
				occNum.setNoCapacity(noCap);
				occNum.setNoClass(noClass);
				occNum.setNoFloor(noFloor);
				occNum.setNoNumber(noNum);

				occNums.add(occNum);

			}

		}

		acc.disConnect();

		return occNums;

	}

	// Інформація про заброньовані номери готелю, які заьроньовані фізичними
	// особами
	public ArrayList<BookedNumberInfo> getBookedNumbersDetailsIndividal()
			throws SQLException {

		ArrayList<BookedNumberInfo> bookNums = new ArrayList<BookedNumberInfo>();

		DbAccess acc = new DbAccess();
		conn = acc.connectionDb();

		if (conn != null) {

			statem = conn.createStatement();

			/*
			 * sql =
			 * "SELECT rnumber, rclass, capacity, rfloor, booking_date, arrival_date, days, individual.name"
			 * + "FROM hotel_room, reservation, individual, legal_entity" +
			 * "WHERE individual.id = reservation.id_individual AND" +
			 * "hotel_room.id = reservation.id_hotel_room";
			 */

			sql = "SELECT rnumber, rclass, capacity, rfloor, booking_date, arrival_date, days, individual.name FROM hotel_room, reservation, individual WHERE individual.id = reservation.id_individual AND hotel_room.id = reservation.id_hotel_room";

			statem.execute(sql);

			resSet = statem.getResultSet();

			while ((resSet != null) && (resSet.next())) {

				BookedNumberInfo bookNum = new BookedNumberInfo();

				bookNum.setBookingDate(resSet.getDate("booking_date"));
				bookNum.setDaysNum(resSet.getInt("days"));
				bookNum.setGuestArrivalDate(resSet.getDate("arrival_date"));

				String indName = resSet.getString("individual.name");
				// String legEntName = resSet.getString("legal_entity.name");

				/*
				 * if (indName == null) bookNum.setName(legEntName); else
				 */
				bookNum.setName(indName);

				bookNum.setNoCapacity(resSet.getInt("capacity"));
				bookNum.setNoClass(resSet.getInt("rclass"));
				bookNum.setNoFloor(resSet.getInt("rfloor"));
				bookNum.setNoNumber(resSet.getInt("rnumber"));

				bookNums.add(bookNum);

			}

		}

		acc.disConnect();

		return bookNums;

	}

	// Інформація про заброньовані номери готелю, які заьроньовані юридичними
	// особами
	public ArrayList<BookedNumberInfo> getBookedNumbersDetailsLegalEntity()
			throws SQLException {

		ArrayList<BookedNumberInfo> bookNums = new ArrayList<BookedNumberInfo>();

		DbAccess acc = new DbAccess();
		conn = acc.connectionDb();

		if (conn != null) {

			statem = conn.createStatement();

			/*
			 * sql =
			 * "SELECT rnumber, rclass, capacity, rfloor, booking_date, arrival_date, days, legal_entity.name"
			 * + "FROM hotel_room, reservation, legal_entity" +
			 * "WHERE legal_entity.id = reservation.id_legal_entity AND" +
			 * "hotel_room.id = reservation.id_hotel_room";
			 */

			sql = "SELECT rnumber, rclass, capacity, rfloor, booking_date, arrival_date, days, legal_entity.name FROM hotel_room, reservation, legal_entity WHERE legal_entity.id = reservation.id_legal_entity AND hotel_room.id = reservation.id_hotel_room";

			statem.execute(sql);

			resSet = statem.getResultSet();

			while ((resSet != null) && (resSet.next())) {

				BookedNumberInfo bookNum = new BookedNumberInfo();

				bookNum.setBookingDate(resSet.getDate("booking_date"));
				bookNum.setDaysNum(resSet.getInt("days"));
				bookNum.setGuestArrivalDate(resSet.getDate("arrival_date"));

				String legEntName = resSet.getString("legal_entity.name");

				bookNum.setName(legEntName);

				bookNum.setNoCapacity(resSet.getInt("capacity"));
				bookNum.setNoClass(resSet.getInt("rclass"));
				bookNum.setNoFloor(resSet.getInt("rfloor"));
				bookNum.setNoNumber(resSet.getInt("rnumber"));

				bookNums.add(bookNum);

			}

		}

		acc.disConnect();

		return bookNums;

	}

	// Інформація про вільні номери готелю
	public ArrayList<HotelRoom> getFreeNumbersDetails() throws SQLException {

		ArrayList<HotelRoom> freeNums = new ArrayList<HotelRoom>();

		DbAccess acc = new DbAccess();
		conn = acc.connectionDb();

		if (conn != null) {

			statem = conn.createStatement();

			/*
			 * sql = "SELECT rnumber, rclass, capacity, rfloor" +
			 * "FROM hotel_room" +
			 * "WHERE hotel_room.id NOT IN (SELECT id_hotel_room FROM guest) AND"
			 * + "hotel_room.id NOT IN (SELECT id_hotel_room FROM reservation)";
			 */

			sql = "SELECT rnumber, rclass, capacity, rfloor FROM hotel_room WHERE hotel_room.id NOT IN (SELECT id_hotel_room FROM guest) AND hotel_room.id NOT IN (SELECT id_hotel_room FROM reservation)";

			statem.execute(sql);

			resSet = statem.getResultSet();

			while ((resSet != null) && (resSet.next())) {

				int noNum = resSet.getInt("rnumber");
				int noClass = resSet.getInt("rclass");
				int noCap = resSet.getInt("capacity");
				int noFloor = resSet.getInt("rfloor");

				HotelRoom freeNum = new HotelRoom();
				freeNum.setCapacity(noCap);
				freeNum.setFloor(noFloor);
				freeNum.setNumber(noNum);
				freeNum.setrClass(noClass);

				freeNums.add(freeNum);

			}
		}

		acc.disConnect();

		return freeNums;

	}

}
