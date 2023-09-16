package util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Data implements Serializable {
    private static Data INSTANCE;

    public HashMap<Integer, List<int[]>> vectors = new HashMap<>();
    public HashMap<Integer, Long> resultados = new HashMap<>();

    private Data() {
    }

    public static Data getInstance() {
        if (INSTANCE == null) {
            Data data = new Data();
            data = Util.unSerialize(data);
            data.save();
            INSTANCE = data;
            return data;
        }

        return INSTANCE;
    }

    public void save() {
        Util.serialize(this);
    }
}
