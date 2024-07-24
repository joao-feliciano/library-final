package com.servlet.login.loginservletexample.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String title;

    @Column(length = 50)
    private String author;

    @Column
    private Double price;

    // Construtor adicional para facilitar a criação de novos livros
    public Book(String title, String author, Double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
