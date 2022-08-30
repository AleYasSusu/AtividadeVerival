import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
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
  public void testaLugarDisponivel100(String lugar) {
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
    "F50A14"
  })
  public void testaLugarBloqueado100(String lugar) {
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
  public void testaLugarOcupado100(String lugar) {
    barca.verificaLugar(lugar);
    barca.ocupaLugar();

    int rEsp = 1;
    int rObs = barca.verificaLugar(lugar);
    Assertions.assertEquals(rEsp, rObs);
  }

  @Nested
  @TestInstance(Lifecycle.PER_CLASS)
  class BarcaTest200 {
  
    @BeforeAll
    public void populaLugares() {
      for(int i = 1; i < 6; i++) {
        for(int j = 1; j < 21; j++) {
          barca.setFila(i);
          barca.setAssento(j);
          barca.ocupaLugar();
        }
      }
    }

    @ParameterizedTest
    @CsvSource({
      "F46A01",
      "F47A01",
      "F54A11",
      "F52A19",
      "F59A19",
      "F50A14"
    })
    public void testaLugarDisponivel200(String lugar) {
      int rEsp = 3;
      int rObs = barca.verificaLugar(lugar);
      Assertions.assertEquals(rEsp, rObs);
    }

    @ParameterizedTest
    @CsvSource({
      "F02A01",
      "F03A01",
      "F24A11",
      "F32A19",
      "F19A19",
      "F20A14"
    })
    public void testaLugarBloqueado200(String lugar) {
      int rEsp = 2;
      int rObs = barca.verificaLugar(lugar);
      Assertions.assertEquals(rEsp, rObs);
    }

    @ParameterizedTest
    @CsvSource({
      "F42A01",
      "F43A01",
      "F56A11",
      "F42A19",
      "F59A18",
      "F40A14"
    })
    public void testaLugarOcupado200(String lugar) {
      barca.verificaLugar(lugar);
      barca.ocupaLugar();

      int rEsp = 1;
      int rObs = barca.verificaLugar(lugar);
      Assertions.assertEquals(rEsp, rObs);
    }
  }

  @Nested
  @TestInstance(Lifecycle.PER_CLASS)
  class BarcaTest300 {
  
    @BeforeAll
    public void populaLugares() {
      for(int i = 1; i < 6; i++) {
        for(int j = 1; j < 21; j++) {
          barca.setFila(i);
          barca.setAssento(j);
          barca.ocupaLugar();
        }
      }
      for(int i = 40; i < 45; i++) {
        for(int j = 1; j < 21; j++) {
          barca.setFila(i);
          barca.setAssento(j);
          barca.ocupaLugar();
        }
      }
    }

    @ParameterizedTest
    @CsvSource({
      "F06A01",
      "F16A01",
      "F24A11",
      "F32A19",
      "F59A19",
      "F60A14"
    })
    public void testaLugarDisponivel300(String lugar) {
      int rEsp = 3;
      int rObs = barca.verificaLugar(lugar);
      Assertions.assertEquals(rEsp, rObs);
    }

    @ParameterizedTest
    @CsvSource({
      "F42A01",
      "F33A01",
      "F14A11",
      "F02A19",
      "F53A19",
      "F21A14"
    })
    public void testaLugarOcupado300(String lugar) {
      barca.verificaLugar(lugar);
      barca.ocupaLugar();

      int rEsp = 1;
      int rObs = barca.verificaLugar(lugar);
      Assertions.assertEquals(rEsp, rObs);
    }
  }
}