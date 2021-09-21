package org.agro.market.demo;

import org.agro.market.demo.controller.product.dto.ProductDto;
import org.agro.market.demo.exception.ProductNotFoundException;
import org.agro.market.demo.repository.ProductRepository;
import org.agro.market.demo.service.ProductService;
import org.agro.market.demo.service.impl.MongoProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.agro.market.demo.repository.document.Product;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestInstance( TestInstance.Lifecycle.PER_CLASS )
public class MongoProductServiceTest {
	ProductService productService;

    @Mock
    ProductRepository repository;

    @BeforeEach()
    public void setup(){
    	productService = new MongoProductService( repository );
    }

    @Test
    void createProductCallsSaveOnRepository(){
    	ProductDto weatherReportDto = new ProductDto("Fertox Insecticida 300ml", 15.900,"Es para matar insectos en plantas", "Fertox",false,"FertoxInsecticida300ml.jpg");
    	productService.createProduct(weatherReportDto);
        verify( repository ).save( any( Product.class ) );
    }
    @Test
    void productIdFoundTest(){
        String productId = "awae-asd45-1dsad";
        Product product = new Product( "Fertox Insecticida 300ml", 15.900,"Es para matar insectos en plantas", "Fertox",false,"FertoxInsecticida300ml.jpg" );
        when( repository.findById(productId) ).thenReturn( Optional.of( product ) );
        Product foundProduct = productService.findProductById( productId );
        Assertions.assertEquals( foundProduct, product );
    }
    @Test
    void productIdNotFoundTest(){
    	String productId = "dsawe1fasdasdoooq123";
        when( repository.findById( productId ) ).thenReturn( Optional.empty() );
        Assertions.assertThrows( ProductNotFoundException.class, () -> {
        	productService.findProductById( productId );
        } );
    }
    @Test
    void productsNameFoundTest(){
        String productName = "Insecticida";
        List<Product> productsByName= new ArrayList<>();
        //First product
        ProductDto firstProductDto = new ProductDto("Fertox Insecticida 300ml", 15.900,"Es para matar insectos en plantas", "Fertox",false,"FertoxInsecticida300ml.jpg");
        Product firstProduct = new Product(firstProductDto);
        productsByName.add(firstProduct);

        //Second product
        ProductDto secondProductDto = new ProductDto("Insecticida polivalente", 20.500,"Elimina plagas y ácaros", "CCTR",false,"Insecticidapolivalente.jpg");
        Product secondProduct = new Product(secondProductDto);
        productsByName.add(secondProduct);

        //Thrid product
        ProductDto thirdProductDto = new ProductDto("Estiércol de caballo", 8.500,"Restaura los niveles de nutrientes", "EDSC",false,"Estiercolcaballo.jpg");
        Product thirdProduct = new Product(thirdProductDto);
        productsByName.add(thirdProduct);
        when( repository.findAll() ).thenReturn( productsByName );
        List<Product> allProductsName = productService.findProductsByname(productName);
        Assertions.assertArrayEquals(allProductsName.toArray(), new Product[]{firstProduct, secondProduct});
    }
    @Test
    void productsNameNotFoundTest(){
        String productName = "Insecticida";
        List<Product> productsByName= new ArrayList<>();
        when( repository.findAll() ).thenReturn( productsByName );
        List<Product> allProductsName = productService.findProductsByname(productName);
        Assertions.assertArrayEquals(allProductsName.toArray(), new Product[]{});
    }

}
