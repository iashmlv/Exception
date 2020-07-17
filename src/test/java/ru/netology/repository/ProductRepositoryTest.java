package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book book1 = new Book(1065, "Dune", 844, "Herbert", 884, 1965);
    private Product product1 = new Product(4338, "Wire", 765);
    private TShirt tshirt1 = new TShirt(8792, "UA Hunt", 1499, "camo", "L");

    @BeforeEach
    public void setUp() {
        repository.save(book1);
        repository.save(product1);
        repository.save(tshirt1);
    }

    @Test
    public void removeByIdExisted() {
        repository.removeById(4338);
        Product[] expected = new Product[]{book1, tshirt1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdException() {
        assertThrows(NotFoundException.class, () -> repository.removeById(1156));
    }



}