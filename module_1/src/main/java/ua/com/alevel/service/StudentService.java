package ua.com.alevel.service;

import ua.com.alevel.db.StudentGroupRelation;
import ua.com.alevel.entity.Student;

public class StudentService {

    private final StudentGroupRelation relation = StudentGroupRelation.getInstance();

    public void createStudent(Student student) {
        if (student.getFirstName() != null && student.getLastName() != null && student.getAge() > 0) {
            relation.createStudent(student);
        }
    }

    public Student[] allStudents() {
        return relation.allStudents();
    }

    public Student[] allStudentsByGroup(String groupId) {
        return relation.allStudentsByGroup(groupId);
    }

    public Student findStudentById(String studentId) {
        return relation.findStudentById(studentId);
    }

    public void deleteStudent(String studentId) {
        Student current = relation.findStudentById(studentId);
        if (current != null) {
            relation.deleteStudent(studentId);
        }
    }
}