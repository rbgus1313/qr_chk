package com.study.domain.post;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.study.common.dto.MessageDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AttdController {

    private final AttdService postService;


    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "common/messageRedirect";
    }

    // 게시글 작성 페이지
    @GetMapping("/post/getBscData.do")
    @ResponseBody
    public AttdVO getBscData(@RequestParam(value = "userId", required = false) final String userId,
    						 Model model) {
    	AttdVO data = postService.findByUserId(userId);
    	model.addAttribute("bscData", data);
        return data;
    }


    // 게시글 작성 페이지
    @GetMapping("/post/write.do")
    public String openPostWrite(@RequestParam(value = "userId", required = false) final String id,
					    		@RequestParam(value = "regUserId", required = false) final String regId,
					    		@RequestParam(value = "isReg", required = false) final String isReg,
					    		@RequestParam(value = "fcltCd", required = false) final String fcltCd,
					    		Model model) {
        //등록된 건이라면
        if (regId != null) {
        	model.addAttribute("regUserId", regId);
        	model.addAttribute("isReg", isReg);
        } else {
        	model.addAttribute("fcltCd", fcltCd);
        }
        return "post/mobWrite";
    }


    // 게시글 리스트 페이지
    @GetMapping("/post/list.do")
    public String openPostList(AttdVO param, Model model) {
        model.addAttribute("pageCnt", (postService.findAllCnt(param) / 10) + 1);
        List<AttdVO> posts = postService.findAllPost(param);
        model.addAttribute("list", posts);
        model.addAttribute("param", param);
        return "post/list";
    }

    // 게시글 리스트 페이지
    @GetMapping("/post/search.do")
    public String search(AttdVO param, Model model) {
        model.addAttribute("pageCnt", (postService.findAllCnt(param) / 10) + 1);
        List<AttdVO> posts = postService.findAllPost(param);
        model.addAttribute("list", posts);
        model.addAttribute("param", param);
        return "post/list ::#content";
    }

    // 게시글 상세 페이지
    @GetMapping("/post/view.do")
    public String openPostView(@RequestParam final Long id, Model model) {
        AttdVO post = postService.findByAttdSn(id);
        model.addAttribute("data", post);
        return "post/popView";
    }


    // 신규 게시글 생성
    @PostMapping("/post/save.do")
    public String savePost(AttdVO params, MultipartFile[] camera, Model model) {
        Map<String, Object> resultMap = postService.attdInfoSave(params, camera);
        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/post/write.do", RequestMethod.GET, resultMap);
        return showMessageAndRedirect(message, model);
    }


    // 기존 게시글 수정
    @PostMapping("/post/update.do")
    public String updatePost(final AttdVO params, Model model) {
        postService.updateAttdInfo(params);
        MessageDto message = new MessageDto("게시글 수정이 완료되었습니다.", "/post/write.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }


    // 게시글 삭제
    @PostMapping("/post/delete.do")
    public String deletePost(@RequestParam final Long id, Model model) {
        postService.deleteByAttdSn(id);
        MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다.", "/post/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }
}
