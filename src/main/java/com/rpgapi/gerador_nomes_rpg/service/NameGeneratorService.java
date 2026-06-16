package com.rpgapi.gerador_nomes_rpg.service;

import com.rpgapi.gerador_nomes_rpg.model.NamePart;
import com.rpgapi.gerador_nomes_rpg.model.NameType;
import com.rpgapi.gerador_nomes_rpg.model.Race;
import com.rpgapi.gerador_nomes_rpg.repository.NamePartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class NameGeneratorService {
    private final NamePartRepository namePartRepository;
    private final Random random = new Random();

    public NameGeneratorService(NamePartRepository namePartRepository) {
        this.namePartRepository = namePartRepository;
    }

    public String generateName(Race race) {

        List<NamePart> prefixes =
                namePartRepository.findByRaceAndType(race, NameType.prefix);

        List<NamePart> suffixes =
                namePartRepository.findByRaceAndType(race, NameType.suffix);

        if (prefixes.isEmpty() || suffixes.isEmpty()) {
            throw new IllegalStateException("Dados não encontrados para raça: " + race);
        }

        String prefix =
                prefixes.get(random.nextInt(prefixes.size())).getValue();

        String suffix =
                suffixes.get(random.nextInt(suffixes.size())).getValue();

        return prefix + suffix;
    }
}
