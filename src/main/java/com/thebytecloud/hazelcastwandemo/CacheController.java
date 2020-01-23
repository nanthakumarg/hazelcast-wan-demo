package com.thebytecloud.hazelcastwandemo;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/demo-cache")
public class CacheController {

    private final HazelcastInstance hazelcastInstance;

    @RequestMapping("/{key}/{value}")
    public JsonReponse putValue(@PathVariable String key, @PathVariable String value) {
        final IMap<String, String> map = hazelcastInstance.getMap("demo-cache");
        map.put(key, value);

        return JsonReponse.builder().message("Saved").build();
    }

    @RequestMapping("/{key}")
    public KeyValuePair putValue(@PathVariable String key) {
        final IMap<String, String> map = hazelcastInstance.getMap("demo-cache");

        return KeyValuePair.builder().key(key).value(map.get(key)).build();
    }

    @RequestMapping("/")
    public List<KeyValuePair> putValue() {
        final IMap<String, String> map = hazelcastInstance.getMap("demo-cache");

        List<KeyValuePair> list = map.entrySet().stream().map(entry -> {
                    return KeyValuePair.builder().key(entry.getKey()).value(entry.getValue()).build();
                })
                .collect(Collectors.toList());
        return list;
    }
}
