package dataaccess;

import java.io.*;
import java.util.List;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileStorageUtil {

    // Enum for StorageType
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

    // For Windows users
    // public static final String OUTPUT_DIR = System.getProperty("user.dir") +
    // "\\src\\dataaccess\\storage";

    // For Mac/Linux users
    public static final String OUTPUT_DIR = System.getProperty("user.dir") + "/src/dataaccess/storage";

    // Save an object to a file based on StorageType
    public static void saveObject(Object obj, StorageType type) {
        Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
            out.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load an object from a file based on StorageType
    public static Object loadObject(StorageType type) {
        Object obj = null;
        Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
            obj = in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    // Save a list of objects based on StorageType
    public static void saveObjectList(List<?> list, StorageType type) {
        Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
            out.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load a list of objects based on StorageType
    public static List<?> loadObjectList(StorageType type) {
        List<?> list = null;
        Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
            list = (List<?>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
