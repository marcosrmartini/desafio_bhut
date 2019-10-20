package br.com.bhut.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bhut.desafio.model.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

}
