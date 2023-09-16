import sort.BubbleSort;
import sort.QuickSort;
import util.Data;
import util.SortUtil;

import java.util.List;
import java.util.stream.Stream;

public class SegundaParte {
    private static final int TEST_RANGE = 10;

    public static void main(String[] args) {
        Data data = Data.getInstance();
        List<Integer> tamanhos = List.of(10_000);

        tamanhos.forEach(size -> SortUtil.executar(
                SortUtil.loadData(size, TEST_RANGE),
                BubbleSort.INSTANCE,
                data.resultadosBubble));
    }
}
