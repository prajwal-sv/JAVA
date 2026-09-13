package LibraryManagementSystem;


import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/*
 * ============================================================
 *       LIBRARY MANAGEMENT SYSTEM - JAVA CONCEPT DEMO
 * ============================================================
 *
 * This single program demonstrates:
 *
 * 1. OOP Fundamentals
 *    - Classes and Objects
 *    - Abstraction
 *    - Encapsulation
 *    - Inheritance
 *    - Polymorphism
 *
 * 2. Interfaces
 *    - Borrowable
 *    - Generic Searchable<T>
 *
 * 3. Generics
 *    - Generic class Inventory<T>
 *    - Generic methods
 *
 * 4. Collections
 *    - ArrayList
 *    - HashMap
 *    - HashSet
 *    - Comparator
 *    - Collections.sort()
 *
 * 5. Exception Handling
 *    - Checked exception
 *    - Unchecked exception
 *    - try-catch-finally
 *    - Multi-catch
 *
 * 6. Enum
 *
 * 7. static and final
 *
 * 8. Multithreading
 *    - Thread
 *    - Runnable
 *    - synchronized
 *
 * 9. File I/O
 *    - BufferedWriter
 *    - BufferedReader
 *
 * 10. Functional Programming
 *     - Lambda expressions
 *     - Streams
 *     - Method references
 *     - Comparator.comparing()
 *
 * 11. Date and Time API
 *     - LocalDateTime
 *
 * ============================================================
 */


/* ============================================================
 * ENUM
 * ============================================================
 *
 * An enum represents a fixed set of constants.
 *
 * Here, every member must have one of three membership types.
 */
enum MembershipType {

    STUDENT(3),
    FACULTY(5),
    GUEST(1);

    // Each membership type has a maximum number of books.
    private final int maxBooksAllowed;

    // Enum constructor.
    MembershipType(int maxBooksAllowed) {
        this.maxBooksAllowed = maxBooksAllowed;
    }

    public int getMaxBooksAllowed() {
        return maxBooksAllowed;
    }
}


/* ============================================================
 * CUSTOM CHECKED EXCEPTION
 * ============================================================
 *
 * A checked exception extends Exception.
 *
 * Java forces the programmer to handle or declare checked
 * exceptions.
 */
class ItemNotAvailableException extends Exception {

    public ItemNotAvailableException(String message) {
        super(message);
    }
}


/* ============================================================
 * CUSTOM UNCHECKED EXCEPTION
 * ============================================================
 *
 * RuntimeException represents an unchecked exception.
 *
 * The compiler does not force us to catch this exception.
 */
class InvalidMemberException extends RuntimeException {

    public InvalidMemberException(String message) {
        super(message);
    }
}


/* ============================================================
 * INTERFACE: Borrowable
 * ============================================================
 *
 * An interface defines behavior that implementing classes
 * promise to provide.
 */
interface Borrowable {

    void borrowItem();

    void returnItem();
}


/* ============================================================
 * GENERIC INTERFACE: Searchable<T>
 * ============================================================
 *
 * T is a generic type parameter.
 *
 * The same interface can theoretically be used for different
 * types of searchable objects.
 */
interface Searchable<T> {

    List<T> search(String keyword);
}


/* ============================================================
 * ABSTRACT CLASS: LibraryItem
 * ============================================================
 *
 * ABSTRACTION:
 * We know every library item has an ID, title and availability,
 * but different item types can define their own item type.
 *
 * ENCAPSULATION:
 * Fields are private and accessed through public getters/setters.
 *
 * INHERITANCE:
 * Book, Magazine and DVD will inherit from LibraryItem.
 */
abstract class LibraryItem {

    private String id;
    private String title;
    private boolean isAvailable;

    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
    }

    // Abstract method.
    // Subclasses MUST provide their own implementation.
    public abstract String getItemType();

    // Getters and setters demonstrate encapsulation.

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return getItemType() +
                "{id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", available=" + isAvailable +
                '}';
    }
}


/* ============================================================
 * CLASS: Book
 * ============================================================
 *
 * INHERITANCE:
 * Book extends LibraryItem.
 *
 * POLYMORPHISM:
 * Book overrides getItemType().
 */
class Book extends LibraryItem {

    private String isbn;
    private String genre;

    // Constructor WITHOUT ISBN.
    public Book(String id, String title, String genre) {
        super(id, title);
        this.genre = genre;
        this.isbn = "N/A";
    }

