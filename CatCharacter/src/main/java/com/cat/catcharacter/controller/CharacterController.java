package com.cat.catcharacter.controller;

import com.cat.catcharacter.model.Character;
import com.cat.catcharacter.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping(path = "/api")
public class CharacterController {

    private CharacterService characterService;

    @Autowired
    public void setCharacterService(CharacterService characterService) {
        this.characterService = characterService;
    }


    //getAllCharacters
    //endpoint http://localhost:9092/api/character/getAll
    @GetMapping(path = "/character/getAll")
    public List<Character> getAllCharacters() {
        System.out.println("getting all Characters");
        return characterService.getAllCharacters();
    }

    //getCharacter
    @GetMapping(path = "/character/{characterId}")
    public Optional getCharacter(@PathVariable Long characterId) {
        System.out.println("getting one Character ==>");
        return characterService.getCharacter(characterId);

    }

}
