package model;

import javax.persistence.*;

@Entity
@Table(name = "transacao")
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransacao;
    private  String descricaoTransa;

    public Transacao() {
    }

    public Transacao(String descricaoTransa) {
        this.descricaoTransa = descricaoTransa;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getDescricaoTransa() {
        return descricaoTransa;
    }

    public void setDescricaoTransa(String descricaoTransa) {
        this.descricaoTransa = descricaoTransa;
    }
}
