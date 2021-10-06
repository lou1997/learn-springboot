package lyd.learn.springboot.entity;
//服务器配置

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource({"classpath:application.properties"})
@ConfigurationProperties(prefix = "test")
public class ServerSettings {
    @Value("${name}")
    private String name;  //名称
    @Value("${domain}")
    private String domain;  //域名地址

    public String getName() {
        return name;
    }

    public ServerSettings(String name, String domain) {
        this.name = name;
        this.domain = domain;
    }


    public ServerSettings() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
