package util;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Data implements Serializable {
    private static Data INSTANCE;

    public HashMap<Integer, List<int[]>> vectors = new HashMap<>();
    public HashMap<Integer, Long> resultadosBubble = new HashMap<>();
    public HashMap<Integer, Long> resultadosMerge = new HashMap<>();
    public HashMap<Integer, Long> resultadosQuick = new HashMap<>();

    private Data() {
    }

    public static Data getInstance() {
        if (INSTANCE == null) {
            Data data = new Data();
            try {
                data = Util.unSerialize(data);
            } catch (Exception e) {
                data.save();
            }
            INSTANCE = data;
            return data;
        }

        return INSTANCE;
    }

    public void save() {
        try {
            Util.serialize(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
