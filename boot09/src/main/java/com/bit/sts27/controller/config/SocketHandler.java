package com.bit.sts27.controller.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SocketHandler extends TextWebSocketHandler{
	
	@Autowired
	HttpSession httpSession;
	
	List<WebSocketSession> list=new ArrayList<>();		
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//		System.out.println("afterConnectionEstablished");
//		socket.connnected됐을 때
		list.add(session);
		System.out.println("websocket:"+session.getId());
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(message);
		for(WebSocketSession sock:list) {
			sock.sendMessage(message);			
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
//		System.out.println("afterConnectionClosed");
//		socket.close() 되면..., 창을 벋어나면...
		list.remove(session);
	}

}
