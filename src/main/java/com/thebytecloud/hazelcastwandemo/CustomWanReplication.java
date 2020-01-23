package com.thebytecloud.hazelcastwandemo;

import com.hazelcast.config.WanPublisherConfig;
import com.hazelcast.config.WanReplicationConfig;
import com.hazelcast.instance.Node;
import com.hazelcast.wan.ReplicationEventObject;
import com.hazelcast.wan.WanReplicationEndpoint;
import com.hazelcast.wan.WanReplicationEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomWanReplication implements WanReplicationEndpoint {
    @Override
    public void init(Node node, WanReplicationConfig wanReplicationConfig, WanPublisherConfig wanPublisherConfig) {
        log.info(">>>>>>>>>>>>>>>>>>>Initializing WAN Replication.............");
    }

    @Override
    public void shutdown() {
        log.info(">>>>>>>>>>>>>>>>>>>Shuting down WAN Replication.............");
    }

    @Override
    public void publishReplicationEvent(String s, ReplicationEventObject replicationEventObject) {
        log.info(">>>>>>>>>>>>>>>>>>>Publishing Replication Event ==> {} key ==> {}", s , replicationEventObject.getKey());
    }

    @Override
    public void publishReplicationEventBackup(String s, ReplicationEventObject replicationEventObject) {
        log.info(">>>>>>>>>>>>>>>>>>>Publishing Replication Event Backup ==> {} key ==> {}", s , replicationEventObject.getKey());
    }

    @Override
    public void publishReplicationEvent(WanReplicationEvent wanReplicationEvent) {
        log.info(">>>>>>>>>>>>>>>>>>>Publishing WAN Replication Event ==> {}", wanReplicationEvent);
    }

    @Override
    public void checkWanReplicationQueues() {
        log.info(">>>>>>>>>>>>>>>>>>>Check WAN Replication Queues");
    }
}
