package br.edu.infnet.apppaws.models.domains;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_TOY")
public class Toy extends Product {

    private boolean forPuppies;
    @Size(min = 3, max = 60, message = "O material deve ter entre {min} e {max} caracteres.")
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
