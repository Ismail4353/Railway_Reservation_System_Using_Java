package SmallApps;
import java.util.*;
//import java.time.LocalDate;
public class Railways {
	//DECLARATION//MEMBERS
	static  boolean EXIT;
	static String Tname;
	static int Upperberth=1;
	static int Middleberth=1;
	static int Lowerberth=1;
	static int Totalberth=Upperberth+Middleberth+Lowerberth;
	static int RAC=1;
	static int Waitinglist=2;
	static String berth[];
	static String Rac[];
	static String waitinglist[];
	static int howmany;
	static String Names;
	static int Age,bert,i,j,k;
	static int id=1999;
	static String Gender;
	static String Seat,Status;
	static String destination;
	static String carrycancel,carrywaiting;
	
	static Scanner sc=new Scanner(System.in);
	public void UserInput() throws InterruptedException {//get input from user
		 System.out.println("------------------------------WELCOME TO IRRS-----------------------------");
		 boolean EXIT=true;
	     while (EXIT){
          
		  System.out.println("Please Select The Input");
		  System.out.println("1.Available Tickets");
		  System.out.println("2.Book Ticket");
		  System.out.println("3.Print Ticket");
		  System.out.println("4.Cancel Ticket");
		  System.out.println("5.Exit");
		  int userinput=sc.nextInt();
		  Switch(userinput);
	     }
	}
	  public static void Switch(int userinput) throws InterruptedException{//selected switch case
	    	
	    	switch(userinput) {
	    	case 1://available tickets
	    		     System.out.println("The Available Tickets Are");
				     System.out.println("loading...");
				     Thread.sleep(1000);
				     AvailableTicket();
				     break;
			case 2://Book ticket
				     Trains();
					 System.out.println("---------------------------------------------------------------");
					 break;
			case 3://print ticket	
				     System.out.println("---------------------------------------------------------------");
				     PrintTicket();
					 break;
			case 4://cancel ticket
				     System.out.println("---------------------------------------------------------------");
				     CancelTicket();
				     break;
			case 5://exit
			         EXIT=false;
					 System.out.println("Thanks for Coming...");
					 System.out.println("---------------------------------------------------------------");
	    	default:
	    		System.out.println("wrong input");
	    		System.out.println("--------------------------------------------------------------");
	    	}
	    	
	    }

    public static void Trains() {//shows train list
    	berth=new String[Totalberth];
    	Rac=new String[RAC];
    	waitinglist =new String[Waitinglist];
    	System.out.println("-------------please type the destination point--------------------------------");
    	System.out.println("CHENNAI");
    	System.out.println("   |");
    	System.out.println("   TO");
    	System.out.println("   |");
    	Tname=sc.next();
    	System.out.println("-------------Please type the train name from chennai to-----------------------");
		destination=sc.nextLine();
		destination=sc.nextLine();
		BookTicket();
		}

   
	public static void AvailableTicket() {
	  
		System.out.println("Total Berth       = 3--Available berths       = "+Totalberth);
        System.out.println("Total RAC         = 2--Available Tickets      = "+RAC);
		System.out.println("Total Waiting List= 2--Available Waiting List = "+Waitinglist);
		System.out.println("---------------------------------------------------------------");
	}
	
