package br.edu.ifrs.canoas.jee.jpaapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifrs.canoas.jee.jpaapp.pojo.Usuario;
import br.edu.ifrs.canoas.jee.jpaapp.util.EntityManagerUtil;

public class UsuarioDAO {

    private EntityManager em;

    public UsuarioDAO() {
    }

    public void salva(Usuario usuario) {
    }

    public void atualiza(Usuario usuario) {
    }

    public void remove(Long id) {
    }

    public Usuario busca(Long id) {
    	return null;

    }

    public List<Usuario> busca() {
    	return null;

    }

    public List<Usuario> buscaPorEmail(String email) {
    	
    	return null;
    }
}