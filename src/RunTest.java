import sort.BubbleSort;
import sort.QuickSort;
import sort.Sorter;
import util.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
// https://www.geeksforgeeks.org/sorting-algorithms/
public class RunTest {
    private static final int TEST_RANGE = 1;

    private static List<int[]> fillVectorList(int size) {
        List<int[]> vector = new ArrayList<>();
        IntStream.range(0,TEST_RANGE).forEach(index -> {
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

    private static List<int[]> loadData(int size) {
        Data data = Data.getInstance();
        List<int[]> list = data.vectors.get(size);
        if (list == null) {
            List<int[]> vectorList = fillVectorList(size);
            data.vectors.put(size, vectorList);
            data.save();
            list = vectorList;
        }
        return list;
    }

    public static void main(String[] args) {
        Data data = Data.getInstance();
//        List<Integer> tamanhos = List.of(62_500, 125_000, 250_000, 375_000);
        List<Integer> tamanhos = List.of(1);
        tamanhos.forEach(v -> RunTest.executar(v, BubbleSort.INSTANCE, data.resultadosBubble));
        tamanhos.forEach(v -> RunTest.executar(v, QuickSort.INSTANCE, data.resultadosQuick));
        data.save();
    }

    public static void executar(int size, Sorter sorter, HashMap<Integer, Long> resultados) {
        List<int[]> vectorList = loadData(size);
        List<Long> times = new ArrayList<>();

        System.out.println("========= " + size + " =========");

        vectorList.forEach(vector -> {
            long inicio = System.currentTimeMillis();
            System.out.println(vectorList.indexOf(vector)+1+"/"+TEST_RANGE);
            sorter.sort(vector);
            long fim = System.currentTimeMillis();
            long tempoExecucao = fim - inicio;
            System.out.println("Tempo: " + tempoExecucao + "ms");
            times.add(tempoExecucao);
        });

        long tempoMedioTotal = (long) times.stream().mapToLong(l -> l).average().orElse(0);
        resultados.put(size, tempoMedioTotal);
        System.out.println("Tempo médio total: " + TimeUnit.MILLISECONDS.toSeconds(tempoMedioTotal) + "s");
    }
}