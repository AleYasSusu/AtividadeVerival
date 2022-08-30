import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

class RankingTest {
	Ranking rank = new Ranking();
	Record r1;
	Record r2;
	Record r3;
	Record r4;
	Record r5;
	Record r6;
	Record r7;
	Record r8;
	Record r9;
	Record r10;
	Record r11;
	Record r12;

	@BeforeEach
	void iniciaVariavel() {
		rank = new Ranking();
		r1 = new Record("a", 1);
		r2 = new Record("b", 2);
		r3 = new Record("c", 3);
		r4 = new Record("d", 4);
		r5 = new Record("e", 5);
		r6 = new Record("f", 6);
		r7 = new Record("g", 7);
		r8 = new Record("h", 8);
		r9 = new Record("i", 9);
		r10 = new Record("j", 10);
		r11 = new Record("k", 11);
		r12 = new Record("l", 0);
	}

//----------------------------------------------------------------------------------------
//Testes metodo boolean add()
	@Test
	void testaAdicionarListaVazia() {

		rank.add(r1);
		assertEquals(1, rank.getRank().size());
	}

	@Test
	void testaAdicionarRankComScoreMaiorEmListaCheia() {

		rank.add(r1);
		rank.add(r2);
		rank.add(r3);
		rank.add(r4);
		rank.add(r5);
		rank.add(r6);
		rank.add(r7);
		rank.add(r8);
		rank.add(r9);
		rank.add(r10);
		rank.add(r11);

		assertEquals(11, rank.getRank().get(9).getScore());
	}

	@Test
	void testaAdicionarRankComScoreMenorEmListaCheia() {

		rank.add(r1);
		rank.add(r2);
		rank.add(r3);
		rank.add(r4);
		rank.add(r5);
		rank.add(r6);
		rank.add(r7);
		rank.add(r8);
		rank.add(r9);
		rank.add(r10);
		assertFalse(rank.add(r12));

	}

//----------------------------------------------------------------------------
	// Testes m�todo numRecords()
	@Test
	void testaNumeroDeRecordsComObjetosCadastrados() {

		rank.add(r1);
		rank.add(r2);
		rank.add(r3);
		rank.add(r4);

		assertEquals(4, rank.numRecords());
	}

	@Test
	void testaNumeroDeRecordsSemObjetosCadastrados() {

		assertEquals(0, rank.numRecords());
	}

//--------------------------------------------------------------------------

//Testes metodo getScore(int i)

	@Test
	void testaRetornarOParticipanteComOScorePassadoPorParametro() {

		rank.add(r1);
		rank.add(r2);
		rank.add(r3);
		rank.add(r4);

		assertEquals(r3, rank.getScore(3));
	}

	@Test
	void buscaScoreNaoCadastrado() {

		rank.add(r1);
		rank.add(r2);
		rank.add(r3);
		rank.add(r4);

		assertNull(rank.getScore(5));
	}

	@Test
	void buscaScoreAcimaDeDezEMenorQueUm() {

		rank.add(r1);
		rank.add(r2);
		rank.add(r3);
		rank.add(r4);

		assertNull(rank.getScore(11));
		assertNull(rank.getScore(0));
	}

// ----------------------------------------------------------------------------
//Testes metodo worstScore()

	@Test
	void buscaWorstScore() {

		rank.add(r1);
		rank.add(r2);
		rank.add(r3);
		rank.add(r4);

		assertEquals(rank.getRank().get(3), rank.worstScore());
	}

	@Test
	void buscarWorstScoreSemExistirNenhumCadastro() {

		assertNull(rank.worstScore());
	}

//----------------------------------------------------------------------------
//Testes metodo bestScore()

	@Test
	void buscaMaiorScore() {

		rank.add(r1);
		rank.add(r2);
		rank.add(r3);
		rank.add(r4);

		assertEquals(rank.getRank().get(0), rank.bestScore());
	}

	@Test
	void buscaBestScoreSemNenhumCadastro() {

		assertNull(rank.bestScore());
	}
}