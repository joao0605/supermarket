package program;

import entities.Client;
import entities.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Supermarket {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Product Rice = new Product(1, "Arroz", 5.99, 1.0);
        char n;

        System.out.println("Seja bem vindo(a) ao Supermercado do João");
        do {
            System.out.print("Você já é membro do nosso clube? Y/N ");
            n = sc.next().charAt(0);

            if (n == 'y' || n == 'Y') {
                System.out.println("Perfeito, insira aqui o seu CPF");
            } else if (n == 'n' || n == 'N') {
                char register;
                do {
                    System.out.print("Deseja realizar seu cadastro? Y/N ");
                    register = sc.next().charAt(0);
                    if (register == 'Y' || register == 'y') {
                        String name;
                        String cpf;
                        System.out.println("Ótimo, precisamos de apenas alguns dados. Vamos lá!!");
                        System.out.println("Qual é o seu nome?");
                        sc.nextLine();
                        name = sc.nextLine();
                        System.out.println("Qual é o seu CPF? \n (sem pontos e traços, somente números)");
                        cpf = sc.next();


                        Client client = new Client(name, cpf, true);

                        System.out.println(client.welcome());

                        //registrar
                    } else if (register == 'N' || register == 'n') {
                        System.out.println("Tudo bem, vamos seguir com as compras :D");
                    } else {
                        System.out.println("Não entendi a sua resposta :/");
                    }
                } while (!(register == 'y' || register == 'Y' || register == 'n' || register == 'N'));
            } else {
                System.out.println("Não entendi sua resposta :/");
            }
        } while (!(n == 'y' || n == 'Y' || n == 'n' || n == 'N'));
        menu();

        sc.close();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int ans;

        System.out.println("Certo, o que você deseja fazer?");
        System.out.println("1 - Comprar produtos");
        System.out.println("2 - Adicionar produtos novos");
        ans = sc.nextInt();

        switch (ans) {
            case 1:
                System.out.println("Esta é a nossa lista de produtos disponíveis no momento:");
                //exibir aqui a lista de produtos
                break;
            case 2:
                String password;
                boolean loop;
                do {
                    System.out.println("Entre com a sua senha de administrador:");
                    password = sc.next();
                    if (password.equals("123456")) {
                        System.out.println("Bem vindo, João!!");
                        System.out.println("Este é o nosso estoque de produtos");
                        //exibir aqui a lista de produtos

                        loop = true;
                    } else {
                        System.out.println("Senha incorreta!!");
                        loop = false;
                    }
                } while (loop == false);
                break;

        }
        sc.close();
    }
}
