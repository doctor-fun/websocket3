package com.example.messagingstompwebsocket.controller;

import com.example.messagingstompwebsocket.pojo.HelloMessage;
import com.example.messagingstompwebsocket.pojo.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

//用模板发送命令
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	//交互
	@MessageMapping("/receive")
	@SendTo("/topic/DirectionOrder")
	public ResponseMessage receive(HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new ResponseMessage(1 ,"left");
	}

	@RequestMapping("/orderSend")
	@ResponseBody
	public void sendOrder(String direction){
//		return new ResponseMessage(2,direction);
		simpMessagingTemplate.convertAndSend("/topic/DirectionOrder", new ResponseMessage(2,direction));
	}

}
