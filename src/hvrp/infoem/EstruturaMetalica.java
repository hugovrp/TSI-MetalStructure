package hvrp.infoem;

import java.util.ArrayList;
import java.util.List;

import hvrp.infoem.mercado.Mercado;

import static mos.io.InputOutput.NEW_LINE;
import static mos.io.InputOutput.SPACE;

/**
 *  Essa classe representa uma estrutura metálica que pode conter uma certa quantidade de peças. 
 *  
 *  @author Hugo Vinícius Rodrigues Pereira
 *
 *  @version 0.1
 */
public class EstruturaMetalica {
	/**
	 *  Lista de peças da estrutura.
	 */
	private List<Peca> pecasList;
	
	/**
	 *  Representam os tipos de peças válidos.
	 */
	private final static int CILINDRO = 1, CUBO = 2, PARALELEPIPEDO = 3;
	
	/**
	 *  Constantes auxiliares para os cálculos realizados.
	 */
	private final static double CEM = 100.0, MIL = 1000.0;
	
	/**
	 *  Construtor default.
	 *  Inicializa um objeto recém-criado para que ele represente uma EstruturaMetalica com uma lista de peças.
	 */
	public EstruturaMetalica() {
		pecasList = new ArrayList<Peca>();
	}
	
	/* Métodos Getters (Métodos de Acesso) */
	
	/**
     *  Obtém a lista de peças da estrutura.
     *
     *  @return a lista de peças da estrutura
     */
	public List<Peca> getPecasList() {
		return pecasList;
	}

	/* Métodos Setters (Métodos Modificadores) */
	
	/**
     *  Define a lista de peças da estrutura.
     *
     *  @param pecasList - a lista de peças da estrutura
     */
	public void setPecasList(List<Peca> pecasList) {
		this.pecasList = pecasList;
	}
	
	/**
	 *  Adiciona uma peça na estrutura metálica.
	 *  
	 *  @param peca - a peça a ser adiciona na estrutura
	 */
	public void adicionarPeca(Peca peca) {
		pecasList.add(peca);
	} // adicionarPeca(Peca peca)
	
	/**
	 *  Obtém uma determinada peça com base no índice fornecido.
	 *  
	 *  @param indice - a peça a ser adiciona na estrutura
	 *  
	 *  @return a peça no indice fornecido
	 */
	public Peca obterPeca(int indice) {
		return pecasList.get(indice);
	} // obterPeca(int indice)
	
	/**
	 *  Obtém o número total de peças na estrutura.
	 *  
	 *  @return o número total de peças na estrutura
	 */
	public int obterTotalPecas() {
		int totalPecas = 0;
		
		for(Peca p : pecasList) {
			totalPecas += p.getQuantidade();
		}
		return totalPecas;
	} // obterTotalPecas()
	
	/**
	 *  Obtém o número total de peças de um determinado tipo de peça fornecido.
	 *  
	 *  @param tipoPeca - tipo da peça, podendo ser Cilindro, Cubo ou Paralelepipedo
	 *  
	 *  @return o número total de peças de um determinado tipo de peça fornecido
	 */
	public int obterTotalPecas(int tipoPeca) {
	    int totalPecas = 0;

	    if (tipoPeca >= CILINDRO && tipoPeca <= PARALELEPIPEDO) {
	        for (Peca p : pecasList) {
	            if (tipoPeca == CILINDRO && p instanceof Cilindro) {
	                totalPecas += p.getQuantidade();
	            }
	            if (tipoPeca == CUBO && p instanceof Cubo) {
	                totalPecas += p.getQuantidade();
	            }
	            if (tipoPeca == PARALELEPIPEDO && p instanceof Paralelepipedo) {
	                totalPecas += p.getQuantidade();
	            }
	        }
	    }
	    return totalPecas; 
	    
	} // obterTotalPecas(int tipoPeca)
	
	/**
	 *  Obtém a área total e as dimensões de cada peça da estrutura.
	 *  
	 *  @return a área total e as dimensões de cada peça da estrutura
	 */
	public String obterAreaTotalEDimensoes() {
		StringBuilder stringBuilder = new StringBuilder();
		List<Peca> listaOrdenada = ordenaLista();
		
		for(Peca p : listaOrdenada) {
			stringBuilder.append(String.format("%10c- %s | %s unidade(s).\n%20cÁrea: %,1.2f %s\n", SPACE, p.getNome(), p.getQuantidade(), SPACE, p.area(), Peca.getUnidadeArea()));
		
			for (Dimensao dimensao : p.obterDimensoes()) {
				stringBuilder.append(String.format("%20c%s: %,1.2f %s\n", SPACE, dimensao.getNome(), dimensao.getValor(), Peca.getUnidade()));
			}
			stringBuilder.append(NEW_LINE);
		}
		
		return stringBuilder.toString();
	} // obterAreaEDimensoes()
	
	/**
	 *  Calcula o peso total da estrutura. 
	 *  O valor retornado corresponderá ao peso total da estrutura, convertido para quilogramas (Kg).
	 *  
	 *  @return o peso total da estrutura
	 */
	public double calcularPesoTotal() {
		double somaPesoTotal = 0;
		
		for(Peca p : pecasList) {
			double densidade = 0;
			if(p.getMaterial().getNome().equalsIgnoreCase(Peca.Material.ALUMINIO.getNome())) { 
				densidade = p.getPesoAluminio();
			}
			else if(p.getMaterial().getNome().equalsIgnoreCase(Peca.Material.FERRO.getNome())) {
				densidade = p.getPesoFerro();
			}
			
			double volumeTotal = p.getQuantidade() * p.volume();
	        somaPesoTotal += converterParaKG(densidade, volumeTotal);
		}
		
		return somaPesoTotal;
	} // calcularPesoTotal()
	
