import java.util.*;

class Student {

}

class StudentCollection {
    List<Student> ls = new ArrayList<Student>();

    public void addStudent(Student s) {

    }

    public void removeStudent(Student s) {

    }

    public StudentIterator getIterator(String choice) {
        if (choice.equalsIgnoreCase("Percentage")) {
            return new PercentageIterator();
        }
        // else if(choice.equalsIgnoreCase("Standard")){
        // return new StandardIterator();
        // }
        return new StandardIterator();
    }

    private class StandardIterator implements StudentIterator {

        int currentIndex = 0;

        public boolean hasNext() {
            if (currentIndex < ls.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Student next() {
            return ls.get(currentIndex++);
        }
    }

    private class PercentageIterator implements StudentIterator {
        int currentIndex = 0;

        public boolean hasNext() {
            while (currentIndex < ls.size()) {
                Student s = ls.get(currentIndex);
                if (s.getPercentage() >= 80) {
                    return true;
                } else
                    currentIndex++;
            }
            // return false;
        }

        @Override
        public Student next() {
            return ls.get(currentIndex++);
        }
    }
}

interface StudentIterator {
    public boolean hasNext();

    public Student next();
}

public class it_custom {
    public static void main(String[] args) {
        StudentCollection s = new StudentCollection();
        Student s1 = new Student(101, "Str1", 60);
        Student s2 = new Student(102, "Str2", 80);
        Student s3 = new Student(103, "Str3", 90);
        Student s4 = new Student(104, "Str4", 50);

        s.addStudent(s1);
        s.addStudent(s2);
        s.addStudent(s3);
        s.addStudent(s4);

        StudentIterator is = s.getIterator("standard");

        while (is.hasNext()) {
            System.out.println(is.next());
        }
    }
}