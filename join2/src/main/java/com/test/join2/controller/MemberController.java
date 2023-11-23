package com.test.join2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.join2.form.MemberForm;
import com.test.join2.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("/signup")
	
	public String signup(MemberForm memberForm) {
		return "signup_form";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid MemberForm memberForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "signup_form";
		}
		if (!memberForm.getMbPw1().equals(memberForm.getMbPw2())) {
			bindingResult.rejectValue("mb_pw2", "passwordIncorrect", "비밀번호를 확인해주세요");
			return "signup_form";
		}
		try {
			this.memberService.create(
					memberForm.getMbId(), 
					memberForm.getMbPw1(), 
					memberForm.getMbName(), 
					memberForm.getMbCompany());
		} catch (Exception e) {
			bindingResult.reject("signupfail", "이미 등록된 유저입니다.");
			return "signup_form";
		}
		return "redirect:/main";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login_form";
	}
	
}
