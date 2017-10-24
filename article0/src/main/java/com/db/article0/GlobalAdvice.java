package com.db.article0;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice     //拦截所有controller的异常
public class GlobalAdvice {

	@ResponseBody
	@ExceptionHandler(BindException.class)
	public Map<String, Object> validExceptionHandler(BindException ex) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors(); //获取所有BindException中的错误
		return new HashMap<String, Object>() {
			private static final long serialVersionUID = -3222861572243435035L;
			{ 
				for (FieldError error : fieldErrors) {// error.getField() 获取参数名， error.getDefaultMessage() 获取错误信息就是@NotNull(message="xxxxx")中的message
					put(error.getField(), error.getDefaultMessage());
				}
			}
		};
	}
}
