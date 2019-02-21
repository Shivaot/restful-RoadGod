package com.rest.webservices.restfulwebservices.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

//HATEOAS  HYPER MEDIA AS THE ENGINE OF APPLICATION STATE -> we also supporting links with the specified reques

@RestController
public class UserResources {


    @Autowired
    private userDaoService service;

    @GetMapping("/users")
    public List<user> retrieveAllUsers() {
        return service.findAll();

    }

    @GetMapping("/users/{id}")
    public user retrieveUser(@PathVariable int id) {
        user user  = service.findOne(id);
        if(user==null)
            throw new userNotFoundException("id-" + id );
        //WE'LL IMPLEMENT HATEOAS HERE
        // /all-users/   SERVER_PATH + "/user"

        //Resource means show the data as we as the hateoas stuff
       // Resource<user> resource = new Resource<user>(user);
        //controllerLINKbUILDER is used to link the methods
         //ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
         //resource.add(linkTo.withRel("all-users"));


        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        user user = service.deleteById(id);

        if(user==null)
            throw new userNotFoundException("id-"+ id);
    }


    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody user user) {
        user savedUser = service.Save(user);
      /*  if (user==savedUser)
            throw new userNotFoundException("user-" + user);*/
      /*STATUS OF CREATION
         user/4  user/{id}  savedUser.getId()
         */
        //we need to append the url with that saved user

        //path method helps im APPENDING something in the URL
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        //extension of http entity that adds a STATUS CODE
        return ResponseEntity.created(location).build();
    }


}
