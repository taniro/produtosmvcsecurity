package tads.eaj.br.produtosmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.br.produtosmvc.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
