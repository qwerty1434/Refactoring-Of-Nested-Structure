import java.util.*;
public class Group {
    private String groupName;
    private List<Student> member = new ArrayList<>();

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public void addMember(List<Student> students){
        member.addAll(students);
    }

    public String getGroupName() {
        return groupName;
    }

    public List<Student> getMembers() {
        return member;
    }

    public List<String> getMemberNames(){
        return member.stream()
                .map(Student::getName)
                .toList();
    }

    public boolean hasMember(String targetName){
        for (String studentName: getMemberNames()) {
            if(studentName.equals(targetName)) return true;
        }
        return false;
    }

    public boolean hasMemberStream(String targetName){
        return getMemberNames()
                .stream()
                .anyMatch(targetName::equals);
    }


}
