package ua.com.alevel.db;

import ua.com.alevel.entity.Group;
import ua.com.alevel.entity.Student;
import ua.com.alevel.entity.StudentGroup;

import java.util.Objects;
import java.util.UUID;

public final class StudentGroupRelation implements StudentGroupStorage {

    private static StudentGroupRelation instance;
    private final Student[] students = new Student[10];
    private final Group[] groups = new Group[10];
    private final StudentGroup[] studentGroups = new StudentGroup[10];
    private StudentGroupRelation() { }

    public static StudentGroupRelation getInstance() {
        if (instance == null) {
            instance = new StudentGroupRelation();
        }
        return instance;
    }

    public void createStudent(Student student) {
        for(int i = 0; i < this.students.length; ++i) {
            if (this.students[i] == null) {
                this.students[i] = student;
                student.setId(generateIdForStudent());
                break;
            }
        }
    }

    public void createGroup(Group group) {
        for (int i = 0; i < groups.length; i++) {
            if (this.groups[i] == null) {
                this.groups[i] = group;
                group.setId(generateIdForGroup());
                break;
            }
        }
    }

    public void attachStudentForGroup(String studentId, String groupId, StudentGroup studentGroup) {
        for (int i = 0; i < studentGroups.length; i++) {
            if (this.studentGroups[i] == null) {
                this.studentGroups[i] = studentGroup;
                studentGroup.setStudentId(studentId);
                studentGroup.setGroupId(groupId);
                break;
            }
        }
    }

    public Student[] allStudentsByGroup(String groupId) {
        String[] studentIdList = new String[10];

        for (int i = 0; i < studentGroups.length; i++) {
            if (this.studentGroups[i] != null) {
                if (Objects.equals(studentGroups[i].getGroupId(), groupId)) {
                    studentIdList[i] = studentGroups[i].getStudentId();
                }
            }
        }

        Student[] list = new Student[10];

        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] != null) {
                for (int j = 0; j < studentIdList.length; j++) {
                    if (Objects.equals(studentIdList[j], this.students[i].getId())) {
                        list[i] = this.students[i];
                    }
                }
            }
        }
        return list;
    }

    public Group findGroupById(String groupId) {
        for(int i = 0; i < this.groups.length; ++i) {
            if (this.groups[i] != null && Objects.equals(this.groups[i].getId(), groupId)) {
                return this.groups[i];
            }
        }
        return null;
    }

    public Student findStudentById(String studentId) {
        for(int i = 0; i < this.students.length; ++i) {
            if (this.students[i] != null && Objects.equals(this.students[i].getId(), studentId)) {
                return this.students[i];
            }
        }
        return null;
    }

    public void deleteStudent(String studentId) {
        for (int i = 0; i < students.length; i++) {
            if (this.students[i] != null && Objects.equals(this.students[i].getId(), studentId)) {
                this.students[i] = null;
            }
            for (int j = 0; j < studentGroups.length; j++) {
                if (this.studentGroups[i] != null && Objects.equals(this.studentGroups[i].getStudentId(), studentId)) {
                    this.studentGroups[i] = null;
                }
            }
        }
    }

    public void deleteGroup(String groupId) {
        for (int i = 0; i < groups.length; i++) {
            if (this.groups[i] != null && Objects.equals(this.groups[i].getId(), groupId)) {
                this.groups[i] = null;
            }
            for (int j = 0; j < studentGroups.length; j++) {
                if (this.studentGroups[i] != null && Objects.equals(this.studentGroups[i].getGroupId(), groupId)) {
                    this.studentGroups[i] = null;
                }
            }
        }
    }

    public Student[] allStudents() {
        return students;
    }

    public Group[] allGroups() {
        return groups;
    }

    public StudentGroup[] allStudentGroups() {
        return studentGroups;
    }

    private String generateIdForStudent() {
        String id = UUID.randomUUID().toString();
        for(int i = 0; i < students.length; i++) {
            if (id.equals(students[i])) {
                return generateIdForStudent();
            }
        }
        return id;
    }

    private String generateIdForGroup() {
        String id = UUID.randomUUID().toString();
        for(int i = 0; i < groups.length; i++) {
            if (id.equals(groups[i])) {
                return generateIdForGroup();
            }
        }
        return id;
    }
}