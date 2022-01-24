package com.relation.entities.jpahibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relation.entities.jpahibernate.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
