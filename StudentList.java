package studentRecords;
import java.util.ArrayList;

public class StudentList {
    ArrayList<Students> students = new ArrayList<>();

    // METHOD TO ADD STUDENT AND PASS IT TO THE ARRAYLIST OF STUDENTS OBJECT || CHOICE 1
    public void addStudent(String name, int id) {
        students.add(new Students(name, id));
    }

    // METHOD TO VIEWTHE STUDENT || CHOICE 2
    public void showStudents() {
        for(Students s : students) {
            s.viewStudents();
        }
    }
    // METHOD TO CHECHK IF THE INPUT ID OF THE USER IS AVAILABLE
    public boolean checkStudentId(int id) {
        for (Students s : students) {
            if(id == s.getId()) {
                return true;
            }
        }
        return false;
    }
    // METHOD TO IF THE ID CHECKER METHOD RETURNS TRUE AND UPDATE THE STUDENT NAME || CHOICE 3
    public void updateName(String name, int id) {
        for (int i = 0; i < students.size(); i++) {
            if(id == students.get(i).getId()) {
                students.get(i).setNewName(name);
            }
        }
    }

    // METHOD TO IF THE ID CHECKER METHOD RETURNS TRUE AND TO DELETE A STUDENT IN THE LSIT || CHOICE 3
    public void deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if(id == students.get(i).getId()) {
                students.remove(i).getName();
            }
        }   
    }
}
