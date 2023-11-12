package br.edu.infnet.apppaws.models.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.lang.Integer;

@Entity
@Table(name = "TB_SALESMAN", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"documentCpf"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class Salesman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codId;
    @Size(min = 3, max = 20)
    private String firstName;
    @Size(min = 3, max = 40)
    private String lastName;
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
    @Column(unique = true)
    private String documentCpf;
    @Size(min = 2, max = 50)
    @Column(unique = true)
    private String email;
    @OneToMany(mappedBy = "salesman")
    private List<Product> products;

    public Salesman() {
    }

    public Salesman(Integer codId) {
        this.codId = codId;
    }

    public Salesman(Integer codId, String firstName, String lastName, String documentCpf, String email) {
        this.codId = codId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentCpf = documentCpf;
        this.email = email;
    }

    public Integer getCodId() {
        return codId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocumentCpf() {
        return documentCpf;
    }

    public String getEmail() {
        return email;
    }

    public void setCodId(Integer codId) {
        this.codId = codId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDocumentCpf(String documentCpf) {
        this.documentCpf = documentCpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProdutos(List<Product> productsList) {
        this.products = productsList;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s - %s", codId, firstName, lastName, documentCpf, email);
    }
}
