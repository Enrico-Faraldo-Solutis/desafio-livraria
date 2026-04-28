package br.com.solutis.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "livro_eletronico")
public class Eletronico extends Livro {

    private int tamanho;

    @ManyToMany
    @JoinTable(
            name = "livro_eletronico_vendas",
            joinColumns = @JoinColumn(name = "fk_livro_eletronico"),
            inverseJoinColumns = @JoinColumn(name = "fk_vendas")
    )
    private List<Venda> vendas;

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    @Override
    public String toString() {
        return "Eletronico{" +
                "tamanho=" + tamanho +
                ", vendas=" + vendas +
                "} " + super.toString();
    }
}
