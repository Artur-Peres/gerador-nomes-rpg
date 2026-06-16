package com.rpgapi.gerador_nomes_rpg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Entity
@Getter
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

    public Npc() {
    }

    public Npc(String name, Race race, RpgClass rpgClass, Occupation occupation, Personality personality) {
        this.name = name;
        this.race = race;
        this.rpgClass = rpgClass;
        this.occupation = occupation;
        this.personality = personality;
    }
}
