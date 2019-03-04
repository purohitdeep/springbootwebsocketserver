package dp.websocket.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import dp.websocket.server.socket.WebSocketServer;

@Configuration
@EnableAutoConfiguration
@EnableWebSocket
public class SpringbootwebsocketserverApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootwebsocketserverApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootwebsocketserverApplication.class);
    }

    /**
     * This is required for connecting with websocket endpoint. As websocket is annotated with
     * serverendpoint
     * 
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Bean
    public WebSocketServer webSocketEndpoint() {
        return new WebSocketServer();
    }

}
