package com.pe.seek.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.pe.seek.entity.Candidate;
import com.pe.seek.repository.CandidateRepository;

class CandidateServiceImplTest {

	@Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private CandidateServiceImpl candidateService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCandidate() {
        Candidate candidate = new Candidate(null, "John Doe", "john.doe@example.com", "Male",
                new BigDecimal("50000"), "2024-11-25T10:15:30", null);
        when(candidateRepository.save(any(Candidate.class))).thenReturn(candidate);

        Candidate createdCandidate = candidateService.createCandidate(candidate);

        assertNotNull(createdCandidate);
        assertEquals("John Doe", createdCandidate.getName());
        verify(candidateRepository, times(1)).save(candidate);
    }

    @Test
    void testGetCandidateById() {
        Candidate candidate = new Candidate(1L, "John Doe", "john.doe@example.com", "Male",
                new BigDecimal("50000"), "2024-11-25T10:15:30", null);
        when(candidateRepository.findById(1L)).thenReturn(Optional.of(candidate));

        Candidate fetchedCandidate = candidateService.getCandidateById(1L);

        assertNotNull(fetchedCandidate);
        assertEquals("John Doe", fetchedCandidate.getName());
        verify(candidateRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateCandidate() {
        Candidate existingCandidate = new Candidate(1L, "John Doe", "john.doe@example.com", "Male",
                new BigDecimal("50000"), "2024-11-25T10:15:30", null);
        Candidate updatedCandidate = new Candidate(1L, "Jane Doe", "jane.doe@example.com", "Female",
                new BigDecimal("60000"), "2024-11-25T10:15:30", "2024-11-25T11:00:00");

        when(candidateRepository.findById(1L)).thenReturn(Optional.of(existingCandidate));
        when(candidateRepository.save(any(Candidate.class))).thenReturn(updatedCandidate);

        Candidate result = candidateService.updateCandidate(updatedCandidate);

        assertEquals("Jane Doe", result.getName());
        assertEquals(new BigDecimal("60000"), result.getSalaryExpected());
        verify(candidateRepository, times(1)).findById(1L);
        verify(candidateRepository, times(1)).save(updatedCandidate);
    }

    @Test
    void testDeleteCandidate() {
        Long candidateId = 1L;
        doNothing().when(candidateRepository).deleteById(candidateId);

        candidateService.deleteCandidate(candidateId);

        verify(candidateRepository, times(1)).deleteById(candidateId);
    }
}
