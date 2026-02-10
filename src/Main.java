import java.sql.*;

public class Main {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/mydb";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
//            Statement statement = connection.createStatement();
//            String query = "select * from students";
//            ResultSet resultSet = statement.executeQuery(query);
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                int age = resultSet.getInt("age");
//                double marks = resultSet.getDouble("marks");
//
//                System.out.println("ID: " + id);
//                System.out.println("NAME: " + name);
//                System.out.println("AGE: " + age);
//                System.out.println("MARKS: " + marks);
//            }

//            String query = String.format("INSERT INTO students(name, age, marks) VALUES('%s', %d, %f)", "Rahul", 23, 74.23);
//            int rowsAffected = statement.executeUpdate(query);
//            if (rowsAffected > 0) {
//                System.out.println("Data inserted successfully!!");
//            } else {
//                System.out.println("data not inserted");
//            }

//            String query = String.format("UPDATE students SET marks = %f WHERE id = %d", 89.5, 2);
//            int rowsAffected = statement.executeUpdate(query);
//            if (rowsAffected > 0) {
//                System.out.println("data updated successfully");
//            } else {
//                System.out.println("data not updated");
//            }

//            String query = "DELETE FROM students WHERE ID = 2";
//            int rowsAffected = statement.executeUpdate(query);
//            if (rowsAffected > 0) {
//                System.out.println("data deleted successfully");
//            } else {
//                System.out.println("data not deleted");
//            }

            String query = "INSERT INTO students(name, age, marks) VALUES(?, ?, ?)";
            //Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "Ankita");
            preparedStatement.setInt(2, 23);
            preparedStatement.setDouble(3, 84.7);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("data added successfully");
            } else {
                System.out.println("data not added");
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}