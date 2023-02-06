package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO { //ACCOUNTテーブルに関する一連の処理をするDAO
    // データベース接続に使用する情報
	private final String pass = "jdbc:postgresql://localhost:5433/postgres";
	private final String dbUserName = "postgres";
	private final String dbPassword = "password";
  

  public Account findByLogin(Login login) {//ログインのためにDBに接続するメソッド
    Account account = null;

    // データベースへ接続
    try (Connection conn = DriverManager.getConnection(pass, dbUserName, dbPassword)) {

      // SELECT文を準備(ログイン画面で入力されたユーザーIDとパスに一致するレコードを探してきてrsに代入してる)
      String sql = "SELECT USER_ID, PASS, MAIL, NAME FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      pStmt.setString(1, login.getUserId());//?一つ目にuserIdをセット
      pStmt.setString(2, login.getPass());//?二つ目にpassをセット

      // SELECTを実行し、結果表を取得
      ResultSet rs = pStmt.executeQuery();

      // 一致したユーザーが存在した場合
      // そのユーザーを表すAccountインスタンスを生成
      if (rs.next()) {
        // 結果表からデータを取得
        String userId = rs.getString("USER_ID");
        String pass = rs.getString("PASS");
        String mail = rs.getString("MAIL");
        String name = rs.getString("NAME");        
        account = new Account(userId, pass, mail, name);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    // 見つかったユーザーまたはnullを返す
    return account;
  }
  
  public boolean userCreate(Account account) {//新規会員登録のためのメソッド
	  // データベースへ接続
	  try (Connection conn = DriverManager.getConnection(pass, dbUserName, dbPassword)) {

	      // INSERT文を準備(会員登録画面で入力された情報をACCOUNTテーブルに追加)
	      String sql = "INSERT INTO ACCOUNT (USER_ID,PASS,MAIL,NAME) VALUES (?,?,?,?)";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      pStmt.setString(1,account.getUserId());
	      pStmt.setString(2,account.getPass());
	      pStmt.setString(3,account.getMail());
	      pStmt.setString(4,account.getName());
	      
	      int result = pStmt.executeUpdate();
	      
	      if(result == 1) {
	    	  return true;
	      } else {
	    	  return false;
	      }
	  } catch (SQLException e) {
	      e.printStackTrace();
	  }
	  return false;
  }

  public boolean userUpdate(Account account) {//会員情報更新のためのメソッド
	  // データベースへ接続
	  try (Connection conn = DriverManager.getConnection(pass, dbUserName, dbPassword)) {

	      //UPDATE文を準備(ユーザー情報更新画面で入力された情報でACCOUNTテーブルを更新)
	      String sql = "UPDATE ACCOUNT SET PASS=?, MAIL=?, NAME=? WHERE USER_ID=?";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      pStmt.setString(1,account.getPass());
	      pStmt.setString(2,account.getMail());
	      pStmt.setString(3,account.getName());
	      pStmt.setString(4,account.getUserId());
	      
	      int result = pStmt.executeUpdate();
	      
	      if(result == 1) {
	    	  return true;
	      } else {
	    	  return false;
	      }
	  } catch (SQLException e) {
	      e.printStackTrace();
	  }
	  return false;
  }
    
}
