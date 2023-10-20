package Service;

import Model.Student;
import Model.StudyGroup;
import Model.Teacher;

import java.util.List;

public class StudyGroupService {
    private final StudyGroup studyGroup = new StudyGroup();
    public void formStudyGroup(Teacher teacher, List<Student> studentList){
        studyGroup.setTeacher(teacher);
        studyGroup.setStudentList(studentList);
    }
    public StudyGroup getStudyGroup(){
        return studyGroup;
    }
}
