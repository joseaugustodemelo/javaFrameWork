package br.com.exerciciojavaframework.modelo;

import br.com.exerciciojavaframework.modelo.entidade.Entidade;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = Fornecedor.BUSCAR_POR_NOME,
        query = "SELECT F FROM Fornecedor F WHERE LOWER(F.nomeFornecedor) LIKE :findName ORDER BY F.nomeFornecedor")
@Entity
@Table(name = "fornecedor")
public class Fornecedor extends Entidade implements Serializable{

    private static final long serialVersionUID = 1L;
    
    public static final String BUSCAR_POR_NOME = "Fornecedor.porNome";
    
    @Column(name = "cnpj", nullable = false, length = 14, unique = true)
    private String cnpj;
    
    @Column(name = "nome_fornecedor", nullable = false, length = 100)
    private String nomeFornecedor;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }
        
    
}
