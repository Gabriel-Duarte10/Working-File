package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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
		String path2 = "C:\\Users\\Gabri\\Desktop\\teste\\summary.txt";
		//C:\\Users\\Gabri\\Desktop\\teste\\Source file.txt
		
		System.out.print("Quantos produtos deseja cadastrar: ");
		int n = sc.nextInt();
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path)))  {
			
			sc.nextLine();
			for(int i=1;i<=n;i++) {
				
				System.out.print("Digite o Produto, o Preco e a Quantidade separados por virgula: ");
				String lines = sc.nextLine();
				bw.write(lines);
				bw.newLine();	
			}	
		}
		catch(IOException e){
			System.out.println("error: " + e.getMessage());
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){

			String readLine =  br.readLine();
			
			while(readLine != null) {
				int posi = readLine.indexOf(',');
				int posi2 = readLine.lastIndexOf(',');
			
				double price = Double.parseDouble(readLine.substring(posi+2, posi2));
				int qtd = Integer.parseInt(readLine.substring(posi2+2));
				
				
				try(BufferedWriter bw2 = new BufferedWriter(new FileWriter(path2))){
					
					bw2.write(readLine.substring(0, posi) + "," + price*qtd);
					bw2.newLine();
					bw2.newLine();
					System.out.println(price*qtd);
				} 
				catch(IOException c) {
					System.out.println("error: " + c.getMessage());
				}
			
				readLine = br.readLine();
			}
		}
		catch(IOException b) {
			System.out.println("error: " + b.getMessage());
		}
		
		

		sc.close();
	}

}
