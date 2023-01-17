package cn.itcast.user.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 第二种实现自动热更新的方式
 */
@Data
@Component
@ConfigurationProperties("pattern")
public class PatternProperties {
    private String dateformat;
}
