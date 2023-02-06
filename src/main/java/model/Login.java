package model;

public class Login { //ログイン情報(idとパス)を1インスタンスとして扱うためのクラス
  private String userId;
  private String pass;

  public Login(String userId, String pass) {
    this.userId = userId;
    this.pass = pass;
  }

  public String getUserId() {
    return userId;
  }

  public String getPass() {
    return pass;
  }
}
