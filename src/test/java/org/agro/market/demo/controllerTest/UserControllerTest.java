package org.agro.market.demo.controllerTest;

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
import org.springframework.test.context.TestPropertySource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        User user = new User(userDto);
        when(userService.create(userDto)).thenReturn(user);

        User response = this.restTemplate.postForObject("http://localhost:" + port + "/v1/user", userDto, User.class);
        verify(userService).create(any(UserDto.class));
    }
}
