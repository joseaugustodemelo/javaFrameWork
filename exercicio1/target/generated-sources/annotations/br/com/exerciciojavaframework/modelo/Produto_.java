package br.com.exerciciojavaframework.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ extends br.com.exerciciojavaframework.modelo.entidade.Entidade_ {

	public static volatile SingularAttribute<Produto, Fornecedor> fornecedor;
	public static volatile SingularAttribute<Produto, String> embalagem;
	public static volatile SingularAttribute<Produto, Double> valor;
	public static volatile SingularAttribute<Produto, String> tipo;
	public static volatile SingularAttribute<Produto, String> nomeProduto;

}

