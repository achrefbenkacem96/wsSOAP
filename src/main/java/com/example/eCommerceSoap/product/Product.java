package com.example.eCommerceSoap.product;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Product  {

        @Id
        @SequenceGenerator(
                name = "product_sequence",
                sequenceName =  "product_sequence",
                allocationSize =1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "product_sequence"
        )
        @Column(name = "id")
        private Long id;
        private String title;
        private double price;
        private String description;
        private String category;
        private String image;
    @OneToOne(cascade = CascadeType.ALL)
    private Rating rating;

    public Product() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Rating getRating() {
        return rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Product( String title, double price, String description, String image, String category, Rating rating) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
        this.rating = rating;
    }
}
