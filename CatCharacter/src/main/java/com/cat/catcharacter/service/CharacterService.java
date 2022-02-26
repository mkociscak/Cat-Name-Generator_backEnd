package com.cat.catcharacter.service;


import com.cat.catcharacter.exceptions.InformationExistsException;
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
//--------------------------------------------

    // create
    public Character createCharacter(Character characterObject) {
        Optional<Character> character = characterRepository.findById(characterObject.getCharacterId());
        System.out.println("creating one Character ==>");
        if (character != null) {
            throw new InformationExistsException("character with id already exists");
        } else {
            return characterRepository.save(characterObject);
        }
    }

    // update
    public Character updateCharacter(Long characterId, Character characterObject) {
        Optional<Character> character = characterRepository.findById(characterId);
        System.out.println("updating one Character ==>");
        if (character.isPresent()) {
            if (characterObject.getCharacterId().equals(character.get().getCharacterId())) {
                System.out.println("Same");
                throw new InformationExistsException("character with id " + characterId + " already exists");
            } else {
                Character updateCharacter = characterRepository.findById(characterId).get();
                updateCharacter.setGender(characterObject.getGender());
                updateCharacter.setPhysique(characterObject.getPhysique());
                updateCharacter.setPersonality(characterObject.getPersonality());
                return characterRepository.save(updateCharacter);
            }
        } else {
            throw new InformationNotFoundException("character with id not found");
        }
    }

    // delete
    public Optional<Character> deleteCharacter(Long characterId) {
        Optional<Character> character = characterRepository.findById(characterId);
        System.out.println("deleting character");

        if (((Optional<?>) character).isPresent()) {
            characterRepository.deleteById(characterId);
            return character;
        } else {
            throw new InformationNotFoundException("character with id not found");
        }
    }

}






