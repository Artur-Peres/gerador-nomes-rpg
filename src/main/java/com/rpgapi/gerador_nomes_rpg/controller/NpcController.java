package com.rpgapi.gerador_nomes_rpg.controller;

import com.rpgapi.gerador_nomes_rpg.dto.NpcRequestDTO;
import com.rpgapi.gerador_nomes_rpg.dto.NpcResponseDTO;
import com.rpgapi.gerador_nomes_rpg.service.NpcService;
import com.rpgapi.gerador_nomes_rpg.model.Npc;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/npc")
public class NpcController {

    private final NpcService npcService;

    public NpcController(NpcService npcService) {
        this.npcService = npcService;
    }
    @GetMapping("/random")
    public NpcResponseDTO generateNpc(){
        return npcService.randomGenerateNpc();
    }

    @PostMapping("/generate")
    public NpcResponseDTO generateNpc(@RequestBody NpcRequestDTO request){
        return npcService.generateNpc(request);
    }

    @GetMapping("/allnpcs")
    public List<NpcResponseDTO> getAllNpcs(){
        return npcService.findAll();
    }

    @GetMapping("/{id}")
    public NpcResponseDTO getNpcById(@PathVariable("id") Long id){
        return npcService.findById(id);
    }
}