	/**
	 *  Calcula o volume total da estrutura. 
	 *  O valor retornado corresponderá ao volume total da estrutura, convertido para metros cúbicos (m³).
	 *  
	 *  @return o volume total da estrutura
	 */
	public double calcularVolumeTotal() {
		double somaVolumeTotal = 0;
		
		for(Peca p : pecasList) {
			somaVolumeTotal += p.getQuantidade() * p.volume();
		}
		 return Math.round(somaVolumeTotal * CEM) / CEM;
	} // calcularVolumeTotal() 
	
	/**
	 *  Calcula o volume total de um determinado tipo de peça da estrutura. 
	 *  O valor retornado corresponderá ao volume total de um determinado tipo de peça da estrutura, convertido para metros cúbicos (m³).
	 *  
	 *  @param tipoPeca - tipo da peça, podendo ser Cilindro, Cubo ou Paralelepipedo
	 *  
	 *  @return o volume total de um determinado tipo de peça da estrutura
	 */
	public double calcularVolumeTotal(int tipoPeca) {
		double somaVolumeTotal = 0;
		
		if (tipoPeca >= CILINDRO && tipoPeca <= PARALELEPIPEDO) {
	        for (Peca p : pecasList) {
	            if (tipoPeca == CILINDRO && p instanceof Cilindro) {
	                somaVolumeTotal += p.getQuantidade() * p.volume();
	            }
	            if (tipoPeca == CUBO && p instanceof Cubo) {
	            	somaVolumeTotal += p.getQuantidade() * p.volume();
	            }
	            if (tipoPeca == PARALELEPIPEDO && p instanceof Paralelepipedo) {
	            	somaVolumeTotal += p.getQuantidade() * p.volume();
	            }
	        }
	    }

		 return Math.round(somaVolumeTotal * CEM) / CEM;
	} // calcularVolumeTotal(int tipoPeca) 
	
	/**
	 *  Calcula o consumo de tinta total da estrutura. 
	 *  O valor retornado corresponderá ao consumo de tinta total da estrutura, convertido para litros (L).
	 *  
	 *  @return o consumo de tinta total da estrutura
	 */
	public int[] calcularConsumoTinta() {
		double somaConsumoTotal = 0;
		int[] latasDeTinta = {0,0,0};
		
		for(Peca p : pecasList) {
			double consumo = 0;
			if(p.getMaterial().getNome().equalsIgnoreCase(Peca.Material.ALUMINIO.getNome())) {
				consumo = p.getConsumoAluminio();
			}
			else if (p.getMaterial().getNome().equalsIgnoreCase(Peca.Material.FERRO.getNome())) {
				consumo = p.getConsumoFerro();
			}
			
			double areaTotal = p.getQuantidade() * p.area();
			somaConsumoTotal += consumo * areaTotal;
		}
	
		somaConsumoTotal = converterParaLitros(somaConsumoTotal);
	    latasDeTinta = Mercado.calculaLatasDeTinta(somaConsumoTotal);
	    
	    return latasDeTinta;
	} // calcularConsumoTinta()
	
	/**
	 *  Função auxiliar que ordena a lista de peças em ordem alfabética. 
	 *  
	 *  @return a lista de peças em ordem alfabética
	 */
	private List<Peca> ordenaLista() {
		List<Peca> lista = new ArrayList<>(pecasList);
		lista.sort((p1, p2) -> p1.getNome().compareToIgnoreCase(p2.getNome()));
		
		return lista;
	} // ordenaLista()
	
	/**
	 *  Função auxiliar para converter o peso total da estrutura para quilogramas (Kg). 
	 * 
	 *  @param densidade - densidade total da estrutura
	 *  @param volume - volume total da estrutura
	 * 
	 *  @return o peso total da estrutura convertido em quilogramas (Kg)
	 */
	private double converterParaKG(double densidade, double volume) {
	    double resultado = (densidade * volume) / MIL;
	    return Math.round(resultado * CEM) / CEM;
	} // converterParaKG(double densidade, double volume)
	
	/**
	 *  Função auxiliar para converter o consumo total de tinta estrutura para litros (L). 
	 * 
	 *  @param consumo - consumo total de tinta estrutura
	 * 
	 *  @return o consumo total de tinta estrutura convertido em litros (L)
	 */
	private double converterParaLitros(double consumo) {		
	    return Math.round(consumo * CEM) / CEM;
	} // converterParaLitros(double consumo)
	
	/**
     *  Retorna uma representação textual das informações da estrutura metálica:<br>
     *  <strong>- Lista de peça utilizadas na estrutura:</strong><br><br>
     *  <strong>'DD'</strong><br><br>
     *  
     *  Onde 'DD' representa as informações de uma determinada peça da estrutura (chama explicitamente o toString da classe Peca).
     *  
     *  @return uma string representando uma peça
     */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("- Lista de peças utilizadas na estrutura:\n");
		List<Peca> listaOrdenada = ordenaLista();
		
		for(Peca p : listaOrdenada) {
			stringBuilder.append(p.toString() + NEW_LINE);
		}
		
		return stringBuilder.toString();
	}
} // class EstruturaMetalica