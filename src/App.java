import fileReder.FileReader;

import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        FileReader reader = new FileReader();
        List<String> students = reader.asStream("students-performance.csv")
                .skip(1)
                .collect(Collectors.toList());

        getCountOfStudent(students);
        getFemalCount(students);
        getMalecount(students);
        getParentalEducation(students);
        getscoresHigher90(students);
        getScoresEqual100(students);
        getScoresEqual100Gender(students);
    }

    private static void getScoresEqual100Gender(List<String> students) {
        List<String> scoresEqual100Gender = students.stream()
                .map(e -> e.split(";"))
                .filter(e -> Integer.valueOf(e[2]) == 100 && Integer.valueOf(e[3]) == 100 && Integer.valueOf(e[4]) == 100)
                .map(e -> e[0])
                .collect(Collectors.toList());
        System.out.println("Genders of these students are: " + scoresEqual100Gender);
    }

    private static void getScoresEqual100(List<String> students) {
        Long scoresEqual100 = students.stream()
                .map(e -> e.split(";"))
                .filter(e -> Integer.valueOf(e[2]) == 100 && Integer.valueOf(e[3]) == 100 && Integer.valueOf(e[4]) == 100)
                .count();
        System.out.println("Number of students with scores equal to 100: " + scoresEqual100);
    }

    private static void getscoresHigher90(List<String> students) {
        Long scoresHigher90 = students.stream()

                .map(e -> e.split(";"))
                .filter(e -> Integer.valueOf(e[2]) > 90 && Integer.valueOf(e[3]) > 90 && Integer.valueOf(e[4]) > 90)
                .count();
        System.out.println("Number of students with scores higher than 90: " + scoresHigher90);
    }

    private static void getParentalEducation(List<String> students) {
        List<String> ParentalEducation = students.stream()
                .map(e -> e.split(";"))
                .map(e -> e[1])
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Parental education levels sorted alphabetically: " + ParentalEducation);
    }

    private static void getMalecount(List<String> students) {
        Long maleStudents = students.stream()
                .map(e -> e.split(";"))
                .filter(e -> e[0].equals("male"))
                .count();
        System.out.println("Number of male students: " + maleStudents);
    }

    private static void getFemalCount(List<String> students) {
        Long femaleStudents = students.stream()
                .map(e -> e.split(";"))
                .filter(e -> e[0].equals("female"))
                .count();
        System.out.println("Number of female students: " + femaleStudents);
    }

    private static void getCountOfStudent(List<String> students) {
        Long countStudents = students.stream()
                .count();
        System.out.println("Total number of student performance entries: " + countStudents);
    }
}
