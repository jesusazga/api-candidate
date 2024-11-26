package com.pe.seek.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.seek.entity.Candidate;
import com.pe.seek.service.CandidateService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Tag(name = "Candidate", description = "Candidates for job application")
@RequestMapping("api/candidates")
public class CandidateController {

	private CandidateService candidateService;
	
	@PostMapping
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate){

		Candidate savedCandidate = candidateService.createCandidate(candidate);
        return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
    }
	
	@GetMapping("{id}")
    public ResponseEntity<Candidate> getUserById(@PathVariable("id") Long candidateId){
		Candidate candidate = candidateService.getCandidateById(candidateId);
        return new ResponseEntity<>(candidate, HttpStatus.OK);
    }
	
	@GetMapping
    public ResponseEntity<List<Candidate>> getAllCandidates(){
        List<Candidate> candidates = candidateService.getAllCandidates();
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }
	
	@PutMapping("{id}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable("id") Long candidateId, @RequestBody Candidate candidate){

		candidate.setId(candidateId);
		Candidate savedCandidate = candidateService.updateCandidate(candidate);
        return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
    }
	
	@DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long userId){
		candidateService.deleteCandidate(userId);
        return new ResponseEntity<>("Candidate successfully deleted!", HttpStatus.OK);
    }
}