    // OVERLOADED CONSTRUCTOR WITH ISBN.
    //
    // Constructor overloading means multiple constructors
    // can have the same name but different parameters.
    public Book(String id, String title, String isbn, String genre) {
        super(id, title);
        this.isbn = isbn;
        this.genre = genre;
    }

    @Override
    public String getItemType() {
        return "Book";
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    /* --------------------------------------------------------
     * toString()
     * --------------------------------------------------------
     *
     * Provides a readable representation of an object.
     */
    @Override
    public String toString() {
        return "Book{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genre='" + genre + '\'' +
                ", available=" + isAvailable() +
                '}';
    }


    /* --------------------------------------------------------
     * equals()
     * --------------------------------------------------------
     *
     * Determines when two Book objects should be considered
     * logically equal.
     *
     * Here we use the book ID.
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Book)) {
            return false;
        }

        Book other = (Book) obj;

        return Objects.equals(getId(), other.getId());
    }


    /* --------------------------------------------------------
     * hashCode()
     * --------------------------------------------------------
     *
     * When equals() is overridden, hashCode() should also be
     * overridden.
     *
     * This is important when objects are used in HashSet,
     * HashMap, etc.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}


/* ============================================================
 * CLASS: Magazine
 * ============================================================
 *
 * Another subclass of LibraryItem.
 */
class Magazine extends LibraryItem {

    private int issueNumber;

    public Magazine(String id, String title, int issueNumber) {
        super(id, title);
        this.issueNumber = issueNumber;
    }

    @Override
    public String getItemType() {
        return "Magazine";
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", issueNumber=" + issueNumber +
                ", available=" + isAvailable() +
                '}';
    }
}


/* ============================================================
 * CLASS: DVD
 * ============================================================
 *
 * Another example of inheritance and method overriding.
 */
class DVD extends LibraryItem {

    private int durationMinutes;

    public DVD(String id, String title, int durationMinutes) {
        super(id, title);
        this.durationMinutes = durationMinutes;
    }

    @Override
    public String getItemType() {
        return "DVD";
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", durationMinutes=" + durationMinutes +
                ", available=" + isAvailable() +
                '}';
    }
}


/* ============================================================
 * CLASS: Member
 * ============================================================
 *
 * Represents a library member.
 */
class Member {

    private String memberId;
    private String name;
    private MembershipType membershipType;

    // We store IDs of borrowed books.
    private final Set<String> borrowedItemIds = new HashSet<>();

    public Member(String memberId,
                  String name,
                  MembershipType membershipType) {

        this.memberId = memberId;
        this.name = name;
        this.membershipType = membershipType;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public Set<String> getBorrowedItemIds() {
        return borrowedItemIds;
    }

    public boolean canBorrowMoreBooks() {
        return borrowedItemIds.size()
                < membershipType.getMaxBooksAllowed();
    }
}


/* ============================================================
 * GENERIC CLASS: Inventory<T extends LibraryItem>
 * ============================================================
 *
 * GENERICS provide compile-time type safety.
 *
 * T extends LibraryItem means T can be LibraryItem or any
 * subclass of LibraryItem.
 *
 * For example:
 *
 * Inventory<Book>
 * Inventory<DVD>
 * Inventory<Magazine>
 */
class Inventory<T extends LibraryItem> {

    private final List<T> items = new ArrayList<>();


    // Generic collection method.
    public void addItem(T item) {
        items.add(item);
    }


    // Generic remove method.
    public boolean removeItem(T item) {
        return items.remove(item);
    }


    // Find item by ID.
    public T findItem(String id) {

        for (T item : items) {

            if (item.getId().equals(id)) {
                return item;
            }
        }

        return null;
    }


    // Return the inventory list.
    public List<T> getItems() {
        return items;
    }
}


/* ============================================================
 * CLASS: Library
 * ============================================================
 *
 * Library implements TWO interfaces:
 *
 * 1. Borrowable
 * 2. Searchable<LibraryItem>
 *
 * This demonstrates INTERFACE IMPLEMENTATION and POLYMORPHISM.
 */
class Library implements Borrowable, Searchable<LibraryItem> {

    /*
     * static means this variable belongs to the CLASS rather
     * than an individual Library object.
     */
    static int totalBooksInLibrary = 0;


    /*
     * final means this value cannot be changed after it has
     * been initialized.
     */
    static final int MAX_CAPACITY = 1000;


    /*
     * ArrayList:
     * An ordered, resizable collection.
     */
    private final List<LibraryItem> items = new ArrayList<>();


    /*
     * HashMap:
     * Stores key-value pairs.
     *
     * Key   = member ID
     * Value = Member object
     */
    private final HashMap<String, Member> members = new HashMap<>();


    /*
     * HashSet:
     * Stores unique values and automatically prevents duplicates.
     *
     * Here it stores unique book genres.
     */
    private final HashSet<String> uniqueGenres = new HashSet<>();


    /*
     * Generic Inventory demonstrates generics.
     */
    private final Inventory<Book> bookInventory = new Inventory<>();


    /* --------------------------------------------------------
     * Add a library item
     * -------------------------------------------------------- */
    public void addItem(LibraryItem item) {

        if (items.size() >= MAX_CAPACITY) {
            throw new IllegalStateException(
                    "Library has reached maximum capacity."
            );
        }

        items.add(item);

        // Count only actual books.
        if (item instanceof Book) {

            totalBooksInLibrary++;

            Book book = (Book) item;

            // HashSet automatically stores each genre once.
            uniqueGenres.add(book.getGenre());

            bookInventory.addItem(book);
        }
    }


    /* --------------------------------------------------------
     * Register a member
     * -------------------------------------------------------- */
    public void registerMember(Member member) {

        members.put(member.getMemberId(), member);
    }


    /* --------------------------------------------------------
     * Searchable<T> implementation
     * --------------------------------------------------------
     *
     * Searches both item ID and title.
     */
    @Override
    public List<LibraryItem> search(String keyword) {

        String lowerKeyword = keyword.toLowerCase();

        return items.stream()
                .filter(item ->
                        item.getId().toLowerCase().contains(lowerKeyword)
                                ||
                        item.getTitle().toLowerCase().contains(lowerKeyword))
                .collect(Collectors.toList());
    }


    /* --------------------------------------------------------
     * Find an item by ID
     * -------------------------------------------------------- */
    public LibraryItem findItem(String itemId) {

        for (LibraryItem item : items) {

            if (item.getId().equals(itemId)) {
                return item;
            }
        }

        return null;
    }


    /* --------------------------------------------------------
     * CORE LOGIC: borrowBook()
     * --------------------------------------------------------
     *
     * synchronized is extremely important here.
     *
     * Imagine two threads try to borrow the same book:
     *
     * Thread 1 -> checks book
     * Thread 2 -> checks book
     *
     * Without synchronization, both might see the book as
     * available.
     *
     * synchronized ensures only ONE thread executes this
     * method at a time for the same Library object.
     */
    public synchronized void borrowBook(
            String memberId,
            String itemId)
            throws ItemNotAvailableException {

        // Validate member.
        Member member = members.get(memberId);

        if (member == null) {

            /*
             * InvalidMemberException is unchecked, so we don't
             * have to declare it in the method signature.
             */
            throw new InvalidMemberException(
                    "Invalid member ID: " + memberId
            );
        }


        // Check membership borrowing limit.
        if (!member.canBorrowMoreBooks()) {

            throw new InvalidMemberException(
                    "Member " + member.getName()
                            + " has reached the borrowing limit."
            );
        }


        // Find requested item.
        LibraryItem item = findItem(itemId);

        if (item == null) {

            throw new ItemNotAvailableException(
                    "Item does not exist: " + itemId
            );
        }


        // Check availability.
        if (!item.isAvailable()) {

            throw new ItemNotAvailableException(
                    "Item is already borrowed: "
                            + item.getTitle()
            );
        }


        /*
         * Update state.
         */
        item.setAvailable(false);

        member.getBorrowedItemIds().add(itemId);


        /*
         * LocalDateTime is part of the modern Java Date/Time API.
         */
        LocalDateTime transactionTime = LocalDateTime.now();

        System.out.println(
                "[" + transactionTime + "] "
                        + member.getName()
                        + " borrowed "
                        + item.getTitle()
        );
    }


    /* --------------------------------------------------------
     * Return a book/item
     * -------------------------------------------------------- */
    public synchronized void returnBook(
            String memberId,
            String itemId) {

        Member member = members.get(memberId);

        if (member == null) {

            throw new InvalidMemberException(
                    "Invalid member ID: " + memberId
            );
        }

        LibraryItem item = findItem(itemId);

        if (item == null) {

            throw new InvalidMemberException(
                    "Invalid item ID: " + itemId
            );
        }


        item.setAvailable(true);

        member.getBorrowedItemIds().remove(itemId);


        System.out.println(
                "[" + LocalDateTime.now() + "] "
                        + member.getName()
                        + " returned "
                        + item.getTitle()
        );
    }


    /* --------------------------------------------------------
     * Interface method: borrowItem()
     * --------------------------------------------------------
     *
     * The interface requires this method.
     *
     * The overloaded borrowBook() method above performs the
     * actual application-specific borrowing operation.
     */
    @Override
    public void borrowItem() {

        System.out.println(
                "Borrowable.borrowItem() called."
        );
    }


    /* --------------------------------------------------------
     * Interface method: returnItem()
     * -------------------------------------------------------- */
    @Override
    public void returnItem() {

        System.out.println(
                "Borrowable.returnItem() called."
        );
    }


    /* --------------------------------------------------------
     * Sort books
     * --------------------------------------------------------
     *
     * Comparator defines HOW objects should be compared.
     *
     * Collections.sort() sorts the list according to the
     * supplied Comparator.
     */
    public void sortBooksByTitle() {

        List<Book> books = new ArrayList<>();

        for (LibraryItem item : items) {

            if (item instanceof Book) {
                books.add((Book) item);
            }
        }


        Collections.sort(
                books,
                Comparator.comparing(Book::getTitle)
        );


        System.out.println("\nBooks sorted by title:");

        for (Book book : books) {
            System.out.println(book);
        }
    }


    /* --------------------------------------------------------
     * STREAM: available items
     * --------------------------------------------------------
     *
     * Streams allow us to process collections in a functional
     * programming style.
     */
    public List<LibraryItem> getAvailableItems() {

        return items.stream()

                // Lambda expression.
                .filter(item -> item.isAvailable())

                .collect(Collectors.toList());
    }


    /* --------------------------------------------------------
     * STREAM: collect book titles
     * -------------------------------------------------------- */
    public List<String> getBookTitles() {

        return items.stream()

                .filter(item -> item instanceof Book)

                .map(LibraryItem::getTitle)

                .collect(Collectors.toList());
    }


    /* --------------------------------------------------------
     * STREAM + Comparator.comparing()
     * + method reference
     * -------------------------------------------------------- */
    public List<Book> getSortedBooksUsingStreams() {

        return items.stream()

                .filter(item -> item instanceof Book)

                .map(item -> (Book) item)

                .sorted(Comparator.comparing(Book::getTitle))

                .collect(Collectors.toList());
    }


    /* --------------------------------------------------------
     * STREAM-BASED REPORT
     * -------------------------------------------------------- */
    public void printStreamReport() {

        System.out.println(
                "\n========== STREAM REPORT =========="
        );


        long availableCount = items.stream()

                .filter(LibraryItem::isAvailable)

                .count();


        System.out.println(
                "Total items: " + items.size()
        );

        System.out.println(
                "Available items: " + availableCount
        );


        System.out.println("\nAvailable items:");

        items.stream()

                .filter(LibraryItem::isAvailable)

                .forEach(item ->
                        System.out.println(
                                "- " + item.getTitle()
                        )
                );


        List<String> bookTitles = items.stream()

                .filter(item -> item instanceof Book)

                .map(LibraryItem::getTitle)

                .sorted()

                .collect(Collectors.toList());


        System.out.println("\nBook titles:");

        bookTitles.forEach(
                title -> System.out.println("- " + title)
        );


        System.out.println(
                "\nUnique genres: " + uniqueGenres
        );
    }


    /* --------------------------------------------------------
     * FILE I/O: SAVE BOOKS
     * --------------------------------------------------------
     *
     * BufferedWriter is used to write text efficiently.
     */
    public void saveBooksToFile(String fileName) {

        /*
         * try-with-resources automatically closes the writer.
         */
        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(fileName))) {

            for (LibraryItem item : items) {

                if (item instanceof Book) {

                    Book book = (Book) item;

                    /*
                     * Store fields separated by |.
                     */
                    writer.write(
                            book.getId() + "|" +
                            book.getTitle() + "|" +
                            book.getIsbn() + "|" +
                            book.getGenre()
                    );

                    writer.newLine();
                }
            }

            System.out.println(
                    "\nBooks saved to " + fileName
            );

        } catch (IOException e) {

            System.out.println(
                    "Error writing file: "
                            + e.getMessage()
            );
        }
    }


    /* --------------------------------------------------------
     * FILE I/O: READ BOOKS
     * --------------------------------------------------------
     *
     * BufferedReader reads text efficiently line by line.
     */
    public List<Book> loadBooksFromFile(String fileName) {

        List<Book> loadedBooks = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                /*
                 * Expected format:
                 *
                 * ID | TITLE | ISBN | GENRE
                 */
                if (data.length == 4) {

                    Book book = new Book(
                            data[0],
                            data[1],
                            data[2],
                            data[3]
                    );

                    loadedBooks.add(book);
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "Error reading file: "
                            + e.getMessage()
            );
        }

        return loadedBooks;
    }


