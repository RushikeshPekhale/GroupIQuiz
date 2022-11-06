package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//import com.pst.Test;

public class Demo1 {
public	static int marks = 0;
public  static String stud_name;	

	public static void presentData() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the student name");
      //   String regex="^[A-Za-z]\\w{5,29}$";
		stud_name = scanner.nextLine();
	
	//	Demo2.stud();
		Connection con = Connections.getConnection();
		String sql = "select * from Question where Ques_no=? ";

		PreparedStatement pst = con.prepareStatement(sql);
		String sqlo="select * from options where Ques_no=?";
		PreparedStatement pste = con.prepareStatement(sqlo);
		
				
		
		for (int i = 1; i <= 10; i++) {
			pst.setInt(1, i);
			ResultSet Ques = pst.executeQuery();
			pste.setInt(1, i);
			ResultSet op = pste.executeQuery();
			

			while (Ques.next()) {
				System.out.println("Question" + Ques.getInt(1)+">>");
				System.out.println(Ques.getString(2));
				while(op.next()) {
					System.out.println(op.getString(2));
					System.out.println(op.getString(3));
					System.out.println(op.getString(4));
					System.out.println(op.getString(5));
				}
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the option from A to D");
				char option = sc.next().charAt(0);
				while ((option >= 101 & option <= 122) || (option >= 69 & option <= 90)) {
					System.out.println("Invalid input");
					System.out.println("Enter the option From A to D");
					option = sc.next().charAt(0);

				}
				String sq = "select Ans from Question where Ques_no=? ";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, i);
				
				ResultSet rset = ps.executeQuery();
				while (rset.next()) {
					String ope = String.valueOf(option);

					
	
					String s = rset.getString(3);

					if (s.equalsIgnoreCase(ope)) {
						marks = marks + 1;
						
					} else {

						// marks=marks-1;
					}

				}
			
			}
		}
	}
}