package br.edu.ifrs.canoas.jee.jpaapp.pojo;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifrs.canoas.jee.jpaapp.util.EntityManagerUtil;

public class UsuarioTest {

	private EntityManager em;

	@Before
	public void setup() {
		em = EntityManagerUtil.getEM();
	}

	@Test
	public void testa_a_persistencia_do_usuario_em_branco () {
		Usuario usuario = new Usuario();

		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();

		assertThat(usuario.getId()).isNotNull();
	}

	@Test
	public void testa_a_persistencia_de_usuario_com_valor() {
		// construtor deve ter email, senha, endereco
		Usuario usuario = new Usuario("email.do@usuario.com", "Senha_Do_Usuario", "Endereco do Usuario");

		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();

		assertThat(usuario.getId()).isNotNull();
		assertThat(usuario.getEndereco()).isEqualTo("Endereco do Usuario");
	}

}