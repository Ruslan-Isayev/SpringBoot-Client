package com.project.client.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

    @JsonProperty(value = "response")
    private T t;
    private RespStatus status;

}
