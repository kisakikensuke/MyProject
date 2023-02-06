package model;

public class Words {//英単語と付随するデータを1インスタンスとして扱うためのクラス
	private String english;
	private String japanese;
	private String on_java;
	private String wrong_1;
	private String wrong_2;
	private String wrong_3;
	
	public Words(String english, String japanese, String on_java, String wrong_1, String wrong_2, String wrong_3) {
		this.english = english;
		this.japanese = japanese;
		this.on_java = on_java;
		this.wrong_1 = wrong_1;
		this.wrong_2 = wrong_2;
		this.wrong_3 = wrong_3;
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

	public String getWrong_1() {
		return wrong_1;
	}

	public String getWrong_2() {
		return wrong_2;
	}

	public String getWrong_3() {
		return wrong_3;
	}
	
}