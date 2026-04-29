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

    public Venda buscarUltimaVenda(){
        EntityManager em = JPAUtil.getEntityManager();
        VendasDao dao = new VendasDao(em);

        return dao.buscarVendas().getLast();
    }

    public void registrarNaVenda(Impresso impresso){
        EntityManager em = JPAUtil.getEntityManager();
        ImpressoDao dao = new ImpressoDao(em);

        dao.registrarNaVenda(impresso);
    }
    public void registrarNaVenda(Eletronico eletronico){
        EntityManager em = JPAUtil.getEntityManager();
        EletronicoDao dao = new EletronicoDao(em);

        dao.registrarNaVenda(eletronico);
    }


    public void venderLivroImpresso(Integer id){
        EntityManager em = JPAUtil.getEntityManager();
        ImpressoDao dao = new ImpressoDao(em);

        dao.vender(id);
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
                            numImpressos++;
                            break;

                        case 2:
                            Eletronico eletronico = new Eletronico();
                            System.out.print("Digite o título do livro: ");
                            eletronico.setTitulo(scanner.nextLine());

                            System.out.print("Digite os autores do livro: ");
                            eletronico.setAutores(scanner.nextLine());

                            System.out.print("Digite a editora do livro: ");
                            eletronico.setEditora(scanner.nextLine());

                            System.out.print("Digite o preço do livro: ");
                            eletronico.setPreco(Float.parseFloat(scanner.nextLine()));

                            System.out.print("Digite o tamanho do livro: ");
                            eletronico.setTamanho(Integer.parseInt(scanner.nextLine()));

                            view.cadastrarLivro(eletronico);
                            numEletronicos++;
                            break;

                        case 3:
                            Impresso impresso1 = new Impresso();
                            Eletronico eletronico1 = new Eletronico();

                            System.out.print("Digite o título do livro: ");
                            String titulo = scanner.nextLine();

                            System.out.print("Digite os autores do livro: ");
                            String autores = scanner.nextLine();

                            System.out.print("Digite a editora do livro: ");
                            String editora = scanner.nextLine();

                            System.out.print("Digite o preço do livro: ");
                            float preco = Float.parseFloat(scanner.nextLine());

                            System.out.print("Digite o frete do livro: ");
                            float frete = Float.parseFloat(scanner.nextLine());

                            System.out.print("Digite a quantidade em estoque do livro: ");
                            int estoque = Integer.parseInt(scanner.nextLine());

                            System.out.print("Digite o tamanho do livro: ");
                            int tamanho = Integer.parseInt(scanner.nextLine());

                            impresso1.setTitulo(titulo);
                            impresso1.setAutores(autores);
                            impresso1.setEditora(editora);
                            impresso1.setPreco(preco);
                            impresso1.setFrete(frete);
                            impresso1.setEstoque(estoque);

                            eletronico1.setTitulo(titulo);
                            eletronico1.setAutores(autores);
                            eletronico1.setEditora(editora);
                            eletronico1.setPreco(preco);
                            eletronico1.setTamanho(tamanho);

                            view.cadastrarLivro(impresso1);
                            numImpressos++;
                            view.cadastrarLivro(eletronico1);
                            numEletronicos++;
                            break;

                        default:
                            System.out.println("Digite uma opção válida.");
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Digite o nome do cliente: ");
                    String cliente = scanner.nextLine();

                    System.out.print("Digite quantos livros deseja comprar: ");
                    int numeroDeLivros = Integer.parseInt(scanner.nextLine());

                    Venda venda = new Venda();
                    venda.setCliente(cliente);

                    List<Impresso> impressosParaVender = new ArrayList<>();
                    List<Eletronico> eletronicosParaVender = new ArrayList<>();

                    for (int i = 0; i < numeroDeLivros; i++){

                        System.out.println("Escolha o tipo do livro para comprar");
                        System.out.println("Digite 1 para impresso");
                        System.out.println("Digite 2 para eletrônico");
                        int livroCompra = Integer.parseInt(scanner.nextLine());

                        switch (livroCompra){
                            case 1:
                                view.listarLivrosImpressos();

                                System.out.println("\n Digite o id do livro que deseja comprar");
                                Integer idImpresso = Integer.parseInt(scanner.nextLine());

                                EntityManager emImpresso = JPAUtil.getEntityManager();
                                ImpressoDao impressoDao = new ImpressoDao(emImpresso);

                                Impresso impresso = impressoDao.encontrarPorId(idImpresso);
                                impressoDao.vender(idImpresso);

                                impressosParaVender.add(impresso);
                                view.venderLivroImpresso(idImpresso);
                                impressosParaVender.add(impresso);

                                break;

                            case 2:
                                view.listarLivrosEletronicos();

                                System.out.println("\n Digite o id do livro que deseja comprar");
                                Integer idEletronico = Integer.parseInt(scanner.nextLine());

                                EntityManager emEletronico = JPAUtil.getEntityManager();
                                EletronicoDao eletronicoDao = new EletronicoDao(emEletronico);

                                Eletronico eletronico = eletronicoDao.encontrarPorId(idEletronico);

                                eletronicosParaVender.add(eletronico);
                                eletronicosParaVender.add(eletronico);

                                break;

                            default:
                                System.out.println("Digite um número válido");
                                i--;
                        }
                    }
                    venda.setLivrosEletronicos(eletronicosParaVender);
                    venda.setLivrosImpressos(impressosParaVender);

                    float valorLivrosEletronicos = 0;

                    for (Eletronico eletronico : eletronicosParaVender){
                        valorLivrosEletronicos += eletronico.getPreco();
                    }

                    float valorLivrosImpressos = 0;

                    for (Impresso impresso : impressosParaVender){
                        valorLivrosImpressos += impresso.getPreco();
                    }

                    venda.setValor(valorLivrosEletronicos + valorLivrosImpressos);

                    view.realizarVenda(venda);

                    Venda vendaFeita = view.buscarUltimaVenda();

                    view.vendas.add(vendaFeita);

                    for (Impresso impresso : impressosParaVender){
                        EntityManager em = JPAUtil.getEntityManager();
                        ImpressoDao dao = new ImpressoDao(em);

                        Impresso impressoManaged = dao.encontrarPorId(impresso.getId());

                        impressoManaged.getVendas().add(vendaFeita);

                        dao.registrarNaVenda(impressoManaged);
                    }

                    for (Eletronico eletronico : eletronicosParaVender){
                        EntityManager em = JPAUtil.getEntityManager();
                        EletronicoDao dao = new EletronicoDao(em);

                        Eletronico eletronicoManaged = dao.encontrarPorId(eletronico.getId());

                        eletronicoManaged.getVendas().add(vendaFeita);

                        dao.registrarNaVenda(eletronicoManaged);
                    }

                    numVendas++;

                    break;

                case 3:
                    view.listarLivros();
                    break;

                case 4:
                    view.listarVendas();
                    break;

                case 5:
                    System.out.println("Obrigado por visitar a livraria digital!");
                    return;

                default:
                    System.out.println("digite uma opção valida");
            }
        }
    }
}
