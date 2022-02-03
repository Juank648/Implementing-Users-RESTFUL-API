package com.restfulapi.springboot.controller;

import com.restfulapi.springboot.data.User;
import com.restfulapi.springboot.dto.UserDto;
import com.restfulapi.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/v1/user" )
public class UserController {
    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable String id ) {
        try {
            return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDto userDto ) {
        return new ResponseEntity<> (userService.create(new User(userDto.getName(), userDto.getEmail(), userDto.getLastName())), HttpStatus.ACCEPTED);
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id ) {
        User user = userService.findById(id);
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setLastName(userDto.getEmail());
        return new ResponseEntity<>(userService.update(user, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        try {
            userService.deleteById(id);
            return new ResponseEntity <>(true, HttpStatus.ACCEPTED);

        } catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.ACCEPTED);
        }
    }
}
