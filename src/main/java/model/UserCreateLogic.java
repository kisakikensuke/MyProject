package model;

import dao.AccountDAO;

public class UserCreateLogic {//新規会員登録処理を担当するBO
	public boolean execute(Account account) {
	    AccountDAO dao = new AccountDAO();
	    boolean result = dao.userCreate(account);
	    return result;
	}
}

