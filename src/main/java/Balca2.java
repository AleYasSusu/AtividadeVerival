import java.util.ArrayList;

public class Balca2 {
    int[][] tab = new int[60][20];

    public int getAssento(String lugar) {
        return Integer.parseInt(lugar.substring(4,5));
    }

    public int getFila(String lugar) {
        return Integer.parseInt(lugar.substring(1,2));
    }
}
