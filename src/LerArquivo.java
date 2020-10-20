import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class LerArquivo {
	
	public static void main(String args[]) {
			
			String dados;
			String [] configuracao;
		
			try{
					FileInputStream arquivo = new FileInputStream("teste.txt");
					InputStreamReader imput = new InputStreamReader(arquivo);
					BufferedReader br = new BufferedReader(imput);
					
					System.out.println("------ TESTANDO ------");
					
					do{
						dados = br.readLine();
						
						if(dados != null) {
							
							System.out.println(dados);
								
						}
						
						configuracao= dados.split(";");
						
						System.out.println("------ QUEBRANDO ------");
						
						System.out.println(configuracao[0]);
						System.out.println(configuracao[1]);
						System.out.println(configuracao[2]);
			
					}while(dados != null);
									
			}catch(Exception e) {
				
			}
		}
}
