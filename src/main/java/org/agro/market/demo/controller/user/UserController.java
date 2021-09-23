package org.agro.market.demo.controller.user;

import org.agro.market.demo.controller.user.dto.UserDto;
import org.agro.market.demo.repository.document.User;
import org.agro.market.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/v1/user" )
public class UserController
{
	private final UserService userService;

    public UserController( @Autowired UserService userService ) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public User updateById(@RequestBody UserDto userDto, @PathVariable String id) {
        return userService.updateById(userDto, id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable String id) {
        return userService.deleteById(id);
    }

}
