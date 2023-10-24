package br.edu.infnet.apppaws.models.domains;

public class Product {

    private String codId;
    private String name;
    private String description;
    private float price;
    private boolean inventory;

    public Product() {
    }

    public Product(String codId, String name, String description, float price, boolean inventory) {
        this.codId = codId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.inventory = inventory;
    }

    public String getCodId() {
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

    public void setCodId(String codId) {
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

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %.2f - %s", codId, name, description, price, inventory);
    }
}
