package bruno.luis.springproject.model;

import java.util.Date;

public class Order {
    private Integer id;
    private String number;
    private Date dateCreation;
    private Date dateShipped;

    private double total;

    public Order() {
    }

    public Order(Integer id, String number, Date dateCreation, Date dateShipped, double total) {
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

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
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
