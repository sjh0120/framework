package com.bit.sts28.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class EchoController {
	@Autowired
	HttpSession session;

	@MessageMapping("/room1")
	@SendTo("/topic/msg1")
	public String func01(String msg) {
//		System.out.println(msg);
//		System.out.println(session);
		return msg;
	}
}
