package com.drivers;

import com.drivers.router.config.JHipsterProperties;
import com.drivers.router.config.Profiles;
import com.drivers.weixin.config.WeixinProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.MetricFilterAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by xhuji on 2016/9/2.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration(exclude = { MetricFilterAutoConfiguration.class, MetricRepositoryAutoConfiguration.class })
@EnableConfigurationProperties({JHipsterProperties.class,WeixinProperties.class})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Slf4j
public class WeixinApplication {
    @Autowired
    private Environment env;

    /**
     * Main method, used to run the application.
     *
     * @param args the command line arguments
     * @throws UnknownHostException  if the local host name could not be resolved into an address
     */
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(WeixinApplication.class);
        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
        addDefaultProfile(app, source);
        Environment env = app.run(args).getEnvironment();
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://127.0.0.1:{}\n\t" +
                        "External: \thttp://{}:{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }

    @PostConstruct
    public void initApplication(){
        if (env.getActiveProfiles().length == 0){
            log.warn("No Spring profile configured, running with default configuration");
        }else {
            log.info("Running with Spring profile(s) : {}", Arrays.toString(env.getActiveProfiles()));
            Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
            if (activeProfiles.contains(Profiles.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(Profiles.SPRING_PROFILE_PRODUCTION)) {
                log.error("You have misconfigured your application! " +
                        "It should not run with both the 'dev' and 'prod' profiles at the same time.");
            }
            if (activeProfiles.contains(Profiles.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(Profiles.SPRING_PROFILE_CLOUD)) {
                log.error("You have misconfigured your application! " +
                        "It should not0 run with both the 'dev' and 'cloud' profiles at the same time.");
            }
        }
    }
    /**
     * If no profile has been configured, set by default the "dev" profile.
     */
    private static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source){
        if (!source.containsProperty("spring.profiles.active") &&
                !System.getenv().containsKey("SPRING_PROFILES_ACTIVE")) {
            app.setAdditionalProfiles(Profiles.SPRING_PROFILE_DEVELOPMENT);
        }
    }
}
