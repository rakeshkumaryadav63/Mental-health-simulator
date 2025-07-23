import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hi, what is your name?");
        String name = sc.nextLine();

        User user = new User(name);
        Assistant assistant = new Assistant(user);

        while (true) {
            System.out.println("\n*** Check-in Menu ***");
            System.out.println("1. Start a session");
            System.out.println("2. Show mood history");
            System.out.println("3. Terminate the session");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    assistant.startSession(sc);
                    break;
                case "2":
                    assistant.showMoodHistory();
                    break;
                case "3":
                    System.out.println("Session terminated. Take care, " + user.getName() + "!");
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}

class User {
    private String name;
    private List<String> moodHistory;

    public User(String name) {
        this.name = name;
        this.moodHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addMood(String mood) {
        moodHistory.add(mood);
    }

    public List<String> getMoodHistory() {
        return moodHistory;
    }
}

class Assistant {
    private User user;

    public Assistant(User user) {
        this.user = user;
    }

    public void startSession(Scanner sc) {
        System.out.println("Welcome to your mental health session, " + user.getName() + ".");
        System.out.print("How are you feeling today? ");
        String mood = sc.nextLine();
        user.addMood(mood);
        System.out.println("Thank you for sharing. Mood recorded.");
    }

    public void showMoodHistory() {
        System.out.println("\nMood History for " + user.getName() + ":");
        if (user.getMoodHistory().isEmpty()) {
            System.out.println("No mood history recorded yet.");
        } else {
            for (int i = 0; i < user.getMoodHistory().size(); i++) {
                System.out.println((i + 1) + ". " + user.getMoodHistory().get(i));
            }
        }
    }
}
