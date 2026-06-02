import com.rpgapi.gerador_nomes_rpg.Service.NpcService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Npc generateNpc(){
        return npcService.generateAndSaveNpc();
    }
    @GetMapping
    public List<Npc> getAllNpcs(){
        return npcService.getAllNpcs();
    }

    @GetMapping("/id")
    public Npc getNpcById(@PathVariable Long id){
        return npcService.getNpcById(id);
    }
}