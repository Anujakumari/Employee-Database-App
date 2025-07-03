package employee_database;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);
        while (true) {
        	System.out.print("--- Employee Database App ---\n ");
            System.out.println("\n1. Add Employee\n2. View Employees\n3. Update Employee\n4. Delete Employee\n5. Exit\n");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        sc.nextLine(); // newline
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Department: ");
                        String dept = sc.nextLine();
                        System.out.print("Salary: ");
                        double salary = sc.nextDouble();
                        dao.addEmployee(name, dept, salary);
                        break;
                    case 2:
                        dao.viewEmployees();
                        break;
                    case 3:
                        System.out.print("Employee ID to Update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("New Name: ");
                        String newName = sc.nextLine();
                        System.out.print("New Department: ");
                        String newDept = sc.nextLine();
                        System.out.print("New Salary: ");
                        double newSalary = sc.nextDouble();
                        dao.updateEmployee(updateId, newName, newDept, newSalary);
                        break;
                    case 4:
                        System.out.print("Employee ID to Delete: ");
                        int deleteId = sc.nextInt();
                        dao.deleteEmployee(deleteId);
                        break;
                    case 5:
                        System.exit(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

	}

}
