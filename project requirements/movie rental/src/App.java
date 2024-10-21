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

public class App {
    public static void main(String[] args) throws Exception {
        // Create an Administrator object
        Administrator admin = new Administrator("Hossam", "Hassan", 1234);

        // Save the administrator object to a file
        FileStorageUtil.saveObject(admin, FileStorageUtil.StorageType.ADMINISTRATORS);

        // Load the administrator object from the file
        Administrator loadedAdmin = (Administrator) FileStorageUtil
                .loadObject(FileStorageUtil.StorageType.ADMINISTRATORS);

        if (loadedAdmin != null) {
            System.out.println("Admin info: " + loadedAdmin.getFullName());
        }

        // Create an Actor object
        Actor actor = new Actor("Leonardo", "DiCaprio", "bio");

        // Save the actor object to a file
        FileStorageUtil.saveObject(actor, FileStorageUtil.StorageType.ACTOR);

        // Load the actor object from the file
        Actor loadedActor = (Actor) FileStorageUtil.loadObject(FileStorageUtil.StorageType.ACTOR);

        if (loadedActor != null) {
            System.out.println("Actor name: " + loadedActor.getFullName());
        }

        // Create an Author object
        Author author = new Author("Isaac", "Asimov", "bio");

        // Save the author object to a file
        FileStorageUtil.saveObject(author, FileStorageUtil.StorageType.AUTHOR);

        // Load the author object from the file
        Author loadedAuthor = (Author) FileStorageUtil.loadObject(FileStorageUtil.StorageType.AUTHOR);

        if (loadedAuthor != null) {
            System.out.println("Author name: " + loadedAuthor.getFullName());
        }

        // Create a Director object
        Director director = new Director("Christopher", "Nolan", "bio");

        // Save the director object to a file
        FileStorageUtil.saveObject(director, FileStorageUtil.StorageType.DIRECTOR);

        // Load the director object from the file
        Director loadedDirector = (Director) FileStorageUtil.loadObject(FileStorageUtil.StorageType.DIRECTOR);

        if (loadedDirector != null) {
            System.out.println("Director name: " + loadedDirector.getFullName());
        }

        // Create a Member object
        MemberUser member = new MemberUser(12, "John", "Doe", 12345, "address", admin);

        // Save the member object to a file
        FileStorageUtil.saveObject(member, FileStorageUtil.StorageType.MEMBERS);

        // Load the member object from the file
        MemberUser loadedMember = (MemberUser) FileStorageUtil.loadObject(FileStorageUtil.StorageType.MEMBERS);

        if (loadedMember != null) {
            System.out.println("Member name: " + loadedMember.getFullName() + ", ID: " + loadedMember.getId());
        }

        // Create a Movie object
        Movie movie = new Movie("Inception",
                "DVD",
                "Sci-Fi",
                author,
                new ArrayList<Actor>(Arrays.asList(actor)),
                director,
                5,
                19.99);

        // Save the movie object to a file
        FileStorageUtil.saveObject(movie, FileStorageUtil.StorageType.MOVIES);

        // Load the movie object from the file
        Movie loadedMovie = (Movie) FileStorageUtil.loadObject(FileStorageUtil.StorageType.MOVIES);

        if (loadedMovie != null) {
            System.out.println("Movie title: " + loadedMovie.getTitle());
        }

        // Create a CheckoutEntry object
        CheckoutEntry entry = new CheckoutEntry(movie, LocalDate.now(), LocalDate.now());

        // Save the checkout entry object to a file
        FileStorageUtil.saveObject(entry, FileStorageUtil.StorageType.CHECKOUTENTRY);

        // Load the checkout entry object from the file
        CheckoutEntry loadedEntry = (CheckoutEntry) FileStorageUtil
                .loadObject(FileStorageUtil.StorageType.CHECKOUTENTRY);

        if (loadedEntry != null) {
            System.out.println("Checkout Entry: " + loadedEntry.getMovieTitle() + ", " + loadedEntry.getCheckoutDate());
        }

        // Create a CheckoutRecord object
        CheckoutRecord record = new CheckoutRecord(member, 100, new ArrayList<CheckoutEntry>(Arrays.asList(entry)));

        // Save the checkout record object to a file
        FileStorageUtil.saveObject(record, FileStorageUtil.StorageType.CHECKOUTRECORD);

        // Load the checkout record object from the file
        CheckoutRecord loadedRecord = (CheckoutRecord) FileStorageUtil
                .loadObject(FileStorageUtil.StorageType.CHECKOUTRECORD);

        if (loadedRecord != null) {
            System.out.println("Checkout Record for member: " + loadedRecord.getMember().getFullName());
        }

    }
}
