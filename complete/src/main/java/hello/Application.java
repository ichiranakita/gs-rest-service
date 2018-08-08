package hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public ConfigurableServletWebServerFactory tomcatCustomizer() {
//        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//        factory.addConnectorCustomizers(connector -> {
//            connector.addUpgradeProtocol(new Http2Protocol());
//        });
//        return factory;
//    }
}
