package com.example.kapture_assignment.modal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CALLs")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Calls {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fromNumber;
    private LocalDateTime startCall;
    private LocalDateTime endCall;
    private int duration;

}