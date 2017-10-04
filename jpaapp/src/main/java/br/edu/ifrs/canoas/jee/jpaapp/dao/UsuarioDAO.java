package br.edu.ifrs.canoas.jee.jpaapp.dao;

import java.util.ArrayList;
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
    	em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
    	
    }

    public void atualiza(Usuario usuario) {
    			
    	em = EntityManagerUtil.getEM();
    	em.getTransaction().begin();
    	em.merge(usuario);
    	em.getTransaction().commit();
    	em.close();
    	
    }

    public void remove(Long id) {
    	em = EntityManagerUtil.getEM();
    	em.getTransaction().begin();
    	em.remove(em.find(Usuario.class, id));
    	em.getTransaction().commit();
    	em.close();
    	
    }

    public Usuario busca(Long id) {
    	em = EntityManagerUtil.getEM();
    	Usuario usuario;
    	usuario = em.find(Usuario.class, id);
    	em.close();
    	return usuario;

    }

    public List<Usuario> busca() {
    	List <Usuario> usr = new ArrayList<Usuario>();
    	
    	em = EntityManagerUtil.getEM();
    	TypedQuery<Usuario> query = em.createQuery("select usr from Usuario usr", Usuario.class);
   
    	usr = query.getResultList();
    	em.close();
    	
    	return usr;
    }

    public List<Usuario> buscaPorEmail(String email) {
    	List <Usuario> usr = new ArrayList<Usuario>();
    	
        em = EntityManagerUtil.getEM();
    	TypedQuery<Usuario> query = em.createQuery("select usr from Usuario where usr.email = :email", Usuario.class);
    	query.setParameter("email", email);
    	usr = query.getResultList();
    	em.close();
    	
    	return usr;
    }
    
}