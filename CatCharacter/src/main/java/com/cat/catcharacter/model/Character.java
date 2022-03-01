package com.cat.catcharacter.model;

import javax.persistence.*;


@Entity
@Table(name = "character")

public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long characterId;

    @Column
    private String gender;

    @Column
    private String physique;

    @Column
    private String personality;

    @Column
    private String vocal;


    public Character() {
    }

    public Character(Long characterId, String gender, String physique, String personality, String vocal) {
        this.characterId = characterId;
        this.gender = gender;
        this.physique = physique;
        this.personality = personality;
        this.vocal = vocal;
    }

    public Long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Long characterId) {
        this.characterId = characterId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhysique() {
        return physique;
    }

    public void setPhysique(String physique) {
        this.physique = physique;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getVocal() {
        return vocal;
    }

    public void setVocal(String vocal) {
        this.vocal = vocal;
    }



    @Override
    public String toString() {
        return "Character{" +
                "characterId=" + characterId +
                ", gender='" + gender + '\'' +
                ", physique='" + physique + '\'' +
                ", personality='" + personality + '\'' +
                ", vocal='" + vocal + '\'' +
                '}';
    }


}

