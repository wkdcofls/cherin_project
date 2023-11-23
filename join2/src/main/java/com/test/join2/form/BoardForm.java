package com.test.join2.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BoardForm {
	
	// @NotEmpty - null 또는 ""을 허용하지 않음
	@NotEmpty(message = "제목을 입력해주세요!")
	@Size(max = 100)
	private String boardTitle;
	
	@NotEmpty(message = "내용을 입력해주세요!")
	private String boardCon;
	
	

}
