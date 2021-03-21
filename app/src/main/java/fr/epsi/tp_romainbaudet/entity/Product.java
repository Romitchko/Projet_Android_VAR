package fr.epsi.tp_romainbaudet.entity;

public class Product {

    private String name, description, picture_url;

    public Product(String Nom, String Description, String Image) {
        this.name = Nom;
        this.description = Description;
        this.picture_url = Image;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getPicture_url() {
        return picture_url;
    }
}
