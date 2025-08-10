package studentRecords;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList studentList = new StudentList();
        StudentMethods sm = new StudentMethods(studentList);
        
        int choice = 0;
        do {
            sm.menu();    
            choice = sm.choice(sc);
            
            switch(choice) {
                case 1:
                    sm.choiceOne(sc);
                break;
                case 2:
                    sm.choiceTwo(sc);  
                break;
                case 3:
                    sm.choiceThree(sc);
                break;
                case 4:
                    sm.choiceFour(sc);
                break;
                case 5:
                    sm.choiceFive();
                break;
            }
        }while(choice != 5);
        sc.close();
    }
}
