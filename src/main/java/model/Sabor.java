package model;

import javax.persistence.*;

@Entity
@Table(name = "sabor")
public class Sabor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSabor;
    private String descricao;

    public Sabor() {
    }

    public Sabor( String descricao) {
        this.descricao = descricao;
    }

    public int getIdsabor() {
        return idSabor;
    }

    public void setIdsabor(int idsabor) {
        this.idSabor = idsabor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
