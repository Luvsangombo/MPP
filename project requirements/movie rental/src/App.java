import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import business.Actor;
import business.Administrator;
import business.Author;
import business.CheckoutEntry;
import business.CheckoutRecord;
import business.Director;
import business.MemberUser;
import business.Movie;
import dataaccess.FileStorageUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Create an Administrator object
        Administrator admin1 = new Administrator("Hossam", "Hassan", 1234);
        Administrator admin2 = new Administrator("od", "ch", 1234);
        Administrator admin3 = new Administrator("Luvsangombo", "Gochoodorj", 1234);
        Administrator admin4 = new Administrator("dummy", "user", 1234);

        // Save the administrator object to a file
        FileStorageUtil.saveObject("1", admin1, FileStorageUtil.StorageType.ADMINISTRATORS);
        FileStorageUtil.saveObject("2", admin2, FileStorageUtil.StorageType.ADMINISTRATORS);
        FileStorageUtil.saveObject("3", admin3, FileStorageUtil.StorageType.ADMINISTRATORS);
        FileStorageUtil.saveObject("4", admin4, FileStorageUtil.StorageType.ADMINISTRATORS);

        // // Retrieve an Actor object
        Administrator retrievedAdministrator = (Administrator) FileStorageUtil.getObject("1",
                FileStorageUtil.StorageType.ADMINISTRATORS);
        System.out.println("Retrieved Administrator: " + retrievedAdministrator);

        // Update an Administator object
        retrievedAdministrator.setLastName("updated lastname"); // Update age
        FileStorageUtil.saveObject("1", retrievedAdministrator,
                FileStorageUtil.StorageType.ADMINISTRATORS);
        System.out.println("Updated Administator: " + FileStorageUtil.getObject("1",
                FileStorageUtil.StorageType.ADMINISTRATORS));

        // Delete an Administator object
        // FileStorageUtil.deleteObject("4",
        // FileStorageUtil.StorageType.ADMINISTRATORS);
        // System.out.println(
        // "Administator4 exists after deletion: " + FileStorageUtil.exists("4",
        // FileStorageUtil.StorageType.ADMINISTRATORS));

        // List all Administator objects
        List<Administrator> allAdministrators = FileStorageUtil
                .listAllObjects(FileStorageUtil.StorageType.ADMINISTRATORS);
        System.out.println("All Admins:");
        for (Administrator admin : allAdministrators) {
            System.out.println(admin);
        }

        // Create an Actor object
        Actor actor1 = new Actor("Leonardo", "DiCaprio", "bio");
        Actor actor2 = new Actor("Meryl", "Streep", "bio");
        Actor actor3 = new Actor("Tom", "Hanks", "bio");
        Actor actor4 = new Actor("Natalie", "Portman", "bio");
        Actor actor5 = new Actor("Brad", "Pitt", "bio");
        Actor actor6 = new Actor("Emma", " Stone", "bio");

        // Save new Actor objects
        FileStorageUtil.saveObject("1", actor1, FileStorageUtil.StorageType.ACTOR);
        FileStorageUtil.saveObject("2", actor2, FileStorageUtil.StorageType.ACTOR);
        FileStorageUtil.saveObject("3", actor3, FileStorageUtil.StorageType.ACTOR);
        FileStorageUtil.saveObject("4", actor4, FileStorageUtil.StorageType.ACTOR);
        FileStorageUtil.saveObject("5", actor5, FileStorageUtil.StorageType.ACTOR);
        FileStorageUtil.saveObject("6", actor6, FileStorageUtil.StorageType.ACTOR);

        // // Retrieve an Actor object
        Actor retrievedActor = (Actor) FileStorageUtil.getObject("2",
                FileStorageUtil.StorageType.ACTOR);
        System.out.println("Retrieved Actor: " + retrievedActor);

        // Update an Actor object
        retrievedActor.setBio("updated bio"); // Update age
        FileStorageUtil.saveObject("2", retrievedActor,
                FileStorageUtil.StorageType.ACTOR);
        System.out.println("Updated Actor: " + FileStorageUtil.getObject("2",
                FileStorageUtil.StorageType.ACTOR));

        // Delete an Actor object
        // FileStorageUtil.deleteObject("5", FileStorageUtil.StorageType.ACTOR);
        // System.out.println(
        // "Actor2 exists after deletion: " + FileStorageUtil.exists("5",
        // FileStorageUtil.StorageType.ACTOR));

        // List all Actor objects
        List<Actor> allActors = FileStorageUtil.listAllObjects(FileStorageUtil.StorageType.ACTOR);
        System.out.println("All Actors:");
        for (Actor actor : allActors) {
            System.out.println(actor);
        }

        // Create an Author object
        Author author1 = new Author("Isaac", "Asimov", "bio");
        Author author2 = new Author("Dummy", "Author", "bio");

        // Save the author object to a file
        FileStorageUtil.saveObject("1", author1, FileStorageUtil.StorageType.AUTHOR);
        FileStorageUtil.saveObject("2", author2, FileStorageUtil.StorageType.AUTHOR);

        // Load the author object from the file
        Author loadedAuthor = (Author) FileStorageUtil.getObject("1", FileStorageUtil.StorageType.AUTHOR);
        System.out.println("Retrieved Author: " + loadedAuthor);

        // Update an Author object
        loadedAuthor.setBio("updated author bio"); // Update age
        FileStorageUtil.saveObject("1", loadedAuthor,
                FileStorageUtil.StorageType.AUTHOR);
        System.out.println("Updated Author: " + FileStorageUtil.getObject("1",
                FileStorageUtil.StorageType.AUTHOR));

        // Delete an Author object
        // FileStorageUtil.deleteObject("1", FileStorageUtil.StorageType.AUTHOR);
        // System.out.println(
        // "Author2 exists after deletion: " + FileStorageUtil.exists("2",
        // FileStorageUtil.StorageType.AUTHOR));

        // List all Author objects
        List<Author> allAuthors = FileStorageUtil.listAllObjects(FileStorageUtil.StorageType.AUTHOR);
        System.out.println("All Authors:");
        for (Author author : allAuthors) {
            System.out.println(author);
        }

        // Create a Director object
        // Create Director objects
        Director director1 = new Director("Christopher", "Nolan", "bio");
        Director director2 = new Director("Dummy", "Director", "bio");

        // Save the director objects to a file
        FileStorageUtil.saveObject("1", director1, FileStorageUtil.StorageType.DIRECTOR);
        FileStorageUtil.saveObject("2", director2, FileStorageUtil.StorageType.DIRECTOR);

        // Retrieve a Director object
        Director retrievedDirector = (Director) FileStorageUtil.getObject("1", FileStorageUtil.StorageType.DIRECTOR);
        System.out.println("Retrieved Director: " + retrievedDirector);

        // Update a Director object
        retrievedDirector.setBio("updated bio"); // Update the bio
        FileStorageUtil.saveObject("1", retrievedDirector, FileStorageUtil.StorageType.DIRECTOR);
        System.out.println("Updated Director: " + FileStorageUtil.getObject("1", FileStorageUtil.StorageType.DIRECTOR));

        // Delete a Director object
        // FileStorageUtil.deleteObject("2", FileStorageUtil.StorageType.DIRECTOR);
        // System.out.println("Director2 exists after deletion: "
        // + FileStorageUtil.exists("2", FileStorageUtil.StorageType.DIRECTOR));

        // List all Director objects
        List<Director> allDirectors = FileStorageUtil.listAllObjects(FileStorageUtil.StorageType.DIRECTOR);
        System.out.println("All Directors:");
        for (Director director : allDirectors) {
            System.out.println(director);
        }

        // Create a MemberUser object

        // Create MemberUser objects
        MemberUser user1 = new MemberUser(1, "John", "Doe", "123.432.1234", "123 Main St", admin1);
        MemberUser user2 = new MemberUser(2, "Jane", "Smith", "123.432.1234", "456 Elm St", admin1);
        MemberUser user3 = new MemberUser(3, "Michael", "Johnson", "123.432.1234", "789 Oak St", admin1);
        MemberUser user4 = new MemberUser(4, "Emily", "Davis", "123.432.1234", "101 Maple St", admin1);
        MemberUser user5 = new MemberUser(5, "Chris", "Brown", "123.432.1234", "102 Pine St", admin1);
        MemberUser user6 = new MemberUser(6, "Sarah", "Wilson", "123.432.1234", "103 Cedar St", admin1);

        // Save the MemberUser objects to a file
        FileStorageUtil.saveObject("1", user1, FileStorageUtil.StorageType.MEMBERS);
        FileStorageUtil.saveObject("2", user2, FileStorageUtil.StorageType.MEMBERS);
        FileStorageUtil.saveObject("3", user3, FileStorageUtil.StorageType.MEMBERS);
        FileStorageUtil.saveObject("4", user4, FileStorageUtil.StorageType.MEMBERS);
        FileStorageUtil.saveObject("5", user5, FileStorageUtil.StorageType.MEMBERS);
        FileStorageUtil.saveObject("6", user6, FileStorageUtil.StorageType.MEMBERS);

        // Retrieve a MemberUser object
        MemberUser retrievedUser = (MemberUser) FileStorageUtil.getObject("1", FileStorageUtil.StorageType.MEMBERS);
        System.out.println("Retrieved MemberUser: " + retrievedUser);

        // Update a MemberUser object
        retrievedUser.setAddress("Updated Address"); // Update the address
        FileStorageUtil.saveObject("1", retrievedUser, FileStorageUtil.StorageType.MEMBERS);
        System.out
                .println("Updated MemberUser: " + FileStorageUtil.getObject("1", FileStorageUtil.StorageType.MEMBERS));

        // Delete a MemberUser object
        // FileStorageUtil.deleteObject("6", FileStorageUtil.StorageType.MEMBERS);
        // System.out.println("MemberUser6 exists after deletion: "
        // + FileStorageUtil.exists("6", FileStorageUtil.StorageType.MEMBERS));

        // List all MemberUser objects
        List<MemberUser> allMembers = FileStorageUtil.listAllObjects(FileStorageUtil.StorageType.MEMBERS);
        System.out.println("All Members:");
        for (MemberUser member : allMembers) {
            System.out.println(member);
        }

        // Create Movie objects
        Movie movie1 = new Movie("Inception", "DVD", "Sci-Fi", author1, new ArrayList<>(Arrays.asList(actor1, actor2)),
                director1, 5, 19.99);
        Movie movie2 = new Movie("The Matrix", "Blu-Ray", "Sci-Fi", author1,
                new ArrayList<>(Arrays.asList(actor1, actor3)), director1, 4, 14.99);
        Movie movie3 = new Movie("La La Land", "Digital", "Romance", author1,
                new ArrayList<>(Arrays.asList(actor2, actor6)), director1, 5, 12.99);
        Movie movie4 = new Movie("Forrest Gump", "DVD", "Drama", author1,
                new ArrayList<>(Arrays.asList(actor3, actor5)), director1, 5, 15.99);
        Movie movie5 = new Movie("Black Swan", "Blu-Ray", "Thriller", author1,
                new ArrayList<>(Arrays.asList(actor4, actor2)), director1, 4, 16.99);
        Movie movie6 = new Movie("The Curious Case of Benjamin Button", "Digital", "Drama", author1,
                new ArrayList<>(Arrays.asList(actor5, actor3)), director1, 5, 17.99);

        // Save the Movie objects to a file
        FileStorageUtil.saveObject("1", movie1, FileStorageUtil.StorageType.MOVIES);
        FileStorageUtil.saveObject("2", movie2, FileStorageUtil.StorageType.MOVIES);
        FileStorageUtil.saveObject("3", movie3, FileStorageUtil.StorageType.MOVIES);
        FileStorageUtil.saveObject("4", movie4, FileStorageUtil.StorageType.MOVIES);
        FileStorageUtil.saveObject("5", movie5, FileStorageUtil.StorageType.MOVIES);
        FileStorageUtil.saveObject("6", movie6, FileStorageUtil.StorageType.MOVIES);

        // Retrieve a Movie object
        Movie retrievedMovie = (Movie) FileStorageUtil.getObject("1", FileStorageUtil.StorageType.MOVIES);
        System.out.println("Retrieved Movie: " + retrievedMovie);

        // Update a Movie object
        retrievedMovie.setPrice(21.99); // Update the price
        FileStorageUtil.saveObject("1", retrievedMovie, FileStorageUtil.StorageType.MOVIES);
        System.out.println("Updated Movie: " + FileStorageUtil.getObject("1", FileStorageUtil.StorageType.MOVIES));

        // Delete a Movie object
        FileStorageUtil.deleteObject("6", FileStorageUtil.StorageType.MOVIES);
        System.out.println(
                "Movie6 exists after deletion: " + FileStorageUtil.exists("6", FileStorageUtil.StorageType.MOVIES));

        // List all Movie objects
        List<Movie> allMovies = FileStorageUtil.listAllObjects(FileStorageUtil.StorageType.MOVIES);
        System.out.println("All Movies:");
        for (Movie movie : allMovies) {
            System.out.println(movie);
        }
        // // Load the movie object from the file
        // Movie loadedMovie = (Movie)
        // FileStorageUtil.loadObject(FileStorageUtil.StorageType.MOVIES);

        // if (loadedMovie != null) {
        // System.out.println("Movie title: " + loadedMovie.getTitle());
        // }

        // // Create a CheckoutEntry object
        // CheckoutEntry entry = new CheckoutEntry(movie, LocalDate.now(),
        // LocalDate.now());

        // // Save the checkout entry object to a file
        // FileStorageUtil.saveObject(entry, FileStorageUtil.StorageType.CHECKOUTENTRY);

        // // Load the checkout entry object from the file
        // CheckoutEntry loadedEntry = (CheckoutEntry) FileStorageUtil
        // .loadObject(FileStorageUtil.StorageType.CHECKOUTENTRY);

        // if (loadedEntry != null) {
        // System.out.println("Checkout Entry: " + loadedEntry.getMovieTitle() + ", " +
        // loadedEntry.getCheckoutDate());
        // }

        // // Create a CheckoutRecord object
        // CheckoutRecord record = new CheckoutRecord(member, 100, new
        // ArrayList<CheckoutEntry>(Arrays.asList(entry)));

        // // Save the checkout record object to a file
        // FileStorageUtil.saveObject(record,
        // FileStorageUtil.StorageType.CHECKOUTRECORD);

        // // Load the checkout record object from the file
        // CheckoutRecord loadedRecord = (CheckoutRecord) FileStorageUtil
        // .loadObject(FileStorageUtil.StorageType.CHECKOUTRECORD);

        // if (loadedRecord != null) {
        // System.out.println("Checkout Record for member: " +
        // loadedRecord.getMember().getFullName());
        // }

    }
}
