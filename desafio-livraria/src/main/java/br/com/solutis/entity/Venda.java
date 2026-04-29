package br.com.solutis.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Venda {

    private static int numVendas;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;

    private String cliente;

    private float valor;

    @ManyToMany(mappedBy = "vendas")
    private List<Impresso> livrosImpressos = new ArrayList<>();

    @ManyToMany(mappedBy = "vendas")
    private List<Eletronico> livrosEletronicos = new ArrayList<>();

    public void addLivroImpresso(Impresso i, int index){
        livrosImpressos.add(index, i);
        i.getVendas().add(this);
    }

    public void addLivroEletronico(Eletronico e, int index){
        livrosEletronicos.add(index, e);
    }

    public void listarLivros(){
        System.out.println(livrosImpressos);
        System.out.println(livrosEletronicos);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public List<Impresso> getLivrosImpressos() {
        return livrosImpressos;
    }

    public void setLivrosImpressos(List<Impresso> livrosImpressos) {
        this.livrosImpressos = livrosImpressos;
    }

    public List<Eletronico> getLivrosEletronicos() {
        return livrosEletronicos;
    }

    public void setLivrosEletronicos(List<Eletronico> livrosEletronicos) {
        this.livrosEletronicos = livrosEletronicos;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "numero=" + numero +
                ", cliente='" + cliente + '\'' +
                ", valor=" + valor +
                '}';
    }
}
