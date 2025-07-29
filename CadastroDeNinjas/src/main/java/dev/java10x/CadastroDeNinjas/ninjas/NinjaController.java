package dev.java10x.CadastroDeNinjas.ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/api")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    // @RequestBody indica que é necessário passar no corpo da requisição POST um Json com os atributos (colunas) do ninja para ser adicionado
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID = " + novoNinja.getId() + ")");
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<?> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        if(!ninjas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ninjas);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não há nenhum ninja na lista");
        }
    }

    // Mostrar ninja por Id (READ)
    // Quando colocamos algo entre {} está sendo passado um "path variable", ou seja, algo que o usuário passa para complementar a url. Nesse caso, o id do ninja que o usuário quer listar
    // Temos que colocar a anotation @PathVariable para indicar justamente o que será o path variable
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id){
        if(ninjaService.listarNinjaPorId(id) != null) {
            NinjaDTO ninjaListado = ninjaService.listarNinjaPorId(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ninjaListado);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " não corresponde a nenhum ninja!");
        }
    }


    // Alterar dados do ninja por id (UPDATE)
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        if(ninjaService.listarNinjaPorId(id) != null){
            NinjaDTO ninja = ninjaService.atualizarNinjaPorId(id, ninjaAtualizado);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Ninja \"" + ninja.getNome() + "\" atualizado com sucesso!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " não corresponde a nenhum ninja!");
        }

    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if(ninjaService.listarNinjaPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Ninja com o ID " + id + " deletado com sucesso!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ID " + id + " não corresponde a nenhum ninja!");
        }
    }

}
