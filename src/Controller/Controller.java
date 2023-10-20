package Controller;

import Model.*;
import Service.DataService;
import Service.StudyGroupService;
import View.StudentView;
import View.StudyGroupView;
import View.TeacherView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final DataService service = new DataService();
    private final StudyGroupService studyGroup = new StudyGroupService();
    private final StudentView studentView = new StudentView();
    private final TeacherView teacherView = new TeacherView();
    private final StudyGroupView studyGroupView = new StudyGroupView();

    public void createStudent(String firstName, String secondName, String lastName, String dateBirth){
        service.create(firstName, secondName, lastName, dateBirth, Type.STUDENT);
    }
    public void createTeacher(String firstName, String secondName, String lastName, String dateBirth){
        service.create(firstName, secondName, lastName, dateBirth, Type.TEACHER);
    }
    public void getAllStudent(){
        List<User> userList = service.getAllStudent();
        for (User user: userList) {
            studentView.printOnConsole((Student) user);
        }
    }
    public void getAllTeacher(){
        List<User> userList = service.getAllTeacher();
        for (User user: userList) {
            teacherView.printTeacherOnConsole((Teacher) user);
        }
    }
    public void createStudyGroup(Integer teacherId, List<Integer> studentIdList){
        Teacher teacher = (Teacher) service.getuserById(Type.TEACHER, teacherId);
        List<Student> studentList = new ArrayList<>();
        for (Integer id: studentIdList) {
            studentList.add((Student) service.getuserById(Type.STUDENT, id));
        }
        studyGroup.formStudyGroup(teacher, studentList);
    }
    public void printStudyGroup(){
        studyGroupView.printStudyGroup(studyGroup.getStudyGroup());
    }
}
