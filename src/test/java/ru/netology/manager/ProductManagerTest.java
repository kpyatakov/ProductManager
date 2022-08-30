package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book product1 = new Book(1, "Horror1", 700, "Hell666");
    Book product2 = new Book(2, "Horror2", 900, "Hell777");
    Smartphone product3 = new Smartphone(3, "Iphone11", 40_000, "Apple");
    Smartphone product4 = new Smartphone(4, "GalaxyA", 20_000, "Samsung");


    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
    }

    @Test
    public void shouldSearchByName() {
        Product[] expected = {product1, product2};
        Product[] actual = manager.searchBy("Horror");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameWithoutCompliance() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Tree");
        Assertions.assertArrayEquals(expected, actual);
    }
}