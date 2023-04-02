public class User {
    private String name;
    private String email;
    private String password;
    private String address;

    public User(String name, String email, String password, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Password: " + password + ", Address: " + address;
    }

    public boolean equals(User other) {
        return name.equals(other.name) && email.equals(other.email) && password.equals(other.password) && address.equals(other.address);
    }


}
