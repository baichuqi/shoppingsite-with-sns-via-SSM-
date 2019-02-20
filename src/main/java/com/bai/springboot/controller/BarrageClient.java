package com.bai.springboot.controller;

import com.bai.springboot.common.Message;
import com.bai.springboot.common.UserPool;
import com.bai.springboot.entity.Text;
import com.bai.springboot.entity.User;
import com.bai.springboot.poxy.MessageProxy;
import com.bai.springboot.util.JsonUtil;
import com.bai.springboot.config.GetHttpSessionConfigurator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;


@ServerEndpoint( "/initi")//configurator = GetHttpSessionConfigurator.class
@Component
public class BarrageClient {
	private static int onlineCount = 0;
	private static Logger LOG = LoggerFactory.getLogger(BarrageClient.class);
	// concurrent包的线程安全Set，用来存放每个客户端对应的webSocketSet对象。
	//若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
	private static CopyOnWriteArraySet<BarrageClient> webSocketSet = new CopyOnWriteArraySet<BarrageClient>();
	// 一个会话可能造成
	private static Map<String,HttpSession> socketNumb = new ConcurrentHashMap<String, HttpSession>();
	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;
	// 整个会话
	private HttpSession httpSession;
	
    @OnOpen
    public void onOpen(Session session,EndpointConfig config) {
        //加入用户池
        String userid="";
        this.session = session;
		this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		webSocketSet.add(this); // 加入set中
		//addOnlineCount(); // 连接数+1
		//System.out.println("有新连接加入！当前连接数为：" + getOnlineCount());
		 /*if(httpSession.getAttribute("user")!=null) {
	        	User u = (User) httpSession.getAttribute("user");
	        	userid=u.getId();
	       }*/
		UserPool.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        LOG.info("user [" + session.getId() + "] send: " + message);
        
       /* if(httpSession.getAttribute("user")!=null) {
        	User u = (User) httpSession.getAttribute("user");
        	LOG.info(" httpsession user is " + u.getId());
        }*/
        LOG.info("websocketset size:"+webSocketSet.iterator());
       
        //给所有用户发送消息
        MessageProxy.getInstance().getProxy(Message.class).send(message, session);
//        MessageProxy.getInstance().getProxy(Message.class).sendto(message, session);
    //得到当前用户的session id，并且获得对方ID
    }

    @OnError
    public void onError(Throwable throwable) {
        LOG.error(throwable.getMessage());
    }

    @OnClose
    public void onClose(Session session) {
        //移除用户池((User) httpSession.getAttribute("user"))
        UserPool.remove(session.getId());

    }
	
}
