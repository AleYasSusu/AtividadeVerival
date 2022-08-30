import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BarcaTest {
  private Barca barca = new Barca();

  @ParameterizedTest
  @CsvSource({
    "F62A01",
    "F32A21",
    "F2A21",
    "F02A1",
    "Z02A19",
    "F03X19"
  })
  public void testaLugarInvalido(String lugar) {
      int rEsp = 0;
      int rObs = barca.verificaLugar(lugar);
      Assertions.assertEquals(rEsp, rObs);
  }

  @ParameterizedTest
  @CsvSource({
    "F02A01",
    "F03A01",
    "F04A11",
    "F02A19",
    "F19A19",
    "F20A14"
  })
  public void testaLugarDisponivelPrimeiros(String lugar) {
    int rEsp = 3;
    int rObs = barca.verificaLugar(lugar);
    Assertions.assertEquals(rEsp, rObs);
  }

  @ParameterizedTest
  @CsvSource({
    "F42A01",
    "F23A01",
    "F54A11",
    "F22A19",
    "F39A19",
    "F40A14"
  })
  public void testaLugarBloqueadoPrimeiros(String lugar) {
    int rEsp = 2;
    int rObs = barca.verificaLugar(lugar);
    Assertions.assertEquals(rEsp, rObs);
  }

  @ParameterizedTest
  @CsvSource({
    "F02A01",
    "F03A01",
    "F04A11",
    "F02A19",
    "F19A19",
    "F20A14"
  })
  public void testaOcupaLugar(String lugar) {
    boolean rEsp = true;
    boolean rObs = barca.ocupaLugar();
    Assertions.assertEquals(rEsp, rObs);
  }

  @ParameterizedTest
  @CsvSource({
    "F02A01",
    "F03A01",
    "F04A11",
    "F02A19",
    "F19A19",
    "F20A14"
  })
  public void testaLugarOcupadoPrimeiros(String lugar) {
    barca.verificaLugar(lugar);
    barca.ocupaLugar();

    int rEsp = 1;
    int rObs = barca.verificaLugar(lugar);
    Assertions.assertEquals(rEsp, rObs);
  }

  // @Nested
  // class BarcaTestSegundos {

  // }
}