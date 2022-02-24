package com.xay.xmlapp.controller;

import com.xay.xmlapp.service.EchoServiceTest;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author v_vyqyxiong
 */
@RestController
public class ControllerTest {

	@Resource
	EchoServiceTest echoServiceTest;

	@GetMapping("echo")
	public String echo(String msg) {
		return echoServiceTest.echo(msg);
	}
}
