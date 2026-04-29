package br.com.solutis.dao;

import br.com.solutis.entity.Impresso;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ImpressoDao {
    private final EntityManager em;

    public ImpressoDao(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Impresso impresso){
        this.em.getTransaction().begin();
        boolean existeComTitulo = this.em.createQuery
                        ("select count(i) from Impresso i where i.titulo = :titulo",
                Long.class)
                .setParameter("titulo", impresso.getTitulo()).getSingleResult() > 0;

        if (existeComTitulo) {
            System.out.println("Já existe o livro cadastrado");
            this.em.close();
            return;
        }

        this.em.persist(impresso);
        this.em.getTransaction().commit();
        this.em.close();
    }

    public List<Impresso> listar(){
        return this.em.createQuery("select i from Impresso i", Impresso.class)
                .getResultList();
    }

    public Impresso encontrarPorId(Integer id){
        return this.em.find(Impresso.class, id);
    }

    public void vender(Integer id){
        this.em.getTransaction().begin();

        Impresso impresso = this.em.find(Impresso.class, id);
        impresso.atualizarEstoque();

        this.em.getTransaction().commit();
        this.em.close();
    }

    public void registrarNaVenda(Impresso impresso){
        this.em.getTransaction().begin();

        this.em.merge(impresso);

        this.em.getTransaction().commit();
        this.em.close();
    }
}
