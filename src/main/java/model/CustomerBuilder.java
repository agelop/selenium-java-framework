package model;


public class CustomerBuilder {

    private String email;
    private String password;


    public CustomerBuilder email(String email) {
        this.email = email;
        return this;
    }

    public CustomerBuilder password(String password) {
        this.password = password;
        return this;
    }


    public Customer build() {
        return new Customer(email, password);
    }
}