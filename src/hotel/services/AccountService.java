package hotel.services;

import java.util.ArrayList;

import hotel.model.Account;

public interface AccountService{
	ArrayList<Account> paidAccounts();
	ArrayList<Account> unpaidAccounts();
	void createAccount(int guestId);
}
