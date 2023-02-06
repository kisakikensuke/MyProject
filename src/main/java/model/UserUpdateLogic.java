package model;

import dao.AccountDAO;

public class UserUpdateLogic {
	public boolean execute(Account account) {
	    AccountDAO dao = new AccountDAO();
	    boolean result = dao.userUpdate(account);
	    return result;
	  }
}
