
import java.util.*;
import java.sql.*;

class BloodBankManagementSystem {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); // Initialize Scanner object for user input
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BloodBankMS", "root", "");

        // Call methods to perform operations
        InsertDonorDetails(con, sc);
        InsertRecipientDetails(con, sc);

        // Close resources
        sc.close();
        con.close();
    }

    static void InsertDonorDetails(Connection con, Scanner sc) throws Exception {
        String sql = "insert into donor(donor_id,donor_name,blood_group,phone_number,donor_age,donor_gender,donation_date) values(?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        System.out.println("Enter id: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline left by previous nextInt()
        System.out.println("Enter name: ");
        String name = sc.nextLine(); // Read the whole line including spaces
        System.out.println("Enter blood group: ");
        String group = sc.next();
        System.out.println("Enter contact number: ");
        String phone = sc.next();
        System.out.println("Enter age: ");
        int age = sc.nextInt();
        System.out.println("Enter gender: ");
        String gender = sc.next();
        System.out.println("Enter donation date: ");
        String date = sc.next();

        // Set values to PreparedStatement
        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setString(3, group);
        pst.setString(4, phone);
        pst.setInt(5, age);
        pst.setString(6, gender);
        pst.setString(7, date);

        int r = pst.executeUpdate();
        if (r > 0) {
            System.out.println("Donor details inserted successfully");
        } else {
            System.out.println("Donor details insertion unsuccessful");
        }
    }

    static void InsertRecipientDetails(Connection con, Scanner sc) throws SQLException {
        String sql = "insert into recipient(recipient_id, recipient_name,blood_group,phone_number,required_blood_units,medical_condition)values(?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        System.out.println("Enter id: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline left by previous nextInt()
        System.out.println("Enter name: ");
        String name = sc.nextLine(); // Read the whole line including spaces
        System.out.println("Enter blood group: ");
        String group = sc.next();
        System.out.println("Enter contact number: ");
        String phone = sc.next();
        System.out.println("Enter number of blood bags required: ");
        int units = sc.nextInt();
        System.out.println("Enter medical condition if any: ");
        String medical = sc.next();

        // Set values to PreparedStatement
        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setString(3, group);
        pst.setString(4, phone);
        pst.setInt(5, units);
        pst.setString(6, medical);

        int r = pst.executeUpdate();
        if (r > 0) {
            System.out.println("Recipient details inserted successfully");
        } else {
            System.out.println("Recipient details insertion unsuccessful");
        }
    }
}
