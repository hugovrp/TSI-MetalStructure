package hvrp.infoem.gui;

import java.io.File;
import java.util.List;
import java.util.Optional;

import hvrp.infoem.Estrutura;
import hvrp.infoem.EstruturaMetalica;
import hvrp.infoem.Paralelepipedo;
import hvrp.infoem.Peca;
import hvrp.infoem.Cubo;
import hvrp.infoem.Cilindro;
import mos.reader.Line;
import mos.reader.Reader;
import static mos.reader.Reader.*;
import static mos.io.InputOutput.*;

/**
 *  Essa classe representa o teste da classe EstruturaMetalica.
 *  
 *  @author Hugo Vinícius Rodrigues Pereira
 *
 *  @version 0.1
 */
public class EM implements Estrutura {
	/**
	 *  Representa uma estrutura metálica.
	 */
	private EstruturaMetalica estruturaMetalica;
	
	/**
	 *  Representa o diretório onde estará o arquivo com as informações da estrutura metálica.
	 */
	private final static String DIRETORIO = "csv";
	
	/**
	 *  Representa o nome do arquivo que será importando, nele está contido as informações da estrutura.
	 */
	private final static String ARQUIVO = "MetalStructure.csv"; 
			
	/**
	 *  Representa o caminho completo do arquivo com as informações da estrutura metálica.
	 */
	private final static String CAMINHO = String.format("%s%c%s", DIRETORIO, File.separatorChar, ARQUIVO);
	
	/**
	 *  Representa uma mensagem que será vista se a exceção IllegalArgumentException for disparada na leitura do tipo de peça da estrutura.
	 */
	private final static String PECA_INVALIDA = "Tipo de peça fornecido é inválido!";
	
	/**
	 *  Representa uma mensagem que será vista se a exceção IllegalArgumentException for disparada na leitura do material da peça da estrutura.
	 */
	private final static String	MATERIAL_INVALIDO = "Material fornecido é inválido!"; 
	
	/**
	 *  Chama o construtor default da classe EM para que o programa seja iniciado. 
	 * 
	 *  @param args
	 */
	public static void main(String[] args) {
		new EM();
	}
	
	/**
	 *  Construtor default.
	 *  Onde será executado os testes de EstruturaMetalica, com um relatório contendo as informações necessárias.
	 */
	public EM() {
		estruturaMetalica = new EstruturaMetalica();
		
		importarPecas();
		relatorioEM();
		//relatorioPecas();
		
		showTextArea(getTextArea(), "Relatório EM (Estrutura Metálica)");
		System.exit(0);
	} 

