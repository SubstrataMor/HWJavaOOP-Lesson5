package Model;

public class Student extends User{
    private int studentId;

    public Student(String firstName, String secondName, String lastName, String dateBirth, int studentId) {
        super(firstName, secondName, lastName, dateBirth);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + super.getFirstName() + '\'' +
                ", secondName='" + super.getSecondName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", dateBirth='" + super.getDateBirth() + '\'' +
                '}';
    }
}
