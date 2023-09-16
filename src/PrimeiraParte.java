import sort.BubbleSort;
import sort.MergeSort;
import util.Data;
import util.SortUtil;

import java.util.List;

public class PrimeiraParte {
    private static final int TEST_RANGE = 50;

    public static void main(String[] args) {
        Data data = Data.getInstance();
        List<Integer> tamanhos = List.of(62_500, 125_000, 250_000, 375_000);

        tamanhos.forEach(vector -> SortUtil.executar(vector,
                BubbleSort.INSTANCE,
                PrimeiraParte.TEST_RANGE,
                data.resultadosBubble));

        tamanhos.forEach(vector -> SortUtil.executar(vector,
                MergeSort.INSTANCE,
                PrimeiraParte.TEST_RANGE,
                data.resultadosMerge));

        data.save();
    }
}