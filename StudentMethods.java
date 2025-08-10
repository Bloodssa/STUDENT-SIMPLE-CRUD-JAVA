package studentRecords;
import java.util.InputMismatchException;
import java.util.Scanner;

// METHODS IN SWITCH CASE
public class StudentMethods {
    Students list = new Students(); 
    StudentList studentList;
    // CONSTRUCTOR TO PASS THE SAME OBJECT OF STUDENTLIST TO SHARE THE SAME OBJECT DATAS
    public StudentMethods(StudentList studentList){
        this.studentList = studentList;
    }

    // MENU FOR THE CHOICES
    public void menu() {
        System.out.println("Choose an operation: ");
        System.out.println("\n[1] Add ");
        System.out.println("[2] View ");
        System.out.println("[3] Update");
        System.out.println("[4] Delete ");
        System.out.println("[5] Exit");
        System.out.println("\nEnter you choice: ");
    }

    // CHOICE WITH TRY AND CATCH TO AVOID MISMATCH EXCEPTION
    public int choice(Scanner sc) {
        int choice = 0;
        while(true) {            
            try {
                if(!sc.hasNextInt()) {
                    sc.nextLine();
                    throw new InputMismatchException("You must enter a number ");
                }
                choice = sc.nextInt();
                sc.nextLine();
                if(choice < 1|| choice > 5) {
                    throw new OutOfRangeException("You must Input Number 1 - 5!");
                }
                break;
            }catch(InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            }catch(OutOfRangeException e) {
                System.out.println("Try again: " + e.getMessage());
            }
        }
        return choice;
    }

    // CHOICE 1
    public void choiceOne(Scanner sc) {
        int id;
        while(true) {
                System.out.println("\nEnter student ID: ");
                id = list.inputStudentId(sc);
                sc.nextLine();
            if(studentList.students.isEmpty()) {
                System.out.println("Enter student name: ");
                String name = sc.nextLine();
                studentList.addStudent(name, id);  
                break;
            }
                if(studentList.checkStudentId(id)) {
                System.out.println("ID is already taken by other student in the list! Enter unique/other");
            }else{
                System.out.println("Enter student name: ");
                String name = sc.nextLine();
                studentList.addStudent(name, id);  
                break;
            }
        }
    }
    // CHOICE 2
    public void choiceTwo(Scanner sc) {
        System.out.println("Student Records:");
        if(studentList.students.isEmpty()) {
            System.out.println("No students found in the list!");
        }else {
            studentList.showStudents();
        }
    }   
    // CHOICE 3
    public void choiceThree(Scanner sc) {
        int id;
        while(true) {
            System.out.println("Enter ID to update: ");
            id = list.inputStudentId(sc);
            sc.nextLine();
            if(studentList.checkStudentId(id)) {
                System.out.println("Enter new name: ");
                String newName = sc.nextLine();
                studentList.updateName(newName, id);
                    break;
            }else {
                System.out.println("Student with ID "+ id +" not found. Please try again.");
                }
        }
    }
    // CHOICE 4
    public void choiceFour(Scanner sc) {
        int id;
        System.out.println("Enter ID to delete: ");
        id = list.inputStudentId(sc);
        sc.nextLine();
        if(studentList.checkStudentId(id)) {
            studentList.deleteStudent(id);
            System.out.println("Student with " + id + " successfully deleted");
        }else {
            System.out.println("Student with ID "+ id +" not found. Please try again.");
        }
    }
    // CHOICE 5
    public void choiceFive() {
        System.out.println("Exiting program. Goodbye!");
    }
}
