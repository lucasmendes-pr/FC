package model;

import javax.persistence.*;

@Entity
@Table(name = "tipo")

public class Tipo {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipo;
    private String tipoDescricao;
    private double peso;

    public Tipo() {
    }

    public Tipo(String tipoDescricao, double peso) {
        this.tipoDescricao = tipoDescricao;
        this.peso = peso;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipoDescricao() {
        return tipoDescricao;
    }

    public void setTipoDescricao(String tipoDescricao) {
        this.tipoDescricao = tipoDescricao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
