package hvrp.infoem;

/**
 *  Esta classe representa o Cilindro, um tipo válido de peça que pode ser adicionado à estrutura metálica.
 *  
 *  @author Hugo Vinícius Rodrigues Pereira
 *
 *  @version 0.1
 */
public final class Cilindro extends Peca {
	/**
	 * Dimensões do Cilindro.
	 */
	public double raio, altura;
	
	/**
     *  Representa o nome do Cilindro.
     */
	public final static String CILINDRO = "Cilindro";
	
	/**
	 *  Construtor default.
	 *  Inicializa um objeto recém-criado para que ele represente um Cilindro sem suas informações.
	 */
	public Cilindro() {
		super(CILINDRO);
	}
	
	/**
	 *  Inicializa um objeto recém-criado para que ele represente um Cilindro, com suas informações: número de unidades, o material do cilindro e 
	 *  suas dimensões (raio, altura). Chama o construtor da sua superclasse (Peca) para definir o nome da peça, a quantidade e o material utilizado.
	 *  
	 *  @param quantidade - número de unidades
	 *  @param material - material do cilindro
	 *  @param raio - raio do cilindro
	 *  @param altura - alutra do cilindro
	 */
	public Cilindro(int quantidade, Material material, double raio, double altura) {
		super(CILINDRO, quantidade, material);
		this.raio = raio;
		this.altura = altura;
	}
	
	/* Métodos Getters (Métodos de Acesso) */
	
	/**
     *  Obtém o raio do cilindro.
     *
     *  @return o raio do cilindro
     */
	public double getRaio() {
		return raio;
	}

	/**
     *  Obtém a altura do cilindro.
     *
     *  @return a altura do cilindro
     */
	public double getAltura() {
		return altura;
	}

	/* Métodos Setters (Métodos Modificadores) */
	
	/**
     *  Define o raio do cilindro.
     *
     *  @param raio - o novo raio do cilindro
     */
	public Cilindro setRaio(double raio) {
		this.raio = raio;
		return this;
	}

	/**
     *  Define a altura do cilindro.
     *
     *  @param altura - a nova altura do cilindro
     */
	public Cilindro setAltura(double altura) {
		this.altura = altura;
		return this;
	}

	/**
     *  Retorna uma representação textual das informações do cilindro, junto com o toString de sua superclasse (Peca): <br>
     *  <strong>Raio: 'DD' m Altura: 'DD' m</strong><br><br>
     *  
     *  Onde 'DD' representa o valor das informações do cilindro (Raio e altura).
     *
     *  @return uma string representando o cilindro
     */
	@Override
	public String toString() {
		return String.format("\n%s\tRaio: %s %4$s Altura: %s %4$s", super.toString(), raio, altura, getUnidade());
	}

	/**
	 *  Calcula e retorna a área do cilindro. 
	 * 
	 *  @return a área do cilindro
	 */
	@Override
	public double area() {
		return DOIS * Math.PI * raio * (raio + altura);
	}
	
	/**
	 *  Calcula e retorna o volume do cilindro. 
	 * 
	 *  @return o volume do cilindro
	 */
	@Override
	public double volume() {
		return Math.PI * (raio * raio) * altura;
	}

	/**
	 *  Método que armazena e retorna as dimensões do cilindro em um vetor de Dimensões.
	 * 
	 *  @return as dimensões do cilindro
	 */
	@Override
	public Dimensao[] obterDimensoes() {
		return new Dimensao[] {new Dimensao("Raio", raio), new Dimensao("Altura", altura)};
	}
} // class Cilindro