package model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduto;
    private String desProduto;
    private Date dataValidadade;
    private double precoUnico;
    private int idSabor, idTipo;

    public Produto() {
    }

    public Produto(String desProduto, Date dataValidadade, double precoUnico, int idSabor, int idTipo) {
        this.desProduto = desProduto;
        this.dataValidadade = dataValidadade;
        this.precoUnico = precoUnico;
        this.idSabor = idSabor;
        this.idTipo = idTipo;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDesProduto() {
        return desProduto;
    }

    public void setDesProduto(String desProduto) {
        this.desProduto = desProduto;
    }

    public Date getDataValidadade() {
        return dataValidadade;
    }

    public void setDataValidadade(Date dataValidadade) {
        this.dataValidadade = dataValidadade;
    }

    public double getPrecoUnico() {
        return precoUnico;
    }

    public void setPrecoUnico(double precoUnico) {
        this.precoUnico = precoUnico;
    }

    public int getIdSabor() {
        return idSabor;
    }

    public void setIdSabor(int idSabor) {
        this.idSabor = idSabor;

    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
}
