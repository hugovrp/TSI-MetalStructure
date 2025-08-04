package hvrp.infoem;

/**
 *  Essa classe representa as dimensões de uma peça. As dimensões são representadas por um nome e um valor.
 *  
 *  @author Hugo Vinícius Rodrigues Pereira
 *
 *  @version 0.1
 */
public class Dimensao {
	private String nome;
	private double valor;
	
	/**
	 *  Construtor default.
	 *  Inicializa um objeto recém-criado para que ele represente uma dimensão vazia.
	 */
	public Dimensao() {
		nome = "";
	}

	/**
	 *  Inicializa um objeto recém-criado para que ele represente uma dimensão utilizando o nome e o valor fornecido.
	 * 
	 *  @param nome - nome da dimensão
	 *  @param valor - valor da dimensão
	 */
	public Dimensao(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	/* Métodos Getters (Métodos de Acesso) */
	
	/**
     *  Obtém o nome da dimensão.
     *
     *  @return o nome da dimensão
     */
	public String getNome() {
		return nome;
	}
	
	/**
     *  Obtém o valor da dimensão.
     *
     *  @return o valor da dimensão
     */
	public double getValor() {
		return valor;
	}

	/* Métodos Setters (Métodos Modificadores) */
	
	/**
     *  Define o nome da dimensão.
     *
     *  @param nome - o novo nome da dimensão
     */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
     *  Define o valor da dimensão.
     *
     *  @param valor - o novo valor da dimensão
     */
	public void setValor(double valor) {
		this.valor = valor;
	}


    /**
     *  Retorna uma representação textual da dimensão no formato:<br>
     *  <strong>'SS': 'DD' m.</strong><br><br>
     *  
     *  Onde 'SS' representa o nome da dimensão e 'DD' representa o valor da dimensão.
     *
     *  @return uma string representando a dimensão
     */
	@Override
	public String toString() {
		return String.format("%s: %,1,2f %s", nome, valor, Peca.getUnidade());
	}
} // class Dimensao