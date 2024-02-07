package SmallApps;

public class RailwayObject {

	int ids;
	String name;
	String destiny;
	int age;
	String gender;
	String tname;
	String Carrycancel,Carrywaiting;
	
	public String Railwayobject(String destination,int id,String Tname,String Names,int Age,String Gender){
	//I have created this method to store the user input and return as string type	
		ids=id;
		name=Names;
		age=Age;
		gender=Gender;
		tname=Tname;
		destiny=destination;
		return"-------From Chennai To "+tname+"--------"+"\nTrain :"+destiny+"\t\tID :"+ids+"\nPassenger Name :"+name+"\nPassenger Age :"+age+"\nPassenger Gender :"+gender;
	
	}
	public String Cancel(String carrycancel) {
		
		Carrycancel=carrycancel;// ticket status for rac to berth
		return Carrycancel+"\nStatus Changed : Berth Confirmed";
	}
	public String Waiting(String carrywaiting) {
		
		Carrywaiting=carrywaiting;//ticket status for waitinglist to RAC 
		
		return Carrywaiting+"\nStatus Changed : RAC Confirmed";
	}
	

}
