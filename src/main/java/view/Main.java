package view;

import dao.*;
import model.*;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    static String resultado = "";

    public static void main(String[] args) {

        String[] menu = {"Cadastrar", "Consultar", "Alterar", "Remover", "Estoque", "Venda ", "Sair"};
        String[] tabelas = {"Produto", "Clientes", "Sabor", "Transação", "Tipo", "Voltar"};
        String[] tabelasMovimento = {"Produto", "Clientes", "Sabor", "Transação", "Tipo", "Estoque","Consulta Geral"};
        String[] tabelaEstoque = {"Inicializar", "Comprar Produto", "Descartar"
                , "Consultar", "Alterar", "Voltar "};
        String[] tabelaVenda = {"Efetuar", "Consultar", "Alterar", "Excluir", "Voltar "};
        int opMenu = 0, opTabela = 0, opEstoque = 0, opVenda = 0;
        do {
            opMenu = JOptionPane.showOptionDialog(null, "**ESCOLHA UMA OPIÇÃO**", "Estoque de Sorvete", 0, -1, null, menu, 0);
            switch (opMenu) {

                case 0:
                    //cadastro
                    opTabela = JOptionPane.showOptionDialog(null, "**ESCOLHA UMA OPIÇÃO**", "CADASTRO", 0, -1, null, tabelas, 0);
                    switch (opTabela) {

                        case 0:
                            cadastrarProduto();
                            break;

                        case 1:
                            cadastrarCliente();
                            break;

                        case 2:
                            cadastrarSabor();
                            break;

                        case 3:
                            cadastrarTransacao();
                            break;

                        case 4:
                            //cadastrar tipo
                            cadastrarTipo();
                            break;
                        case 5:
                            break;

                    }
                    if (opTabela != 5) {
                        JOptionPane.showMessageDialog(null, "Cadastro efetuando com sucesso.");
                    }
                    break;

                case 1:
                    //consultar
                    opTabela = JOptionPane.showOptionDialog(null, "**ESCOLHA UMA OPIÇÃO**", "CONSULTA", 0, -1, null, tabelasMovimento, 0);
                    switch (opTabela) {

                        case 0:
                            resultado = consultarProduto();
                            JOptionPane.showMessageDialog(null, resultado);
                            break;

                        case 1:
                            resultado = consultarCliente();
                            JOptionPane.showMessageDialog(null, resultado);
                            break;

                        case 2:
                            resultado = consultarSabor();
                            JOptionPane.showMessageDialog(null, resultado);
                            break;

                        case 3:
                            resultado = consultarTransacao();
                            JOptionPane.showMessageDialog(null, resultado);
                            break;

                        case 4:
                            //consultar tipo
                            resultado = consultarTipo();
                            JOptionPane.showMessageDialog(null, resultado);
                            break;

                        case 5:
                            resultado = consultarEstoque();
                            JOptionPane.showMessageDialog(null, resultado);
                            break;
                            case 6:
                                resultado = consultarEstoqueGeral();
                                JOptionPane.showMessageDialog(null, resultado);
                                break;
                    }
                    break;

                case 2:
                    //alterar
                    opTabela = JOptionPane.showOptionDialog(null, "**ESCOLHA UMA OPIÇÃO**", "ALTERAÇÃO", 0, -1, null, tabelas, 0);
                    switch (opTabela) {

                        case 0:
                            resultado = consultarProduto() + "\n" + "Digite o ID do produto.";
                            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado));
                            alterarProduto(id);
                            break;

                        case 1:
                            resultado = consultarCliente() + "\n" + "Digite o ID do cliente.";
                            id = Integer.parseInt(JOptionPane.showInputDialog(resultado));
                            alterarCliente(id);
                            break;

                        case 2:
                            resultado = consultarSabor() + "\n" + "Digite o ID do sabor.";
                            id = Integer.parseInt(JOptionPane.showInputDialog(resultado));
                            alterarSabor(id);
                            break;

                        case 3:
                            resultado = consultarTransacao() + "\n" + "Digite o ID da transação.";
                            id = Integer.parseInt(JOptionPane.showInputDialog(resultado));
                            alterarTransacao(id);
                            break;

                        case 4:
                            //alterar tipo
                            resultado = consultarTipo() + "\n" + "Digite o ID do tipo.";
                            id = Integer.parseInt(JOptionPane.showInputDialog(resultado));
                            alterarTipo(id);
                            break;
                        case 5:
                            break;
                        case 6:
                    }
                    if (opTabela != 5) {
                        JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso.");
                    }
                    break;

                case 3:
                    //exclução
                    opTabela = JOptionPane.showOptionDialog(null, "**ESCOLHA UMA OPIÇÃO**", "EXCLUÇÃO", 0, -1, null, tabelas, 0);
                    switch (opTabela) {

                        case 0:
                            resultado = consultarProduto() + "\n" + "Digite o ID do produto que deseja excluir.";
                            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado));
                            removerProduto(id);
                            break;

                        case 1:
                            resultado = consultarCliente() + "\n" + "Digite o ID do cliente que deseja excluir.";
                            id = Integer.parseInt(JOptionPane.showInputDialog(resultado));
                            removerCliente(id);
                            break;

                        case 2:
                            resultado = consultarSabor() + "\n" + "Digite o ID do sabor que deseja excluir.";
                            id = Integer.parseInt(JOptionPane.showInputDialog(resultado));
                            removerSabor(id);
                            break;

                        case 3:
                            resultado = consultarTransacao() + "\n" + "Digite o ID da transação que deseja excluir.";
                            id = Integer.parseInt(JOptionPane.showInputDialog(resultado));
                            removerTransacao(id);
                            break;

                        case 4:
                            //remover tipo
                            resultado = consultarTipo() + "\n" + "Digite o ID do tipo que deseja excluir.";
                            id = Integer.parseInt(JOptionPane.showInputDialog(resultado));
                            removerTipo(id);
                            break;

                        case 5:
                            break;
                    }
                    if (opTabela != 5) {
                        JOptionPane.showMessageDialog(null, "Registro removido com sucesso.");
                    }
                    break;

                case 4://Estoque
                    opEstoque = JOptionPane.showOptionDialog(null, "**ESCOLHA UMA OPIÇÃO**", "", 0, -1, null, tabelaEstoque, 0);
                    switch (opEstoque) {

                        case 0:
                            iniciazarEstoque();
                            break;

                        case 1:
                            resultado = consultarEstoque() + "\n" + "Digite o ID do estoque.";
                            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado));
                            compraEstoque(id);
                            break;

                        case 2:
                            resultado = consultarEstoque() + "\n" + "Digite o ID do estoque.";
                            id = Integer.parseInt(JOptionPane.showInputDialog(resultado));
                            descarteEstoque(id);
                            break;

                        case 3:
                            resultado = consultarEstoque();
                            JOptionPane.showMessageDialog(null, resultado);
                            break;

                        case 4:
                            resultado = consultarEstoque() + "\n" + "Digite o ID do estoque.";
                            id = Integer.parseInt(JOptionPane.showInputDialog(resultado));
                            alterarEstoque(id);
                            break;

                        case 5:
                            break;

                    }
                    if (opTabela != 5) {
                        JOptionPane.showMessageDialog(null, "Operação realizado com sucesso.");
                    }
                    break;

                case 5: // vendas
                    opVenda = JOptionPane.showOptionDialog(null, "**ESCOLHA UMA OPIÇÃO**",
                            "", 0, -1, null, tabelaVenda, 0);
                    switch (opVenda) {
                        case 0:
                            resultado = consultarEstoque() + "\n" + "Digite o ID do estoque que deseja vender.";
                            int id = Integer.parseInt(JOptionPane.showInputDialog(resultado));
                            vendaEstoque(id);

                            break;
                        case 1:
                            resultado = consultarVenda();
                            JOptionPane.showMessageDialog(null, resultado);
                            break;
                        case 2:
                            resultado = consultarVenda() + "\n" + "Digite o ID da venda que deseja alterar.";
                            id = Integer.parseInt(JOptionPane.showInputDialog(resultado));
                            alterarVenda(id);

                            break;
                        case 3:
                            resultado = consultarVenda() + "\n" + "Digite o ID de venda que deseja excluir.";
                            id = Integer.parseInt(JOptionPane.showInputDialog(resultado));
                            removerVenda(id);

                            break;
                        case 4:

                            break;
                    }
                    if (opTabela != 4) {
                        JOptionPane.showMessageDialog(null, "Operação realizado com sucesso.");
                    }
                    break;
                case 6:
                    //sair
                    JOptionPane.showMessageDialog(null, "Obrigado pela preferêcia.");
                    break;
            }
        } while (opMenu != 6);

    }//psvm

    private static void cadastrarSabor() {
        String descricao = JOptionPane.showInputDialog("Digite os sabor.");
        Sabor sabor = new Sabor(descricao);
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        SaborDao saborDao = new SaborDao(em);
        em.getTransaction().begin();
        // método cadastrar
        saborDao.cadastrar(sabor);
        // valida a transação
        em.getTransaction().commit();
        //encerra a conexão com o banco
        em.close();
    }

    public static String consultarSabor() {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        SaborDao saborDao = new SaborDao(em);

        List<Sabor> todos = saborDao.buscarTodos();

        int tam = todos.size();
        String resultado = "\t  ID  \t  DESCRIÇÃO  \n";

        for (int i = 0; i < tam; i++) {

            resultado += todos.get(i).getIdsabor() + " - " +
                    todos.get(i).getDescricao() + "\n";

        }
        return resultado;
    }

    public static void removerSabor(int id) {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        SaborDao saborDao = new SaborDao(em);

        //buscar o produlto carregar o produto na variavel
        Sabor sabor = saborDao.buscarPorId(id);
        //iniciar atransacao
        em.getTransaction().begin();
        // remover o produto
        saborDao.remover(sabor);
        //validar exclucao do banco de dados
        em.getTransaction().commit();
        //encerra
        em.close();
    }

    public static void alterarSabor(int id) {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        SaborDao saborDao = new SaborDao(em);
        Sabor sabor = saborDao.buscarPorId(id);
        String descricao = JOptionPane.showInputDialog("Digite os sabor.");
        //iniciar tranacao.
        em.getTransaction().begin();
        //carrega o produto na memoria para alterar.
        saborDao.alterar(sabor);
        //elterar os campos da tabela produto.
        sabor.setDescricao(descricao);

        //validar exclucao do banco de dados
        em.getTransaction().commit();
        //encerra
        em.close();
    }

    private static void cadastrarTipo() {
        String descricao = JOptionPane.showInputDialog("Digite os tipos de sorvetes que tem ?");
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso."));
        Tipo tipo = new Tipo(descricao, peso);
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        TipoDao tipoDao = new TipoDao(em);
        em.getTransaction().begin();
        // método cadastrar
        tipoDao.cadastrar(tipo);
        // valida a transação
        em.getTransaction().commit();
        //encerra a conexão com o banco
        em.close();
    }

    public static String consultarTipo() {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        TipoDao tipoDao = new TipoDao(em);

        List<Tipo> todos = tipoDao.buscarTodos();

        int tam = todos.size();
        String resultado = "\t  ID    \t     DESCRIÇÃO  \t PESO  \n";

        for (int i = 0; i < tam; i++) {

            resultado += todos.get(i).getIdTipo() + " - " +
                    todos.get(i).getTipoDescricao() + " - " + todos.get(i).getPeso() + "\n";

        }
        return resultado;
    }

    public static void removerTipo(int id) {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        TipoDao tipoDao = new TipoDao(em);

        //buscar o produlto carregar o produto na variavel
        Tipo tipo = tipoDao.buscarPorId(id);
        //iniciar atransacao
        em.getTransaction().begin();
        // remover o produto
        tipoDao.remover(tipo);
        //validar exclucao do banco de dados
        em.getTransaction().commit();
        //encerra
        em.close();
    }

    public static void alterarTipo(int id) {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        TipoDao tipoDao = new TipoDao(em);
        Tipo tipo = tipoDao.buscarPorId(id);
        String descricao = JOptionPane.showInputDialog("Digite o tipo.");
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso."));
        //iniciar tranacao.
        em.getTransaction().begin();
        //carrega o produto na memoria para alterar.
        tipoDao.alterar(tipo);
        //elterar os campos da tabela produto.
        tipo.setTipoDescricao(descricao);
        tipo.setPeso(peso);

        //validar exclucao do banco de dados
        em.getTransaction().commit();
        //encerra
        em.close();
    }

    private static void cadastrarCliente() {
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
        String email = JOptionPane.showInputDialog("Digite o email:");
        long fone = Long.parseLong(JOptionPane.showInputDialog("Digite o telefone do cliente:"));
        Cliente cliente = new Cliente(nome, email, fone);
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        ClienteDao clienteDao = new ClienteDao(em);
        em.getTransaction().begin();
        // método cadastrar
        clienteDao.cadastrar(cliente);
        // valida a transação
        em.getTransaction().commit();
        //encerra a conexão com o banco
        em.close();
    }

    public static String consultarCliente() {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        ClienteDao clienteDao = new ClienteDao(em);

        List<Cliente> todos = clienteDao.buscarTodos();

        int tam = todos.size();
        String resultado = "\t   ID   \t    NOME \t EMAIL \t FONE   \n";

        for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getIdCliente() + " - " + todos.get(i).getNome() + " - " +
                    todos.get(i).getEmail() + " - " + todos.get(i).getFone() + "\n";
        }
        return resultado;
    }

    public static void removerCliente(int id) {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        ClienteDao clienteDao = new ClienteDao(em);

        //buscar o produlto carregar o produto na variavel
        Cliente cliente = clienteDao.buscarPorId(id);
        //iniciar atransacao
        em.getTransaction().begin();
        // remover o produto
        clienteDao.remover(cliente);
        //validar exclucao do banco de dados
        em.getTransaction().commit();
        //encerra
        em.close();
    }

    public static void alterarCliente(int id) {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        ClienteDao clienteDao = new ClienteDao(em);
        Cliente cliente = clienteDao.buscarPorId(id);
        String descricao = JOptionPane.showInputDialog("Digite o nome do cliente:");
        String dEmail = JOptionPane.showInputDialog("Digite o email do cliente:");
        long fone = Long.parseLong(JOptionPane.showInputDialog("Digite o telefone: "));
        //iniciar tranacao.
        em.getTransaction().begin();
        //carrega o produto na memoria para alterar.
        clienteDao.alterar(cliente);
        //elterar os campos da tabela produto.
        cliente.setNome(descricao);
        cliente.setEmail(dEmail);
        cliente.setFone(fone);

        //validar exclucao do banco de dados
        em.getTransaction().commit();
        //encerra
        em.close();
    }

    private static void cadastrarTransacao() {
        String descricaoTransa = JOptionPane.showInputDialog("Digite se e descarte, entrada, saida, venda, transferencia ?");
        Transacao transacao = new Transacao(descricaoTransa);
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        TransacaoDao transacaoDao = new TransacaoDao(em);
        em.getTransaction().begin();
        // método cadastrar
        transacaoDao.cadastrar(transacao);
        // valida a transação
        em.getTransaction().commit();
        //encerra a conexão com o banco
        em.close();
    }

    public static String consultarTransacao() {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        TransacaoDao transacaoDao = new TransacaoDao(em);

        List<Transacao> todos = transacaoDao.buscarTodos();

        int tam = todos.size();
        String resultado = "\t  ID   \t    DESCRIÇÃO   \n";

        for (int i = 0; i < tam; i++) {

            resultado += todos.get(i).getIdTransacao() + " - " + todos.get(i).getDescricaoTransa() + "\n";
        }
        return resultado;
    }

    public static void alterarTransacao(int id) {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        TransacaoDao transacaoDao = new TransacaoDao(em);
        Transacao transacao = transacaoDao.buscarPorId(id);
        String descricao = JOptionPane.showInputDialog("Digite os sabor.");
        //iniciar tranacao.
        em.getTransaction().begin();
        //carrega o produto na memoria para alterar.
        transacaoDao.alterar(transacao);
        //elterar os campos da tabela produto.
        transacao.setDescricaoTransa(descricao);

        //validar exclucao do banco de dados
        em.getTransaction().commit();
        //encerra
        em.close();
    }

    public static void removerTransacao(int id) {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        TransacaoDao transacaoDao = new TransacaoDao(em);

        //buscar o produlto carregar o produto na variavel
        Transacao transacao = transacaoDao.buscarPorId(id);
        //iniciar atransacao
        em.getTransaction().begin();
        // remover o produto
        transacaoDao.remover(transacao);
        //validar exclucao do banco de dados
        em.getTransaction().commit();
        //encerra
        em.close();
    }

    private static void cadastrarProduto() {
        Date dataValidade;
        String desProduto = JOptionPane.showInputDialog("Qual e o produto ?");
        resultado = JOptionPane.showInputDialog(null, "Data de validade.");
        try {
            dataValidade = new SimpleDateFormat("yyyy/MM/dd").parse(resultado);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        double precoUnico = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço unico do produto."));
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        resultado = consultarSabor() + "\n" + "Digite o ID do sabor.";
        int idSabor = Integer.parseInt(JOptionPane.showInputDialog(resultado));
        resultado = consultarTipo() + "\n" + "Digite o ID do tipo.";
        int idTipo = Integer.parseInt(JOptionPane.showInputDialog(resultado));
        Produto produto = new Produto(desProduto, dataValidade, precoUnico, idSabor, idTipo);
        em.getTransaction().begin();
        // método cadastrar
        produtoDao.cadastrar(produto);
        // valida a transação
        em.getTransaction().commit();
        //encerra a conexão com o banco
        em.close();
    }

    public static String consultarProduto() {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        SaborDao saborDao = new SaborDao(em);
        TipoDao tipoDao = new TipoDao(em);
        List<Produto> todos = produtoDao.buscarTodos();

        int tam = todos.size();
        String resultado = "\t  ID    \t   DESCRIÇAO   \t  " +
                " DATA DE VALIDADE    \t     PREÇO UNITARIO    \t    IDTIPO   \t   IDSABOR \n";

        for (int i = 0; i < tam; i++) {
            Sabor sabor = saborDao.buscarPorId(todos.get(i).getIdSabor());
            Tipo tipo = tipoDao.buscarPorId(todos.get(i).getIdTipo());
            resultado += todos.get(i).getIdProduto() + "       -      " +
                    todos.get(i).getDesProduto() + "       -     " +
                    todos.get(i).getDataValidadade() + "    -     " +
                    todos.get(i).getPrecoUnico() + "     -    " +
                    todos.get(i).getIdTipo() + "    -    " +
                    tipo.getTipoDescricao() + "     -    " +
                    todos.get(i).getIdSabor() + "   -    " +
                    sabor.getDescricao() + "\n";
        }
        return resultado;
    }

    public static void removerProduto(int id) {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        //buscar o produlto carregar o produto na variavel
        Produto produto = produtoDao.buscarPorId(id);
        //iniciar atransacao
        em.getTransaction().begin();
        // remover o produto
        produtoDao.remover(produto);
        //validar exclucao do banco de dados
        em.getTransaction().commit();
        //encerra
        em.close();
    }

    public static void alterarProduto(int id) {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        Produto produto = produtoDao.buscarPorId(id);
        String desProduto = JOptionPane.showInputDialog("Digite os produto.");
        double precoUnico = Double.parseDouble(JOptionPane.showInputDialog("Digite o  preço unico do produto."));
        Date dataValidade;
        resultado = JOptionPane.showInputDialog(null, "Data de validade.");
        try {
            dataValidade = new SimpleDateFormat("dd/MM/yyyy").parse(resultado);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        resultado = consultarSabor() + "\n" + "Digite o ID do sabor.";
        int idSabor = Integer.parseInt(JOptionPane.showInputDialog(resultado));
        resultado = consultarTipo() + "\n" + "Digite o ID do tipo.";
        int idTipo = Integer.parseInt(JOptionPane.showInputDialog(resultado));

        //iniciar transacao.
        em.getTransaction().begin();
        //carrega o produto na memoria para alterar.
        produtoDao.alterar(produto);
        //elterar os campos da tabela produto.
        produto.setDesProduto(desProduto);
        produto.setPrecoUnico(precoUnico);
        produto.setDataValidadade(dataValidade);
        produto.setIdSabor(idSabor);
        produto.setIdTipo(idTipo);
        //validar exclucao do banco de dados
        em.getTransaction().commit();
        //encerra
        em.close();
    }

    private static void iniciazarEstoque() {
        resultado = consultarProduto() + "\n" + "Digite o ID do Produto.";
        int idProduto = Integer.parseInt(JOptionPane.showInputDialog(resultado));
        resultado = consultarTransacao() + "\n" + "Digite o ID do Transação.";
        int idTransacao = Integer.parseInt(JOptionPane.showInputDialog(resultado));

        Date dataTransacao;
        resultado = JOptionPane.showInputDialog(null, "Data de transacao.");
        try {
            dataTransacao = new SimpleDateFormat("dd/MM/yyyy").parse(resultado);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        int qtTotal = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de produto que tem no estoque."));
        Estoque estoque = new Estoque(idProduto, idTransacao, dataTransacao, qtTotal);
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        EstoqueDao estoqueDao = new EstoqueDao(em);

        em.getTransaction().begin();
        // método cadastrar
        estoqueDao.cadastrar(estoque);
        // valida a transação
        em.getTransaction().commit();
        //encerra a conexão com o banco
        em.close();
    }

    public static String consultarEstoque() {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        EstoqueDao estoqueDao = new EstoqueDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);
        TransacaoDao transacaoDao = new TransacaoDao(em);
        SaborDao saborDao = new SaborDao(em);
        List<Estoque> todos = estoqueDao.buscarTodos();

        int tam = todos.size();
        String resultado = "IDESTOQUE \t  IDPRODUTO \t   NOME PRODUTO \t    IDTRANSAÇÃO \t    DESCRIÇÃO TRANSAÇÃO \t    DATA TRANSAÇÃO" +
                " \t    QUANTIDADE EM ESTOQUE \n";

        for (int i = 0; i < tam; i++) {
            Produto produto = produtoDao.buscarPorId(todos.get(i).getIdProduto());
            Transacao transacao = transacaoDao.buscarPorId(todos.get(i).getIdTransacao());
            Sabor sabor = saborDao.buscarPorId(produto.getIdSabor());
            resultado += todos.get(i).getIdEstoque() + " - " +
                    todos.get(i).getIdProduto() + " - " +
                    produto.getDesProduto() + " - " +
                    sabor.getDescricao() + " - " +
                    todos.get(i).getIdTransacao() + " - " +
                    transacao.getDescricaoTransa() + " - " +
                    todos.get(i).getDataTransacao() + " - " +
                    todos.get(i).getQtTotal() +
                    "\n";
        }
        return resultado;

    }

    public static void alterarEstoque(int id) {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        EstoqueDao estoqueDao = new EstoqueDao(em);
        Estoque estoque = estoqueDao.buscarPorId(id);
        int qtTotal = Integer.parseInt(JOptionPane.showInputDialog("Digite quantidade de produto no estoque."));
        Date dataTransacao;
        resultado = JOptionPane.showInputDialog(null, "Data de transação.");
        try {
            dataTransacao = new SimpleDateFormat("dd/MM/yyyy").parse(resultado);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        resultado = consultarProduto() + "\n" + "Digite o ID do produto.";
        int idProduto = Integer.parseInt(JOptionPane.showInputDialog(resultado));
        resultado = consultarTransacao() + "\n" + "Digite o ID do tipo.";
        int idTransacao = Integer.parseInt(JOptionPane.showInputDialog(resultado));

        //iniciar transacao.
        em.getTransaction().begin();
        //carrega o produto na memoria para alterar.
        estoqueDao.alterar(estoque);
        //elterar os campos da tabela produto.
        estoque.setDataTransacao(dataTransacao);
        estoque.setQtTotal(qtTotal);
        estoque.setIdProduto(idProduto);
        estoque.setIdTransacao(idTransacao);
        //validar exclucao do banco de dados
        em.getTransaction().commit();
        //encerra
        em.close();
    }

    public static void compraEstoque(int id) {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        EstoqueDao estoqueDao = new EstoqueDao(em);
        Estoque estoque = estoqueDao.buscarPorId(id);
        int qtComprada = Integer.parseInt(JOptionPane.showInputDialog("Digite quantidade comprada."));
        qtComprada = qtComprada + estoque.getQtTotal();
        //iniciar transacao.
        em.getTransaction().begin();
        //carrega o produto na memoria para alterar.
        estoqueDao.alterar(estoque);
        //elterar os campos da tabela produto.
        estoque.setQtTotal(qtComprada);
        //validar exclucao do banco de dados
        em.getTransaction().commit();
        //encerra
        em.close();
    }

    public static void vendaEstoque(int idEstoque) {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        EstoqueDao estoqueDao = new EstoqueDao(em);
        VendaDao vendaDao = new VendaDao(em);
        Estoque estoque = estoqueDao.buscarPorId(idEstoque);
        resultado = consultarCliente() + "\n" + "Digite o ID do cliente.";
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog(resultado));

        int qtVenda = Integer.parseInt(JOptionPane.showInputDialog("Digite quantidade de venda."));
        Date dataVenda;
        resultado = JOptionPane.showInputDialog(null, "Data de venda(dd/MM/yyyy)");
        try {
            dataVenda = new SimpleDateFormat("dd/MM/yyyy").parse(resultado);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        Venda venda = new Venda(qtVenda, dataVenda, idCliente, idEstoque);
        //iniciar transacao.
        em.getTransaction().begin();
        // cadastrar venda
        qtVenda = estoque.getQtTotal() - qtVenda;
        //carrega o produto na memoria para alterar.
        estoqueDao.alterar(estoque);
        //elterar os campos da tabela produto.
        estoque.setQtTotal(qtVenda);
        vendaDao.cadastrar(venda);
        //validar exclucao do banco de dados
        em.getTransaction().commit();
        //encerra
        em.close();
    }

    public static void descarteEstoque(int id) {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        EstoqueDao estoqueDao = new EstoqueDao(em);
        Estoque estoque = estoqueDao.buscarPorId(id);
        int qtDescarte = Integer.parseInt(JOptionPane.showInputDialog("Digite quantidade descartada."));
        qtDescarte = estoque.getQtTotal() - qtDescarte;
        //iniciar transacao.
        em.getTransaction().begin();
        //carrega o produto na memoria para alterar.
        estoqueDao.alterar(estoque);
        //elterar os campos da tabela produto.
        estoque.setQtTotal(qtDescarte);
        //validar exclucao do banco de dados
        em.getTransaction().commit();
        //encerra
        em.close();
    }

    public static String consultarVenda() {
        // concexão com o banco de dados

        EntityManager em = JPAUtil.getEntityManager();
        VendaDao vendaDao = new VendaDao(em);

        List<Venda> todos = vendaDao.buscarTodos();

        int tam = todos.size();
        String resultado = "\t  ID   \t    IDCLIENTE \t    IDPRODUTO   \t    DATA VENDA \t QUANTIDADE DE VENDA  \n";

        for (int i = 0; i < tam; i++) {

            resultado += todos.get(i).getIdVenda() + " - " + todos.get(i).getIdCliente() + " - "
                    + todos.get(i).getIdEstoque() + " - " +
                    todos.get(i).getDataVenda() + " - " +
                    todos.get(i).getQtVenda() +
                    "\n";

        }
        return resultado;
    }

    public static void alterarVenda(int id) {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();
        EstoqueDao estoqueDao = new EstoqueDao(em);
        VendaDao vendaDao = new VendaDao(em);
        Venda venda = vendaDao.buscarPorId(id);
        int vendaAnt = venda.getQtVenda();
        resultado = consultarCliente() + "\n" + "Digite o ID do cliente.";
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog(resultado));
        int qtVenda = Integer.parseInt(JOptionPane.showInputDialog("Digite quantidade de venda."));
        int idEstoque = venda.getIdEstoque();
        Estoque estoque = estoqueDao.buscarPorId(idEstoque);
        Date dataVenda;
        resultado = JOptionPane.showInputDialog(null, "Data de venda(dd/MM/yyyy)");
        try {
            dataVenda = new SimpleDateFormat("dd/MM/yyyy").parse(resultado);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        //iniciar transacao.
        em.getTransaction().begin();
        //carrega o produto na memoria para alterar.
        vendaDao.alterar(venda);
        estoqueDao.alterar(estoque);
        //elterar os campos da tabela produto.
        venda.setIdCliente(idCliente);
        venda.setDataVenda(dataVenda);
        venda.setQtVenda(qtVenda);
        vendaAnt = estoque.getQtTotal() + vendaAnt - qtVenda;
        estoque.setQtTotal(vendaAnt);

        //validar exclucao do banco de dados
        em.getTransaction().commit();
        //encerra
        em.close();

    }

    public static void removerVenda(int id) {
        // concexão com o banco de dados
        EntityManager em = JPAUtil.getEntityManager();

        VendaDao vendaDao = new VendaDao(em);
        Venda venda = vendaDao.buscarPorId(id);
        //buscar o produlto carregar o produto na variavel
        int idEstoque = venda.getIdEstoque();
        EstoqueDao estoqueDao = new EstoqueDao(em);
        Estoque estoque = estoqueDao.buscarPorId(idEstoque);
        //iniciar atransacao
        em.getTransaction().begin();
        int vendaExcluida = venda.getQtVenda();
        vendaExcluida = estoque.getQtTotal() + venda.getQtVenda();
        // remover o produto
        vendaDao.remover(venda);
        estoque.setQtTotal(vendaExcluida);
        //validar exclucao do banco de dados
        em.getTransaction().commit();
        //encerra
        em.close();
    }
    public static String consultarEstoqueGeral(){
        EntityManager em = JPAUtil.getEntityManager();
        ConsultaEstoqueDao consultaEstoqueDao = new ConsultaEstoqueDao(em);

        List<ConsultaEstoque> todos = consultaEstoqueDao.buscarTodos();

        int tam = todos.size();
        String resultado = "ID - SABOR - TIPO - QTD.VENDA - QTD.TOTAL  \n";

        for (int i = 0; i < tam; i++) {

            resultado += todos.get(i).getIdSabor()+ " - " +
                    todos.get(i).getDescricao()+ " - " +
                   // todos.get(i).getIdTipo()+ " - " +
                    todos.get(i).getTipoDescricao()+ " - " +
                    //todos.get(i).getIdProduto()+ " - " +
                    //todos.get(i).getDesProduto()+ " - " +
                    //todos.get(i).getIdVenda()+ " - " +
                    todos.get(i).getQtVenda()+ " - " +
                    //todos.get(i).getIdEstoque()+ " - " +
                    todos.get(i).getQtTotal() +
                    "\n";

        }
        return resultado;
    }

}

