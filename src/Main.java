import Controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.createStudent("1", "1", "1", "111");
        controller.createStudent("2", "2", "2", "222");
        controller.createStudent("3", "3", "3", "333");
        controller.createStudent("4", "4", "4", "444");
        controller.getAllStudent();
        controller.printStudyGroup();
    }
}
