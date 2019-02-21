
public class Employee {

	private String empName; 
	private String empid;
	private String dept;
	private String contactno;
	private String address;
	private double salary;
	private String doj;
	

	public Employee(String empname, String empid, String dept, String contactno, String address, double salary,
			String doj) {
		this.empName = empname;
		this.empid = empid;
		this.dept = dept;
		this.contactno = contactno;
		this.address = address;
		this.salary = salary;
		this.doj = doj;
	}

	public String getEmpname() {
		return empName;
	}

	public void setEmpname(String empname) {
		this.empName = empname;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
