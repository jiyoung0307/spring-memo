package com.toy.proj.memo.controller;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.toy.proj.memo.model.Memo;
import com.toy.proj.memo.service.MemoService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/memo")
public class MemoViewController {

    private final MemoService memoService;

    @GetMapping({"/list", ""})
    public String memoList(Model model, @RequestParam(name="q", required = false) String keyword) {
        
    	if(keyword == null || keyword.isBlank()) {
    		model.addAttribute("memoList", memoService.getAllMemo());    	
    	} else {
    		model.addAttribute("memoList", memoService.searchMemo(keyword));    		
    	}
    	
    	model.addAttribute("q", keyword);
    	return "list";
    }
    
    @GetMapping("/view/{seq}")
    public String memoView(Model model, @PathVariable Integer seq) {
    	
		model.addAttribute("memo", memoService.getMemo(seq));
		
    	return "detail";
    }
    
    @GetMapping("/write")
    public String writeView(Model model) {
    	
    	model.addAttribute("memo", new Memo());
    	return "write";
    }
    
    @GetMapping("/edit/{seq}")
    public String editView(Model model, @PathVariable Integer seq) {
    	
    	model.addAttribute("memo", memoService.getMemo(seq));
    	return "write";
    }
    
    @PostMapping("/view")
    public String createMemo(HttpServletRequest request, Memo memo) {
    	
    	// TODO 임시 아이디를 IP로 사용
    	String ip = request.getHeader("X-FORWARDED-FOR");
    	
    	if(ip == null) {
    		ip = request.getRemoteAddr();
    	}
    	
    	memo.setCrmid(ip);
    	memo.setUpmid(ip);
    	
    	Memo newMemo = memoService.createMemo(memo);
    	return "redirect:/memo/view/" + newMemo.getSerial();
    }
}
