import java.util.*;
public class Main {
    public static void main(String[] args) {
        Group groupA = new Group("GROUP-A");
        groupA.addMember(List.of(Student.of("A"),
                Student.of("B"),
                Student.of("C"),
                Student.of("D")));
        Group groupB = new Group("GROUP-B");
        groupB.addMember(List.of(Student.of("E"),
                Student.of("F"),
                Student.of("G"),
                Student.of("H")));
        Group groupC = new Group("GROUP-C");
        groupC.addMember(List.of(Student.of("I"),
                Student.of("J"),
                Student.of("K"),
                Student.of("L")));
        Group groupD = new Group("GROUP-D");
        groupD.addMember(List.of(Student.of("M"),
                Student.of("N"),
                Student.of("O"),
                Student.of("P")));

        List<Group> totalGroup = List.of(groupA, groupB, groupC, groupD);

        String targetName = "O";

        System.out.println(findGroupWithTargetMemberIncluded(targetName,totalGroup).getGroupName());
        System.out.println(refactoring1(targetName,totalGroup).getGroupName());
        System.out.println(refactoring2(targetName,totalGroup).getGroupName());
        System.out.println(refactoring3(targetName,totalGroup).getGroupName());
    }

    // badCode
    public static Group findGroupWithTargetMemberIncluded(String targetName, List<Group> totalGroup){
        for (Group group: totalGroup) {
            for(Student student: group.getMembers()){
                if(student.getName().equals(targetName)){
                    return group;
                }
            }
        }
        throw new RuntimeException("NOT_EXIST");
    }
    public static Group refactoring1(String targetName, List<Group> totalGroup){
        for (Group group: totalGroup) {
            for(String studentName: group.getMemberNames()){
                if(studentName.equals(targetName)){
                    return group;
                }
            }
        }
        throw new RuntimeException("NOT_EXIST");
    }

    public static Group refactoring2(String targetName, List<Group> totalGroup){
        for (Group group: totalGroup) {
            if(group.hasMember(targetName)){
                return group;
            }
        }
        throw new RuntimeException("NOT_EXIST");
    }

    public static Group refactoring3(String targetName, List<Group> totalGroup){
        for (Group group: totalGroup) {
            if(group.hasMemberStream(targetName)){
                return group;
            }
        }
        throw new RuntimeException("NOT_EXIST");
    }

}
