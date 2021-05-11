package com.shopping;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@PostMapping("/login")
	public @ResponseBody String login(@RequestParam("username") String username,
			@RequestParam("password") String password) {

		String decryptedPassword =  new String(java.util.Base64.getDecoder().decode(password));
		AesUtil aesUtil = new AesUtil(128, 1000);
		Map map = new HashMap<>();
		if (decryptedPassword != null && decryptedPassword.split("::").length == 3) {
			String decryptedPasswordVal = aesUtil.decrypt(decryptedPassword.split("::")[1], decryptedPassword.split("::")[0], "1234567891234567", decryptedPassword.split("::")[2]);
			//map.put("password", password);
		}
		return "Success";
	} 

}
