package br.edu.infnet.apppaws.models.domains;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_FARMACY")
public class Farmacy extends Product {

    @Size(min = 3, max = 60, message = "A dosagem deve ter entre {min} e {max} caracteres.")
    private String dosage;
    @Size(min = 3, max = 30)
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
