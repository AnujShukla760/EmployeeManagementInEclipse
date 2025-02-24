import java.util.Scanner;

public class EMS {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int size = 0; // we can do the task without this as well but to follow this a good approach
		while (true) {
			try {
				System.out.print(" Enter the number of Employees :  ");
				size = scanner.nextInt();
				if (size <= 0) {
					System.out.println("Enter the number greater than 0 ");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("Enter the valid Input please ");
				scanner.nextLine(); // It clears the input buffer and consumes the new line ..........
			}

		}

		EmployeeService employeeService = new EmployeeService(size);
		while (true) {
			try {

				System.out.println("\n Menu :  ");
				System.out.println(" 1. Add Employee ");
				System.out.println(" 2. Display Employees ");
				System.out.println(" 3. Find Employee By ID ");
				System.out.println(" 4. Update Employee salary ");
				System.out.println(" 5. Delete Employee ");
				System.out.println(" 6. Exit the Application ");
				System.out.print("\n  Enter Your Choice : ");
				int choice = scanner.nextInt();
				scanner.nextLine(); // clears the input buffer ...........

				switch (choice) {

				// *********** we can code in the "switch-case" itself grab these concepts
				// ****************88
				case 1:
					int id;
					String name;
					double salary;

					// to handle the input of the "ID" ..........
					while (true) {
						try {
							System.out.print(" Enter the Id Of the Employee : ");
							id = scanner.nextInt();
							scanner.nextLine();
							break;
						} catch (Exception e) {
							System.out.println("Enter the Valid ID of the Employee");
							scanner.nextLine(); // it is very important as "IT CLEARS INPUT BUFFER " and if we don't do
												// this
							// the infinite outputs will be seen of this block..........
						}
					}
					// handling the "name" input
					while (true) {
						System.out.print(" Enter the Name of the Employee : ");
						name = scanner.nextLine();
						if (!isValidName(name)) {
							System.out.println(" Please enter the Valid Name ");
							scanner.nextLine(); // clears input buffer
						} else {
							break;
						}
					}

					// to handle the input of the "salary" .......
					while (true) {
						try {
							System.out.print("Enter the Salary of the Employee : ");
							salary = scanner.nextDouble();
							if (salary <= 0 || salary > 1000000) {
								System.out.println("Enter the salary between 0 and 1000000");

								continue;
							}

							break;
						} catch (Exception e) {
							System.out.println(" Enter the Valid Salary ");
							scanner.nextLine(); // clears the input buffer (V.V.Imp)
						}
					}
					

					employeeService.addEmployee(id, name, salary);
					break;

				case 2:
					employeeService.showEmployeeList();
					break;
				case 3:
					System.out.print(" Enter the Employee Id to Find Out : ");
					int searchId = scanner.nextInt();
					employeeService.findEmployeeById(searchId);
					break;
				case 4:
					System.out.print("Enter Employee ID to update salary: ");
					int updateId = scanner.nextInt();
					System.out.print("Enter new salary: ");
					double newSalary = scanner.nextDouble();
					employeeService.updateSalary(updateId, newSalary);
					break;
				case 5:
					System.out.print("Enter Employee ID to delete: ");
					int deleteId = scanner.nextInt();
					employeeService.deleteEmployee(deleteId);
					break;
				case 6:
					System.out.println("Exiting The Application.....");
					scanner.close();
					return; // to exit from the switch statement
				default:
					System.out.println(" Please Select A Valid Choice   ");

				}

			} catch (Exception e) {
				System.out.println(" Error Occured ");
				scanner.nextLine();
			}
		}
	}
// new concept to check the valid name input in the runtime .................
	private static boolean isValidName(String name) {
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c != ' '))
				return false;
		}
		return true;

	}
}
