package com.cat.catcharacter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cat.catcharacter.model.Character;



@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    Character findByCharacterId(Long characterId);
}
