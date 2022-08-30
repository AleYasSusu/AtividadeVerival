import java.util.ArrayList;

public class Ranking {
	private ArrayList<Record> ranqueamento;

	public ArrayList<Record> getRank() {
		return this.ranqueamento;
	}

	public Ranking() {
		this.ranqueamento = new ArrayList<Record>();
	}

	// Insere novo registro na lista mantendo a ordena��o // Retorna true se a
	// inser��o foi poss�vel
	public boolean add(Record record) {
		int ultimo = ranqueamento.size() - 1;
		if (ranqueamento.size() < 10) {
			ranqueamento.add(record);
			ordenaRanking();
			return true;
		} else if (record.getScore() <= ranqueamento.get(ultimo).getScore()) {
			return false;
		}
		ranqueamento.remove(ultimo);
		return ranqueamento.add(record);
	}

	public void ordenaRanking() {
		Record aux = null;
		for (int i = 1; i < ranqueamento.size(); i++) {
			int j = (i - 1);
			if (ranqueamento.get(i).getScore() < ranqueamento.get(j).getScore()) {
				aux = ranqueamento.get(i);
				ranqueamento.set(i, ranqueamento.get(j));
				ranqueamento.set(j, aux);
			}
		}
	}

	// Retorna � quantidade de registros armazenados
	public int numRecords() {
		return ranqueamento.size();
	}

	// Retorna o i-�simo registro armazenado ou // null se o valor de i for inv�lido
	public Record getScore(int i) {
		int b = i;
		if (b > 10 || b < 1 || b >= ranqueamento.size()) {
			return null;
		}
		return this.ranqueamento.get(i - 1);
	}

	// Retorna o pior score armazenado // Retorna null se a lista estiver vazia
	public Record worstScore() {
		Record r;
		if (ranqueamento.size() == 0) {
			return null;}
		int n = this.ranqueamento.size() - 1;
		r = this.ranqueamento.get(n);
		return r;
	}

	// Retorna o melhor score armazenado // Retorna null se a lista estiver vazia
	public Record bestScore() {
		if (this.ranqueamento.size() > 0) {
			return this.ranqueamento.get(0);
		}
		return null;
	}
}
