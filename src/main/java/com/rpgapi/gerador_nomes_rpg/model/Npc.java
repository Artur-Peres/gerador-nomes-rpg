package com.rpgapi.gerador_nomes_rpg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Npc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Race race;

    @Enumerated(EnumType.STRING)
    private RpgClass rpgClass;

    @Enumerated(EnumType.STRING)
    private Occupation occupation;

    @Enumerated(EnumType.STRING)
    private Personality personality;

    public Npc(String name, Race race, RpgClass rpgClass, Occupation occupation, Personality personality) {
        this.name = name;
        this.race = race;
        this.rpgClass = rpgClass;
        this.occupation = occupation;
        this.personality = personality;
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public RpgClass getRpgClass() {
        return rpgClass;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public Personality getPersonality() {
        return personality;
    }
}
