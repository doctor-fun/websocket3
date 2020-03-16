package com.example.messagingstompwebsocket.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage implements Serializable {
    //序列化id To do
    private Integer messageid;
    private Instructor instructor;


}
