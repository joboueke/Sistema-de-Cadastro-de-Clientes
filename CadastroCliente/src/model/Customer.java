package model;

public class Customer {
    private String name;
    private String cpf;
    private String email;

    public Customer(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s | CPF: %s | E-mail: %s", name, cpf, email);
    }

    public String toFileString() {
        return name + ";" + cpf + ";" + email;
    }

    public static Customer fromFileString(String line) {
        String[] parts = line.split(";");
        if (parts.length != 3) return null;
        return new Customer(parts[0], parts[1], parts[2]);
    }
}
