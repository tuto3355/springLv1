package com.nakta.springlv1.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Board {
    private Long id;
    private String title;
    private String userName;
    private String content;
    private String password;
    private String date;

}
