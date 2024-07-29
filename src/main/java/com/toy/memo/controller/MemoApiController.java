package com.toy.memo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toy.memo.model.Memo;
import com.toy.memo.service.MemoService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/memo")
public class MemoApiController {

    private final MemoService memoService;

    // url : api/memo/save
    @PostMapping("/save")
    public ResponseEntity<Memo> createMemo(HttpServletRequest request, @RequestBody Memo memo) {
    	
    	// TODO 임시 아이디를 IP로 사용
    	String ip = request.getHeader("X-FORWARDED-FOR");
    	
    	if(ip == null) {
    		ip = request.getRemoteAddr();
    	}
    	
    	memo.setCrmid(ip);
    	memo.setUpmid(ip);
    	
    	Memo newMemo = memoService.createMemo(memo);
    	return ResponseEntity.ok(newMemo);
    }

    // url : api/memo/update TODO
    @PutMapping("/update")
    public ResponseEntity<Boolean> updatememo(@RequestBody Memo memo) {
    	return null;
    }

    // url : api/memo/delete/{memoNo} TODO
    @DeleteMapping("/delete/{memoNo}")
    public ResponseEntity<Boolean> deletememo(@PathVariable Long memoNo) {
    	return null;
    }

    // url : api/memo/all
    @GetMapping("/all")
    public ResponseEntity<List<Memo>> getAllMemo() {
    	return ResponseEntity.ok(memoService.getAllMemo());
    }

    // url : api/memo/view/{serial}
    @GetMapping("/view/{serial}")
    public ResponseEntity<Memo> getmemo(@PathVariable String serial) {
    	return ResponseEntity.ok(memoService.getMemo(serial));
    }

    // url : api/memo/search?q=something
    @GetMapping("/search")
    public ResponseEntity<List<Memo>> searchmemo(@RequestParam("q") String keyword) {
    	return ResponseEntity.ok(memoService.searchMemo(keyword));
    }

}
