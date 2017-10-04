package br.edu.ifrs.canoas.jee.jpaapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifrs.canoas.jee.jpaapp.pojo.Mensagem;
import br.edu.ifrs.canoas.jee.jpaapp.util.EntityManagerUtil;

public class MensagemDAO {

    private EntityManager em;

    public MensagemDAO() {
    	
    }

    public void salva(Mensagem mensagem) {
    	em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.persist(mensagem);
		em.getTransaction().commit();
		em.close();
    	
    }

    public void atualiza(Mensagem mensagem) {
    			
    	em = EntityManagerUtil.getEM();
    	em.getTransaction().begin();
    	em.merge(mensagem);
    	em.getTransaction().commit();
    	em.close();
    	
    }

    public void remove(Long id) {
    	em = EntityManagerUtil.getEM();
    	em.getTransaction().begin();
    	em.remove(em.find(Mensagem.class, id));
    	em.getTransaction().commit();
    	em.close();
    	
    }

    public Mensagem busca(Long id) {
    	em = EntityManagerUtil.getEM();
    	Mensagem mensagem;
    	mensagem = em.find(Mensagem.class, id);
    	em.close();
    	return mensagem;

    }

    public List<Mensagem> busca() {
    	List <Mensagem> msg = new ArrayList<Mensagem>();
    	
    	em = EntityManagerUtil.getEM();
    	TypedQuery<Mensagem> query = em.createQuery("select msg from Mensagem msg", Mensagem.class);
   
    	msg = query.getResultList();
    	em.close();
    	
    	return msg;
    }

    public List<Mensagem> buscaPorTexto(String texto) {
    	List <Mensagem> msg = new ArrayList<Mensagem>();
    	
        em = EntityManagerUtil.getEM();
    	TypedQuery<Mensagem> query = em.createQuery("select msg from Mensagem msg", Mensagem.class);
    	query.setParameter("texto", texto);
    	msg = query.getResultList();
    	em.close();
    	
    	return msg;
    }
    
}