	/**
	 * 	Realiza a importação das informações de determinadas peças cadastradas no arquivo .csv fornecido. 
	 *  Utiliza métodos das classes (mos.reader.Line e mos.reader.Reader) para percorrer o arquivo .csv fornecido.
	 * 
	 *  @throws IllegalArgumentException caso seja passado um tipo de peça inválido ou um material inválido
	 *  @throws NumberFormatException caso ocorra algum problema nas conversões de string para int ou double (parseInt() e parseDouble())
	 */
	public void importarPecas() throws IllegalArgumentException, NumberFormatException {
		List<Line> lineList = read(CAMINHO, Reader.SEMICOLON);
		
		lineList.removeFirst();
		
		for(Line line : lineList) { 
			Optional<String> optional = line.getData(0);
			Optional<String> material = line.getData(2);
			
			if(optional.isPresent() && material.isPresent()) {
				
				if(optional.get().equalsIgnoreCase(Cubo.CUBO)) {
					if(material.get().equalsIgnoreCase(Peca.Material.ALUMINIO.getNome()))
						estruturaMetalica.adicionarPeca(new Cubo(Integer.parseInt(line.getData(1).get()), Peca.Material.ALUMINIO, Double.parseDouble(line.getData(7).get())));
					
					else if(material.get().equalsIgnoreCase(Peca.Material.FERRO.getNome()))
						estruturaMetalica.adicionarPeca(new Cubo(Integer.parseInt(line.getData(1).get()), Peca.Material.FERRO, Double.parseDouble(line.getData(7).get())));
					
					else 
						throw new IllegalArgumentException(MATERIAL_INVALIDO);
				}
				
				else if(optional.get().equalsIgnoreCase(Cilindro.CILINDRO)) {
					if(material.get().equalsIgnoreCase(Peca.Material.ALUMINIO.getNome()))
						estruturaMetalica.adicionarPeca(new Cilindro(Integer.parseInt(line.getData(1).get()), Peca.Material.ALUMINIO, Double.parseDouble(line.getData(3).get()), Double.parseDouble(line.getData(4).get())));
					
					else if(material.get().equalsIgnoreCase(Peca.Material.FERRO.getNome()))
						estruturaMetalica.adicionarPeca(new Cilindro(Integer.parseInt(line.getData(1).get()), Peca.Material.FERRO, Double.parseDouble(line.getData(3).get()), Double.parseDouble(line.getData(4).get())));
					
					else 
						throw new IllegalArgumentException(MATERIAL_INVALIDO);
				}
				
				else if(optional.get().equalsIgnoreCase(Paralelepipedo.PARALELEPIPEDO)) {
					if(material.get().equalsIgnoreCase(Peca.Material.ALUMINIO.getNome()))
						estruturaMetalica.adicionarPeca(new Paralelepipedo(Integer.parseInt(line.getData(1).get()), Peca.Material.ALUMINIO, Double.parseDouble(line.getData(4).get()), Double.parseDouble(line.getData(5).get()), Double.parseDouble(line.getData(6).get())));
					
					else if(material.get().equalsIgnoreCase(Peca.Material.FERRO.getNome()))
						estruturaMetalica.adicionarPeca(new Paralelepipedo(Integer.parseInt(line.getData(1).get()), Peca.Material.FERRO, Double.parseDouble(line.getData(4).get()), Double.parseDouble(line.getData(5).get()), Double.parseDouble(line.getData(6).get())));
					
					else 
						throw new IllegalArgumentException(MATERIAL_INVALIDO);
				}
				
				else {
					throw new IllegalArgumentException(PECA_INVALIDA);
				}
			}
		}
	} // importarPecas() throws IllegalArgumentException
	
	/**
	 *  Relatório base da estrutura, contendo suas principais informações: peso total, volume total, latas de tinta necessárias para pinta a estrutura e
	 *  o volume total por cada tipo de peça cadastrada. Utiliza métodos da classe (mos.io.InputOutput) para gravar os dados em uma interface.
	 */
	public void relatorioEM() {
		StringBuilder relatorio = new StringBuilder(String.format("\n%10c- ESTRUTURA:\n", SPACE));
		int[] latas = numeroDeLatasDeTinta();
		
		relatorio.append(String.format("%20cPeso Total: %s %s\n", SPACE, pesoTotal(), Peca.getUnidadePesoTotal()));
		relatorio.append(String.format("%20cVolume Total: %s %s\n", SPACE, volumeTotal(), Peca.getUnidadeVolume()));
		relatorio.append(String.format("%20cLatas de tinta necessárias para pintar a estrutura:\n", SPACE));
		relatorio.append(String.format("%30c5 litros: %s lata(s)\n%30c2 litros: %s lata(s)\n%30c0,5 litros: %s lata(s)\n", SPACE, latas[2], SPACE, latas[1], SPACE, latas[0]));
		
		relatorio.append(String.format("\n%10c- VOLUME TOTAL POR TIPO DE PEÇA:\n", SPACE));
		relatorio.append(String.format("%20cCilindro: %s %s\n", SPACE, volumeTotalPeca(1), Peca.getUnidadeVolume()));
		relatorio.append(String.format("%20cCubo: %s %s\n", SPACE, volumeTotalPeca(2), Peca.getUnidadeVolume()));
		relatorio.append(String.format("%20cParalelepipedo: %s %s\n", SPACE, volumeTotalPeca(3), Peca.getUnidadeVolume()));
		
		
		writeTextArea(relatorio);
	} // relatorioEM()
	
