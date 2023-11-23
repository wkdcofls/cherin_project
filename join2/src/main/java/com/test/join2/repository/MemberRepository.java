package com.test.join2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.join2.entity.Member;



public interface MemberRepository extends JpaRepository<Member, String>{
	Optional<Member> findBymbId(String mbId);
}
