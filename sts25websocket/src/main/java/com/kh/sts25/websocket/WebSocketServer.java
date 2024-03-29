package com.kh.sts25.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class WebSocketServer extends TextWebSocketHandler{
//	접속기능
//	-WebSocketSession: 웹소켓 통신에서 사용자(브라우저)정보를 저장하는 영역
//	-id : 식별자(고유번호)
//	-uri : 접속 주소
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("접속 : session = {}", session);
	}
//	수신기능
//	TextMessage
//	사용자가 보낸 메시지 객체
//	-payload : 메시지 본문
//	-bytecount : 보내진 메시지의 크기
//	-last : 이 메시지가 마지막인지 알려줌
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.info("수신");
		log.info("session = {}", session);
		log.info("message = {}", message);
		
		//메시지 전송은 어떻게 하는가?
		//대상: session(WebSocketSession)
		//내용: message
		session.sendMessage(message); //보낸놈한테 다시 보냄
		
	}
//	종료기능
//	WebSocketSession: 나간 사람의 웹소켓 정보
//	CloseStatus: 나간 사람의 종료 상태 객체
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("종료");
		log.info("session = {}", session);
		log.info("status = {}", status);
	}

}
