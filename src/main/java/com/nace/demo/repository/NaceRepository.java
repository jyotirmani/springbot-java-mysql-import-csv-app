package com.nace.demo.repository;

import com.nace.demo.model.Nace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaceRepository extends JpaRepository<Nace, Integer> {

}
