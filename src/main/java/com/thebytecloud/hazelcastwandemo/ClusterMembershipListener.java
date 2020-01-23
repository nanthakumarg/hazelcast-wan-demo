package com.thebytecloud.hazelcastwandemo;

import com.hazelcast.core.MemberAttributeEvent;
import com.hazelcast.core.MembershipEvent;
import com.hazelcast.core.MembershipListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ClusterMembershipListener implements MembershipListener {
    @Override
    public void memberAdded(MembershipEvent membershipEvent) {
        log.info("Added member ==> {}", membershipEvent.getMember());
    }

    @Override
    public void memberRemoved(MembershipEvent membershipEvent) {
        log.info("Removed member ==> {}", membershipEvent.getMember());
    }

    @Override
    public void memberAttributeChanged(MemberAttributeEvent memberAttributeEvent) {
        log.info("Member attributes changed ==> {}", memberAttributeEvent.getMember());
    }
}