    /* --------------------------------------------------------
     * STATIC METHOD
     * --------------------------------------------------------
     *
     * static methods can be called using the class name:
     *
     * Library.printReport();
     */
    public static void printReport() {

        System.out.println(
                "\n========== LIBRARY STATIC REPORT =========="
        );

        System.out.println(
                "Total books in library: "
                        + totalBooksInLibrary
        );

        System.out.println(
                "Maximum library capacity: "
                        + MAX_CAPACITY
        );
    }
}


/* ============================================================
 * RUNNABLE FOR MULTITHREADING
 * ============================================================
 *
 * Runnable represents a task that can be executed by a Thread.
 */
class BorrowTask implements Runnable {

    private final Library library;
    private final String memberId;
    private final String itemId;

    public BorrowTask(
            Library library,
            String memberId,
            String itemId) {

        this.library = library;
        this.memberId = memberId;
        this.itemId = itemId;
    }


    @Override
    public void run() {

        try {

            /*
             * Two threads may execute this at approximately
             * the same time.
             *
             * Library.borrowBook() is synchronized, so only
             * one thread can successfully borrow the book.
             */
            library.borrowBook(memberId, itemId);

            System.out.println(
                    Thread.currentThread().getName()
                            + " successfully borrowed the book."
            );

        } catch (ItemNotAvailableException |
                 InvalidMemberException e) {

            /*
             * MULTI-CATCH:
             *
             * Multiple exception types can be handled by one
             * catch block when the handling logic is the same.
             */
            System.out.println(
                    Thread.currentThread().getName()
                            + " failed: "
                            + e.getMessage()
            );
        }
    }
}


