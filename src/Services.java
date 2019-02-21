import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Services {
	Employee emp;
	DatabaseManager db;
	Services(DatabaseManager db) {
		this.db =db;
	}
	Services(Employee e, DatabaseManager db) {
		this.emp = e;
		this.db = db;
	}
	
	public void addEmployee() {
    	
        try {
        	
       		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
       		String date = df.format(new Date());
       		Connection con;
       		Statement stmt;
        	db.setConnection();
        	con = db.getConnection();
        	stmt = db.getStmt();
        	String query = "insert into employee(name, eid, dept, contactno, address, salary,doj)" + " values(?,?,?,?,?,?,?)";
        	PreparedStatement pstmt = con.prepareStatement(query);
        	pstmt.setString(1, emp.getEmpname());
        	pstmt.setString(2, emp.getEmpid());
        	pstmt.setString(3, emp.getDept());
        	pstmt.setString(4, emp.getContactno());
        	pstmt.setString(5, emp.getAddress());
        	pstmt.setDouble(6, emp.getSalary());
        	pstmt.setString(7, emp.getDoj());
        	pstmt.execute();
        	System.out.println("\nYou are successfully added!");
        	
        	con.close();
        } catch (SQLException e) {
    		e.printStackTrace();
    	}
   }
	
	public void EmployeeByName(String name) {
		
		try {
			int flag = 0;
			Connection con;
			Statement stmt;
			db.setConnection();
			con = db.getConnection();
			stmt = db.getStmt();
			String query = "select * from employee";
			ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					if(rs.getString("name").equalsIgnoreCase(name))
					{
					flag = 1;
					String Ename = rs.getString("name");
					String id = rs.getString("eid");
					String depart = rs.getString("dept");
					String contact = rs.getString("contactno");
					String address = rs.getString("address");
					int sal = rs.getInt("salary");
					String doj = rs.getString("doj");
					System.out.println("--------------------------------------------------------------");
					System.out.println(Ename + " " + id + " " + depart + " " + contact + " " + address+ " "+ sal + " " + doj);
					System.out.println("--------------------------------------------------------------");
					}	
				}
				if(flag == 0)
				{
					System.out.println("The person with name " +" "+ name+ " " + "does not exist!");
				}
				con.close();
			 
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
	
	public void EmployeeById(String id) {
		
		try {
			int flag = 0;
			Connection con;
			Statement stmt;
			db.setConnection();
			con = db.getConnection();
			stmt = db.getStmt();
			String query = "select * from employee";
			ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					if(rs.getString("eid").equals(id))
					{
					flag = 1;
					String Ename = rs.getString("name");
					String identity = rs.getString("eid");
					String depart = rs.getString("dept");
					String contact = rs.getString("contactno");
					String address = rs.getString("address");
					int sal = rs.getInt("salary");
					String doj = rs.getString("doj");
					System.out.println("--------------------------------------------------------------");
					System.out.println(Ename + " " + identity + " " + depart + " " + contact + " " + address + " " + sal + " " + " " + doj);
					System.out.println("--------------------------------------------------------------");
					}	
				}
				if(flag == 0)
				{
					System.out.println("The employee with employee id " +" "+ id + " " + "does not exist!");
				}
				con.close();
			 
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void maxSalary() {
		
		 
		 try {
			Connection con;
			Statement stmt;
			db.setConnection();
			con = db.getConnection();
			stmt = db.getStmt();
			String query = "select * from employee where salary = (select max(salary) from employee)";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				String Ename = rs.getString("name");
				String identity = rs.getString("eid");
				String depart = rs.getString("dept");
				String contact = rs.getString("contactno");
				String address = rs.getString("address");
				int sal = rs.getInt("salary");
				String doj = rs.getString("doj");
				
				System.out.println(Ename + " " + identity + " " + depart + " " + contact + " " + address + " " + sal + " " + doj);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	 }
	
	public void minSalary() {
		 
		 
		 try {
			Connection con;
			Statement stmt;
			db.setConnection();
			con = db.getConnection();
			stmt = db.getStmt();
			String query = "select * from employee where salary = (select min(salary) from employee)";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				String Ename = rs.getString("name");
				String identity = rs.getString("eid");
				String depart = rs.getString("dept");
				String contact = rs.getString("contactno");
				String address = rs.getString("address");
				int sal = rs.getInt("salary");
				String doj = rs.getString("doj");
				System.out.println(Ename + " " + identity + " " + depart + " " + contact + " " + address + " " + sal + " " + doj);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 }
	
	public void avgSalary() {
		 
		 
		 try {
			Connection con;
			Statement stmt;
			db.setConnection();
			con = db.getConnection();
			stmt = db.getStmt();
			String query = "select Avg(salary) from employee";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Double sal = rs.getDouble("Avg(salary)");

				System.out.println(sal);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 }
	
	public void yearOfExperience(String ed) {
		 Connection connection;
		 try {
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	 		 String date = df.format(new Date());
	 		
			 Connection con;
			 Statement stmt;
			 db.setConnection();
			 con = db.getConnection();
			 stmt = db.getStmt();
			 String query = "select DATEDIFF(now(),doj) AS 'Result' from employee where eid = ?";
			 PreparedStatement pstmt = con.prepareStatement(query);
			 pstmt.setString(1, ed);
			 ResultSet rs = pstmt.executeQuery();
			 while(rs.next()) {
				 int years = Integer.parseInt(rs.getString("Result"))/365;
				 int months = (Integer.parseInt(rs.getString("Result"))%365)/31;
				 int days = (Integer.parseInt(rs.getString("Result"))%365)%31;
				 System.out.println(years+ " years "+ months+ " months "+ days+ " days ");
			 }
			 con.close();
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
	 }
}
