package dataaccess;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import business.Movie;
import dataaccess.FileStorageUtil.StorageType;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileStorageUtil {

    public enum StorageType {
        ACTOR,
        ADMINISTRATORS,
        AUTHOR,
        CHECKOUTENTRY,
        CHECKOUTRECORD,
        DIRECTOR,
        MEMBERS,
        MOVIES,
    }

    public static final String OUTPUT_DIR = System.getProperty("user.dir") + "/src/dataaccess/storage";

    public static <T> void saveMap(HashMap<String, T> map, StorageType type) {
        Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
            out.writeObject(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> HashMap<String, T> loadMap(StorageType type) {
        HashMap<String, T> map = new HashMap<>();
        Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
        if (Files.exists(path)) {
            try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
                map = (HashMap<String, T>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public static <T> void saveObject(String key, T obj, StorageType type) {
        HashMap<String, T> map = loadMap(type);
        map.put(key, obj);
        saveMap(map, type);
    }

    public static <T> T getObject(String key, StorageType type) {
        HashMap<String, T> map = loadMap(type);
        return map.get(key);
    }

    public static <T> void deleteObject(String key, StorageType type) {
        HashMap<String, T> map = loadMap(type);
        map.remove(key);
        saveMap(map, type);
    }

    public static <T> boolean exists(String key, StorageType type) {
        HashMap<String, T> map = loadMap(type);
        return map.containsKey(key);
    }

    public static <T> List<T> listAllObjects(StorageType type) {
        HashMap<String, T> map = loadMap(type);
        return new ArrayList<>(map.values());
    }

    // New method to search movies by title
    public static List<Movie> searchMovieByTitle(String title) {
        HashMap<String, Movie> movieMap = loadMap(StorageType.MOVIES);
        List<Movie> matchingMovies = new ArrayList<>();

        for (Movie movie : movieMap.values()) {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) { // Case-insensitive match
                matchingMovies.add(movie);
            }
        }
        return matchingMovies;
    }
}
