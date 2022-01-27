package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Pessoa> listaDeContribuintes = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Tax payer #" + n + " data:");
			System.out.print("Individual or company (i/c)?");
			char tipoDeContribuinte = sc.next().charAt(0);
			System.out.print("Name:");
			String nomeDoContribuinte = sc.next();
			System.out.print("Anual Income: ");
			double rendaDoContribuinte = sc.nextDouble();
			if (tipoDeContribuinte == 'i') {				
				System.out.print("Health expenditures: ");
				double gastosComSaude = sc.nextDouble();
				PessoaFisica contribuinte = new PessoaFisica(nomeDoContribuinte, rendaDoContribuinte, gastosComSaude);
				listaDeContribuintes.add(contribuinte);
			} else {
				System.out.print("Number of employees: ");
				int numeroDeFuncionarios = sc.nextInt();
				PessoaJuridica contribuinte = new PessoaJuridica(nomeDoContribuinte, rendaDoContribuinte, numeroDeFuncionarios);
				listaDeContribuintes.add(contribuinte);
			}
		}
		System.out.println();
		System.out.println("TAXES PAID:");
		double totalDeImpostosDeTodosContribuintesDaLista = 0;
		for (Pessoa contribuinte : listaDeContribuintes) {
			System.out.println(contribuinte);
			totalDeImpostosDeTodosContribuintesDaLista += contribuinte.impostoAPagar();
		}
		System.out.println();
		System.out.print("TOTAL TAXES: $ " + String.format("%.2f", totalDeImpostosDeTodosContribuintesDaLista));
	}

}
