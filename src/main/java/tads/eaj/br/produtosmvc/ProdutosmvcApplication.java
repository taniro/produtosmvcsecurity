package tads.eaj.br.produtosmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tads.eaj.br.produtosmvc.model.Usuario;
import tads.eaj.br.produtosmvc.repository.UsuarioRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ProdutosmvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProdutosmvcApplication.class, args);
    }

    @Autowired
    private UsuarioRepository repository;

    @PostConstruct
    public void initUsers() {

        List<Usuario> users = Stream.of(
                new Usuario(1L, "admin", encoder().encode("admin"), false, false, false, true, true),
                new Usuario(2L, "user1", encoder().encode("user1"), false, false, false, true, false),
                new Usuario(3L, "user2", encoder().encode("user2"), false, false, false, true, false)

        ).collect(Collectors.toList());

        repository.saveAll(users);

    }

    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
