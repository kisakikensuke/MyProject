package model;

public class Mylist {//マイリストデータを1インスタンスとして扱うためのクラス mylist_idとuser_idは管理しない
	private String english;
	private String japanese;
	private String on_java;
	
	public Mylist(String english, String japanese, String on_java) {
		this.english = english;
		this.japanese = japanese;
		this.on_java = on_java;
	}

	public String getEnglish() {
		return english;
	}

	public String getJapanese() {
		return japanese;
	}

	public String getOn_java() {
		return on_java;
	}

}
