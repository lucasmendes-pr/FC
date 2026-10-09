package model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idVenda;
    private int qtVenda ;
    private Date dataVenda;

    private int idCliente, idEstoque; //sair altomaticamente.//

    public Venda() {
    }

    public Venda( int qtVenda, Date dataVenda, int idCliente, int idEstoque) {

        this.qtVenda = qtVenda;
        this.dataVenda = dataVenda;
        this.idCliente = idCliente;
        this.idEstoque = idEstoque;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getQtVenda() {
        return qtVenda;
    }

    public void setQtVenda(int qtVenda) {
        this.qtVenda = qtVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idProduto) {
        this.idEstoque = idProduto;
    }
}