package com.desafio.decrypto.msdb.repository;

import com.desafio.decrypto.msdb.entity.Comitente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComitenteRepository extends JpaRepository<Comitente, Long> {
}
