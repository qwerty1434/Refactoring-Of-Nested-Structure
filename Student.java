public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public static Student of(String name){
        return new Student(name);
    }
}
