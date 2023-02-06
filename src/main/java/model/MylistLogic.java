package model;

import java.util.ArrayList;

import dao.MylistDAO;

public class MylistLogic {
	public ArrayList<Mylist> acquisition(String userId){
		MylistDAO dao = new MylistDAO();
		ArrayList<Mylist> mylists = new ArrayList<>();
		mylists = dao.acquisition(userId);
		return mylists;
	}
	
	public void add(Mylist mylist,String userId) {
		MylistDAO dao = new MylistDAO();
		dao.add(mylist,userId);
	}
	
	public void delete(String english,String userId) {
		MylistDAO dao = new MylistDAO();
		dao.delete(english,userId);
	}
}
