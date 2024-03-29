package bruno.luis.springproject.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;
    private Date dateCreation;
    private Date dateShipped;

    private Double total;

    @ManyToOne
    private UserModel user;

    @OneToMany(mappedBy = "order")
    private List<DetailOrder> detail;

    public Order() {
    }

    public Order(Integer id, String number, Date dateCreation, Date dateShipped, Double total) {
        this.id = id;
        this.number = number;
        this.dateCreation = dateCreation;
        this.dateShipped = dateShipped;
        this.total = total;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateShipped() {
        return this.dateShipped;
    }

    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }

    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public UserModel getUser() {
        return this.user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<DetailOrder> getDetail() {
        return this.detail;
    }

    public void setDetail(List<DetailOrder> detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", number='" + getNumber() + "'" +
                ", dateCreation='" + getDateCreation() + "'" +
                ", dateShipped='" + getDateShipped() + "'" +
                ", total='" + getTotal() + "'" +
                "}";
    }

}
