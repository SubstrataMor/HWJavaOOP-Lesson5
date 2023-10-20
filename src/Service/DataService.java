package Service;

import Model.Student;
import Model.Teacher;
import Model.Type;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    private List<User> userList;

    public DataService() {
        this.userList = new ArrayList<>();
    }

    public void create(String firstName, String secondName, String lastName, String dateBirth, Type type) {
        int id = getFreeId(type);
        if (Type.STUDENT == type) {
            Student student = new Student(firstName, secondName, lastName, dateBirth,id);
            userList.add(student);
        }
        if (Type.TEACHER == type) {
            Teacher teacher = new Teacher(firstName, secondName, lastName, dateBirth,id);
            userList.add(teacher);
        }
    }

    private int getFreeId(Type type) {
        boolean isStudent = Type.STUDENT == type;
        int lastId = 1;
        for (User user: userList) {
            if (user instanceof Teacher && !isStudent){
                lastId = ((Teacher) user).getTeacherId() +1;
            }
            if (user instanceof Student && isStudent){
                lastId = ((Student) user).getStudentId() +1;
            }
        }
        return lastId;
    }

    public User getuserById(Type type, int id){
        boolean isStudent = Type.STUDENT == type;
        for (User user: userList) {
            if (user instanceof Teacher && !isStudent && ((Teacher) user).getTeacherId() == id){
                return user;
            }
            if (user instanceof Student && isStudent && ((Student) user).getStudentId() == id){
                return user;
            }
        }
        return null;
    }
    public List<User> getAllUsers(){
        return userList;
    }
    public List<User> getAllStudent(){
        List<User> resultList = new ArrayList<>();
        for (User user: userList) {
            if (user instanceof Student){
                resultList.add(user);
            }
        }
        return resultList;
    }
    public List<User> getAllTeacher(){
        List<User> resultList = new ArrayList<>();
        for (User user: userList) {
            if (user instanceof Teacher){
                resultList.add(user);
            }
        }
        return resultList;
    }
}
