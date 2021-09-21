package org.agro.market.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.agro.market.demo.controller.product.dto.ProductDto;
import org.agro.market.demo.repository.ProductRepository;
import org.agro.market.demo.repository.document.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class ProductControllerTest {
	
	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    ProductRepository repository;

    @Test
    public void createProductTest() {

        ProductDto weatherReportDto = new ProductDto("Fertox Insecticida 300ml", 15.900,"Es para matar insectos en plantas", "Fertox",false,"FertoxInsecticida300ml.jpg");
        this.restTemplate.postForObject("http://localhost:" + port + "/v1/product", weatherReportDto, Product.class);
        verify( repository ).save( any( Product.class ) );
    }
    
    @Test
    public void findProductByIdTest() {
    	String productId = "awae-asd45-1dsad";
    	ProductDto productDto = new ProductDto("Fertox Insecticida 300ml", 15.900,"Es para matar insectos en plantas", "Fertox",false,"FertoxInsecticida300ml.jpg");
        Product product = new Product(productDto);
        when( repository.findById(productId) ).thenReturn( Optional.of( product ) );
        Product prd = this.restTemplate.getForObject("http://localhost:" + port + "/v1/product/awae-asd45-1dsad", Product.class);
        Assertions.assertEquals( prd, product );

    }

    @Test
    public void findProductsByNameTest() {
        String productName = "Insecticida";
        List<Product> productsByName= new ArrayList<>();
        //First product
        ProductDto firstProductDto = new ProductDto("Fertox Insecticida 300ml", 15.900,"Es para matar insectos en plantas", "Fertox",false,"FertoxInsecticida300ml.jpg");
        productsByName.add(new Product(firstProductDto));

        //Second product
        ProductDto secondProductDto = new ProductDto("Insecticida polivalente", 20.500,"Elimina plagas y ácaros", "CCTR",false,"Insecticidapolivalente.jpg");
        productsByName.add(new Product(secondProductDto));

        //Thrid product
        ProductDto thirdProductDto = new ProductDto("Estiércol de caballo", 8.500,"Restaura los niveles de nutrientes", "EDSC",false,"Estiercolcaballo.jpg");
        productsByName.add(new Product(thirdProductDto));
        when( repository.findAll() ).thenReturn( productsByName );
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/v1/product/name/" + productName, List.class).size()).isEqualTo(2);
    }
}
