package hvrp.infoem;

import static mos.io.InputOutput.SPACE;

/**
 *  Essa classe representa uma peça da estrutura metálica. 
 *  
 *  @author Hugo Vinícius Rodrigues Pereira
 *
 *  @version 0.1
 */
public abstract sealed class Peca permits Cilindro, Cubo, Paralelepipedo {
	/**
     *  Nome de determinada peça.
     */
	public String nome;
	
	/**
     *  Quantidade de determinada peça.
     */
	protected int quantidade;
	
	/**
     *  Material de determinada peça.
     */
	protected Material material;
	
	/**
	 * Constantes auxiliares para os cálculos realizados.
	 */
	protected final static double DOIS = 2.0;
	protected final static double SEIS = 6.0;
	
	/**
     *  Representa a unidade padrão das dimensões de uma peça.
     */
	private final static String UNIDADE = "m";
	
	/**
     *  Representa a unidade padrão do peso total da estrutura.
     */
	private final static String UNIDADE_PESO_TOTAL = "Kg";
	
	/**
     *  Representa a unidade padrão da área de uma peça.
     */
	private final static String UNIDADE_AREA = UNIDADE + "²";
	
	/**
     *  Representa a unidade padrão do volume de uma peça.
     */
	private final static String UNIDADE_VOLUME = UNIDADE + "³";
	
	/**
     *  Representa a unidade padrão do peso específico dos materiais.
     */
	private final static String UNIDADE_PESO = "g/m³";
	
	/**
     *  Representa a unidade padrão do consumo de tinta dos materiais.
     */
	private final static String UNIDADE_CONSUMO_TINTA = "l/m²";
	
	/**
     *  Representa o peso do alumínio.
     */
	private final static double PESO_ALUMINIO = 2.7;
	
	/**
     *  Representa o consumo de tinta do alumínio.
     */
	private final static double CONSUMO_ALUMINIO = 0.5;
	
	/**
     *  Representa o peso do ferro.
     */
	private final static double PESO_FERRO = 7.8;
	
	/**
     *  Representa o consumo de tinta do ferro.
     */
	private final static double CONSUMO_FERRO = 0.7;
	
	/**
	 *  Construtor default.
	 *  Inicializa um objeto recém-criado para que ele represente uma Peca sem suas informações.
	 */
	public Peca() {
		this("");
	}
	
	/**
	 *  Inicializa um objeto recém-criado para que ele represente uma Peca com nome fornecido.
	 *  
	 *  @param nome - nome da peça
	 */
	public Peca(String nome) {
		this.nome = nome;
	}
	
