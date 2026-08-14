package com.rpgapi.gerador_nomes_rpg.controller;

import com.rpgapi.gerador_nomes_rpg.dto.NpcRequestDTO;
import com.rpgapi.gerador_nomes_rpg.dto.NpcResponseDTO;
import com.rpgapi.gerador_nomes_rpg.service.NpcService;
import com.rpgapi.gerador_nomes_rpg.model.Npc;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Tag(name="NPC'S",description = "Gerar ou Consultar NPC'S.")
@RestController
@RequestMapping("/npc")
public class NpcController {

    private final NpcService npcService;

    public NpcController(NpcService npcService) {
        this.npcService = npcService;
    }

    @Operation(summary = "Gera NPC Aleatorio.",description = "Gera NPC com classe,raça,ocupaçao,personalidade totalmente aleatorios.")
    @GetMapping("/random")
    public NpcResponseDTO generateNpc(){
        return npcService.randomGenerateNpc();
    }

    @Operation(summary = "Gera NPC com Raça.",description = "Raça como parametro obrigatorio.")
    @PostMapping("/generate")
    public NpcResponseDTO generateNpc(@RequestBody NpcRequestDTO request){
        return npcService.generateNpc(request);
    }

    @Operation(summary = "Busca NPC'S",description = "busca no banco de dados todos os npcs criados.")
    @GetMapping("/allnpcs")
    public List<NpcResponseDTO> getAllNpcs(){
        return npcService.findAll();
    }

    @Operation(summary = "Busca NPC por ID",description = "busca no banco de dados npcs criados pelo ID.")
    @GetMapping("/{id}")
    public NpcResponseDTO getNpcById(@PathVariable("id") Long id){
        return npcService.findById(id);
    }
}