package util;

import sort.Sorter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class SortUtil {

    private static List<int[]> fillVectorList(int size, int vectorsQuantity) {
        List<int[]> vector = new ArrayList<>();
        IntStream.range(0, vectorsQuantity).forEach(index -> {
            int[] ints = new int[size];
            fillVectorWithRandomInts(ints);
            vector.add(ints);
        });
        return vector;
    }

    private static void fillVectorWithRandomInts(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = ThreadLocalRandom.current().nextInt();
        }
    }

    public static List<int[]> loadData(int size, int vectorsQuantity) {
        Data data = Data.getInstance();
        List<int[]> list = data.vectors.get(size);
        if (list == null) {
            List<int[]> vectorList = fillVectorList(size, vectorsQuantity);
            data.vectors.put(size, vectorList);
            data.save();
            list = vectorList;
        }
        return list;
    }

    public static List<int[]> executar(List<int[]> vectorList, Sorter sorter, HashMap<Integer, Long> resultados) {
        int testRange = vectorList.size();
        int size = vectorList.get(0).length;
        List<Long> times = new ArrayList<>();

        System.out.println("========= " + size + " =========");

        vectorList.forEach(vector -> {
            long inicio = System.currentTimeMillis();
            System.out.println(vectorList.indexOf(vector)+1+"/"+testRange);
            sorter.sort(vector);
            long fim = System.currentTimeMillis();
            long tempoExecucao = fim - inicio;
            System.out.println("Tempo: " + tempoExecucao + "ms");
            times.add(tempoExecucao);
        });

        long tempoMedioTotal = (long) times.stream().mapToLong(l -> l).average().orElse(0);
        resultados.put(size, tempoMedioTotal);
        System.out.println("Tempo médio total: " + tempoMedioTotal + "ms");
        return vectorList;
    }
}
