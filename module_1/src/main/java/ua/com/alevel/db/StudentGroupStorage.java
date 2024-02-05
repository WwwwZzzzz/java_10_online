package ua.com.alevel.db;

import ua.com.alevel.entity.Group;
import ua.com.alevel.entity.Student;
import ua.com.alevel.entity.StudentGroup;

public interface StudentGroupStorage {
    void createStudent(Student var1);
    void createGroup(Group var1);
    Student[] allStudents();
    Group[] allGroups();
    void attachStudentForGroup(String var1, String var2, StudentGroup var3);
    StudentGroup[] allStudentGroups();
    Student[] allStudentsByGroup(String var1);
    Group findGroupById(String var1);
    Student findStudentById(String var1);
    void deleteStudent(String var1);
    void deleteGroup(String var1);
}
