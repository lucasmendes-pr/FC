package model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "estoque")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstoque;
    private int idProduto,idTransacao;
    private Date dataTransacao;
    private int qtTotal;

    public Estoque() {
    }

    public Estoque(int idProduto, int idTransacao, Date dataTransacao, int qtTotal) {
        this.idProduto = idProduto;
        this.idTransacao = idTransacao;
        this.dataTransacao = dataTransacao;
        this.qtTotal = qtTotal;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public int getQtTotal() {
        return qtTotal;
    }
    public void setQtTotal(int qtTotal) {
        this.qtTotal = qtTotal;
    }
}

