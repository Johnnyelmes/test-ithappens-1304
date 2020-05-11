package com.john.estoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.john.estoque.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	@Transactional(readOnly = true)
	@Query("Select obj from Produto obj WHERE obj.descricao LIKE %:descricao%")
	List<Produto> search(@Param("descricao") String descricao);
}
