package bruno.luis.springproject.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String username;
    private String email;
    private String address;
    private String phone;
    private String type;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Product> products;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    // Constructor vacío
    public UserModel() {
    }

    public UserModel(Integer id, String name, String username, String email, String address, String phone,
            String type, String password) {
        super();
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.type = type;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() { // Corregido el nombre del método aquí
        return name;
    }

    public void setName(String name) { // Corregido el nombre del método aquí
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() { // Corregido el nombre del método aquí
        return address;
    }

    public void setAddress(String address) { // Corregido el nombre del método aquí
        this.address = address;
    }

    public String getPhone() { // Corregido el nombre del método aquí
        return phone;
    }

    public void setPhone(String phone) { // Corregido el nombre del método aquí
        this.phone = phone;
    }

    public String getType() { // Corregido el nombre del método aquí
        return type;
    }

    public void setType(String type) { // Corregido el nombre del método aquí
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", username='" + getUsername() + "'" +
                ", email='" + getEmail() + "'" +
                ", address='" + getAddress() + "'" +
                ", phone='" + getPhone() + "'" +
                ", type='" + getType() + "'" +
                ", password='" + getPassword() + "'" +
                "}";
    }
}
