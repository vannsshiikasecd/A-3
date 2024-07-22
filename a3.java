import java.util.Scanner;

public class a3 {
    private static final int MAX_BOOKS = 100;
    private String[] isbns;
    private int count;

    public a3() {
        isbns = new String[MAX_BOOKS];
        count = 0;
    }

    public boolean validateISBN(String isbn) {
        if (isbn.length() == 10 || isbn.length() == 13) {
            for (char c : isbn.toCharArray()) {
                if (!Character.isDigit(c) && c != 'X') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean searchISBN(String isbn) {
        for (int i = 0; i < count; i++) {
            if (isbns[i].equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    public void addBook(String isbn) {
        if (count < MAX_BOOKS) {
            isbns[count++] = isbn;
        } else {
            System.out.println("Database is full. Cannot add more books.");
        }
    }

    public void printAllISBNs() {
        for (int i = 0; i < count; i++) {
            System.out.println(isbns[i]);
        }
    }

    public static void main(String[] args) {
        a3 db = new a3();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Book Database Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Search for ISBN");
            System.out.println("3. Print all ISBNs");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN to add: ");
                    String isbnToAdd = scanner.nextLine();
                    while (!db.validateISBN(isbnToAdd)) {
                        System.out.print("Invalid ISBN. Please enter a valid ISBN (10 or 13 digits): ");
                        isbnToAdd = scanner.nextLine();
                    }
                    db.addBook(isbnToAdd);
                    System.out.println("ISBN added to database.");
                    break;
                case 2:
                    System.out.print("Enter ISBN to search: ");
                    String isbnToSearch = scanner.nextLine();
                    if (db.searchISBN(isbnToSearch)) {
                        System.out.println("ISBN found in database.");
                    } else {
                        System.out.println("ISBN not found in database.");
                    }
                    break;
                case 3:
                    System.out.println("All ISBNs in database:");
                    db.printAllISBNs();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
