package program;

import entities.Client;
import entities.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Supermarket {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Client client1 = new Client("John", "123456789", true);

        ArrayList<Client> client = new ArrayList<>();
        client.add(client1);


        Product rice = new Product(1, "Arroz", 5.99, 1.0);
        Product cheese = new Product(2, "Queijo", 2.99, 1.0);
        Product milk = new Product(3, "Leite", 2.50, 1.0);
        Product bread = new Product(4, "Pão", 0.75, 10.0);

        ArrayList<Product> product = new ArrayList<>();
        product.add(rice);
        product.add(cheese);
        product.add(milk);
        product.add(bread);

        char n;

        System.out.println("Seja bem vindo(a) ao Supermercado do João");
        do {

            System.out.print("Você já é membro do nosso clube? Y/N ");
            n = sc.next().charAt(0);
            String cpf;

            if (n == 'y' || n == 'Y') {
                System.out.println("Perfeito, insira aqui o seu CPF");
                cpf = sc.next();
                if(cpf.equals(client1.getCpf())) {
                    System.out.println("Seja bem vindo, " + client1.getName() +"!");

                }

            } else if (n == 'n' || n == 'N') {
                char register;
                do {
                    System.out.print("Deseja realizar seu cadastro? Y/N ");
                    register = sc.next().charAt(0);
                    if (register == 'Y' || register == 'y') {
                        String name;

                        System.out.println("Ótimo, precisamos de apenas alguns dados. Vamos lá!!");
                        System.out.println("Qual é o seu nome?");
                        sc.nextLine();
                        name = sc.nextLine();
                        System.out.println("Qual é o seu CPF? \n (sem pontos e traços, somente números)");
                        cpf = sc.next();


                        Client newClient = new Client(name, cpf, true);
                        client.add(newClient);

                        System.out.println(newClient.welcome());

                        //registrar
                    } else if (register == 'N' || register == 'n') {
                        System.out.println("Tudo bem, vamos seguir com as compras sem efetuar o registro :D");
                    } else {
                        System.out.println("Não entendi a sua resposta :/");
                    }
                } while (!(register == 'y' || register == 'Y' || register == 'n' || register == 'N'));
            } else {
                System.out.println("Não entendi sua resposta :/");
            }
        } while (!(n == 'y' || n == 'Y' || n == 'n' || n == 'N'));


        int ans;

        System.out.println("\nCerto, o que você deseja fazer?");
        System.out.println("1 - Comprar produtos");
        System.out.println("2 - Adicionar produtos novos");
        ans = sc.nextInt();

        switch (ans) {
            case 1:
                System.out.println("Esta é a nossa lista de produtos disponíveis no momento:");
                System.out.println(product);
                break;
            case 2:
                String password;
                boolean loop;
                do {
                    System.out.println("Entre com a sua senha de administrador:");
                    password = sc.next();
                    if (password.equals("123456")) {
                        System.out.println("### PÁGINA DE ADMINISTRADOR ###");
                        System.out.println("Bem vindo, João!!\n");
                        System.out.println("Este é o nosso estoque de produtos:");
                        System.out.println(product);
                        char add;

                        do {
                            String name;
                            Double price, quantity;
                            int code;


                            System.out.print("Digite o código do novo produto: ");
                            code = sc.nextInt();
                            System.out.print("Digite o nome: ");
                            name = sc.next();
                            System.out.print("Digite o preço unitário: ");
                            price = sc.nextDouble();
                            System.out.print("Digite a quantidade disponível: ");
                            quantity = sc.nextDouble();
                            System.out.print("Deseja adicionar um novo produto? Y/N ");
                            add = sc.next().charAt(0);

                            Product newProduct = new Product(code, name, price, quantity);
                            product.add(newProduct);

                        } while (add == 'Y' || add == 'y');
                        System.out.println("Este é o nosso estoque de produtos atualizado:");
                        System.out.println(product);

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
