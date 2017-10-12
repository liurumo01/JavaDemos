package space.snowwolf.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN, reason="用户名和密码不匹配")
public class UsernameNotMatchPasswordException extends RuntimeException {

	private static final long serialVersionUID = 6455910598974297139L;
	
}