/* ============================================================
 * MAIN CLASS
 * ============================================================
 *
 * This is the entry point of the application.
 *
 * The public class has the same name as the file:
 *
 * LibraryManagementSystem.java
 */
public class LibraryManagementSystem {

    public static void main(String[] args) {

        System.out.println(
                "=============================================="
        );

        System.out.println(
                "      LIBRARY MANAGEMENT SYSTEM"
        );

        System.out.println(
                "=============================================="
        );


        /* ----------------------------------------------------
         * CREATE LIBRARY
         * ---------------------------------------------------- */
        Library library = new Library();


        /* ----------------------------------------------------
         * CREATE BOOKS
         * ----------------------------------------------------
         *
         * Demonstrates constructor overloading.
         */

        Book book1 = new Book(
                "B001",
                "Java Programming",
                "978-123456",
                "Programming"
        );

        Book book2 = new Book(
                "B002",
                "Clean Code",
                "Programming"
        );

        Book book3 = new Book(
                "B003",
                "The Hobbit",
                "978-789101",
                "Fantasy"
        );


        /* ----------------------------------------------------
         * CREATE OTHER LIBRARY ITEM TYPES
         * ---------------------------------------------------- */

        Magazine magazine = new Magazine(
                "M001",
                "Technology Today",
                42
        );

        DVD dvd = new DVD(
                "D001",
                "Java Tutorial",
                120
        );


        /* ----------------------------------------------------
         * ADD ITEMS
         * ---------------------------------------------------- */

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);
        library.addItem(magazine);
        library.addItem(dvd);


