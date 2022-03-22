package program;

import entities.Client;
import entities.Product;

import java.util.*;

public class Supermarket {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Client client1 = new Client("John", "123456789", true);

        ArrayList<Client> client = new ArrayList<>();
        client.add(client1);
        String cpf = null;

// Produtos pré configurados e adicionados à lista

        Product rice = new Product(1, "Arroz", 5.99);
        Product cheese = new Product(2, "Queijo", 2.99);
        Product milk = new Product(3, "Leite", 2.50);
        Product bread = new Product(4, "Pão", 0.75);
        Product egg = new Product(5, "Ovo", 0.15);
        Product butter = new Product(6, "Manteiga", 1.25);
        Product juice = new Product(7, "Suco", 0.5);


        List<Product> product = new ArrayList<>();
        product.add(rice);
        product.add(cheese);
        product.add(milk);
        product.add(bread);
        product.add(egg);
        product.add(butter);
        product.add(juice);

        char n; //Será utilizada abaixo em menu

        System.out.println("Seja bem vindo(a) ao Supermercado do João");
        do {

            System.out.print("Você já é membro do nosso clube? Y/N ");
            n = sc.next().charAt(0);


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
                    if (register == 'Y' || register == 'y') { //"página" de cadastro
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
        System.out.println("2 - Adicionar novos produtos ao estoque");
        System.out.println("3 - Remover produtos do estoque");
        ans = sc.nextInt();

        switch (ans) {
            case 1: // opção de compra
                List<Product> shoplist = new ArrayList<>();
                int shopCode;
                char newShop;


                do {
                    System.out.println("Esta é a nossa lista de produtos disponíveis no momento:");
                    System.out.println(product);

                    System.out.println("---------------------------------------------------------");
                    System.out.print("Digite o código do produto que você deseja adicionar ao seu carrinho de compras: ");
                    shopCode = sc.nextInt();

                    for (Product item : product) {
                        if (item.getCode() == shopCode) {
                            shoplist.add(item);
                        }
                    }
                    System.out.println("CARRINHO");
                    System.out.println(shoplist);
                    System.out.println();

                    System.out.print("Deseja adicionair mais um item ao carrinho? Y/N ");
                    newShop = sc.next().charAt(0);
                } while (newShop == 'y' || newShop == 'Y');

                System.out.println();
                System.out.println("RESUMO DA COMPRA");
                System.out.println(shoplist);
                Double finalPrice = 0.0;

                for (Product total: shoplist) {
                    finalPrice += total.getPrice();
                    }

                System.out.println("----------------------------------");
                System.out.printf("Valor total da compra: R$ %.2f", finalPrice);
                System.out.println();
                System.out.println("----------------------------------");

                if (cpf != null) { //não consegui puxar os dados do newClient aqui

                    Double clubMember = finalPrice * 0.9;
                    System.out.printf("Por ser membro do nosso clube, você tem direito a 10/100 de desconto e o valor final da sua compra é de R$ %.2f", clubMember);
                }
                System.out.println();
                System.out.println("----------------");
                System.out.println("Forma de pagamento");
                System.out.println("1 - Dinheiro");
                System.out.println("2 - Cartão");
                int payment = sc.nextInt();
                System.out.println("Você escolheu: ");
                if (payment == 1) {
                    System.out.println("Dinheiro! ");
                }else {
                    System.out.println("Cartão! ");
                }

                System.out.println("Finalize a compra com nosso funcionário e volte sempre!");

                break;
            case 2: //opção para "administrador" adicionar novos produtos ao estoque
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
                            sc.nextLine();
                            name = sc.nextLine();
                            System.out.print("Digite o preço unitário: ");
                            price = sc.nextDouble();



                            Product newProduct = new Product(code, name, price);
                            product.add(newProduct);

                            System.out.println("Este é o nosso estoque de produtos atualizado:");
                            System.out.println(product);

                            System.out.print("Deseja adicionar um novo produto? Y/N ");
                            add = sc.next().charAt(0);

                        } while (add == 'Y' || add == 'y');


                        loop = true;
                    } else {
                        System.out.println("Senha incorreta!!");
                        loop = false;
                    }
                } while (loop == false);
                break;
            case 3:
                do {
                    System.out.println("Entre com a sua senha de administrador:");
                    password = sc.next();
                    if (password.equals("123456")) {
                        System.out.println("### PÁGINA DE ADMINISTRADOR ###");
                        System.out.println("Bem vindo, João!!\n");
                        System.out.println("Este é o nosso estoque de produtos:");
                        System.out.println(product);
                        char rmv;


                        do {

                            int code;
                            System.out.print("Digite o código do produto que deseja remover: ");
                            code = sc.nextInt();
                            for (Product products : product) {
                                if(products.getCode() == code) {
                                    product.remove(products);
                                    break;
                                }
                            }

                            System.out.println("Este é o nosso estoque de produtos atualizado:");
                            System.out.println(product);

                            System.out.print("Deseja remover um novo produto? Y/N ");
                            rmv = sc.next().charAt(0);
                        } while (rmv == 'Y' || rmv == 'y');
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
