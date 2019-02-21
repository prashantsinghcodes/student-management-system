import java.util.Scanner;

public class DatabaseDemo {
	public static void main(String[] args) {
		int choice;
		String character,ch1,ch2;
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Add Employee\n2.Find Employee\n3.Find Salary\n4.Year of Experience");
		do {
		System.out.println("Enter the choice : ");
		choice = sc.nextInt();
		switch(choice) {
		case 1: System.out.print("Name: ");
				 String name = sc.next();
				 System.out.print("Employee Id: ");
				 String empid = sc.next();
				 System.out.print("Department: ");
				 String dept = sc.next();
				 System.out.print("Contact Number: ");
				 String contactno = sc.next();
				 System.out.print("Address: ");
				 String address = sc.next();
				 System.out.print("Salary: ");
				 double salary = (double)sc.nextInt();
				 System.out.print("Date of Joining(yyyy-mm-dd): ");
				 String doj = sc.next();
				 Employee e = new Employee(name, empid, dept,contactno, address, salary, doj);
				 DatabaseManager db = new DatabaseManager();
				 Services s = new Services(e,db);
				 s.addEmployee();
				 break;
		case 2:	System.out.println("1.By Name\n2.By Employee Id");
				System.out.println("Enter your choice: ");
				int ch = sc.nextInt();
			
				switch(ch) {
				case 1: System.out.println("Enter the name of the Employee: ");
				        String ename = sc.next();
				        DatabaseManager dba = new DatabaseManager();
				        Services ser = new Services(dba);
				        ser.EmployeeByName(ename);
				        break;
				case 2: System.out.println("Enter the employee id of the Employee: ");
				        String id = sc.next();
				        DatabaseManager database = new DatabaseManager();
				        Services serv = new Services(database);
				        serv.EmployeeById(id);
				        break;
				default: System.out.println("Enter a correct choice!");
				}
				break;
		case 3: System.out.println("1.Employee with Maximum salary\n2.Employee with Minimum salary\n3.Average Salary\n");
		        System.out.println("Enter your choice: ");
		        int c = sc.nextInt();
		        switch(c) {
		        case 1: DatabaseManager datab = new DatabaseManager();
		        		Services service = new Services(datab);
		        		service.maxSalary();
		        		break;
		        case 2: DatabaseManager databa = new DatabaseManager();
        				Services servicee = new Services(databa);
        				servicee.minSalary();
        				break;
		        case 3: DatabaseManager databas = new DatabaseManager();
		        		Services serviceee = new Services(databas);
		        		serviceee.avgSalary();
		        		break;
        		default: System.out.println("Enter a correct choice!");
		        }
		        break;
		case 4: System.out.println("Enter the employee id whose experience you want to know: ");
				String employeeId = sc.next();
				DatabaseManager dataBase = new DatabaseManager();
				Services serve = new Services(dataBase);
				serve.yearOfExperience(employeeId);
				break;
		default: System.out.println("Enter a valid choice!");
		}
		System.out.println();
		System.out.println("Do you want to continue?(y/n)");
		character = sc.next();
	}while(character.equalsIgnoreCase("y"));
 }
}
