import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BroadcastingCompany bbc = new BroadcastingCompany();
        bbc.restoreState(); // Automatically restore the saved state when the application starts
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Add a program");
            System.out.println("2. Remove a program");
            System.out.println("3. Display current programs");
            System.out.println("4. Save state");
            System.out.println("5. Restore state");
            System.out.println("6. Exit");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Enter the program name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter the program duration (in minutes):");
                    try {
                        int duration = Integer.parseInt(scanner.nextLine().trim());
                        bbc.addProgram(new Program(name, duration));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number for the duration.");
                    }
                    break;
                case "2":
                    System.out.println("Enter the program name:");
                    String programName = scanner.nextLine();
                    Program programToRemove = null;
                    for (Program program : bbc.getPrograms()) {
                        if (program.getName().equals(programName)) {
                            programToRemove = program;
                            break;
                        }
                    }
                    if (programToRemove != null) {
                        bbc.removeProgram(programToRemove);
                    } else {
                        System.out.println("Program not found.");
                    }
                    break;
                case "3":
                    System.out.println("Current programs:");
                    for (Program program : bbc.getPrograms()) {
                        System.out.println(program);
                    }
                    break;
                case "4":
                    bbc.saveState();
                    break;
                case "5":
                    bbc.restoreState();
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}