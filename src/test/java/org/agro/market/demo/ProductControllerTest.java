package org.agro.market.demo;

import org.assertj.core.api.Assert;
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
    	ProductDto productDto=new ProductDto("Fertox Insecticida 300ml", 15.900,"Es para matar insectos en plantas", "Fertox",false,"FertoxInsecticida300ml.jpg");
        Product product = new Product(productDto);
        when( repository.findById(productId) ).thenReturn( Optional.of( product ) );
        Product prd=this.restTemplate.getForObject("http://localhost:" + port + "/v1/product/awae-asd45-1dsad", Product.class);
        Assertions.assertEquals( prd, product );
    }

    @Test
    public void getAllProductsTest(){
        List<Product> products = new ArrayList<>();
        List<Product> productTets = new ArrayList<>();
        products.add(new Product( "Fertox Insecticida 300ml", 15.900,"Es para matar insectos en plantas", "Fertox",false,"FertoxInsecticida300ml.jpg"));
        products.add(new Product( "Ferten Insecticida 500ml", 18.200,"Es para matar plagas en plantas", "Ferten",false,"FertenInsecticida500ml.jpg"));
        when(repository.findAll()).thenReturn(products);
        productTets = this.restTemplate.getForObject("http://localhost:" + port + "/v1/product", List.class);
        Assertions.assertEquals(productTets.size(), products.size());
    }

    @Test
    public void updateProductByIdTest(){
        Product product= new Product( "Fertox Insecticida 300ml", 15.900,"Es para matar insectos en plantas", "Fertox",false,"FertoxInsecticida300ml.jpg");
        String productId = product.getId();
        when(repository.existsById(productId)).thenReturn(true);
        when(repository.findById(productId)).thenReturn(Optional.of(product));
        ProductDto productDto= new ProductDto("Ferten Insecticida 500ml", 18.200,"Es para matar plagas en plantas", "Ferten",false,"FertenInsecticida500ml.jpg");
        this.restTemplate.put("http://localhost:" + port + "/v1/product/"+productId,productDto);
        Assertions.assertEquals(product.getPrice(),productDto.getPrice());
    }

    @Test
    public void deleteProductByIdTest(){
        Product product= new Product( "Fertox Insecticida 300ml", 15.900,"Es para matar insectos en plantas", "Fertox",false,"FertoxInsecticida300ml.jpg");
        String productId = product.getId();
        when(repository.existsById(productId)).thenReturn(true);
        this.restTemplate.delete("http://localhost:" + port + "/v1/product/"+productId);
        verify(repository).deleteById(productId);
    }
}