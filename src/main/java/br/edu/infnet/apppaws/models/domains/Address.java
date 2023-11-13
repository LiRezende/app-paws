package br.edu.infnet.apppaws.models.domains;

import javax.persistence.*;

@Entity
@Table(name = "TB_ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codId;
    private String cep;
    private String street;
    private String complement;
    private String district;
    private String local;
    private String uf;

    public Address() {
    }

    public Address(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {

        return String.format("cep (%s) - bairro (%s) - uf (%s)",
                cep,
                district,
                uf
        );
    }

    public Integer getId() {
        return codId;
    }

    public String getCep() {
        return cep;
    }

    public String getStreet() {
        return street;
    }

    public String getComplement() {
        return complement;
    }

    public String getDistrict() {
        return district;
    }

    public String getLocal() {
        return local;
    }

    public String getUf() {
        return uf;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
