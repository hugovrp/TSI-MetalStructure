package hvrp.infoem;

/**
 *  Esta classe representa o Cubo, um tipo válido de peça que pode ser adicionado à estrutura metálica.
 *  
 *  @author Hugo Vinícius Rodrigues Pereira
 *
 *  @version 0.1
 */
public final class Cubo extends Peca {
	/**
	 * Dimensões do Cubo.
	 */
	public double aresta;

	/**
     *  Representa o nome do Cubo.
     */
	public final static String CUBO = "Cubo";
	
	/**
	 *  Construtor default.
	 *  Inicializa um objeto recém-criado para que ele represente um Cubo sem suas informações.
	 */
	public Cubo() {
		super(CUBO);
	}
	
	/**
	 *  Inicializa um objeto recém-criado para que ele represente um Cubo, com suas informações: número de unidades, o material do cubo e 
	 *  suas dimensões (aresta). Chama o construtor da sua superclasse (Peca) para definir o nome da peça, a quantidade e o material utilizado.
	 *  
	 *  @param quantidade - número de unidades
	 *  @param material - material do cubo
	 *  @param aresta - aresta do cubo
	 */
	public Cubo(int quantidade, Material material, double aresta) {
		super(CUBO, quantidade, material);
		this.aresta = aresta;
	}
	
	/* Métodos Getters (Métodos de Acesso) */
	
	/**
     *  Obtém a aresta do cubo.
     *
     *  @return a aresta do cubo
     */
	public double getAresta() {
		return aresta;
	}

	/* Métodos Setters (Métodos Modificadores) */
	
	/**
     *  Define a aresta do cubo.
     *
     *  @param aresta - a nova aresta do cubo
     */
	public Cubo setAresta(double aresta) {
		this.aresta = aresta;
		return this;
	}

	/**
     *  Retorna uma representação textual das informações do cubo, junto com o toString de sua superclasse (Peca): <br>
     *  <strong>Aresta: 'DD' m</strong><br><br>
     *  
     *  Onde 'DD' representa o valor das informações do cubo (Aresta).
     *
     *  @return uma string representando o cubo
     */
	@Override
	public String toString() {
		return String.format("\n%s\tAresta: %s %s", super.toString(), aresta, getUnidade());
	}
	
	/**
	 *  Calcula e retorna a área do cubo. 
	 * 
	 *  @return a área do cubo
	 */
	@Override
	public double area() {
		return SEIS * (aresta * aresta);
	}
	
	/**
	 *  Calcula e retorna o volume do cubo. 
	 * 
	 *  @return o volume do cubo
	 */
	@Override
	public double volume() {
		return aresta * aresta * aresta;
	}
	
	/**
	 *  Método que armazena e retorna as dimensões do cubo em um vetor de Dimensões.
	 * 
	 *  @return as dimensões do cubo
	 */
	@Override
	public Dimensao[] obterDimensoes() {
		return new Dimensao[] {new Dimensao("Aresta", aresta)};
	}
} // class Cubo