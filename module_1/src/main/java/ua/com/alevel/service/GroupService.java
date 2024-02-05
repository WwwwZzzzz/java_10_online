package ua.com.alevel.service;

import ua.com.alevel.db.StudentGroupRelation;
import ua.com.alevel.entity.Group;
import ua.com.alevel.entity.StudentGroup;


public class GroupService {

    private final StudentGroupRelation relation = StudentGroupRelation.getInstance();

    public void createGroup(Group group) {
        relation.createGroup(group);
    }

    public void attachStudentForGroup(String studentId, String groupId, StudentGroup studentGroup) {
        relation.attachStudentForGroup(studentId, groupId, studentGroup);
    }

    public Group[] allGroups() {
        return relation.allGroups();
    }

    public StudentGroup[] allStudentGroups() {
        return relation.allStudentGroups();
    }

    public Group findGroupById(String groupId) {
        return relation.findGroupById(groupId);
    }

    public void deleteGroup(String groupId) {
        Group current = relation.findGroupById(groupId);
        if (current != null) {
            relation.deleteGroup(groupId);
        }
    }
}