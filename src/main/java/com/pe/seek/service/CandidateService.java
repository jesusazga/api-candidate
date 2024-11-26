package com.pe.seek.service;

import java.util.List;

import com.pe.seek.entity.Candidate;

public interface CandidateService {

	Candidate createCandidate(Candidate candidate);
	Candidate getCandidateById(Long candidateId);
	List<Candidate> getAllCandidates();
	Candidate updateCandidate(Candidate candidate);
	void deleteCandidate(Long candidateId);
}
