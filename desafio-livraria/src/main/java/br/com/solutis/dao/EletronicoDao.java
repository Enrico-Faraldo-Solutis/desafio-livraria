package br.com.solutis.dao;

import br.com.solutis.entity.Eletronico;
import br.com.solutis.entity.Impresso;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EletronicoDao {
    private final EntityManager em;

    public EletronicoDao(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Eletronico eletronico){
        this.em.getTransaction().begin();
        boolean existeComTitulo = this.em.createQuery
                        ("select count(e) from Eletronico e where e.titulo = :titulo",
                                Long.class)
                .setParameter("titulo", eletronico.getTitulo()).getSingleResult() > 0;

        if (existeComTitulo) {
            System.out.println("Já existe o livro cadastrado");
            this.em.close();
            return;
        }
        this.em.persist(eletronico);
        this.em.getTransaction().commit();
        this.em.close();
    }

    public List<Eletronico> listar(){
        return this.em.createQuery("select e from Eletronico e", Eletronico.class)
                .getResultList();
    }

    public Eletronico encontrarPorId(Integer id){
        return this.em.find(Eletronico.class, id);
    }

    public void registrarNaVenda(Eletronico eletronico){
        this.em.getTransaction().begin();

        this.em.merge(eletronico);

        this.em.getTransaction().commit();
        this.em.close();
    }
}
