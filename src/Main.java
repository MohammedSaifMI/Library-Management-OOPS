import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Map<String, Book> bkHashMap = new HashMap<>();
        Map<String, String> adminData = new HashMap<>();
        Map<String, String> userData = new HashMap<>();
        Map<String, MemberLib> members = new HashMap<>();

        System.out.println("\t\t\t********** Welcome to Library **********");
        int choice1 = -1;
        do {
            try {
                System.out.println("1. Admin");
                System.out.println("2. User");
                System.out.println("3. Exit");
                System.out.println("Enter your choice: ");
                choice1 = scanner.nextInt();

                switch (choice1) {
                    case 1: {
                        int adChoice;
                        System.out.println("\t\t\t------------Welcome to Admin Page--------");
                        System.out.println("1. Login");
                        System.out.println("2. Sign-Up");
                        System.out.println("3. Exit");
                        System.out.print("Enter your choice: ");
                        adChoice = scanner.nextInt();

                        try {
                            switch (adChoice) {
                                case 1: {
                                    System.out.println("\t\t\tHola! Admin");
                                    System.out.print("Enter AdminName: ");
                                    String adminName = scanner.next();
                                    System.out.print("Enter AdminPassword: ");
                                    String adminPassword = scanner.next();

                                    System.out.println("Validating...");
                                    try {
                                        Thread.sleep(3000);
                                    } catch (InterruptedException e) {
                                        System.out.println("Credential didn't work...Sign Up");
                                        scanner.nextLine();
                                    }

                                    if (adminData.containsKey(adminName) && adminData.get(adminName).equals(adminPassword)) {
                                        System.out.println("Login Successful!");

                                        int choice;
                                        do {
                                            System.out.println("\t----Admin Menu-----");
                                            System.out.println("1. Display all books");
                                            System.out.println("2. Add Book");
                                            System.out.println("3. Exit");
                                            System.out.print("Enter your choice: ");
                                            choice = scanner.nextInt();

                                            try {
                                                switch (choice) {
                                                    case 1: {
                                                        if (bkHashMap.isEmpty())
                                                            System.out.println("\t\t\tNo books are available...");
                                                        else {
                                                            System.out.println("\t\t\tAll books in Library:");
                                                            for (Book book : bkHashMap.values()) {
                                                                book.displayInfo();
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    case 2: {
                                                        int numBooks = 0;
                                                        boolean validInput = false;

                                                        while (!validInput) {
                                                            System.out.print("Enter the number of books you want to add: ");
                                                            try {
                                                                numBooks = scanner.nextInt();
                                                                validInput = true;
                                                            } catch (InputMismatchException e) {
                                                                System.out.println("Enter a valid number of books to add (Only integer)");
                                                                scanner.nextLine();
                                                            }
                                                        }
                                                        for (int i = 0; i < numBooks; i++) {
                                                            System.out.print("Enter the name of the book: ");
                                                            String title = scanner.next();
                                                            System.out.print("Enter the book Id: ");
                                                            String id = scanner.next();
                                                            System.out.print("Enter the author of the book: ");
                                                            String author = scanner.next();
                                                            System.out.print("Enter the genre of the book: ");
                                                            String genre = scanner.next();

                                                            bkHashMap.put(id, new Book(title, id, author, genre));
                                                        }
                                                        break;
                                                    }
                                                    case 3: {
                                                        System.out.println("Thank you, Goodbye!");
                                                        break;
                                                    }
                                                    default:
                                                        System.out.println("Invalid choice");
                                                }
                                            } catch (Exception e) {
                                                System.out.println("Invalid choice...Enter a valid choice");
                                                scanner.nextLine();
                                            }

                                        } while (choice != 3);
                                    } else {
                                        System.out.println("Invalid Admin Credentials");
                                    }
                                    break;
                                }

                                case 2: {
                                    System.out.println("\t\t\tAdmin Sign-Up Page");
                                    System.out.print("Enter AdminName: ");
                                    String adminName = scanner.next();
                                    System.out.print("Enter AdminPassword: ");
                                    String adminPassword = scanner.next();
                                    System.out.print("Enter confirm AdminPassword: ");
                                    String confirmPassword = scanner.next();

                                    if (adminPassword.equals(confirmPassword)) {
                                        adminData.put(adminName, adminPassword);
                                        System.out.println("\t\t\tSuccessfully Signed In :)");
                                    } else {
                                        System.out.println("\t\t\tIncorrect Password :(");
                                    }
                                    break;
                                }
                                case 3:
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid choice...Enter a valid choice");
                            scanner.nextLine();
                        }
                        break;
                    }
                    case 2: {
                        int userChoice;
                        System.out.println("\t\t\tSelect any of the options you would like to");
                        System.out.println("1. Login User");
                        System.out.println("2. Sign-Up");
                        System.out.println("3. Exit");
                        System.out.print("Enter your choice: ");
                        userChoice = scanner.nextInt();

                        try {
                            switch (userChoice) {
                                case 1: {
                                    System.out.println("\t\t\tHello! User :)");
                                    System.out.print("Enter the user name: ");
                                    String userName = scanner.next();
                                    System.out.print("Enter the password: ");
                                    String password = scanner.next();

                                    System.out.println("Validating...");
                                    try {
                                        Thread.sleep(3000);
                                    } catch (InterruptedException e) {
                                        System.out.println("Credential didn't work...Sign Up");
                                        scanner.nextLine();
                                    }

                                    if (userData.containsKey(userName) && userData.get(userName).equals(password)) {
                                        System.out.println("Login successful done!");

                                        System.out.print("Enter the member id: ");
                                        String memId = scanner.next();

                                        MemberLib member;
                                        if (members.containsKey(userName)) {
                                            member = members.get(userName);
                                            System.out.println("Welcome back, " + userName + "!");
                                        } else {
                                            member = new MemberLib(memId, userName);
                                            members.put(userName, member);
                                            System.out.println("New member registered.");
                                        }

                                        int choice;
                                        do {
                                            System.out.println("\t----Menu-----");
                                            System.out.println("1. Display all books");
                                            System.out.println("2. Purchase book");
                                            System.out.println("3. Show purchased books");
                                            System.out.println("4. Exit");
                                            choice = scanner.nextInt();

                                            try {
                                                switch (choice) {
                                                    case 1:
                                                        if (bkHashMap.isEmpty())
                                                            System.out.println("No Books Found :(");
                                                        else {
                                                            System.out.println("\t\t\tAll books in Library");
                                                            boolean found = false;
                                                            for (Map.Entry<String, Book> entry : bkHashMap.entrySet()) {
                                                                if (!member.hasPurchasedBook(entry.getKey())) {
                                                                    entry.getValue().displayInfo();
                                                                    found = true;
                                                                }
                                                            }
                                                            if (!found) {
                                                                System.out.println("You've already purchased all available books!");
                                                            }

                                                        }
                                                        break;

                                                    case 2:
                                                        System.out.print("Enter the book Id: ");
                                                        String bookId = scanner.next();
                                                        try {
                                                            member.purchaseBook(bookId, bkHashMap);
                                                            System.out.println("Purchase Successful!");
                                                        } catch (BookNotAvailableExcep e) {
                                                            System.out.println("Invalid BookId......");

                                                            scanner.nextLine();
                                                        }
                                                        break;

                                                    case 3:
                                                        member.displayPurchasedBook();
                                                        break;

                                                    case 4:
                                                        System.out.println("Thank you, Goodbye!");
                                                        break;

                                                    default:
                                                        System.out.println("Invalid choice");
                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("Enter a valid choice");
                                                scanner.nextLine();
                                            }

                                        } while (choice != 4);
                                    } else {
                                        System.out.println("Invalid User Credentials");
                                    }
                                    break;
                                }
                                case 2: {
                                    System.out.println("\t\t\t-------------User Sign-Up Page------------");
                                    System.out.print("Enter the user name: ");
                                    String userName = scanner.next();
                                    System.out.print("Enter the password: ");
                                    String userPassword = scanner.next();
                                    System.out.print("Enter the confirm password: ");
                                    String confirmPassword = scanner.next();

                                    if (userPassword.equals(confirmPassword)) {
                                        userData.put(userName, userPassword);
                                        System.out.println("\t\t\tSuccessfully Signed In :)");
                                    } else {
                                        System.out.println("\t\t\tIncorrect Password :(");
                                    }
                                    break;
                                }
                                case 3:
                                    break;
                                default:
                                    System.out.println("Invalid Option");
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid choice...Enter a valid choice");
                            scanner.nextLine();
                        }
                        break;
                    }
                    case 3: {
                        System.out.println("Thank you!, Goodbye :) ");
                        break;
                    }
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice...Enter a valid choice");
                scanner.nextLine();
            }
        }
        while (choice1 != 3) ;
    }
}