package model;

import java.util.ArrayList;

import dao.WordsDAO;

public class LearnEnglishLogic {//英単語学習を担当するBO
	public ArrayList<Words> acquisitionWords() {
	    WordsDAO dao = new WordsDAO();
	    ArrayList<Words> words = new ArrayList<>();
	    words  = dao.acquisitionWords();
	    return words;
	}
	public ArrayList<Words> findWords() {
	    WordsDAO dao = new WordsDAO();
	    ArrayList<Words> words = new ArrayList<>();
	    words  = dao.findWords();
	    return words;
	}
}
