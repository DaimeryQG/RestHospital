package com.imss.qro.repository;

import com.imss.qro.models.Insumos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsumosRepository extends JpaRepository<Insumos, Integer> {

}
