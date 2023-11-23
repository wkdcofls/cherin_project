package com.test.join2.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RepleForm {
	
	@NotEmpty(message = "내용을 입력해주세요!")
	private String repleCon;
	

}
