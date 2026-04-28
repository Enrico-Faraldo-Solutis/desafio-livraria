package br.com.solutis.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "livro_impresso")
public class Impresso extends Livro{

    private float frete;

    private int estoque;

    @ManyToMany
    @JoinTable(
            name = "livro_impresso_vendas",
            joinColumns = @JoinColumn(name = "fk_livro_impresso"),
            inverseJoinColumns = @JoinColumn(name = "fk_vendas")
    )
    private List<Venda> vendas;

    public void atualizarEstoque(){
        estoque--;
    }

    public float getFrete() {
        return frete;
    }

    public void setFrete(float frete) {
        this.frete = frete;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    @Override
    public String toString() {
        return "Impresso{" +
                "frete=" + frete +
                ", estoque=" + estoque +
                ", vendas=" + vendas +
                "} " + super.toString();
    }
}
