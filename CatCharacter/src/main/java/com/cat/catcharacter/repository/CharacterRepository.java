package com.cat.catcharacter.repository;

import com.cat.catcharacter.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Qualifier;
import java.util.List;

@Qualifier(value="Category")
@Repository
public interface CharacterRepository extends JpaRepository <Character, Long> {
    Character getCharacter(Long characterId);

    }


