package com.thebytecloud.hazelcastwandemo;

import com.hazelcast.config.*;
import com.hazelcast.core.MembershipListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
@Configuration
public class HazelcastConfig {

    public static final String HAZELCAST_XML = "hazelcast.xml";

    @Bean
    public Config configureHazelcast(final MembershipListener listener) throws IOException {

        Config config = null;
        boolean fileExists = false;
        File file = new File(HAZELCAST_XML);

        log.info("File path============> {}", file.getAbsolutePath());

        if(fileExists = file.exists()) {
            log.info("File exists ==> {} ", fileExists);
            config = new XmlConfigBuilder(new FileInputStream(HAZELCAST_XML)).build();
        } else {
            Resource resource = new ClassPathResource(HAZELCAST_XML);
            config = new XmlConfigBuilder(resource.getInputStream()).build();
        }

        config.setInstanceName("nexge-"+System.getenv("HOSTNAME"));

        /*MapConfig mapConfig = new MapConfig();
        mapConfig.setName("demo-cache")
                .setInMemoryFormat(InMemoryFormat.OBJECT)
                .setBackupCount(1)
                .setStatisticsEnabled(true)
                .setReadBackupData(true);

        config.addMapConfig( mapConfig );*/

        log.info("Initializing Hazelcast.....!");

        return config.addListenerConfig(new ListenerConfig(listener));

    }
}
