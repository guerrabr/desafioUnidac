package com.example.desafioUnidac.cafeDaManhaServices;

import java.util.List;

import com.example.desafioUnidac.cafeDaManhaRepository.CafeDaManhaRepository;
import com.example.desafioUnidac.entidades.CafeDaManha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeDaManhaService {
	
	private final CafeDaManhaRepository cafeManhaRepository;
	
	@Autowired
	public CafeDaManhaService(CafeDaManhaRepository cafeManhaRepository) {
		this.cafeManhaRepository = cafeManhaRepository;
	}
	
	public boolean verificarExistenciaCPF(String cpf) {
		return cafeManhaRepository.existsByCpf(cpf);
	}
	
	public boolean validarOpcaoCafe(String comida, String dataCafeDaManha) {

        boolean opcaoJaRegistrada = cafeManhaRepository.existsByComidaAndDataCafeDaManha(comida, dataCafeDaManha);
        return opcaoJaRegistrada;
    }
	
	public List<CafeDaManha> buscarPorData(String dataCafeDaManha) {
        return cafeManhaRepository.findAllByDataCafeDaManha(dataCafeDaManha);
    }
}
