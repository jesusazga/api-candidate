package com.pe.seek.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pe.seek.entity.Candidate;
import com.pe.seek.repository.CandidateRepository;
import com.pe.seek.service.CandidateService;
import com.pe.seek.utility.Function;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CandidateServiceImpl implements CandidateService {

	private CandidateRepository candidateRepository;

	@Override
	public Candidate createCandidate(Candidate candidate) {
		// TODO Auto-generated method stub
		candidate.setProcessDate(Function.getLocalDateStr("yyyy-MM-dd'T'HH:mm:ss"));
		return candidateRepository.save(candidate);
	}

	@Override
	public Candidate getCandidateById(Long candidateId) {
		// TODO Auto-generated method stub
		Optional<Candidate> optionalCandidate = candidateRepository.findById(candidateId);
		return optionalCandidate.get();
	}

	@Override
	public List<Candidate> getAllCandidates() {
		// TODO Auto-generated method stub
		return candidateRepository.findAll();
	}

	@Override
	public Candidate updateCandidate(Candidate candidate) {
		// TODO Auto-generated method stub
		Candidate existingCandidate = candidateRepository.findById(candidate.getId()).get();
		existingCandidate.setName(candidate.getName());
		existingCandidate.setEmail(candidate.getEmail());
		existingCandidate.setGender(candidate.getGender());
		existingCandidate.setSalaryExpected(candidate.getSalaryExpected());
		existingCandidate.setModificationDate(Function.getLocalDateStr("yyyy-MM-dd'T'HH:mm:ss"));
		
		return candidateRepository.save(existingCandidate);
	}

	@Override
	public void deleteCandidate(Long candidateId) {
		// TODO Auto-generated method stub
		candidateRepository.deleteById(candidateId);
	}

}