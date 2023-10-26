package com.example.app.controller;

import com.example.app.domain.PostDTO;
import com.example.app.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post/*")
@Slf4j
public class PostController {
    private final PostService postService;

//    게시글 작성
    @GetMapping("write")
    public void goToWriteForm(PostDTO postDTO){;}

    @PostMapping("write")
    public RedirectView write(PostDTO postDTO){
        postService.write(postDTO);
        return new RedirectView("list");
    }

//    게시글 목록
    @GetMapping("list")
    public void showList(Model model){
        model.addAttribute("posts", postService.getList());
    }
}
