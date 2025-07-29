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
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao){
        return missoesService.criarMissao(missao);
    }

    // mostrar todas as missões (READ)
    @GetMapping("/listar")
    public List<MissoesDTO> listarMissoes(){
        return missoesService.listarMissoes();
    }

    // mostrar missão por id (READ)
    @GetMapping("/listar/{id}")
    public MissoesDTO listarMissaoPorId(@PathVariable Long id){
        return missoesService.listarMissaoPorId(id);
    }

    // alterar dados da missão por id (UPDATE)
    @PutMapping("/atualizar/{id}")
    public MissoesDTO atualizarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missao){
        return missoesService.atualizarMissaoPorId(id, missao);
    }

    // deletar missão por id (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoPorId(@PathVariable Long id) {
        missoesService.deletarMissaoPorId(id);
    }

}
