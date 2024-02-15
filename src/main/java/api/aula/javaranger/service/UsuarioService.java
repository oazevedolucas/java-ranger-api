package api.aula.javaranger.service;


import api.aula.javaranger.entity.Usuario;
import api.aula.javaranger.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void criarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodosUsuarios(){
        return usuarioRepository.findAll();
    }

    public void excluirUsuarioPorId(Integer id){
        usuarioRepository.deleteById(id);
    }
}