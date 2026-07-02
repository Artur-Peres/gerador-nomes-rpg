package com.rpgapi.gerador_nomes_rpg.service;

import com.rpgapi.gerador_nomes_rpg.dto.NpcRequestDTO;
import com.rpgapi.gerador_nomes_rpg.dto.NpcResponseDTO;
import com.rpgapi.gerador_nomes_rpg.model.Npc;
import com.rpgapi.gerador_nomes_rpg.model.Occupation;
import com.rpgapi.gerador_nomes_rpg.model.Personality;
import com.rpgapi.gerador_nomes_rpg.model.Race;
import com.rpgapi.gerador_nomes_rpg.model.RpgClass;
import com.rpgapi.gerador_nomes_rpg.repository.NpcRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class NpcService {
    private final NpcRepository npcRepository;
    private final NameGeneratorService nameGeneratorService;

    private final Random random = new Random();

    public NpcService(NpcRepository npcRepository, NameGeneratorService nameGeneratorService) {
        this.npcRepository = npcRepository;
        this.nameGeneratorService = nameGeneratorService;
    }

    public NpcResponseDTO randomGenerateNpc() {

        Race race = randomRace();

        String name =
                nameGeneratorService.generateName(race);

        RpgClass rpgClass =
                randomEnum(RpgClass.values());

        Personality personality =
                randomEnum(Personality.values());

        Occupation occupation =
                randomEnum(Occupation.values());

        Npc npc = new Npc(
                name,
                race,
                rpgClass,
                occupation,
                personality

        );

        return toResponseDTO(npcRepository.save(npc));
    }

    public NpcResponseDTO generateNpc(
            NpcRequestDTO request
    ) {

        Race race = request.getRace();

        RpgClass rpgClass =
                request.getRpgClass() != null ? request.getRpgClass(): randomEnum(RpgClass.values());

        Personality personality =
                request.getPersonality() != null ? request.getPersonality(): randomEnum(Personality.values());

        Occupation occupation =
                request.getOccupation() != null ? request.getOccupation() : randomEnum(Occupation.values());

        String name =
                nameGeneratorService.generateName(race);

        Npc npc = new Npc(
                name,
                race,
                rpgClass,
                occupation,
                personality
        );

        return toResponseDTO(npcRepository.save(npc));
    }

    private NpcResponseDTO toResponseDTO(Npc npc) {

        return new NpcResponseDTO(
                npc.getId(),
                npc.getName(),
                npc.getRace(),
                npc.getRpgClass(),
                npc.getOccupation(),
                npc.getPersonality()
        );
    }

    public List<NpcResponseDTO> findAll() {
        return npcRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public NpcResponseDTO findById(Long id) {
        Npc npc = npcRepository.findById(id).orElseThrow(() -> new RuntimeException("NPC não encontrado"));
        return toResponseDTO(npc);
    }

    private Race randomRace() {
        return randomEnum(Race.values());
    }

    private <T> T randomEnum(T[] values) {
        return values[random.nextInt(values.length)];
    }
}
