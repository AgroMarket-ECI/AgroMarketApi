package org.agro.market.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.agro.market.demo.controller.user.dto.UserDto;
import org.agro.market.demo.repository.document.User;
import org.agro.market.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@TestPropertySource("classpath:test.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    UserService userService;

    @Test
    public void shouldReturnUserCreated()
            throws Exception {
        UserDto userDto = new UserDto("marcos.chia@mail.escuelaing.edu.co","La_prueb4","C");
        this.restTemplate.postForObject("http://localhost:" + port + "/v1/user", userDto, User.class);
        verify(userService).create(any(UserDto.class));
    }
}
