import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
  private String username;
  private String password;
  private String name;
  private String email;

  public Student(String username, String password,String name,String email) {
    this.username = username;
    this.password = password;
    this.name=name;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}

public class OnlineCoarse {
  private static List<Student> students = new ArrayList<>();
  private static Student currentStudent = null;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("Welcome to the Course Management System");
      System.out.println("1. Register");
      System.out.println("2. Login");
      System.out.println("3. Exit");
      System.out.print("Please choose an option: ");

      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume the newline character

      switch (choice) {
        case 1:
          register(scanner);
          break;
        case 2:
          login(scanner);
          break;
        case 3:
          System.out.println("Exiting...");
          scanner.close();
          System.exit(0);
        default:
          System.out.println("Invalid choice. Please try again.");
          break;
      }
    }
  }

  private static void register(Scanner scanner) {
    System.out.print("enter name");
    String name=scanner.nextLine();
    System.out.print("enter email");
    String email=scanner.nextLine();
    System.out.print("Enter a username: ");
    String username = scanner.nextLine();
    System.out.print("Enter a password: ");
    String password = scanner.nextLine();

    Student newStudent = new Student(username, password,name,email);
    students.add(newStudent);

    System.out.println("Registration successful. You can now log in.");
  }

  private static void login(Scanner scanner) {
    System.out.print("Enter your username: ");
    String username = scanner.nextLine();
    System.out.print("Enter your password: ");
    String password = scanner.nextLine();

    for (Student student : students) {
      if (student.getUsername().equals(username)&& student.getPassword().equals(password)) {
         currentUser = student;
        System.out.println("Login successful.");

        // Add your course management logic here for the logged-in user
        return;
      }
    }
    System.out.println("Please enter valid username or passwrod");
  }
}