package util;

import java.io.*;

public class Util {
    private static final String path = "./data/";

    private Util() {
    }

    public static boolean serialize(Object object) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path + object.getClass().getSimpleName() + ".ser")) {
            ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
            output.writeObject(object);
            output.close();
        }
        return true;
    }

    public static <T> T unSerialize(T object) throws IOException, ClassNotFoundException {
        try (FileInputStream fileInputStream = new FileInputStream(path + object.getClass().getSimpleName() + ".ser")) {
            ObjectInputStream output = new ObjectInputStream(fileInputStream);
            object = (T) output.readObject();
            output.close();
        }
        return object;
    }
}
