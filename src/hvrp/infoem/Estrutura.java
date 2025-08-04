package hvrp.infoem;

/**
 *  Interface a ser implementada por uma classe para que se possa testar a classe EstruturaMetalica.
 *  
 *  @author Hugo Vinícius Rodrigues Pereira
 *
 *  @version 0.1
 */
public interface Estrutura {
	/**
	 *  Representam os tipos de peças válidos.
	 */
	int CILINDRO = 1, CUBO = 2, PARALELEPIPEDO = 3;
	
	/**
	 *  Calcula o peso total da estrutura metálica.
	 *  Retorna o em quilogramas (Kg) correspondente ao peso total da estrutura metálica.
	 */
	double pesoTotal();
	
	/**
	 *  Calcula o volume total da estrutura metálica.
	 *  Retorna o valor em metros cúbicos (m³) correspondente ao volume total da estrutura metálica.
	 */
	double volumeTotal();
	
	/**
	 *  Calcula o número de latas de tinta necesárias para pintar a estrutura metálica.
	 *
	 *  Retorna um vetor de números inteiros com a quantidade de cada lata de tinta.
	 *  A quantidade das latas de tinta de 0,5 litro, 2 litros e 5 litros são armazenadas, respectivamente, nas posições 0, 1 e 2.
	 */
	int[] numeroDeLatasDeTinta();
	
	/**
	 *  Calcula o volume total de todas as peças da estrutura metálica que possuem o mesmo tipo.
	 *  O valores válidos para o tipo da peça são CILINDRO, CUBO ou PARALELEPIPEDO, definidos na interface Estrutura. 
	 *  Retorna o valor em metros cúbicos (m³) correspondente ao volume da peça.
	 *  
	 *  @throws IllegalArgumentException caso seja passado um tipo de peça inválido
	 */
	double volumeTotalPeca(int tipoPeca) throws IllegalArgumentException;	
} // interface Estrutura