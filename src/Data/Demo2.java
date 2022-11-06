package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo2 {

	public static void StudentDetails() throws SQLException {
		// Scanner sc = new Scanner(System.in);
		// System.out.println("Enter the student name");

		// String name = sc.nextLine();
		Demo1 d = new Demo1();
		String name = d.stud_name;
		Connection con = Connections.getConnection();
		String sql = "insert into Student_Details(Stud_name,marks) values(?,?) ";

		PreparedStatement pst = con.prepareStatement(sql);

		pst.setString(1, name);
		int mark = Demo1.marks;
		pst.setInt(2, mark);
		pst.executeUpdate();

	}

	public static void getMarks()

	{ int mark=Demo1.marks;
		System.out.println(Demo1.stud_name +" "+ "your score>>" + " " + Demo1.marks + "/10");
    if(mark>=8)
    {
    	System.out.println("RESULT"+" "+"GRADE A");
    }else if(mark>=6 & mark<=8)
    {
    	System.out.println("RESULT"+" "+"GRADE B");
    }else if(mark==5)
    {
    	System.out.println("RESULT"+" "+"GRADE C");
    }else if(mark<5)
    {
    	System.out.println("FAIL");
    }
	}
	 public static void getScore() throws SQLException
	    {Connection con = Connections.getConnection();
		 String sql="select stud_id,stud_name,marks from Student_Details order by marks";
			PreparedStatement pst=con.prepareStatement(sql);
			//for(int i=1;i<20;i++) {
		//	pst.setInt(1,i); //? psition, id
			ResultSet rs=pst.executeQuery();
			System.out.println("ID"+"      "+"Name"+"                  "+"Marks");
			while(rs.next()) {
				System.out.println("id>>"+rs.getInt(1)+"    "+"Name>>"+rs.getString(2)+"       "+"marks>>"+rs.getLong(3));
				
				
	    }
	    
}
}