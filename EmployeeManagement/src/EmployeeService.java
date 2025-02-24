import java.lang.reflect.UndeclaredThrowableException;

public class EmployeeService {
	// to maintain list of employees
	private Employee[] employees;
	private int count;

	public EmployeeService(int size) {
		employees = new Employee[size];
		count = 0;

	}

	public void addEmployee(int id, String name, double salary) {
		try {
			if (count >= employees.length) {
				throw new Exception(" List is already full ");
			} else {
				employees[count] = new Employee(id, name, salary);
				count++;
				System.out.println("Employee Added Successfully ");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void showEmployeeList() {
		if (count == 0) {
			System.out.println(" OOPS no Employee to be shown ");
			return;
		}
		for (int i = 0; i < count; i++) {

			System.out.println("The List of Employees : ");
			employees[i].display();
		}

	}

	public void findEmployeeById(int searchId) {
		try {
			for (int i = 0; i < count; i++) {

				if (employees[i].getId() == searchId) {
					employees[i].display();
					return;
				}
			}
			throw new EmployeeNotFound(" The employee not found with this Id ");
		} catch (EmployeeNotFound e) {

			System.out.println("Error : " + e.getMessage());
		}

	}

	public void updateSalary(int updateId, double newSalary)  {
		try {
			for (int i = 0; i < count; i++) {

				if (employees[i].getId() == updateId) {
					employees[i].setSalary(newSalary);
					return;
				}

			}throw new EmployeeNotFound("Employee Id with "+ updateId + " not found ");
			

		} catch (InvalidSalary | EmployeeNotFound e ) { // new concept 
			System.out.println(e.getMessage());
		}
	}

	public void deleteEmployee(int deleteId) {
		
			 for (int i = 0; i < count; i++) {
			 if (employees[i].getId() == deleteId) {
			 employees[i] = employees[count- 1]; // Replace with last employee
			 employees[count- 1] = null; // Remove last employee
			 count--; // Reduce count
			 System.out.println("Employee with ID " + deleteId + " deleted successfully.");
			 return;
			 }
			 }
			 System.out.println("Error: Employee with ID " + deleteId + " not found.");

	}
}
