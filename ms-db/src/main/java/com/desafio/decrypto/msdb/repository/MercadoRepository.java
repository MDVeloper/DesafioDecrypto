package com.desafio.decrypto.msdb.repository;

import com.desafio.decrypto.msdb.entity.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Mercado
 */
@Repository
public interface MercadoRepository extends JpaRepository<Mercado, Long> {
}
