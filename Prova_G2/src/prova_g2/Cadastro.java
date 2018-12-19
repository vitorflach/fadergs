/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova_g2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alu201815484
 */
public class Cadastro {
	public static void main(String[] args) {
		Scanner scanf = new Scanner(System.in);
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		int menu = 0, opcao, idade;
		boolean flag = false;
		String nome;

		System.out.println("BEM VINDO AO PROGRAMA DE CADASTRAMENTO");

		do {
			try {
				System.out.println("Por favor, selecione a opção desejada no Menu abaixo: ");
				System.out.println("1)Cadastrar Pessoa.");
				System.out.println("2)Buscar Pessoa.");
				System.out.println("3)Incrementar idade.");
				System.out.println("4)Excluir pessoa.");
				System.out.println("5)Listar pessoas.");
				System.out.println("6)Listar pessoas de idade X.");
				System.out.println("7)Sair.");
				menu = scanf.nextInt();
				switch (menu) {
				case 1:
					System.out.println("VOCÊ SELECIONOU: CADASTRAR PESSOA");
					do {
						System.out.println("Selecione a opção de cadastramento ==> \n1)PF\n2)PJ");
						opcao = scanf.nextInt();
						switch (opcao) {
						case 1:
							System.out.println("Digite o Nome e a Idade da Pessoa: ");
							pessoas.add(new PF(scanf.next(), scanf.nextInt()));
							break;
						case 2:
							System.out.println("Digite o Nome e a Idade da Pessoa: ");
							pessoas.add(new PJ(scanf.next(), scanf.nextInt()));
							break;
						default:
							System.out.println("Opção Inválida.");
						}
					} while (opcao != 1 && opcao != 2);
					break;
				case 2:
					System.out.println("VOCÊ SELECIONOU: BUSCAR PESSOA");
					System.out.println("Digite o nome da pessoa que você deseja buscar: ");
					nome = scanf.next();
					for (Pessoa p : pessoas) {
						if (p.getNome().equals(nome)) {
							System.out.println("---------------------------------------");
							System.out.println("PESSOA ENCONTRADA");
							System.out.println("Nome: " + p.getNome());
							System.out.println("Idade: " + p.getIdade());
							System.out.println("---------------------------------------");
							flag = true;
						}
					}
					if (!flag) {
						System.out.println("PESSOA NÃO ENCONTRADA");
						System.out.println("---------------------------------------");

					}
					flag = false;
					break;
				case 3:
					System.out.println("VOCÊ SELECIONOU: INCREMENTAR IDADE");
					System.out.println("Digite o nome da pessoa que você deseja incrementar idade: ");
					nome = scanf.next();
					for (Pessoa p : pessoas) {

						if (p.getNome().equals(nome)) {
							System.out.println("Pessoa encontrada!");
							System.out.println("Idade atual ==> " + p.getIdade());
							System.out.println("Quantos anos você quer incrementar para essa pessoa?");
							p.setIdade(scanf.nextInt() + p.getIdade());
							System.out.println("---------------------------------------");
							System.out.println("Nome: " + p.getNome());
							System.out.println("NOVA idade: " + p.getIdade());
							System.out.println("---------------------------------------");
							flag = true;
						}
					}
					if (!flag) {
						System.out.println("PESSOA NÃO ENCONTRADA");
						System.out.println("---------------------------------------");
					}
					flag = false;
					break;
				case 4:
					System.out.println("VOCÊ SELECIONOU: EXCLUIR PESSOA");
					System.out.println("Digite o nome da pessoa que você deseja excluir: ");
					nome = scanf.next();
					for (Pessoa p : pessoas) {
						if (p.getNome().equals(nome)) {
							pessoas.remove(p);
							System.out.println("PESSOA ENCONTRADA E REMOVIDA COM SUCESSO!!");
							System.out.println("---------------------------------------");
							flag = true;
							break;
						}
					}
					if (!flag) {
						System.out.println("PESSOA NÃO ENCONTRADA");
						System.out.println("---------------------------------------");

					}
					flag = false;
					break;
				case 5:
					System.out.println("VOCÊ SELECIONOU: LISTAR PESSOAS");
					if (pessoas.isEmpty()) {
						System.out.println("---------------------------------------");
						System.out.println("LISTA VAZIA");
						System.out.println("---------------------------------------");
					} else {
						for (Pessoa p : pessoas) {
							System.out.println("Nome: " + p.getNome());
							System.out.println("Idade: " + p.getIdade());
							System.out.println("---------------------------------------");
						}
					}
					break;
				case 6:
					if (pessoas.isEmpty()) {
						System.out.println("---------------------------------------");
						System.out.println("NENHUMA PESSOA FOI INCREMENTADA NA LISTA");
						System.out.println("---------------------------------------");
					} else {
						System.out.println("VOCÊ SELECIONOU: LISTAR PESSOAS DE IDADE X");
						System.out.println(
								"Digite uma idade e o programa irá imprimir na tela todas as pessoas que tem essa idade: ");
						idade = scanf.nextInt();
						for (Pessoa p : pessoas) {
							if (p.getIdade() == idade) {
								System.out.println("---------------------------------------");
								System.out.println("Nome: " + p.getNome());
								System.out.println("---------------------------------------");
								flag = true;
							}
						}
						if (!flag) {
							System.out.println("NINGUÉM NA LISTA POSSUI ESTA IDADE!");
							System.out.println("---------------------------------------");
						}
						flag = false;
					}
					break;
				case 7:
					System.out.println("PROGRAMA FINALIZADO, ATÉ LOGO.");
					break;
				default:
					System.out.println("Opção inválida.");
					System.out.println("----------------------------------------");
				}
			} catch (InputMismatchException e) {
				System.err.println("TIPO DE DADO INVÁLIDO");
				scanf.next();
			}
		} while (menu != 7);
	}
}
