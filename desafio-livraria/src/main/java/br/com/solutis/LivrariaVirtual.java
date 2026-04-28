package br.com.solutis;

import br.com.solutis.dao.EletronicoDao;
import br.com.solutis.dao.ImpressoDao;
import br.com.solutis.dao.VendasDao;
import br.com.solutis.entity.Eletronico;
import br.com.solutis.entity.Impresso;
import br.com.solutis.entity.Venda;
import br.com.solutis.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LivrariaVirtual {
    private final int MAX_IMPRESSOS = 10;
    private final int MAX_ELETRONICOS = 20;
    private final int MAX_VENDAS = 50;
    private static int numImpressos = 0;
    private static int numEletronicos = 0;
    private static int numVendas = 0;
    private List<Impresso> impressos = new ArrayList<>();
    private List<Eletronico> eletronicos = new ArrayList<>();
    private List<Venda> vendas = new ArrayList<>();

    public void cadastrarLivro(Impresso impresso){
        EntityManager em = JPAUtil.getEntityManager();
        ImpressoDao dao = new ImpressoDao(em);

        dao.cadastrar(impresso);
    }

    public void cadastrarLivro(Eletronico eletronico){
        EntityManager em = JPAUtil.getEntityManager();
        EletronicoDao dao = new EletronicoDao(em);

        dao.cadastrar(eletronico);
    }

    public void realizarVenda(Venda venda){
        EntityManager em = JPAUtil.getEntityManager();
        VendasDao dao = new VendasDao(em);

        dao.cadastrar(venda);
    }

    public void listarLivrosImpressos(){
        EntityManager em = JPAUtil.getEntityManager();
        ImpressoDao dao = new ImpressoDao(em);

        impressos = dao.listar();

        System.out.println(impressos);
    }

    public void listarLivrosEletronicos(){
        EntityManager em = JPAUtil.getEntityManager();
        EletronicoDao dao = new EletronicoDao(em);

        eletronicos = dao.listar();

        System.out.println(eletronicos);
    }

    public void listarLivros(){
        listarLivrosImpressos();
        listarLivrosEletronicos();
    }

    public void listarVendas(){
        EntityManager em = JPAUtil.getEntityManager();
        VendasDao dao = new VendasDao(em);

        vendas = dao.listar();

        System.out.println(vendas);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LivrariaVirtual view = new LivrariaVirtual();

        while (true){
            System.out.println("BOAS VINDAS À LIVRARIA DIGITAL");
            System.out.println("Escolha uma opção.");
            System.out.println("Digite 1 para Cadastrar livro");
            System.out.println("Digite 2 para Realizar venda");
            System.out.println("Digite 3 para listar livros");
            System.out.println("Digite 4 para listar vendas");
            System.out.println("Digite 5 para sair");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao){
                case 1:
                    System.out.println("Escolha o tipo do livro para cadastrar");
                    System.out.println("Digite 1 para impresso");
                    System.out.println("Digite 2 para eletrônico");
                    System.out.println("Digite 3 para ambos");

                    int opcaoLivro = Integer.parseInt(scanner.nextLine());

                    switch (opcaoLivro){
                        case 1:
                            Impresso impresso = new Impresso();
                            System.out.print("Digite o título do livro: ");
                            impresso.setTitulo(scanner.nextLine());

                            System.out.print("Digite os autores do livro: ");
                            impresso.setAutores(scanner.nextLine());

                            System.out.print("Digite a editora do livro: ");
                            impresso.setEditora(scanner.nextLine());

                            System.out.print("Digite o preço do livro: ");
                            impresso.setPreco(Float.parseFloat(scanner.nextLine()));

                            System.out.print("Digite o frete do livro: ");
                            impresso.setFrete(Float.parseFloat(scanner.nextLine()));

                            System.out.print("Digite a quantidade em estoque do livro: ");
                            impresso.setEstoque(Integer.parseInt(scanner.nextLine()));

                            view.cadastrarLivro(impresso);
                    }
            }
        }
    }
}
