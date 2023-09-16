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

        tamanhos.forEach(size -> SortUtil.executar(
                SortUtil.loadData(size, TEST_RANGE),
                BubbleSort.INSTANCE,
                data.resultadosBubble));

        tamanhos.forEach(size -> SortUtil.executar(
                SortUtil.loadData(size, TEST_RANGE),
                MergeSort.INSTANCE,
                data.resultadosMerge));

        data.save();
    }
}