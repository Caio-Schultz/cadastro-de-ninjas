package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    // adicionar missão (CREATE)
    @PostMapping("/criar")
    public String criarMissoes(){
        return "Missões adicionadas";
    }

    // mostrar todas as missões (READ)
    @GetMapping("/todas")
    public String mostrarTodasAsMissoes(){
        return "Todas as missões mostradas";
    }

    // mostrar missão por id (READ)
    @GetMapping("/todasId")
    public String mostrarMissaoPorId(){
        return "Missão por id mostrada";
    }

    // alterar dados da missão por id (UPDATE)
    @PutMapping("/alterarId")
    public String alterarMissaoPorId(){
        return "Missão alterada";
    }

    // deletar missão por id (DELETE)
    @DeleteMapping("/deletarId")
    public String deletarMissaoPorId(){
        return "Missão deletada";
    }

}
