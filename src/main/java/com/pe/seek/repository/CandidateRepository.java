package com.pe.seek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.seek.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
