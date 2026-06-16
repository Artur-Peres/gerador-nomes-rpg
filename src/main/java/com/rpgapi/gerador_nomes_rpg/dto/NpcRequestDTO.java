package com.rpgapi.gerador_nomes_rpg.dto;

import com.rpgapi.gerador_nomes_rpg.model.Occupation;
import com.rpgapi.gerador_nomes_rpg.model.Personality;
import com.rpgapi.gerador_nomes_rpg.model.Race;
import com.rpgapi.gerador_nomes_rpg.model.RpgClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NpcRequestDTO {
    private Race race;
    private RpgClass rpgClass;
    private Occupation occupation;
    private Personality personality;
}


