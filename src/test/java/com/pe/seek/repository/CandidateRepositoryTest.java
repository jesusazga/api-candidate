package com.pe.seek.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pe.seek.entity.Candidate;

@DataJpaTest
class CandidateRepositoryTest {

	@Autowired
    private CandidateRepository candidateRepository;

    @Test
    void testSaveCandidate() {
        Candidate candidate = new Candidate(null, "John Doe", "john.doe@example.com", "Male",
                new BigDecimal("50000"), "2024-11-25T10:15:30", null);
        Candidate savedCandidate = candidateRepository.save(candidate);

        assertThat(savedCandidate.getId()).isNotNull();
        assertThat(savedCandidate.getName()).isEqualTo("John Doe");
    }

    @Test
    void testFindAllCandidates() {
        Candidate candidate1 = new Candidate(null, "John Doe", "john.doe@example.com", "Male",
                new BigDecimal("50000"), "2024-11-25T10:15:30", null);
        Candidate candidate2 = new Candidate(null, "Jane Smith", "jane.smith@example.com", "Female",
                new BigDecimal("60000"), "2024-11-25T10:15:30", null);

        candidateRepository.save(candidate1);
        candidateRepository.save(candidate2);

        List<Candidate> candidates = candidateRepository.findAll();

        assertThat(candidates).hasSize(2);
    }
}
