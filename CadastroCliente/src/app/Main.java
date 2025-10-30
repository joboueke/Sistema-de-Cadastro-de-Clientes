package app;

import model.Customer;
import service.CustomerService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerService service = new CustomerService();

        service.loadFromFile(); // Carrega os dados ao iniciar

        boolean running = true;
        while (running) {
            System.out.println("\n==== SISTEMA DE CLIENTES ====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Buscar cliente por CPF");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            String option = sc.nextLine();

            switch (option) {
                case "1" -> {
                    System.out.print("Nome: ");
                    String name = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("E-mail: ");
                    String email = sc.nextLine();

                    service.addCustomer(new Customer(name, cpf, email));
                    System.out.println("Cliente cadastrado!");
                }
                case "2" -> service.listCustomers();
                case "3" -> {
                    System.out.print("Digite o CPF: ");
                    String cpf = sc.nextLine();
                    service.searchByCpf(cpf);
                }
                case "4" -> {
                    System.out.println("Encerrando...");
                    running = false;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }
}
