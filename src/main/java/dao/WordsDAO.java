package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Words;

public class WordsDAO {//WORDSテーブルに関する一連の処理をするDAO
	// データベース接続に使用する情報
	private final String pass = "jdbc:postgresql://localhost:5433/postgres";
	private final String dbUserName = "postgres";
	private final String dbPassword = "password";
	
	public ArrayList<Words> acquisitionWords() {//(アクイジション)WORDSテーブルから全英単語を取得するメソッド
		// データベースへ接続
	    try (Connection conn = DriverManager.getConnection(pass, dbUserName, dbPassword)) {
	    	// SELECT文を準備(WORDSテーブルから全レコードを取得)
	    	String sql = "SELECT ENGLISH,JAPANESE,ON_JAVA,WRONG_1,WRONG_2,WRONG_3 FROM WORDS ORDER BY ENGLISH";
	    	PreparedStatement pStmt = conn.prepareStatement(sql);

	        // SELECTを実行し、結果を取得
	        ResultSet rs = pStmt.executeQuery();
	        
	        //結果をまとめる用のリストを作成
	        ArrayList<Words> words = new ArrayList<>();
	        
	        // 結果からWordsインスタンスを生成してArrayListにaddするループ処理
	        while(rs.next()) {
	          // 結果表からデータを取得
	          String english = rs.getString("ENGLISH");
	          String japanese = rs.getString("JAPANESE");
	          String on_java = rs.getString("ON_JAVA");
	          String wrong_1 = rs.getString("WRONG_1");       
	          String wrong_2 = rs.getString("WRONG_2");       
	          String wrong_3 = rs.getString("WRONG_3");           
	          Words word = new Words(english,japanese,on_java,wrong_1,wrong_2,wrong_3);
	          words.add(word);
	        }
	        return words;
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Words> findWords() {//(アクイジション)WORDSテーブルから全英単語を取得するメソッド
		// データベースへ接続
	    try (Connection conn = DriverManager.getConnection(pass, dbUserName, dbPassword)) {
	    	// SELECT文を準備(WORDSテーブルから全レコードを取得)
	    	String sql = "SELECT ENGLISH,JAPANESE,ON_JAVA,WRONG_1,WRONG_2,WRONG_3 FROM WORDS ORDER BY DIFFICULTY";
	    	PreparedStatement pStmt = conn.prepareStatement(sql);

	        // SELECTを実行し、結果を取得
	        ResultSet rs = pStmt.executeQuery();
	        
	        //結果をまとめる用のリストを作成
	        ArrayList<Words> words = new ArrayList<>();
	        
	        // 結果からWordsインスタンスを生成してArrayListにaddするループ処理
	        while(rs.next()) {
	          // 結果表からデータを取得
	          String english = rs.getString("ENGLISH");
	          String japanese = rs.getString("JAPANESE");
	          String on_java = rs.getString("ON_JAVA");
	          String wrong_1 = rs.getString("WRONG_1");       
	          String wrong_2 = rs.getString("WRONG_2");       
	          String wrong_3 = rs.getString("WRONG_3");           
	          Words word = new Words(english,japanese,on_java,wrong_1,wrong_2,wrong_3);
	          words.add(word);
	        }
	        return words;
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
}