	/**
	 *  Relatório extra usado para testar alguns métodos de EstruturaMetalica, contendo informações como: total de peças, total de peças por tipo de peça, 
	 *  área total e dimensões de cada peça e informações de uma determinada peça. Utiliza métodos da classe (mos.io.InputOutput) para gravar os dados em uma interface.
	 */
	public void relatorioPecas() {
		StringBuilder relatorio = new StringBuilder();
		
		relatorio.append(String.format("\n- Total de Peças: %s peça(s).\n", estruturaMetalica.obterTotalPecas()));
		relatorio.append(String.format("%10cCilindro: %s unidade(s)\n", SPACE, estruturaMetalica.obterTotalPecas(1)));
		relatorio.append(String.format("%10cCubo: %s unidade(s)\n", SPACE, estruturaMetalica.obterTotalPecas(2)));
		relatorio.append(String.format("%10cParalelepipedo: %s unidade(s)\n", SPACE, estruturaMetalica.obterTotalPecas(3)));
		
		relatorio.append(String.format("\n- ÁREA E DIMENSÕES:\n"));
		relatorio.append(String.format("%s", estruturaMetalica.obterAreaTotalEDimensoes()));

		relatorio.append(String.format("- Pegando a primeira peça cadastrada:\n"));
		relatorio.append(String.format("%10c%s", SPACE, estruturaMetalica.obterPeca(0)));
		
		writeTextArea(estruturaMetalica.toString() + relatorio);
	} // relatorioPecas()
	
	/**
	 *  Obtém a área total e as dimensões de cada peça da estrutura.
	 *  Retorna a área de cada peça em metros quadrados (m²) e suas dimensões em metros (m).
	 */
	public String obterAreaTotalEDimensoes() {
		return estruturaMetalica.obterAreaTotalEDimensoes();
	} // obterAreaEDimensoes()
	
	/**
	 *  Calcula o peso total da estrutura metálica.
	 *  Retorna o em quilogramas (Kg) correspondente ao peso total da estrutura metálica.
	 */
	@Override
	public double pesoTotal() {
		return estruturaMetalica.calcularPesoTotal();
	} // pesoTotal()

	/**
	 *  Calcula o volume total da estrutura metálica.
	 *  Retorna o valor em metros cúbicos (m³) correspondente ao volume total da estrutura metálica.
	 */
	@Override
	public double volumeTotal() {
		return estruturaMetalica.calcularVolumeTotal();
	} // volumeTotal()

	/**
	 *  Calcula o número de latas de tinta necesárias para pintar a estrutura metálica.
	 *
	 *  Retorna um vetor de números inteiros com a quantidade de cada lata de tinta.
	 *  A quantidade das latas de tinta de 0,5 litro, 2 litros e 5 litros são armazenadas, respectivamente, nas posições 0, 1 e 2.
	 */
	@Override
	public int[] numeroDeLatasDeTinta() {
		return estruturaMetalica.calcularConsumoTinta();
	} // numeroDeLatasDeTinta()

	/**
	 *  Calcula o volume total de todas as peças da estrutura metálica que possuem o mesmo tipo.
	 *  O valores válidos para o tipo da peça são CILINDRO, CUBO ou PARALELEPIPEDO, definidos na interface Estrutura. 
	 *  Retorna o valor em metros cúbicos (m³) correspondente ao volume da peça.
	 *  
	 *  @throws IllegalArgumentException caso seja passado um tipo de peça inválido
	 */
	@Override
	public double volumeTotalPeca(int tipoPeca) throws IllegalArgumentException {
		if(tipoPeca >= CILINDRO && tipoPeca <= PARALELEPIPEDO)
			return estruturaMetalica.calcularVolumeTotal(tipoPeca);
		else 
			throw new IllegalArgumentException(PECA_INVALIDA);
	} // volumeTotalPeca(int tipoPeca)
} // class EM