        /* ----------------------------------------------------
         * REGISTER MEMBERS
         * ----------------------------------------------------
         *
         * Demonstrates enum values.
         */

        Member student = new Member(
                "S001",
                "Alice",
                MembershipType.STUDENT
        );

        Member faculty = new Member(
                "F001",
                "Dr. Bob",
                MembershipType.FACULTY
        );

        Member guest = new Member(
                "G001",
                "Charlie",
                MembershipType.GUEST
        );


        library.registerMember(student);
        library.registerMember(faculty);
        library.registerMember(guest);


        /* ----------------------------------------------------
         * ENUM DEMONSTRATION
         * ---------------------------------------------------- */

        System.out.println(
                "\nMembership limits:"
        );

        System.out.println(
                "Student: "
                        + MembershipType.STUDENT
                        .getMaxBooksAllowed()
        );

        System.out.println(
                "Faculty: "
                        + MembershipType.FACULTY
                        .getMaxBooksAllowed()
        );

        System.out.println(
                "Guest: "
                        + MembershipType.GUEST
                        .getMaxBooksAllowed()
        );


        /* ----------------------------------------------------
         * POLYMORPHISM
         * ----------------------------------------------------
         *
         * A LibraryItem reference can point to a Book,
         * Magazine, or DVD.
         */
        System.out.println(
                "\nPolymorphism demonstration:"
        );

