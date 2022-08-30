package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {

    Book product1 = new Book(1, "Horror1", 700, "Hell666");
    Book product2 = new Book(2, "Horror2", 900, "Hell777");
    Smartphone product3 = new Smartphone(3, "iPhone11", 40_000, "Apple");
    Smartphone product4 = new Smartphone(4, "GalaxyA", 20_000, "Samsung");

    @Test
    public void shouldSaveProducts() {
        ProductRepository prod = new ProductRepository();
        prod.save(product1);
        prod.save(product2);
        prod.save(product3);
        prod.save(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = prod.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ProductRepository prod = new ProductRepository();
        prod.save(product1);
        prod.save(product2);
        prod.save(product3);
        prod.save(product4);
        prod.removeById(3);

        Product[] expected = {product1, product2, product4};
        Product[] actual = prod.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

 }