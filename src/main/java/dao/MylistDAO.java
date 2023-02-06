package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Mylist;

public class MylistDAO {//MYLISTテーブルに関する一連の処理をするDAO
	// データベース接続に使用する情報
	private final String pass = "jdbc:postgresql://localhost:5433/postgres";
	private final String dbUserName = "postgres";
	private final String dbPassword = "password";
	
	public ArrayList<Mylist> acquisition(String userId) {//MYLISTテーブルからuserIdが一致する全レコードを取得するメソッド
		// データベースへ接続
	    try (Connection conn = DriverManager.getConnection(pass, dbUserName, dbPassword)) {
	    	// SELECT文を準備(MYLISTテーブルからuserIdが一致する全レコードを取得)
	    	String sql = "SELECT ENGLISH,JAPANESE,ON_JAVA FROM MYLIST WHERE USER_ID=?";
	    	PreparedStatement pStmt = conn.prepareStatement(sql);
	    	pStmt.setString(1, userId);//?一つ目にuserIdをセット

	        // SELECTを実行し、結果を取得
	        ResultSet rs = pStmt.executeQuery();
	        
	        //結果をまとめる用のリストを作成
	        ArrayList<Mylist> mylists = new ArrayList<>();
	        
	        // 結果からMylistインスタンスを生成してArrayListにaddするループ処理
	        while(rs.next()) {
	          // 結果表からデータを取得
	          String english = rs.getString("ENGLISH");
	          String japanese = rs.getString("JAPANESE");
	          String on_java = rs.getString("ON_JAVA");          
	          Mylist mylist = new Mylist(english,japanese,on_java);
	          mylists.add(mylist);
	        }
	        return mylists;
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	
	public void add(Mylist mylist,String userId) {//MYLISTテーブルにマイリストを追加するメソッド
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(pass, dbUserName, dbPassword)) {
			// INSERT文を準備(MYLISTテーブルに追加)
			String sql = "INSERT INTO MYLIST (ENGLISH,JAPANESE,ON_JAVA,USER_ID) VALUES (?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,mylist.getEnglish());
			pStmt.setString(2,mylist.getJapanese());
			pStmt.setString(3,mylist.getOn_java());
			pStmt.setString(4,userId);
		      
			pStmt.executeUpdate();
		  } catch (SQLException e) {
			  e.printStackTrace();
		  }
	}
	
	public void delete(String english,String userId) {//MYLIST削除するためのメソッド
		//データベース接続
		try (Connection conn = DriverManager.getConnection(pass, dbUserName, dbPassword)) {
			String sql = "DELETE FROM MYLIST WHERE ENGLISH=? AND USER_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,english);
			pStmt.setString(2,userId);
			
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
