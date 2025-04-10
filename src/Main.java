import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<String , Book> bookHashMap = new HashMap<>();
        HashMap<String, String> adminData = new HashMap<>();
        HashMap<String, String> userData = new HashMap<>();

        System.out.println("\t\t\t********** Welcome to Library **********");

        int choice1;
        do {
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
                                e.printStackTrace();
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

                                    switch (choice) {
                                        case 1:
                                            if (bookHashMap.isEmpty())
                                                System.out.println("\t\t\tNo books are available...");
                                            else {
                                                System.out.println("\t\t\tAll books in Library:");
                                                for (Book book : bookHashMap.values()) {
                                                    book.displayInfo();
                                                }
                                            }
                                            break;

                                        case 2:
                                            System.out.print("Enter the number of books you want to add: ");
                                            int numBooks = scanner.nextInt();

                                            for (int i = 0; i < numBooks; i++) {
                                                System.out.print("Enter the name of the book: ");
                                                String title = scanner.next();
                                                System.out.print("Enter the book Id: ");
                                                String  id = scanner.next();
                                                System.out.print("Enter the author of the book: ");
                                                String author = scanner.next();
                                                System.out.print("Enter the genre of the book: ");
                                                String genre = scanner.next();

                                                bookHashMap.put(id, new Book(title, id, author, genre));
                                            }
                                            break;

                                        case 3:
                                            System.out.println("Thank you, Goodbye!");
                                            break;

                                        default:
                                            System.out.println("Invalid choice");
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
                                e.printStackTrace();
                            }

                            if (userData.containsKey(userName) && userData.get(userName).equals(password)) {
                                System.out.println("Login successful done!");

                                System.out.print("Enter the member id: ");
                                String memId = scanner.next();

                                MemberLib member = new MemberLib(memId, userName);

                                int choice;
                                do {
                                    System.out.println("\t----Menu-----");
                                    System.out.println("1. Display all books");
                                    System.out.println("2. Purchase book");
                                    System.out.println("3. Show purchased books");
                                    System.out.println("4. Exit");
                                    choice = scanner.nextInt();

                                    switch (choice) {
                                        case 1:
                                            if (bookHashMap.isEmpty())
                                                System.out.println("No Books Found :(");
                                            else {
                                                System.out.println("\t\t\tAll books in Library");
                                                for (Book book : bookHashMap.values()) {
                                                    book.displayInfo();
                                                }
                                            }
                                            break;

                                        case 2:
                                            System.out.print("Enter the book Id: ");
                                            String  bookId = scanner.next();
                                            try {
                                                member.purchaseBook(bookId, bookHashMap);
                                                System.out.println("Purchase Successful!");
                                            } catch (BookNotAvailableExcep e) {
                                                System.out.println(e.getMessage());
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
                    break;
                }
                case 3: {
                    System.out.println("Thank you!, Goodbye :( ");
                    break;
                }
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice1 != 3);
    }
}
