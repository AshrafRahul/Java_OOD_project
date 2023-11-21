import java.util.Scanner;

public class AttendanceSystem {
    private static String[] studentNames = new String[20];
    private static int[] presentAttendance = new int[20];
    private static int[] absentAttendance = new int[20];
    private static int indexNumber = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter how many students you want to add: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < num; i++) {
            System.out.print("Enter student name: ");
            studentNames[indexNumber++] = scanner.nextLine();
        }
    }

    public static void takeAttendance() {
        System.out.println("Enter Y for present and N for absent");

        for (int i = 0; i < indexNumber; i++) {
            System.out.print(i + 1 + ". " + studentNames[i] + " is present (Y/N): ");
            char ch = scanner.nextLine().charAt(0);

            if (ch == 'Y' || ch == 'y') {
                presentAttendance[i]++;
            } else if (ch == 'N' || ch == 'n') {
                absentAttendance[i]++;
            } else {
                System.out.println("Invalid character. Try again.");
                i--;
            }
        }
    }

    public static void checkAttendance() {
        System.out.println("\n    Total Present | Total Absent");

        for (int i = 0; i < indexNumber; i++) {
            System.out.print(studentNames[i] + "     " + presentAttendance[i] + "           |   " + absentAttendance[i]);
            System.out.println();
        }
    }

    public static void removeStudent() {
        System.out.print("\nEnter student name to remove: ");
        String nameToRemove = scanner.nextLine();

        for (int i = 0; i < indexNumber; i++) {
            if (nameToRemove.equals(studentNames[i])) {
                for (int j = i; j < indexNumber - 1; j++) {
                    studentNames[j] = studentNames[j + 1];
                    presentAttendance[j] = presentAttendance[j + 1];
                    absentAttendance[j] = absentAttendance[j + 1];
                }
                indexNumber--;
                System.out.println(nameToRemove + " student is removed");
                break;
            } else if (i == indexNumber - 1) {
                System.out.println("This name is not found");
            }
        }
    }

    public static void main(String[] args) {
        int opt, choose;

        do {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1. Add Student");
            System.out.println("2. Take Attendance");
            System.out.println("3. Check Attendance");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");

            System.out.print("\nPlease choose any menu: ");
            choose = scanner.nextInt();
            scanner.nextLine();

            switch (choose) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    takeAttendance();
                    break;
                case 3:
                    checkAttendance();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (true);
    }
}
