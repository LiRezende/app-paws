package br.edu.infnet.apppaws.models.domains;

public class Toy extends Product {

    private boolean forPuppies;
    private String material;

    public boolean isForPuppies() {
        return forPuppies;
    }

    public String getMaterial() {
        return material;
    }

    public void setForPuppies(boolean forPuppies) {
        this.forPuppies = forPuppies;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", forPuppies, material);
    }
}
