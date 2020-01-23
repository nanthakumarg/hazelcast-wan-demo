package com.thebytecloud.hazelcastwandemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class JsonReponse {
    private String message;
}