	/**
	 *  Inicializa um objeto recém-criado para que ele represente uma Peca, com suas informações: número de unidades e o material da peça.
	 *  
	 *  @param nome - nome da peça
	 *  @param quantidade - número de unidades
	 *  @param material - material da peça
	 */
	public Peca(String nome, int quantidade, Material material) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.material = material;
	}
	
	/* Métodos Getters (Métodos de Acesso) */
	
	/**
     *  Obtém o nome de uma determinada peça.
     *
     *  @return o nome de uma determinada peça
     */
	public final String getNome() {
		return nome;
	}

	/**
     *  Obtém a quantidade de uma determinada peça.
     *
     *  @return a quantidade de uma determinada peça
     */
	public final int getQuantidade() {
		return quantidade;
	}

	/**
     *  Obtém o material de uma determinada peça.
     *
     *  @return o material de uma determinada peça
     */
	public final Material getMaterial() {
		return material;
	}

	/**
     *  Obtém o consumo de tinta do alumínio.
     *
     *  @return o consumo de tinta do alumínio
     */
	public final double getConsumoAluminio() {
		return CONSUMO_ALUMINIO;
	}

	/**
     *  Obtém o consumo de tinta do ferro.
     *
     *  @return o consumo de tinta do ferro
     */
	public final double getConsumoFerro() {
		return CONSUMO_FERRO;
	}

	/**
     *  Obtém o peso específico do alumínio.
     *
     *  @return o peso específico do alumínio
     */
	public final double getPesoAluminio() {
		return PESO_ALUMINIO;
	}
	
	/**
     *  Obtém o peso específico do ferro.
     *
     *  @return o peso específico do ferro
     */
	public final double getPesoFerro() {
		return PESO_FERRO;
	}
	
	/**
     *  Obtém a unidade padrão das dimensões de uma peça.
     *
     *  @return a unidade padrão das dimensões de uma peça
     */
	public final static String getUnidade() {
		return UNIDADE;
	}
	
	/**
     *  Obtém a unidade padrão do peso total da estrutura.
     *
     *  @return a unidade padrão do peso total da estrutura
     */
	public final static String getUnidadePesoTotal() {
		return UNIDADE_PESO_TOTAL;
	}
	
	/**
     *  Obtém a unidade padrão da área de uma peça.
     *
     *  @return a unidade padrão da área de uma peça
     */
	public final static String getUnidadeArea() {
		return UNIDADE_AREA;
	} 

	/**
     *  Obtém a unidade padrão do volume de uma peça.
     *
     *  @return a unidade padrão do volume de uma peça
     */
	public final static String getUnidadeVolume() {
		return UNIDADE_VOLUME;
	}

	/**
     *  Obtém a unidade padrão do peso específico dos materiais.
     *
     *  @return a unidade padrão do peso específico dos materiais.
     */
	public final static String getUnidadePeso() {
		return UNIDADE_PESO;
	}

	/**
     *  Obtém a unidade padrão do consumo de tinta dos materiais.
     *
     *  @return a unidade padrão do consumo de tinta dos materiais.
     */
	public final static String getUnidadeConsumoTinta() {
		return UNIDADE_CONSUMO_TINTA;
	}

	/* Métodos Setters (Métodos Modificadores) */
	
	/**
     *  Define o nome da peça.
     *
     *  @param nome - o novo nome da peça
     */
	public final Peca setNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	/**
     *  Define a quantidade de peças.
     *
     *  @param quantidade - a nova quantidade de peças
     */
	public final Peca setQuantidade(int quantidade) {
		this.quantidade = quantidade;
		return this;
	}

	/**
     *  Define o material da peça.
     *
     *  @param material - o novo material da peça
     */
	public final Peca setMaterial(Material material) {
		this.material = material;
		return this;
	}
	
	/**
     *  Retorna uma representação textual das informações de uma peça:<br>
     *  <strong>'SS' | 'DD' Material: 'MM'</strong><br><br>
     *  
     *  Onde 'SS' representa o nome da peça, 'DD' a quantidade de peças cadastradas e 'MM' o material da peça (implicitamente chama o toString da Interface Material).
     *  
     *  @return uma string representando uma peça
     */
	@Override
	public String toString() {
		return String.format("%10c%s | %s unidade(s).\n\tMaterial: %s\n", SPACE, nome, quantidade, material);
	}

	/**
	 *  Calcula e retorna a área de uma peça. 
	 * 
	 *  @return a área da peça
	 */
	public abstract double area();
	
	/**
	 *  Calcula e retorna o volume de uma peça. 
	 * 
	 *  @return o volume da peça
	 */
	public abstract double volume();
	
	/**
	 *  Método que armazena e retorna as dimensões de uma peça em um vetor de Dimensões.
	 * 
	 *  @return as dimensões da peça
	 */
	public abstract Dimensao[] obterDimensoes();
	
	/**
	 *  Interface interna que representa o material de uma peça com seu determinado peso e consumo de tinta.
	 *  
	 *  @author Hugo Vinícius Rodrigues Pereira
	 *
	 *  @version 0.1
	 */
	public static enum Material {
		/**
		 *  Tipos de material válidos.
		 */
		ALUMINIO("Aluminio", PESO_ALUMINIO, CONSUMO_ALUMINIO),
		FERRO("Ferro", PESO_FERRO, CONSUMO_FERRO);
		
		private String nome;
		private double pesoEspecifico, consumoTinta;

		/**
		 *  Inicializa um objeto recém-criado para que ele represente o Material de uma Peca, com suas informações: nome do material, peso específico
		 *  e consumo de tinta.
		 *  
		 *  @param nome - nome do material
		 *  @param pesoEspecifico - peso específico do material
		 *  @param consumoTinta - consumo de tinta do material
		 */  
		private Material(String nome, double pesoEspecifico, double consumoTinta) {
			this.nome = nome;
			this.pesoEspecifico = pesoEspecifico;
			this.consumoTinta = consumoTinta;
		}

		/* Métodos Getters (Métodos de Acesso) */
		
		/**
	     *  Obtém o nome de um determinado material.
	     *
	     *  @return o nome de um determinado material
	     */
		public String getNome() {
			return nome;
		}

		/**
	     *  Obtém o peso específico de um determinado material.
	     *
	     *  @return o peso específico de um determinado material
	     */
		public double getPesoEspecifico() {
			return pesoEspecifico;
		}

		/**
	     *  Obtém o consumo de tinta de um determinado material.
	     *
	     *  @return o consumo de tinta de um determinado material
	     */
		public double getConsumoTinta() {
			return consumoTinta;
		}
		
		/* Métodos Setters (Métodos Modificadores) */
		
		/**
	     *  Define o nome do material.
	     *
	     *  @param nome - o novo nome do material
	     */
		public void setNome(String nome) {
			this.nome = nome;
		}

		/**
	     *  Define o peso específico do material.
	     *
	     *  @param pesoEspecifico - o novo peso específico do material
	     */
		public void setPesoEspecifico(double pesoEspecifico) {
			this.pesoEspecifico = pesoEspecifico;
		}

		/**
	     *  Define o consumo de tinta do material.
	     *
	     *  @param consumoTinta - o novo consumo de tinta do material
	     */
		public void setConsumoTinta(double consumoTinta) {
			this.consumoTinta = consumoTinta;
		}

		/**
	     *  Retorna uma representação textual das informações de um material:<br>
	     *  <strong>'SS' | Peso: 'DD' g/m³ Consumo de Tinta: 'DD' l/m²</strong><br><br>
	     *  
	     *  Onde 'SS' representa o nome do material e 'DD' representa as informações do material (peso específico e consumo de tinta).
	     *  
	     *  @return uma string representando um material
	     */
		@Override
		public String toString() {
			return String.format("%s | Peso: %s %s - Consumo de Tinta: %s %s", nome, pesoEspecifico, getUnidadePeso(), consumoTinta, getUnidadeConsumoTinta());
		}
	} // enum Material
} // class Peca