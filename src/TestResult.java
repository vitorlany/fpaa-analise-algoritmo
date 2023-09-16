import util.Data;

public class TestResult {
    public static void main(String[] args) {
        Data data = Data.getInstance();
        System.out.println(data.vectors);
        System.out.println(data.resultadosBubble);
        System.out.println(data.resultadosQuick);
    }
}
