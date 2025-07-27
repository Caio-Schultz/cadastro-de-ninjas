package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    // adicionar missão (CREATE)
    @PostMapping("/criar")
    public String criarMissoes(){
        return "Missões adicionadas";
    }

    // mostrar todas as missões (READ)
    @GetMapping("/listar")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    // mostrar missão por id (READ)
    @GetMapping("/listar/{id}")
    public MissoesModel listarMissaoPorId(@PathVariable Long id){
        return missoesService.listarMissaoPorId(id);
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
