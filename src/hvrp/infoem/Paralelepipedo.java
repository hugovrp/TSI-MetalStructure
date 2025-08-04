package hvrp.infoem;

/**
 *  Esta classe representa o Paralelepipedo, um tipo válido de peça que pode ser adicionado à estrutura metálica.
 *  
 *  @author Hugo Vinícius Rodrigues Pereira
 *
 *  @version 0.1
 */
public final class Paralelepipedo extends Peca {
	/**
	 * Dimensões do Paralelepipedo.
	 */
	public double altura, largura, profundidade;

	/**
     *  Representa o nome do Paralelepipedo.
     */
	public final static String PARALELEPIPEDO = "Paralelepipedo";
	
	/**
	 *  Construtor default.
	 *  Inicializa um objeto recém-criado para que ele represente um Paralelepipedo sem suas informações.
	 */
	public Paralelepipedo() {
		super(PARALELEPIPEDO);
	}

	/**
	 * 	Inicializa um objeto recém-criado para que ele represente um Paralelepipedo, com suas informações: número de unidades, o material do paralelepipedo e 
	 *  suas dimensões (altura, largura e profundidade). Chama o construtor da sua superclasse (Peca) para definir o nome da peça, a quantidade e o material utilizado.
	 * 
	 *  @param quantidade - número de unidades
	 *  @param material - material do paralelepipedo
	 *  @param altura - altura do paralelepipedo
	 *  @param largura - largura do paralelepipedo
	 *  @param profundidade - profundidade do paralelepipedo
	 */
	public Paralelepipedo(int quantidade, Material material, double altura, double largura, double profundidade) {
		super(PARALELEPIPEDO, quantidade, material);
		this.altura = altura;
		this.largura = largura;
		this.profundidade = profundidade;
	}
	
	/* Métodos Getters (Métodos de Acesso) */
	
	/**
     *  Obtém a altura do paralelepipedo.
     *
     *  @return a altura do paralelepipedo
     */
	public double getAltura() {
		return altura;
	}

	/**
     *  Obtém a largura do paralelepipedo.
     *
     *  @return a largura do paralelepipedo
     */
	public double getLargura() {
		return largura;
	}

	/**
     *  Obtém a profundidade do paralelepipedo.
     *
     *  @return a profundidade do paralelepipedo
     */
	public double getProfundidade() {
		return profundidade;
	}

	/* Métodos Setters (Métodos Modificadores) */
	
	/**
     *  Define a altura do paralelepipedo.
     *
     *  @param altura - a nova altura do paralelepipedo
     */
	public Paralelepipedo setAltura(double altura) {
		this.altura = altura;
		return this;
	}

	/**
     *  Define a largura do paralelepipedo.
     *
     *  @param largura - a nova altura do paralelepipedo
     */
	public Paralelepipedo setLargura(double largura) {
		this.largura = largura;
		return this;
	}

	/**
     *  Define a profundidade do paralelepipedo.
     *
     *  @param profundidade - a nova altura do paralelepipedo
     */
	public Paralelepipedo setProfundidade(double profundidade) {
		this.profundidade = profundidade;
		return this;
	}

	/**
     *  Retorna uma representação textual das informações do paralelepipedo, junto com o toString de sua superclasse (Peca): <br>
     *  <strong>Altura: 'DD' m Largura: 'DD' m Profundidade: 'DD' m</strong><br><br>
     *  
     *  Onde 'DD' representa os valores das informações do paralelepipedo (Altura, largura e profundidade).
     *
     *  @return uma string representando o paralelepipedo
     */
	@Override
	public String toString() {
		return String.format("\n%s\tAltura: %s %5$s Largura: %s %5$s Profundidade: %s %5$s", super.toString(), altura, largura, profundidade, getUnidade());
	}
	
	/**
	 *  Calcula e retorna a área do paralelepipedo. 
	 * 
	 *  @return a área do paralelepipedo
	 */
	@Override
	public double area() {
		return DOIS * (altura * largura + altura * profundidade + largura * profundidade);
	}

	/**
	 *  Calcula e retorna o volume do paralelepipedo. 
	 * 
	 *  @return o volume do paralelepipedo
	 */
	@Override
	public double volume() {
		return altura * largura * profundidade;
	}
	
	/**
	 *  Método que armazena e retorna as dimensões do paralelepipedo em um vetor de Dimensões.
	 * 
	 *  @return as dimensões do paralelepipedo
	 */
	@Override
	public Dimensao[] obterDimensoes() {
		return new Dimensao[] {new Dimensao("Altura", altura), new Dimensao("Largura", largura), new Dimensao("Profundidade", profundidade)};
	}
} // class Paralelepipedo