package studentRecords;
import java.util.Scanner;
// import java.util.ArrayList;
import java.util.InputMismatchException;

public class Students {
    private String name;
    private int id;

    // NO PARAMETERS CONSTRUCTOR
    public Students(){}

    public Students(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setNewName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    // TO VIEW ALL THE STUDENTS 
    public void viewStudents() {
        System.out.println("ID : " + getId() + ", Name: " + getName()); 
    }

    // ID INPUT TO AVOID INPUTMISMATCHEXCEPTION
    public int inputStudentId(Scanner sc) {
        int id;
        while(true) {
            try{
                if(!sc.hasNextInt()) {
                    sc.nextLine();
                    throw new InputMismatchException("You must enter a number ");
                }
                id = sc.nextInt();
                break;
            }catch(InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return id;
    }
}
