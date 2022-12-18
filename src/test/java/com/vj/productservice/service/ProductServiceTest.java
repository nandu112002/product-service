package com.vj.productservice.service;

import com.vj.productservice.model.Product;
import com.vj.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    void createProduct() {

    }

    @Test
    void getAllProducts() {
        List<Product> productList = new ArrayList();
        productList.add(Product.builder().name("Apple iWatch").description("Apple iWatch 7 White").price(new BigDecimal(341.75)).id(1L).build());
        productList.add(Product.builder().name("Samsung Watch").description("Samsung Watch 12 Yellow").price(new BigDecimal(41.25)).id(2L).build());

        when(productRepository.findAll()).thenReturn(productList); // mock
        assertEquals(3, productService.getAllProducts().size());
    }
}