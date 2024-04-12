package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String usuario;
        do {
            System.out.print("Informe o nome de usuário (deve começar com uma letra e ter entre 5 e 8 caracteres): ");
            usuario = scanner.nextLine();
        } while (!usuario.matches("[a-zA-Z][a-zA-Z0-9]{4,7}"));

        boolean primeiraCompra;
        do {
            System.out.print("É a primeira compra? (S/N): ");
            String resposta = scanner.nextLine();
            primeiraCompra = resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("N");
        } while (!primeiraCompra);

        double valorCompra;
        do {
            System.out.print("Informe o valor da compra (deve ser um número positivo): ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Valor inválido. Por favor, informe um número positivo: ");
                scanner.next();
            }
            valorCompra = scanner.nextDouble();
        } while (valorCompra <= 0);

        double desconto = calcularDesconto(primeiraCompra, valorCompra);
        double valorFinal = valorCompra - (valorCompra * desconto);

        System.out.println("Valor final da compra após o desconto: R$" + valorFinal);

        scanner.close();
    }

    public static double calcularDesconto(boolean primeiraCompra, double valorCompra) {
        double desconto = 0.0;

        if (primeiraCompra) {
            desconto = 0.15;
        } else if (valorCompra > 500.00) {
            desconto = 0.10;
        } else if (valorCompra > 200.00) {
            desconto = 0.05;
        }

        return desconto;
    }
}