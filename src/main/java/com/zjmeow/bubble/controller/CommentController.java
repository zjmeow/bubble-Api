package com.zjmeow.bubble.controller;

import com.zjmeow.bubble.model.dto.CommentDTO;
import com.zjmeow.bubble.model.vo.ApiResponse;
import com.zjmeow.bubble.service.CommentService;
import com.zjmeow.bubble.util.RestResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 对bubble的评论
 * @author: zjm
 **/

@RequestMapping(value = "/comments")
@RestController
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    ApiResponse<String> comment(CommentDTO commentDTO) {
        commentService.comment(commentDTO);
        return RestResultGenerator.genResult("发布成功", "ok");
    }

}
