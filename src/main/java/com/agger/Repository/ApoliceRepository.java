package com.agger.Repository;

import com.agger.Model.Apolice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApoliceRepository extends JpaRepository<Apolice, String> {

    Optional<Apolice> findByNumber(String number);
}
