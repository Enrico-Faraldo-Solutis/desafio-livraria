package br.com.solutis.dao;

import br.com.solutis.entity.Impresso;
import br.com.solutis.entity.Venda;
import jakarta.persistence.EntityManager;

import java.util.List;

public class VendasDao {
    private final EntityManager em;

    public VendasDao(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Venda venda){
        this.em.getTransaction();
        this.em.persist(venda);
        this.em.getTransaction().commit();
        this.em.close();
    }

    public List<Venda> listar(){
        return this.em.createQuery("select v from Venda v", Venda.class)
                .getResultList();
    }
}
