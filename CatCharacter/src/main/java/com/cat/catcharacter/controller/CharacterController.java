package com.cat.catcharacter.controller;

import com.cat.catcharacter.model.Character;
import com.cat.catcharacter.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        System.out.println("getting one Character...");
        return characterService.getCharacter(characterId);
    }
//--------------------------------------------

    // create
    @PostMapping("/character/")
    public Character createCharacter(@RequestBody Character characterObject) {
        System.out.println("creating Character...");
        return characterService.createCharacter(characterObject);
    }

    // update
    @PutMapping(path = "/character/{characterId}")
    public Character updateCharacter(@PathVariable(value = "characterId") Long characterId, @RequestBody Character characterObject) {
        System.out.println("updating Character...");
        return characterService.updateCharacter(characterId, characterObject);
    }

    // delete
    @DeleteMapping(path = "/character/{characterId}")
    public Optional<Character> deleteCharacter(@PathVariable(value = "characterId") Long characterId) {
        System.out.println("deleting Character...");
        return characterService.deleteCharacter(characterId);
    }


}