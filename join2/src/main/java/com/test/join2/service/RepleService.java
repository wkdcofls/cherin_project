package com.test.join2.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.test.join2.entity.Board;
import com.test.join2.entity.Reple;
import com.test.join2.repository.RepleRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RepleService {
	
	private final RepleRepository repleRepository;
	
	@Transactional
	public void repleCreate(Board board, String repleCon) {
		Reple r = new Reple();
		r.setRepleCon(repleCon);
		r.setBoard(board);
		r.setRepleDate(LocalDateTime.now());
		this.repleRepository.save(r);
	}
	
	
	
	
	
	
	

}
