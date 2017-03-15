package bo;

import java.util.ArrayList;
import java.util.List;

public class Message {
	List<String> list = new ArrayList<>();
	
	
	public void addMessage(String message){
		list.add(message);
	}
	
	
	public List<String> getAllMessages(){
		return list;
	}
	
	public String getAllMessagesAsString(){
		StringBuffer s = new StringBuffer();
		for(String st : list){
			s.append(st);
			s.append("<br>");
		}
		return s.toString();
	}

	public void clear() {
		list.clear();
	}
}
