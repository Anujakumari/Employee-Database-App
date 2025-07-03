package employee_database;

import java.sql.*;
import java.sql.PreparedStatement;

public class EmployeeDAO {
	
	// Add new employee
    public void addEmployee(String name, String department, double salary) throws Exception {
        String sql = "INSERT INTO employee (name, department, salary) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, department);
            stmt.setDouble(3, salary);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee added successfully.");
            }
        }
    }

    // View all employees
    public void viewEmployees() throws Exception {
        String sql = "SELECT * FROM employee";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("ID | Name | Department | Salary");
            System.out.println("------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dept = rs.getString("department");
                double salary = rs.getDouble("salary");

                System.out.printf("%d | %s | %s | %.2f\n", id, name, dept, salary);
            }
        }
    }

    // Update employee by ID
    public void updateEmployee(int id, String newName, String newDepartment, double newSalary) throws Exception {
        String sql = "UPDATE employee SET name = ?, department = ?, salary = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newName);
            stmt.setString(2, newDepartment);
            stmt.setDouble(3, newSalary);
            stmt.setInt(4, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Employee not found with ID: " + id);
            }
        }
    }

    // Delete employee by ID
    public void deleteEmployee(int id) throws Exception {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee not found with ID: " + id);
            }
        }
    }

}
