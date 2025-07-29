package dev.java10x.CadastroDeNinjas.missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO missaoCriada = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + missaoCriada.getNomeMissao() + " (ID: " + missaoCriada.getId() + ")");
    }

    // mostrar todas as missões (READ)
    @GetMapping("/listar")
    public ResponseEntity<?> listarMissoes(){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        if(!missoes.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(missoes);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não há nenhuma missão na lista");
        }
    }

    // mostrar missão por id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id){
        if(missoesService.listarMissaoPorId(id) != null){
            MissoesDTO missaoListada = missoesService.listarMissaoPorId(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(missaoListada);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " não corresponde a nenhuma missão!");
        }
    }

    // alterar dados da missão por id (UPDATE)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missao){
        if(missoesService.listarMissaoPorId(id) != null){
            MissoesDTO missaoAtualizada = missoesService.atualizarMissaoPorId(id, missao);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Missão \"" + missaoAtualizada.getNomeMissao() + "\" atualizada com sucesso!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " não corresponde a nenhuma missão!");
        }

    }

    // deletar missão por id (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id) {
        if(missoesService.listarMissaoPorId(id) != null){
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Missão com ID " + id + " deletada com sucesso!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " não corresponde a nenhuma missão!");
        }

    }

}
