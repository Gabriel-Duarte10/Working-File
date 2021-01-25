package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	
		
		
		System.out.print("Digite o caminho e o nome do arquivo a ser criado: ");
		String path = sc.nextLine();
		//C:\\Users\\Gabri\\Desktop\\teste\\teste.txt
		
		System.out.print("Quantos produtos deseja cadastrar: ");
		int n = sc.nextInt();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path)))  {
			
			sc.nextLine();
			for(int i=1;i<=n;i++) {
				
				System.out.print("Digite o Produto, o Preco e a Quantidade: ");
				String lines = sc.nextLine();
				bw.write(lines);
				bw.newLine();	
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		sc.close();
	}

}
