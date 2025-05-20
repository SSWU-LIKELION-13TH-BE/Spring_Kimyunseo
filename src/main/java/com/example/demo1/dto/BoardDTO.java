package com.example.demo1.dto;

import java.util.Date;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BoardDTO {
    private Long boardId;
    private String title;
    private String content;
    private String writer;
    private Date postDate;
    private MultipartFile image;
}