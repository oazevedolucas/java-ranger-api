package api.aula.javaranger.controller;

import api.aula.javaranger.entity.Usuario;
import api.aula.javaranger.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> criarUsuario(
            @RequestBody Usuario usuario
    ) {
        usuarioService.criarUsuario(usuario);
       return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listarTodosUsuarios());
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Void> excluirUsuario(
           @PathVariable("usuarioId")  Integer id
    ){
        usuarioService.excluirUsuarioPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
