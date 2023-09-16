import sort.MergeSort;
import sort.QuickSort;
import util.Data;
import util.SortUtil;

import java.util.List;
import java.util.stream.Stream;

public class SegundaParte {
    private static final int TEST_RANGE = 10;

    public static void main(String[] args) {
        Data data = Data.getInstance();
        int size = 10_000;
        List<int[]> list = SortUtil.loadData(size, TEST_RANGE);

        SortUtil.executar(
                SortUtil.loadData(size, TEST_RANGE),
                QuickSort.INSTANCE,
                data.resultadosQuick);

        SortUtil.executar(
                SortUtil.loadData(size, TEST_RANGE),
                QuickSort.INSTANCE,
                data.resultadosQuickSorted);

        data.save();
    }
}
