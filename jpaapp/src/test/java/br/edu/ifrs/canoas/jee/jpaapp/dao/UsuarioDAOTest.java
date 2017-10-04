package br.edu.ifrs.canoas.jee.jpaapp.dao;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import br.edu.ifrs.canoas.jee.jpaapp.pojo.Usuario;

public class UsuarioDAOTest {

	UsuarioDAO usuarioDAO = new UsuarioDAO();

	@Test
	public void testSalvaNovoUsuario() {
		// Cria usuario
		Usuario usuario = new Usuario("email.do@usuario.com", "senha123",
				"endereco");
		// salva no banco
		usuarioDAO.salva(usuario);
		// verifica se salvou
		assertThat(usuario.getEmail()).isEqualTo("email.do@usuario.com");
		assertThat(usuario.getId()).isNotNull();

	}

	@Test
	public void testaBuscaTodosUsuarios() {
		// Cria usuario
		Usuario u1 = new Usuario("email", "senha", "endereco");
		Usuario u2 = new Usuario("email", "senha", "endereco");
		Usuario u3 = new Usuario("email", "senha", "endereco");
		
		usuarioDAO.salva(u1);
		usuarioDAO.salva(u2);
		usuarioDAO.salva(u3);
		List<Usuario> usuarios = usuarioDAO.busca();
		// Deve ter no mínimo 3 usuários no banco
		assertThat(usuarios).size().isEqualTo(4);
	}

	@Test
	public void testaUsuarioPorEmail() {
		Usuario usuario = new Usuario("EMAIL@DO.USUARIO", "senha", "endereco");
		// Cria usuario
		usuarioDAO.salva(usuario);
		
		assertThat(usuario.getEmail()).isEqualTo("EMAIL@DO.USUARIO");
		assertThat(usuario.getId()).isNotNull();

	}
	@Test
	public void testaAtualizaUsuario() {

		Usuario usuario = new Usuario("emailDeAtualizacao", "senha", "endereco");
		// Cria usuario
		usuarioDAO.salva(usuario);
		assertThat(usuario.getId()).isNotNull();
		assertThat(usuario.getEmail()).as("emailDeAtualizacao");
		usuario.setEmail("agora_mudou_o_email");
		usuarioDAO.atualiza(usuario);
		Usuario novoUsuarioRecuperadoDoBanco = usuarioDAO.busca(usuario.getId());
		assertThat(novoUsuarioRecuperadoDoBanco.getEmail()).isEqualTo("agora_mudou_o_email");
	}

	@Test
	public void testaRemoveUsuario() {
		Usuario usuario = new Usuario("emailDeExclusao", "senha", "endereco");
		usuarioDAO.salva(usuario);
		// verifica se salvou com sucesso
		assertThat(usuario.getId()).isNotNull();
		// remove
		usuarioDAO.remove(usuario.getId());
		// remove
		assertThat(usuarioDAO.busca(usuario.getId())).isNull();
		// VERIFICA SE REMOVEU COM SUCESSO
	}

}