package com.example.desafioUnidac.cafeDaManhaRepository;
import java.util.List;

import com.example.desafioUnidac.entidades.CafeDaManha;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeDaManhaRepository extends JpaRepository<CafeDaManha, Integer>{
	
	@Query(value = "SELECT COUNT(*) > 0 FROM TB_CAFE_DA_MANHA WHERE CPF = :cpf", nativeQuery = true)
	boolean existsByCpf(@Param("cpf") String cpf);
	
	@Query(value = "SELECT COUNT(*) > 0 FROM TB_CAFE_DA_MANHA WHERE COMIDA = :comida AND DATA_CAFE_DA_MANHA = :dataCafeDaManha", nativeQuery = true)
	boolean existsByComidaAndDataCafeDaManha(@Param("comida") String comida, @Param("dataCafeDaManha") String dataCafeDaManha);

    @Query(value = "SELECT * FROM TB_CAFE_DA_MANHA WHERE DATA_CAFE_DA_MANHA =:dataCafeDaManha", nativeQuery = true)
    List<CafeDaManha> findAllByDataCafeDaManha(@Param("dataCafeDaManha") String dataCafeDaManha);
}
