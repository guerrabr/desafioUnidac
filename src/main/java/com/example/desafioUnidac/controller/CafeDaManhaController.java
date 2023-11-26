package com.example.desafioUnidac.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.example.desafioUnidac.cafeDaManhaDTO.CafeDaManhaDTO;
import com.example.desafioUnidac.cafeDaManhaRepository.CafeDaManhaRepository;
import com.example.desafioUnidac.cafeDaManhaServices.CafeDaManhaService;
import com.example.desafioUnidac.entidades.CafeDaManha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value ="/cafeDaManha")
public class CafeDaManhaController {
	@Autowired
	private CafeDaManhaRepository repository;
	
	@Autowired
	private CafeDaManhaService service;
	
	@GetMapping
	public List<CafeDaManha> finAll(){
		List<CafeDaManha> result = repository.findAll();
		return result;
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<String> insert(@Valid @RequestBody CafeDaManhaDTO cafeDaManha) {
		String cpf = cafeDaManha.getCpf();

		if (service.verificarExistenciaCPF(cpf)) {
			System.out.println("service.verificarExistenciaCPF(cpf) "
					+ service.validarOpcaoCafe(cafeDaManha.getComida(), cafeDaManha.getDataCafeDaManha()));

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário com CPF já existe");
		} else {
			if (service.validarOpcaoCafe(cafeDaManha.getComida(), cafeDaManha.getDataCafeDaManha())) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Café da manhã já cadastrado por um colaborador nessa Data");
			} else {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		        LocalDate dataConvertida = LocalDate.parse(cafeDaManha.getDataCafeDaManha(), formatter);
		        LocalDate dataAtual = LocalDate.now();
		        
		        if(dataConvertida.isBefore(dataAtual)) {
		        	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.body("Data para o café da manhã é menor que a data atual");
		        }
		        
				CafeDaManha cafeDaManhaobj = new CafeDaManha(cafeDaManha);
				CafeDaManha result = repository.save(cafeDaManhaobj);
				return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso");

			}
		}

	}
	@GetMapping ("/lista")
	@ResponseBody
	public ResponseEntity<List<CafeDaManha>> findByDataCafe(@RequestParam("dataCafeDaManha") String dataCafeDaManha) {
		System.out.println(dataCafeDaManha);
		List<CafeDaManha> result = repository.findAllByDataCafeDaManha(dataCafeDaManha);
		return ResponseEntity.ok().body(result);
	}
}
