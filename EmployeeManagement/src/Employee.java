
public class Employee {
 public Employee() {
	 
 }
	// attributes
	int id;

	public double getSalary() {
		return salary;
	}

	// this is a new concept that we are using the getter setter methods for other
	// operations also
	public void setSalary(double salary) throws InvalidSalary {
		if (salary <= 0 || salary > 1000000) {
			throw new InvalidSalary(" Please enter the valid salary ");
		} else {

			this.salary = salary;
		}
	}

	String name;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	double salary;

	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		// constructor to initialize the values of the attributes

	}

	public void display() {
		System.out.println("Id : " + id + " Name : " + name + " Salary : " + salary);
	}
// to display the details of the employees 
}