package model;



public class Customer {

    private String email;
    private String password;

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Customer() {
    }

    public String getEmail() {
        return this.email;
    }


    public String getPassword() {
        return this.password;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String toString() {
        return "Customer(email=" + this.getEmail() + ")";
    }

}
