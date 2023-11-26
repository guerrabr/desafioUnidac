package com.example.desafioUnidac.cafeDaManhaDTO;

import java.util.Date;

import jakarta.validation.constraints.Pattern;

public class CafeDaManhaDTO {

	private String nome;
	private String cpf;
	private String comida;
	private String dataCafeDaManha;
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
