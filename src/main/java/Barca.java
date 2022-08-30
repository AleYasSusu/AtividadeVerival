public class Barca {
  static final int LUGAR_INVALIDO = 0;
  static final int LUGAR_OCUPADO = 1;
  static final int LUGAR_BLOQUEADO = 2;   
  static final int LUGAR_LIVRE = 3; 

  public int[][] lugares = new int[61][21];
  private int contador = 0;
  private int fila;
  private int assento;

  public void setFila(int f) {
    fila = f;
  }

  public void setAssento(int a) {
    assento = a;
  }

  private int getFila(String lugar) {
    String str = lugar.substring(1, 3);
    return str.matches("[0-9]{2}") ? Integer.parseInt(str) : 0;
  }

  private int getAssento(String lugar) {
    String str = lugar.substring(4);
    return str.matches("[0-9]{2}") ? Integer.parseInt(str) : 0;
  }

  private boolean isLugarValido(String lugar) {
    if (lugar.length() != 6) {
      return false;
    }

    if (lugar.charAt(0) != 'F' || lugar.charAt(3) != 'A') {
      return false;
    }

    setFila(getFila(lugar));
    setAssento(getAssento(lugar));
    return fila >= 1 && fila <= 60 && assento >= 1 && assento <= 20;
  }

  private boolean isLugarLivre(int fila, int assento) {
    return lugares[fila][assento] != 1;
  }

  public int verificaLugar(String lugar) {
    if(!isLugarValido(lugar)) {
      return LUGAR_INVALIDO;
    }

    if (contador < 100) {
      if (fila <= 20) {
        return isLugarLivre(fila, assento) ? LUGAR_LIVRE : LUGAR_OCUPADO; 
      } 
      return LUGAR_BLOQUEADO;
    } else if (contador < 200) {
      if (fila >= 40 && fila <= 60) {
        return isLugarLivre(fila, assento) ? LUGAR_LIVRE : LUGAR_OCUPADO; 
      }
      return LUGAR_BLOQUEADO;
    } else {
      return isLugarLivre(fila, assento) ? LUGAR_LIVRE : LUGAR_OCUPADO; 
    }
  }

  public boolean ocupaLugar() {
    try {
      lugares[fila][assento] = 1;
      contador++;
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public void liberaLugar(String lugar) {
    lugares[fila][assento] = 0;
    contador--;
  }
}