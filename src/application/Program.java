package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// exercicio comerciante
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int nProdutos;
		
		System.out.print("Serao digitados dados de quantos produtos? ");
		nProdutos = sc.nextInt();
		String[] nomeProduto = new String[nProdutos];
		double[] precoCompra = new double[nProdutos];
		double[] precoVenda = new double[nProdutos];
		double[] porcentagemLucros = new double[nProdutos];
		int lucro10 = 0, lucro1020 = 0, lucro20 = 0;
		double vTotalVenda = 0.00, vTotalCompra = 0.00;
		
		for(int i = 0; i < nProdutos; i++) {
			sc.nextLine();
			System.out.printf("Produto %d\n", i+1);
			System.out.print("Nome: ");
			nomeProduto[i] = sc.nextLine();
			System.out.print("Preco de compra: ");
			precoCompra[i] = sc.nextDouble();
			System.out.print("Preco de venda: ");
			precoVenda[i] = sc.nextDouble();
		}
		
		for(int i = 0; i < nProdutos; i++) {
			porcentagemLucros[i] = (precoVenda[i] - precoCompra[i]) / precoCompra[i] * 100.00;
		}
		
		for(int i = 0; i < nProdutos; i++) {
			if(porcentagemLucros[i] < 10.0) {
				lucro10++;
			} else if (porcentagemLucros[i] < 20.0) {
				lucro1020++;
			} else {
				lucro20++;
			}
		}

		for (int i = 0; i < nProdutos; i++) {
			vTotalCompra += precoCompra[i];
			vTotalVenda += precoVenda[i];
		}
		
		double lucroTotal = vTotalVenda - vTotalCompra; 
		System.out.println("\nRELATORIO:");
		System.out.printf("Lucro abaixo de 10%%: %d\n", lucro10);
		System.out.printf("Lucro entre 10%% e 20%%: %d\n", lucro1020);
		System.out.printf("Lucro acima de 20%%: %d\n", lucro20);
		System.out.printf("Valor total de compra: %.2f\n", vTotalCompra);
		System.out.printf("Valor total de venda: %.2f\n", vTotalVenda);
		System.out.printf("Lucro total: %.2f\n", lucroTotal);
		sc.close();

	}

}