    public static void BookTicket() {
    	System.out.println("How many tickets you want to book?");
	    howmany=sc.nextInt();
	    berth=new String[Totalberth];
	    Rac=new String[RAC];
	    waitinglist=new String[Waitinglist];
	    DataConnect DC=new DataConnect();
	    j=0;k=0;
	    for(i=0;i<howmany;i++) {
	    	id++;
	    	System.out.println("Your Name : ");
			Names=sc.nextLine();
			Names=sc.nextLine();
			System.out.println("Your Age : ");
			Age=sc.nextInt();
			System.out.println("Your Gender : ");
			Gender=sc.next();
			System.out.println("Berth Preference: ");
			System.out.println("1.upper berth ");
			System.out.println("2.middle berth ");
			System.out.println("3.lower berth ");
			bert=sc.nextInt();
			BookingRule();
			DC.Database(id, Names, Age, Gender, Tname, destination, Seat, Status);
	    }
	    
	}
    public static void BookingRule() {
    	//LocalDate date=new LocalDate.now();
    	RailwayObject RO=new RailwayObject();//object created
    	if (Age<5)
		{
			System.out.println("berth not allocated for child");
			Status="child";
		}
		if (Age>60)
		{
			if (Lowerberth>0)
			{
				bert=3;
			}
			else if (Middleberth>0)
			{
				bert=2;
			}
			else if (Upperberth>0)
			{
				bert=1;
			}
            
		}
		switch (bert) {
		case 1://upperberth
			if(Upperberth>0) {
				System.out.println("Successfully Booked");
				Status="Confirm";
				Seat="Upper berth";
				Upperberth--;
				Totalberth=Upperberth+Middleberth+Lowerberth;
				berth[i]=RO.Railwayobject(destination,id,Tname, Names, Age, Gender)+"\nBerth :"+Seat;
			}
			else if(Middleberth>0) {
				System.out.println("Successfully Booked");
				Status="Confirm";
				Seat="Middle berth";
				Middleberth--;
				Totalberth=Upperberth+Middleberth+Lowerberth;
				berth[i]=RO.Railwayobject(destination,id,Tname, Names, Age, Gender)+"\nBerth :"+Seat;
			}
			else if(Lowerberth>0) {
				System.out.println("Successfully Booked");
				Status="Confirm";
				Seat="Lower berth";
				Lowerberth--;
				Totalberth=Upperberth+Middleberth+Lowerberth;
				berth[i]=RO.Railwayobject(destination,id,Tname, Names, Age, Gender)+"\nBerth :"+Seat;
			}
			else if(RAC>0) {
				System.out.println("RAC Booked");
				Seat="RAC";
				Status="RAC";
				RAC--;
				Rac[j]=RO.Railwayobject(destination,id,Tname, Names, Age, Gender)+"\nBerth :"+Seat;
				j++;
			}
			else if (Waitinglist>0) {
				System.out.println("Under WaitingList");
				Seat="Waiting List";
				Status="WL";
				Waitinglist--;
				waitinglist[k]=RO.Railwayobject(destination,id,Tname, Names, Age, Gender)+"\nBerth :"+Seat+"-"+(k+1);
				k++;
			}
			else 
				System.out.println("Sorry No Tickets Are Available");
			break;
		case 2://middleberth
			if(Middleberth>0) {
				System.out.println("Successfully Booked");
				Status="Confirm";
				Seat="Middle berth";
				Middleberth--;
				Totalberth=Upperberth+Middleberth+Lowerberth;
				berth[i]=RO.Railwayobject(destination,id,Tname, Names, Age, Gender)+"\nBerth :"+Seat;
			}
			else if(Lowerberth>0) {
				System.out.println("Successfully Booked");
				Status="Confirm";
				Seat="Lower berth";
				Lowerberth--;
				Totalberth=Upperberth+Middleberth+Lowerberth;
				berth[i]=RO.Railwayobject(destination,id,Tname, Names, Age, Gender)+"\nBerth :"+Seat;
			}
			else if(Upperberth>0) {
				System.out.println("Successfully Booked");
				Status="Confirm";
				Seat="Upper berth";
				Upperberth--;
				Totalberth=Upperberth+Middleberth+Lowerberth;
				berth[i]=RO.Railwayobject(destination,id,Tname, Names, Age, Gender)+"\nBerth :"+Seat;
			}
			else if(RAC>0) {
				System.out.println("RAC Booked");
				Seat="RAC";
				Status="RAC";
				RAC--;
				Rac[j]=RO.Railwayobject(destination,id,Tname, Names, Age, Gender)+"\nBerth :"+Seat;
				j++;
			}
			else if (Waitinglist>0) {
				System.out.println("Under WaitingList");
				Seat="Waiting List";
				Status="WL";
				Waitinglist--;
				waitinglist[k]=RO.Railwayobject(destination,id,Tname, Names, Age, Gender)+"\nBerth :"+Seat+"-"+(k+1);
				k++;
			}
			else 
				System.out.println("Sorry No Tickets Are Available");
			break;
		case 3://lowerberth
			if(Lowerberth>0) {
				System.out.println("Successfully Booked");
				Status="Confirm";
				Seat="Lower berth";
				Lowerberth--;
				Totalberth=Upperberth+Middleberth+Lowerberth;
				berth[i]=RO.Railwayobject(destination,id,Tname, Names, Age, Gender)+"\nBerth :"+Seat;
			}
			else if(Middleberth>0) {
				System.out.println("Successfully Booked");
				Status="Confirm";
				Seat="Middle berth";
				Middleberth--;
				Totalberth=Upperberth+Middleberth+Lowerberth;
				berth[i]=RO.Railwayobject(destination,id,Tname, Names, Age, Gender)+"\nBerth :"+Seat;
			}
			else if(Upperberth>0) {
				System.out.println("Successfully Booked");
				Status="Confirm";
				Seat="Upper berth";
				Upperberth--;
				Totalberth=Upperberth+Middleberth+Lowerberth;
				berth[i]=RO.Railwayobject(destination,id,Tname, Names, Age, Gender)+"\nBerth :"+Seat;
			}
			else if(RAC>0) {
				System.out.println("RAC Booked");
				Seat="RAC";
				Status="RAC";
				RAC--;
				Rac[j]=RO.Railwayobject(destination,id,Tname, Names, Age, Gender)+"\nBerth :"+Seat;
				j++;
			}
			else if (Waitinglist>0) {
				System.out.println("Under WaitingList");
				Seat="Waiting List";
				Status="WL";
				Waitinglist--;
				waitinglist[k]=RO.Railwayobject(destination,id,Tname, Names, Age, Gender)+"\nBerth :"+Seat+"-"+(k+1);
				k++;
			}
			else 
				System.out.println("Sorry No Tickets Are Available");
			break;
		default :
			System.out.println("Wrong Input");
		}
    }
    
