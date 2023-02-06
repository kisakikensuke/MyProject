package model;

import dao.AccountDAO;

public class LoginLogic { //ログイン処理を担当するBO
  public boolean execute(Login login) {
    AccountDAO dao = new AccountDAO();
    Account account = dao.findByLogin(login);
    return account != null;
  }
}
