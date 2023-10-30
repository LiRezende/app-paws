package br.edu.infnet.apppaws.models.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_FARMACY")
public class Farmacy extends Product {

    private String dosage;
    private String laboratory;

    public String getDosage() {
        return dosage;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", dosage, laboratory);
    }
}
