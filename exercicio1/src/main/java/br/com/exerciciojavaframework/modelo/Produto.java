package br.com.exerciciojavaframework.modelo;

import br.com.exerciciojavaframework.modelo.entidade.Entidade;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@NamedQuery(name = Produto.BUSCAR_POR_NOME, 
        query = "SELECT P FROM Produto P WHERE LOWER(P.nomeProduto) LIKE :findName ORDER BY P.nomeProduto")

@Entity
@Table(name = "produto")
public class Produto extends Entidade implements Serializable{
    
    private static final long serialVersionUID = 1L;
    public static final String BUSCAR_POR_NOME = "Produto.porNome";
    
    @Column(name = "nome_produto", nullable = false, length = 100)    
    private String nomeProduto;
    
    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Fornecedor fornecedor;
    
    @Column(name = "valor")    
    private Double valor;
    
    @Column(name = "tipo", length = 1)    
    private String tipo;
    
    @Column(name = "embalagem", length = 100)    
    private String embalagem;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }
    
    
    
}