    public static void PrintTicket() {
    	 for( int y=0;y<berth.length;y++) {
    		 if(berth[y]!=null) {
			 System.out.println(berth[y]);
			 System.out.println("---------------------------------------------------------------");
    		 }
    		}
    	 for(int l=0;l<Rac.length;l++) {
    		 if(Rac[l]!=null) {
    		 System.out.println(Rac[l]);
			 System.out.println("---------------------------------------------------------------");
    		 }
    	 }
    	 for(int h=0;h<waitinglist.length;h++) {
    		 if(waitinglist[h]!=null) {
             System.out.println(waitinglist[h]);
    	     System.out.println("---------------------------------------------------------------");
    		 }
    	 }
	}
    
    public static void CancelTicket() {
		System.out.println("Please Enter Your Ticket Id");
		int cancelid=sc.nextInt();
		int q=0;
		int n=2000;
		RailwayObject R=new RailwayObject();
		RailwayObject WAIT=new RailwayObject();
		for(int p=0;p<howmany;p++) {
			if(cancelid==n) {
				berth[q]=null;//ticket cancelled
				carrycancel=Rac[0];
				Rac[0]=R.Cancel(carrycancel);
				berth[q]=Rac[0];
			for(int o=0;o<Rac.length-1;o++) {
				if(Rac[o+1]!=null) {
				Rac[o]=Rac[o+1];
				}
			}
			 carrywaiting=waitinglist[0];
			 waitinglist[0]=WAIT.Waiting(carrywaiting);
			 Rac[Rac.length-1]=waitinglist[0];
			 if(true) {
			 for(int m=0;m<waitinglist.length-1;m++) {
				 if(waitinglist[m+1]!=null) {
					waitinglist[m]=waitinglist[m+1];
				 }
			  }
			   waitinglist[waitinglist.length-1]=null;
			 }
			 if(Rac[Rac.length-1]==null) {
				 RAC++;
			 }
			 if(waitinglist[waitinglist.length-1]==null) {
				 Waitinglist++;
			 }
			 
			 System.out.println("Ticket Succesfully Cancelled");
			 System.out.println("---------------------------------------------------------------");
			 break;
			  }q++;n++;
		}
	}
}