        List<LibraryItem> polymorphicItems =
                new ArrayList<>();

        polymorphicItems.add(book1);
        polymorphicItems.add(magazine);
        polymorphicItems.add(dvd);

        for (LibraryItem item : polymorphicItems) {

            System.out.println(
                    item.getTitle()
                            + " -> "
                            + item.getItemType()
            );
        }


        /* ----------------------------------------------------
         * INTERFACE DEMONSTRATION
         * ---------------------------------------------------- */

        System.out.println(
                "\nInterface demonstration:"
        );

        library.borrowItem();
        library.returnItem();


        /* ----------------------------------------------------
         * SORT BOOKS
         * ---------------------------------------------------- */

        library.sortBooksByTitle();


        /* ----------------------------------------------------
         * GENERIC INVENTORY DEMONSTRATION
         * ---------------------------------------------------- */

        System.out.println(
                "\nGeneric Inventory demonstration:"
        );

        Inventory<Book> inventory =
                new Inventory<>();

        inventory.addItem(book1);
        inventory.addItem(book2);

        System.out.println(
                "Found: "
                        + inventory.findItem("B001")
        );


        /* ----------------------------------------------------
         * NORMAL BORROWING
         * ---------------------------------------------------- */

        System.out.println(
                "\nNormal borrowing:"
        );

        try {

            library.borrowBook(
                    "S001",
                    "B001"
            );

        } catch (ItemNotAvailableException |
                 InvalidMemberException e) {

            System.out.println(
                    "Borrowing error: "
                            + e.getMessage()
            );

        } finally {

            /*
             * finally normally executes regardless of whether
             * an exception occurred.
             */
            System.out.println(
                    "Borrow operation completed."
            );
        }


        /* ----------------------------------------------------
         * INTENTIONALLY TRIGGER
         * ItemNotAvailableException
         * ---------------------------------------------------- */

        System.out.println(
                "\nTriggering ItemNotAvailableException:"
        );

        try {

            /*
             * B001 has already been borrowed.
             */
            library.borrowBook(
                    "F001",
                    "B001"
            );

        } catch (ItemNotAvailableException |
                 InvalidMemberException e) {

            System.out.println(
                    "Expected exception: "
                            + e.getMessage()
            );

        } finally {

            System.out.println(
                    "Availability exception demonstration finished."
            );
        }


        /* ----------------------------------------------------
         * INTENTIONALLY TRIGGER
         * InvalidMemberException
         * ---------------------------------------------------- */

        System.out.println(
                "\nTriggering InvalidMemberException:"
        );

        try {

            library.borrowBook(
                    "INVALID_MEMBER",
                    "B002"
            );

        } catch (ItemNotAvailableException |
                 InvalidMemberException e) {

            System.out.println(
                    "Expected exception: "
                            + e.getMessage()
            );

        } finally {

            System.out.println(
                    "Invalid member demonstration finished."
            );
        }


        /* ----------------------------------------------------
         * RETURN BOOK
         * ---------------------------------------------------- */

        System.out.println(
                "\nReturning B001:"
        );

        library.returnBook(
                "S001",
                "B001"
        );


        /* ----------------------------------------------------
         * MULTITHREADING
         * ----------------------------------------------------
         *
         * Two different members attempt to borrow the SAME
         * book at nearly the same time.
         *
         * Because borrowBook() is synchronized, only one
         * thread can successfully change the book's state.
         */

