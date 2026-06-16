package com.rpgapi.gerador_nomes_rpg.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "name_parts")
public class NamePart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    @Enumerated(EnumType.STRING)
    private Race race;

    @Enumerated(EnumType.STRING)
    private NameType type;

    public String getValue() {
        return value;
    }
}
