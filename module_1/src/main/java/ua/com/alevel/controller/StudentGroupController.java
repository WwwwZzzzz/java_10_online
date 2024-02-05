package ua.com.alevel.controller;

import ua.com.alevel.entity.Group;
import ua.com.alevel.entity.Student;
import ua.com.alevel.entity.StudentGroup;
import ua.com.alevel.service.GroupService;
import ua.com.alevel.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentGroupController {
    GroupService groupService = new GroupService();
    StudentService studentService = new StudentService();

    public StudentGroupController() { }

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        this.menu();
        String position = "";

        while((position = reader.readLine()) != null) {
            this.crud(position, reader);
            this.menu();
        }

    }

    void menu() {
        System.out.println(" ");
        System.out.println("====================MENU====================");
        System.out.println("Create student - enter 1");
        System.out.println("Create group - enter 2");
        System.out.println("Show all students - enter 3");
        System.out.println("Show all groups - enter 4");
        System.out.println("Attach student to Group - enter 5");
        System.out.println("Show all students by group - enter 6");
        System.out.println("Show all students groups - enter 7");
        System.out.println("Update group - enter 8");
        System.out.println("Update student - enter 9");
        System.out.println("Delete student - enter 10");
        System.out.println("Delete group - enter 11");
        System.out.println("If you want to exit please enter q");
        System.out.println("====================END====================");
        System.out.println(" ");
    }

    void crud(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1":
                this.createStudent(reader);
                break;
            case "2":
                this.createGroup(reader);
                break;
            case "3":
                this.allStudents();
                break;
            case "4":
                this.allGroups();
                break;
            case "5":
                this.attachStudentForGroup(reader);
                break;
            case "6":
                this.allStudentsByGroup(reader);
                break;
            case "7":
                this.allStudentGroups();
                break;
            case "8":
                this.updateStudent(reader);
                break;
            case "9":
                this.updateGroup(reader);
                break;
            case "10":
                this.deleteStudent(reader);
                break;
            case "11":
                this.deleteGroup(reader);
                break;
            case "q":
                System.exit(0);
        }

    }

    public void createStudent(BufferedReader reader) throws IOException {
        System.out.println("====================Create Student====================");
        System.out.println("Please enter student first name");
        String studentFirstName = reader.readLine();
        System.out.println("Please enter student last name");
        String studentLatName = reader.readLine();
        System.out.println("Please enter student age");
        int studentAge = Integer.parseInt(reader.readLine());

        Student student = new Student();

        student.setFirstName(studentFirstName);
        student.setLastName(studentLatName);
        student.setAge(studentAge);
        this.studentService.createStudent(student);
    }

    public void createGroup(BufferedReader reader) throws IOException {
        System.out.println("====================Create Group====================");
        System.out.println("Please enter group name");
        String groupName = reader.readLine();

        Group group = new Group();

        group.setName(groupName);
        this.groupService.createGroup(group);
    }

    public Student updateStudent(BufferedReader reader) throws IOException {
        System.out.println("====================Update Student====================");
        System.out.println("Please enter student id");
        String studentId = reader.readLine();

        Student student = this.studentService.findStudentById(studentId);

        if (student != null) {
            System.out.println("Please enter student first name");
            String studentFirstName = reader.readLine();
            student.setFirstName(studentFirstName);
            System.out.println("Please enter student last name");
            String studentLastName = reader.readLine();
            student.setLastName(studentLastName);
            System.out.println("Please enter student age");
            int studentAge = Integer.parseInt(reader.readLine());
            student.setAge(studentAge);
        } else {
            System.out.println("Such group does not exist");
        }

        return student;
    }

    public Group updateGroup(BufferedReader reader) throws IOException {
        System.out.println("====================Update Group====================");
        System.out.println("Please enter group id");
        String groupId = reader.readLine();

        Group group = this.groupService.findGroupById(groupId);

        if (group != null) {
            System.out.println("Please enter group name");
            String groupName = reader.readLine();
            group.setName(groupName);
        } else {
            System.out.println("Such group does not exist");
        }

        return group;
    }

    public void deleteStudent(BufferedReader reader) throws IOException {
        System.out.println("Delete student");
        System.out.println("Please enter student id");
        String studentId = reader.readLine();
        this.studentService.deleteStudent(studentId);
        Student student = this.studentService.findStudentById(studentId);
        if (student == null) {
            System.out.println("Student deleted successfully");
        }
    }

    public void deleteGroup(BufferedReader reader) throws IOException {
        System.out.println("Delete group");
        System.out.println("Please enter group id");
        String groupId = reader.readLine();
        this.groupService.deleteGroup(groupId);
        Group group = this.groupService.findGroupById(groupId);
        if (group == null) {
            System.out.println("Group deleted successfully");
        }
    }

    public void attachStudentForGroup(BufferedReader reader) throws IOException {
        System.out.println("Attach student to group");
        System.out.println("Please enter student id");
        String studentId = reader.readLine();
        System.out.println("Please enter group id");
        String groupId = reader.readLine();

        StudentGroup studentGroup = new StudentGroup();

        studentGroup.setStudentId(studentId);
        studentGroup.setGroupId(groupId);
        this.groupService.attachStudentForGroup(studentId, groupId, studentGroup);
        System.out.println("studentGroup studentId " + studentGroup.getStudentId() +
                " studentGroup groupId " + studentGroup.getGroupId());
    }

    public Student[] allStudentsByGroup(BufferedReader reader) throws IOException {
        System.out.println("All Students by Group");
        System.out.println("Please enter group id");
        String groupId = reader.readLine();
        Student[] studentList = this.studentService.allStudentsByGroup(groupId);

        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null) {
                System.out.println("Student id: " + studentList[i].getId() +
                        ", Student first name: " + studentList[i].getFirstName() +
                        ", Student last name: " + studentList[i].getLastName() +
                        ", Student age: " + studentList[i].getAge());
            }
        }
        return studentList;
    }

    void allStudents() {
        System.out.println("All Students");
        Student[] students = this.studentService.allStudents();

        for(int i = 0; i < students.length; ++i) {
            if (students[i] != null) {
                System.out.println("Student id: " + students[i].getId() +
                        ", Student first name: " + students[i].getFirstName() +
                        ", Student last name: " + students[i].getLastName() +
                        ", Student age: " + students[i].getAge());
            }
        }
    }

    void allGroups() {
        System.out.println("All Groups");
        Group[] groups = this.groupService.allGroups();

        for(int i = 0; i < groups.length; ++i) {
            if (groups[i] != null) {
                System.out.println("Group id: " + groups[i].getId() +
                        ", Group name: " + groups[i].getName());
            }
        }
    }

    void allStudentGroups() {
        System.out.println("All Student Groups Relations");
        StudentGroup[] studentGroups = this.groupService.allStudentGroups();

        for(int i = 0; i < studentGroups.length; ++i) {
            if (studentGroups[i] != null) {
                System.out.println("Student id: " + studentGroups[i].getStudentId() +
                        ", Group id: " + studentGroups[i].getGroupId());
            }
        }
    }
}
