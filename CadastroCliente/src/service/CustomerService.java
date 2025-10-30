package service;

import model.Customer;
import util.FileUtil;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private final List<Customer> customers = new ArrayList<>();
    private final String FILE_PATH = "clientes.txt";

    public void addCustomer(Customer customer) {
        customers.add(customer);
        saveToFile();
    }

    public void listCustomers() {
        if (customers.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    public void searchByCpf(String cpf) {
        for (Customer c : customers) {
            if (c.getCpf().equals(cpf)) {
                System.out.println("Cliente encontrado:");
                System.out.println(c);
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    public void loadFromFile() {
        List<String> lines = FileUtil.readLines(FILE_PATH);
        for (String line : lines) {
            Customer c = Customer.fromFileString(line);
            if (c != null) customers.add(c);
        }
    }

    private void saveToFile() {
        List<String> lines = new ArrayList<>();
        for (Customer c : customers) {
            lines.add(c.toFileString());
        }
        FileUtil.writeLines(FILE_PATH, lines);
    }
}