        System.out.println(
                "\n========== MULTITHREADING =========="
        );

        Thread thread1 = new Thread(
                new BorrowTask(
                        library,
                        "S001",
                        "B002"
                ),
                "Thread-Student"
        );

        Thread thread2 = new Thread(
                new BorrowTask(
                        library,
                        "F001",
                        "B002"
                ),
                "Thread-Faculty"
        );


        thread1.start();
        thread2.start();


        /*
         * join() makes the main thread wait until both worker
         * threads have completed.
         */
        try {

            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println(
                    "Main thread was interrupted."
            );
        }


        /* ----------------------------------------------------
         * STREAMS AND LAMBDAS
         * ---------------------------------------------------- */

        System.out.println(
                "\n========== STREAM / LAMBDA DEMO =========="
        );


        System.out.println(
                "\nAvailable items:"
        );

        library.getAvailableItems()
                .forEach(
                        item -> System.out.println(
                                "- " + item.getTitle()
                        )
                );


        System.out.println(
                "\nBook titles:"
        );

        library.getBookTitles()
                .forEach(
                        title -> System.out.println(
                                "- " + title
                        )
                );


        System.out.println(
                "\nBooks sorted using Streams:"
        );

        library.getSortedBooksUsingStreams()
                .forEach(
                        book -> System.out.println(
                                "- " + book.getTitle()
                        )
                );


        /* ----------------------------------------------------
         * SEARCH INTERFACE
         * ---------------------------------------------------- */

        System.out.println(
                "\nSearch results for 'Java':"
        );

        List<LibraryItem> searchResults =
                library.search("Java");

        searchResults.forEach(
                item -> System.out.println(
                        "- " + item
                )
        );


        /* ----------------------------------------------------
         * STREAM-BASED REPORT
         * ---------------------------------------------------- */

        library.printStreamReport();


        /* ----------------------------------------------------
         * FILE I/O
         * ---------------------------------------------------- */

        System.out.println(
                "\n========== FILE I/O =========="
        );

        String fileName = "books.txt";


        // Save books to file.
        library.saveBooksToFile(fileName);


        // Read books back from file.
        List<Book> loadedBooks =
                library.loadBooksFromFile(fileName);


        System.out.println(
                "\nBooks loaded from file:"
        );

        loadedBooks.forEach(
                book -> System.out.println(
                        "- " + book
                )
        );


        /* ----------------------------------------------------
         * STATIC REPORT
         * ---------------------------------------------------- */

        Library.printReport();


        /* ----------------------------------------------------
         * equals() AND hashCode() DEMONSTRATION
         * ---------------------------------------------------- */

        System.out.println(
                "\n========== equals() / hashCode() =========="
        );

        Book anotherBookWithSameId =
                new Book(
                        "B001",
                        "Different Title",
                        "Different Genre"
                );

        System.out.println(
                "book1.equals(anotherBookWithSameId): "
                        + book1.equals(
                        anotherBookWithSameId
                )
        );

        System.out.println(
                "book1.hashCode(): "
                        + book1.hashCode()
        );

        System.out.println(
                "anotherBookWithSameId.hashCode(): "
                        + anotherBookWithSameId.hashCode()
        );


        /* ----------------------------------------------------
         * FINAL VARIABLE
         * ---------------------------------------------------- */

        System.out.println(
                "\nMAX_CAPACITY is final: "
                        + Library.MAX_CAPACITY
        );


        /* ----------------------------------------------------
         * END
         * ---------------------------------------------------- */

        System.out.println(
                "\n=============================================="
        );

        System.out.println(
                "       PROGRAM EXECUTION COMPLETE"
        );

        System.out.println(
                "=============================================="
        );
    }
}


/* ============================================================
 * OPTIONAL Main CLASS
 * ============================================================
 *
 * The requirement specifically mentions a "Main" class.
 *
 * Since Java allows only one public top-level class per file,
 * this class is package-private.
 *
 * It can still have a main() method and can delegate to the
 * main method of LibraryManagementSystem.
 *
 * The recommended entry point is:
 *
 *     java LibraryManagementSystem
 *
 * ============================================================
 */
class Main {

    public static void main(String[] args) {

        LibraryManagementSystem.main(args);
    }
}

