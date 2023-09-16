import util.Data;

public class TestResult {
    public static void main(String[] args) {
        Data data = Data.getInstance();
        System.out.println("Bubble Sort: " + data.resultadosBubble);
        System.out.println("Merge Sort: " + data.resultadosMerge);
        System.out.println("Quick Sort: " + data.resultadosQuick);
        System.out.println("Quick Sort (sorted before): " + data.resultadosQuickSorted);
    }
}
