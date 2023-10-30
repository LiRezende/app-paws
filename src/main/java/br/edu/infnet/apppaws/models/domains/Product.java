package br.edu.infnet.apppaws.models.domains;

import jakarta.persistence.*;

import java.lang.Integer;

@Entity
@Table(name = "TB_PRODUCT")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codId;
    private String name;
    private String description;
    private float price;
    private boolean inventory;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codIdSalesman")
    private Salesman salesman;

    public Product() {
    }

    public Product(Integer codId, String name, String description, float price, boolean inventory, Salesman salesman) {
        this.codId = codId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.inventory = inventory;
        this.salesman = salesman;
    }

    public Integer getCodId() {
        return codId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public boolean isInventory() {
        return inventory;
    }

    public void setCodId(Integer codId) {
        this.codId = codId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setInventory(boolean inventory) {
        this.inventory = inventory;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %.2f - %s", codId, name, description, price, inventory);
    }
}
