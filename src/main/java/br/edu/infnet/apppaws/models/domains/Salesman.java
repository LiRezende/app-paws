package br.edu.infnet.apppaws.models.domains;

public class Salesman {

    private String codId;
    private String firstName;
    private String lastName;
    private String documentCpf;
    private String email;

    public Salesman() {
    }

    public Salesman(String codId, String firstName, String lastName, String documentCpf, String email) {
        this.codId = codId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentCpf = documentCpf;
        this.email = email;
    }

    public String getCodId() {
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

    public void setCodId(String codId) {
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

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s - %s", codId, firstName, lastName, documentCpf, email);
    }
}
