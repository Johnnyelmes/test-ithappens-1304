package com.john.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.john.estoque.domain.FilialProduto;

@Repository
public interface FilialProdutoRepository extends JpaRepository<FilialProduto, Integer> {

}
