package org.agro.market.demo.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.agro.market.demo.controller.auth.LoginDto;
import org.agro.market.demo.controller.auth.TokenDto;
import org.agro.market.demo.controller.user.dto.UserDto;
import org.agro.market.demo.repository.document.User;
import org.agro.market.demo.service.ProductService;
import org.agro.market.demo.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.agro.market.demo.controller.product.dto.ProductDto;
import org.agro.market.demo.repository.document.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    UserService userService;

    @MockBean
    ProductService productService;

    String validToken;


    @BeforeAll
    public void setup() {
        UserDto userDto = new UserDto("marcos.chia@mail.escuelaing.edu.co", "La_prueb4", "C");
        User newUser = new User(userDto);
        newUser.setId("6147ba24b19c0a36090b8dcb");
        when(userService.findByEmail("marcos.chia@mail.escuelaing.edu.co")).thenReturn(newUser);

        LoginDto loginDto = new LoginDto("marcos.chia@mail.escuelaing.edu.co", "La_prueb4");
        String url = "http://localhost:" + port + "/v1/auth";
        validToken = this.restTemplate.postForObject(url, loginDto, TokenDto.class).getToken();
    }

    @Test
    public void createProductTest() throws Exception{
        ProductDto productDto = new ProductDto("Fertox Insecticida 300ml", 15.900, "Es para matar insectos en plantas", "Fertox", false, "FertoxInsecticida300ml.jpg");
        Product product = new Product(productDto);
        when(productService.createProduct(productDto)).thenReturn(product);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(validToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        String stringObject = mapper.writeValueAsString(productDto);
        HttpEntity<String> request = new HttpEntity<>(stringObject, headers);

        ResponseEntity<Product> productResponse = this.restTemplate.exchange("http://localhost:" + port + "/v1/product", HttpMethod.POST, request, Product.class);
        assertEquals(productResponse.getStatusCode().OK,HttpStatus.OK);
    }

    @Test
    public void findProductByIdTest() {
        String productId = "awae-asd45-1dsad";
        ProductDto productDto = new ProductDto("Fertox Insecticida 300ml", 15.900, "Es para matar insectos en plantas", "Fertox", false, "FertoxInsecticida300ml.jpg");
        Product product = new Product(productDto);
        when(productService.findProductById(productId)).thenReturn(product);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(validToken);
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<Product> productResponse = this.restTemplate.exchange("http://localhost:" + port + "/v1/product/"+productId, HttpMethod.GET, request, Product.class);
        assertEquals(productResponse.getBody().getId(), product.getId());
    }

    @Test
    public void findProductsByNameTest() {
        String productName = "Insecticida";
        List<Product> productsByName = new ArrayList<>();
        //First product
        ProductDto firstProductDto = new ProductDto("Fertox Insecticida 300ml", 15.900, "Es para matar insectos en plantas", "Fertox", false, "FertoxInsecticida300ml.jpg");
        productsByName.add(new Product(firstProductDto));

        //Second product
        ProductDto secondProductDto = new ProductDto("Insecticida polivalente", 20.500, "Elimina plagas y ácaros", "CCTR", false, "Insecticidapolivalente.jpg");
        productsByName.add(new Product(secondProductDto));
        when(productService.findProductsByname(productName)).thenReturn(productsByName);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(validToken);
        HttpEntity<String> request = new HttpEntity<>(headers);

        assertThat(this.restTemplate.exchange("http://localhost:" + port + "/v1/product/name/"+productName, HttpMethod.GET, request, new ParameterizedTypeReference<List<Product>>() { }).getBody().size()).isEqualTo(2);
    }

    @Test
    public void getAllProductsTest() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Fertox Insecticida 300ml", 15.900, "Es para matar insectos en plantas", "Fertox", false, "FertoxInsecticida300ml.jpg"));
        products.add(new Product("Ferten Insecticida 500ml", 18.200, "Es para matar plagas en plantas", "Ferten", false, "FertenInsecticida500ml.jpg"));
        when(productService.getAllProducts()).thenReturn(products);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(validToken);
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<List<Product>> productListResponse = this.restTemplate.exchange("http://localhost:" + port + "/v1/product", HttpMethod.GET, request, new ParameterizedTypeReference<List<Product>>() { });
        Assertions.assertEquals(productListResponse.getBody().size(), products.size());
    }

    @Test
    public void updateProductByIdTest() throws Exception {
        Product product= new Product( "Fertox Insecticida 300ml", 15.900,"Es para matar insectos en plantas", "Fertox",false,"FertoxInsecticida300ml.jpg");
        String productId = "awae-asd45-1dsad";
        ProductDto productDto = new ProductDto("Ferten Insecticida 500ml", 18.200,"Es para matar plagas en plantas", "Ferten",false,"FertenInsecticida500ml.jpg");
        product.setPrice(18.200);
        when(productService.updateProductById(productDto,productId)).thenReturn(product);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(validToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        String stringObject = mapper.writeValueAsString(productDto);
        HttpEntity<String> request = new HttpEntity<>(stringObject, headers);

        ResponseEntity<Product> response = this.restTemplate.exchange("http://localhost:" + port + "/v1/product/"+productId, HttpMethod.PUT, request, Product.class);
        Assertions.assertEquals(response.getStatusCode().OK,HttpStatus.OK);
    }

    @Test
    public void deleteProductByIdTest() {
        Product product = new Product("Fertox Insecticida 300ml", 15.900, "Es para matar insectos en plantas", "Fertox", false, "FertoxInsecticida300ml.jpg");
        String productId = "awae-asd45-1dsad";
        when(productService.deleteProductById(productId)).thenReturn(true);

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(validToken);
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<Boolean> response = this.restTemplate.exchange("http://localhost:" + port + "/v1/product/"+productId, HttpMethod.DELETE, request, Boolean.class);
        assertTrue(response.getBody());
    }
}
