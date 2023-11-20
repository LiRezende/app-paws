package br.edu.infnet.apppaws.models.domains;

public class Information {

    private Integer id;
    private String text;
    private String description;

    @Override
    public String toString() {

        return String.format("id (%d) - text (%s) - description (%s)",
                id, text, description
        );
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
