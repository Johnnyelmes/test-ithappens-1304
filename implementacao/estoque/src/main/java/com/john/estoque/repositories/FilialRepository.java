package com.john.estoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.john.estoque.domain.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Integer> {

}
