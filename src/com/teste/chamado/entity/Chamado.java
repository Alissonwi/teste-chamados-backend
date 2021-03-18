package com.teste.chamado.entity;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CHAMADO", schema = "CHAMADODB")
public class Chamado implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "data_inclusao")
	private Date dataInclusao;
	
	@Column(name = "data_conclusao")
	private Date dataConclusao;
	
	
	public Chamado() {
	}
	
	public Chamado(Integer id) {
		this.id = id;
	}
	
	public Chamado(String titulo,
            Boolean status, String descricao,
            Date dataInclusao, Date dataConclusao) {
        this.titulo = titulo;
        this.status = status;
        this.descricao = descricao;
        this.dataInclusao = dataInclusao;
        this.dataConclusao = dataConclusao;
    }
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}

	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	
	
	public Date getDataConclusao() {
		return dataConclusao;
	}
	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	
}