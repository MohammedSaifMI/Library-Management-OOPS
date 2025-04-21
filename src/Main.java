import java.util.*;
import java.util.logging.Logger;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());

        Set<Book> bkSet = new HashSet<>();
        Map<String, String> adminData = new HashMap<>();
        Map<String, String> userData = new HashMap<>();
        Map<String, MemberLib> members = new HashMap<>();

        logger.info("\t\t\t********** Welcome to Library **********");
        int choice1 = -1;
        do {
            try {
                logger.info("\n1.Admin\n2.User\n3.Exit");
                logger.info("Enter your choice: ");
                choice1 = scanner.nextInt();

                switch (choice1) {
                    case 1: {
                        int adChoice;
                        logger.info("\t\t\t------------Welcome to Admin Page--------");
                        logger.info("\n1.Login\n2.Sign-Up\n3.Exit");
                        logger.info("Enter your choice: ");
                        adChoice = scanner.nextInt();

                        try {
                            switch (adChoice) {
                                case 1: {
                                    logger.info("\t\t\tHola! Admin");
                                    logger.info("Enter AdminName: ");
                                    String adminName = scanner.next();
                                    logger.info("Enter AdminPassword: ");
                                    String adminPassword = scanner.next();
                                    logger.info("Validating...");

                                    if (adminData.containsKey(adminName) && adminData.get(adminName).equals(adminPassword)) {
                                        logger.info("\t\t\tYou have successfully logged in!");

                                        int choice;
                                        do {
                                            logger.info("\t----Admin Menu-----");
                                            logger.info("\n1.Display all books\n2.Add Book\n3.Exit");
                                            logger.info("Enter your choice: ");
                                            choice = scanner.nextInt();

                                            try {
                                                switch (choice) {
                                                    case 1: {
                                                        if (bkSet.isEmpty())
                                                            logger.info("\t\t\tNo books are available...");
                                                        else {
                                                            logger.info("\t\t\tAll books in Library:");
                                                            for (Book book : bkSet) {
                                                                book.displayInfo();
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    case 2: {
                                                        int numBooks = 0;
                                                        boolean validInput = false;

                                                        while (!validInput) {
                                                            logger.info("Enter the number of books you want to add: ");
                                                            try {
                                                                numBooks = scanner.nextInt();
                                                                validInput = true;
                                                            } catch (InputMismatchException e) {
                                                                logger.warning("Enter a valid number of books to add (Only integer)");
                                                                scanner.nextLine();
                                                            }
                                                        }
                                                        for (int i = 0; i < numBooks; i++) {
                                                            logger.info("Enter the name of the book: ");
                                                            String title = scanner.next();
                                                            logger.info("Enter the book Id: ");
                                                            String id = scanner.next();
                                                            logger.info("Enter the author of the book: ");
                                                            String author = scanner.next();
                                                            logger.info("Enter the genre of the book: ");
                                                            String genre = scanner.next();
                                                            Book newBook= new Book(title,id,author,genre);
                                                            newBook.isAvailable = true;
                                                            bkSet.add(newBook);
                                                        }
                                                        break;
                                                    }
                                                    case 3: {
                                                        logger.info("Thank you, Goodbye!");
                                                        break;
                                                    }
                                                    default:
                                                        logger.warning("Invalid choice");
                                                }
                                            } catch (Exception e) {
                                                logger.warning("Invalid choice...Enter a valid choice");
                                                scanner.nextLine();
                                            }

                                        } while (choice != 3);
                                    } else {
                                        logger.warning("Invalid Admin Credentials");
                                    }
                                    break;
                                }

                                case 2: {
                                    logger.info("\t\t\tAdmin Sign-Up Page");
                                    logger.info("Enter AdminName: ");
                                    String adminName = scanner.next();
                                    logger.info("Enter AdminPassword: ");
                                    String adminPassword = scanner.next();
                                    logger.info("Enter confirm AdminPassword: ");
                                    String confirmPassword = scanner.next();

                                    if (adminPassword.equals(confirmPassword)) {
                                        adminData.put(adminName, adminPassword);
                                        logger.info("\t\t\tSuccessfully Signed In :)");
                                    } else {
                                        logger.warning("\t\t\tIncorrect Password :(");
                                    }
                                    break;
                                }
                                case 3:
                                    break;
                                default:
                                    logger.warning("Invalid choice");
                            }
                        } catch (Exception e) {
                            logger.warning("Invalid choice...Enter a valid choice");
                            scanner.nextLine();
                        }
                        break;
                    }
                    case 2: {
                        int userChoice;
                        logger.info("\t\t\tSelect any of the options you would like to");
                        logger.info("\n1.Login User\n2.Sign-Up\n3.Exit");
                        logger.info("Enter your choice: ");
                        userChoice = scanner.nextInt();

                        try {
                            switch (userChoice) {
                                case 1: {
                                    logger.info("\t\t\tHello! User :)");
                                    logger.info("Enter the user name: ");
                                    String userName = scanner.next();
                                    logger.info("Enter the password: ");
                                    String password = scanner.next();

                                    logger.info("Validating...");

                                    if (userData.containsKey(userName) && userData.get(userName).equals(password)) {
                                        logger.info("Login successful!");

                                        logger.info("Enter the member id: ");
                                        String memId = scanner.next();

                                        MemberLib member;
                                        if (members.containsKey(userName)) {
                                            member = members.get(userName);
                                            logger.info("Welcome back, " + userName + "!");
                                        } else {
                                            member = new MemberLib(memId, userName);
                                            members.put(userName, member);
                                            logger.info("New member registered.");
                                        }

                                        int choice;
                                        do {
                                            logger.info("\t----Menu-----");
                                            logger.info("1.Display all books\n2.Purchase book\n3.Show Purchased book\n4.Exit");
                                            choice = scanner.nextInt();

                                            try {
                                                switch (choice) {
                                                    case 1:
                                                        if (bkSet.isEmpty())
                                                            logger.warning("No Books Found :(");
                                                        else {
                                                            logger.info("\t\t\tAll books in Library");
                                                            boolean found = false;
                                                            for (Book book : bkSet) {
                                                                if (!member.hasPurchasedBook(book.getId())) {
                                                                    book.displayInfo();
                                                                    found = true;
                                                                }
                                                            }
                                                            if (!found) {
                                                                logger.info("You've already purchased all available books!");
                                                            }

                                                        }
                                                        break;

                                                    case 2:
                                                        logger.info("Enter the book Id: ");
                                                        String bookId = scanner.next();
                                                        try {
                                                            member.purchaseBook(bookId, bkSet);
                                                            logger.info("Purchase Successful!");
                                                        } catch (BookNotAvailableExcep e) {
                                                            logger.warning("Invalid BookId......");
                                                            scanner.nextLine();
                                                        }
                                                        break;

                                                    case 3:
                                                        member.displayPurchasedBook();
                                                        break;

                                                    case 4:
                                                        logger.info("Thank you, Goodbye!");
                                                        break;

                                                    default:
                                                        logger.warning("Invalid choice");
                                                }
                                            } catch (InputMismatchException e) {
                                                logger.warning("Enter a valid choice");
                                                scanner.nextLine();
                                            }

                                        } while (choice != 4);
                                    } else {
                                        logger.warning("Invalid User Credentials");
                                    }
                                    break;
                                }
                                case 2: {
                                    logger.info("\t\t\t-------------User Sign-Up Page------------");
                                    logger.info("Enter the user name: ");
                                    String userName = scanner.next();
                                    logger.info("Enter the password: ");
                                    String userPassword = scanner.next();
                                    logger.info("Enter the confirm password: ");
                                    String confirmPassword = scanner.next();

                                    if (userPassword.equals(confirmPassword)) {
                                        userData.put(userName, userPassword);
                                        logger.info("\t\t\tSuccessfully Signed In :)");
                                    } else {
                                        logger.warning("\t\t\tIncorrect Password :(");
                                    }
                                    break;
                                }
                                case 3:
                                    break;
                                default:
                                    logger.warning("Invalid Option");
                            }
                        } catch (Exception e) {
                            logger.warning("Invalid choice...Enter a valid choice");
                            scanner.nextLine();
                        }
                        break;
                    }
                    case 3: {
                        logger.info("Thank you!, Goodbye :) ");
                        break;
                    }
                    default:
                        logger.warning("Invalid choice");
                }
            } catch (InputMismatchException e) {
                logger.warning("Invalid choice...Enter a valid choice");
                scanner.nextLine();
            }
        } while (choice1 != 3);
    }
}
