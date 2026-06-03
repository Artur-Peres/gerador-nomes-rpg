package com.rpgapi.gerador_nomes_rpg.repository;

import com.rpgapi.gerador_nomes_rpg.model.NamePart;
import com.rpgapi.gerador_nomes_rpg.model.NameType;
import com.rpgapi.gerador_nomes_rpg.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NamePartRepository extends JpaRepository<NamePart, Long> {
    List<NamePart> findByRaceAndType(Race race, NameType type);
}
