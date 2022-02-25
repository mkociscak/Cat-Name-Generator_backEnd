package com.cat.catcharacter.service;


import com.cat.catcharacter.exceptions.InformationNotFoundException;
import com.cat.catcharacter.model.Character;
import com.cat.catcharacter.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    private CharacterRepository characterRepository;

    @Autowired
    public void setCharacterRepository(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    //getAllCharacters
    public List<Character> getAllCharacters() {
        System.out.println("getting all Characters");
        return characterRepository.findAll();
    }

    //getCharacter
    public Optional getCharacter(Long characterId) {
        Optional character = characterRepository.findById(characterId);
        System.out.println("getting one Character ==>");
        if (character.isPresent()) {
            return character;
        } else {
            throw new InformationNotFoundException("character with id " + characterId + " not found");
        }
    }


    // create

    // update

    // delete
}



