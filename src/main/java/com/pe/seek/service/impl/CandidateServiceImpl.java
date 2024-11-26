package com.pe.seek.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pe.seek.entity.Candidate;
import com.pe.seek.exception.InternalErrorException;
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
		return candidateRepository.findById(candidateId)
	            .orElseThrow(() -> new InternalErrorException("Candidato con ID " + candidateId + " no encontrado"));
	}

	@Override
	public List<Candidate> getAllCandidates() {
		// TODO Auto-generated method stub
		List<Candidate> candidateList = candidateRepository.findAll();
		if (Function.isListNullOrEmpty(candidateList)) {
			new InternalErrorException("No se encontraron candidatos");
		}
		return candidateRepository.findAll();
	}

	@Override
	public Candidate updateCandidate(Candidate candidate) {
		// TODO Auto-generated method stub
		
		Candidate existingCandidate = candidateRepository.findById(candidate.getId())
	            .orElseThrow(() -> new InternalErrorException("No se pudo actualizar el registro, candidato con ID " + candidate.getId() + " no encontrado"));
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
		candidateRepository.findById(candidateId)
	            .orElseThrow(() -> new InternalErrorException("No se pudo borrar el registro, candidato con ID " + candidateId + " no encontrado"));
		
		candidateRepository.deleteById(candidateId);
	}

}
