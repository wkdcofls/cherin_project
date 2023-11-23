package com.test.join2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.test.join2.entity.Board;


// JpaRepository<대상이 되는 엔티티, 해당 엔티티의 식별자 데이터타입>
// JpaRepostitory가 가지고 있는 메서드를 사용해서 DB를 제어할 수 있음
public interface BoardRepository extends JpaRepository<Board, Integer>{
	
	Page<Board> findAll(Pageable pageable);
	/* Pageable - 스프링에서 페이징 처리를 하기 위한 인터페이스
	 * 		    - 페이지 번호, 페이지 크기, 정렬 순서 등을 설정
	 * Page - 주로 JPA쿼리 결과를 Page 객체로 반환받아 페이징 처리를 수행  
	 * */
	
	
	
	
	
	
	
	
	
}
