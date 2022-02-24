package com.xay.xmlapp.service;

import org.springframework.stereotype.Service;

/**
 * @author v_vyqyxiong
 */
@Service
public class EchoServiceTest {

	public String echo(String msg){
		return "ECHO["+msg+"]";
	}
}
