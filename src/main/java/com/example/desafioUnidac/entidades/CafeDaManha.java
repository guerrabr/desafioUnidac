package com.example.desafioUnidac.entidades;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.desafioUnidac.cafeDaManhaDTO.CafeDaManhaDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table (name="tb_cafeDaManha")
public class CafeDaManha {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF inválido")
	private String cpf;
	private String comida;
	private String dataCafeDaManha;
	 public CafeDaManha() {
	      
	 }
	public CafeDaManha (CafeDaManhaDTO cafeDaManhaDTO) {
		this.nome = cafeDaManhaDTO.getNome();
		this.cpf = cafeDaManhaDTO.getCpf();
		this.comida = cafeDaManhaDTO.getComida();
		this.dataCafeDaManha = cafeDaManhaDTO.getDataCafeDaManha();

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getComida() {
		return comida;
	}
	public void setComida(String comida) {
		this.comida = comida;
	}
	public String getDataCafeDaManha() {
		return dataCafeDaManha;
	}
	public void setDataCafeDaManha(String dataCafeDaManha) {
		this.dataCafeDaManha = dataCafeDaManha;
	}
}
