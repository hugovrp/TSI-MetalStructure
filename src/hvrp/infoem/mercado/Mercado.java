package hvrp.infoem.mercado;

/**
 *  Essa classe representa um "Mercado" de latas de tinta, contendo latas de 5, 2 e 0.5 litros.
 *  
 *  @author Hugo Vinícius Rodrigues Pereira
 *
 *  @version 0.1
 */
public class Mercado {
	/**
     *  Capacidade da lata de tinta grande (5 litros).
     */
    public static final double LATA_5L = 5.0;

    /**
     *  Capacidade da lata de tinta média (2 litros).
     */
    public static final double LATA_2L = 2.0;

    /**
     *  Capacidade da lata de tinta pequena (0,5 litros).
     */
    public static final double LATA_05L = 0.5;
	
    /**
	 *  Construtor default.
	 *  Inicializa um objeto recém-criado para que ele represente o Mercado.
	 */
	public Mercado() {}
    
    /* Métodos Getters (Métodos de Acesso) */
	
	/**
     *  Obtém a lata de 5 litros.
     *
     *  @return a lata de 5 litros
     */
	public static final double getLata5l() {
		return LATA_5L;
	}

	/**
     *  Obtém a lata de 2 litros.
     *
     *  @return a lata de 2 litros
     */
	public static final double getLata2l() {
		return LATA_2L;
	}

	/**
     *  Obtém a lata de 0,5 litros.
     *
     *  @return a lata de 0,5 litros
     */
	public static final double getLata05l() {
		return LATA_05L;
	}

	/**
	 * 	Calcula quantas latas de tinta serão necessárias utilizando o consumo fornecido, em litros, como base.
	 * 
	 * 	@param consumo - o consumo de tinta em litros.
	 * 	@return retorna um vetor de inteiros, com a quantidade de latas de tinta que serão utilizadas. A posição [2] do vetor
	 *          irá conter a quantidade de latas de 5L, a posição [1] irá conter a quantidade de latas de 2L e a posição [0]
	 *          irá conter a quantidade de latas de 0.5L.
	 */
	public static int[] calculaLatasDeTinta(double consumo) {
		int[] latas = {0,0,0};
		
		latas[2] = (int) (consumo / LATA_5L);
		consumo -= latas[2] * LATA_5L;

	    latas[1] = (int) (consumo / LATA_2L);
	    consumo -= latas[1] * LATA_2L;

	    latas[0] = (int) Math.ceil(consumo / LATA_05L); 
	    
		return latas;
	}
}
