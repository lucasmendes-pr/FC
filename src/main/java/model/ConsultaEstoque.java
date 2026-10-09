package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_consulta_estoque")
public class ConsultaEstoque {
    @Id
    private int idVenda;
    private int  idEstoque, idProduto, idTipo, idSabor,qtVenda, qtTotal;
    private String descricao,desProduto,tipoDescricao;

    public int getIdVenda() {
        return idVenda;
    }

    public int getQtVenda() {
        return qtVenda;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public int getIdSabor() {
        return idSabor;
    }

    public int getQtTotal() {
        return qtTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDesProduto() {
        return desProduto;
    }

    public String getTipoDescricao() {
        return tipoDescricao;
    }
}
