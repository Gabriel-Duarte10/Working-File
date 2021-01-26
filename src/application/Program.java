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

		System.out.println("Digite o caminho e o nome do arquivo a ser criado: ");
		System.out.println("exemple: C:\\Users\\Gabri\\Desktop\\Source file.txt ");
		System.out.print(": ");
		String path = sc.nextLine();
		
		int position = path.lastIndexOf("\\");
		
		String path2 = path.substring(0, position) + "\\summary.txt";
		
	

		System.out.print("Quantos produtos deseja cadastrar: ");
		int n = sc.nextInt();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

			sc.nextLine();
			for (int i = 1; i <= n; i++) {

				System.out.print("Digite o Produto, o Preco e a Quantidade separados por virgula: ");
				String lines = sc.nextLine();
				bw.write(lines);
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("error: " + e.getMessage());
		}

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String readLine = br.readLine();
			try (BufferedWriter bw2 = new BufferedWriter(new FileWriter(path2))) {
				while (readLine != null) {
					int posi = readLine.indexOf(',');
					int posi2 = readLine.lastIndexOf(',');

					double price = Double.parseDouble(readLine.substring(posi + 2, posi2));
					int qtd = Integer.parseInt(readLine.substring(posi2 + 2));

					bw2.write(readLine.substring(0, posi) + ", " + String.format("%.2f", price*qtd));
					bw2.newLine();
					readLine = br.readLine();
				}
			} catch (IOException c) {
				System.out.println("error: " + c.getMessage());
			}

		} catch (IOException b) {
			System.out.println("error: " + b.getMessage());
		}

		sc.close();
	}

}
