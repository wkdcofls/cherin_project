package com.test.join2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.join2.entity.Member;
import com.test.join2.repository.MemberRepository;
import com.test.join2.role.MemberRole;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberSecurityService implements UserDetailsService{
	private final MemberRepository memberRepository;
	@Override
	public UserDetails loadUserByUsername(String mbId) throws UsernameNotFoundException{
		Optional<Member> _member = this.memberRepository.findBymbId(mbId);
		if(_member.isEmpty()) {
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
		}
		Member member = _member.get();
		List<GrantedAuthority> authorities = new ArrayList<>();
		if("admin".equals(mbId)) {
			authorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.getValue()));
		}else {
			authorities.add(new SimpleGrantedAuthority(MemberRole.USER.getValue()));
		}
		return new User(member.getMbId(),member.getMbPw(), authorities);
	}

}
