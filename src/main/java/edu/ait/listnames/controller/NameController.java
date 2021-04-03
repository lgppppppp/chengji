package edu.ait.listnames.controller;

import java.util.List;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.dao.EmptyResultDataAccessException;

import edu.ait.listnames.dto.Name;
import edu.ait.listnames.repository.NameRepository;
import edu.ait.listnames.exceptions.NameNotFoundException;

@RestController
public class NameController {
  
  @Autowired
  NameRepository nameRepository;

  @GetMapping("names")
  public List<Name> getNames() {
    return nameRepository.findAll();
  }

  @PostMapping("names/")
  public ResponseEntity createName(@RequestBody Name newName) {
    nameRepository.save(newName);
    URI location = ServletUriComponentsBuilder
              .fromCurrentRequest().path("{id}")
              .buildAndExpand(newName.getId()).toUri();
    return ResponseEntity.created(location).build();
  } 

  @PutMapping("names/")
  public ResponseEntity updateName(@RequestBody Name newName) {
    if (newName.getId() != null) {
      nameRepository.save(newName);
      return ResponseEntity.status(HttpStatus.OK).build();
    } else {
      nameRepository.save(newName);
      URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{id}")
                .buildAndExpand(newName.getId()).toUri();
      return ResponseEntity.created(location).build();                
    }
  }

  @DeleteMapping("names/{nameId}")
  public ResponseEntity deleteNameById(@PathVariable(value = "nameId") Integer nameId)  {
    try {
      nameRepository.deleteById(nameId);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // send a 204 status code rather than the normal 200
    } catch (EmptyResultDataAccessException e) {
      throw new NameNotFoundException("Unable to delete name with id: " + nameId);
    }  
  }

}
