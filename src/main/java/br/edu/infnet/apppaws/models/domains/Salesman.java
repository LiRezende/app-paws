package br.edu.infnet.apppaws.models.domains;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "codIdSalesman")
    private List<Product> products;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "codIdAddress")
    private Address address;

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

    public List<Product> getProducts() {
        return products;
    }

    public Address getAddress() {
        return address;
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

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("codId (%d) - nome (%s) - sobrenome (%s) - cpf (%s) - email (%s) - endereço (%s) - produtos (%d)",
                codId, firstName, lastName, documentCpf, email, address, products != null ? products.size() : 0);
    }
}
