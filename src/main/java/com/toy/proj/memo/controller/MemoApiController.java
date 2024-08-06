package com.toy.proj.memo.controller;

import com.toy.proj.memo.model.Memo;
import com.toy.proj.memo.service.MemoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/memo")
public class MemoApiController {

    private final MemoService memoService;

    // url : api/memo/save
    @PostMapping("/save")
    public ResponseEntity<Memo> createMemo(HttpServletRequest request, @RequestBody Memo memoDto) {
    	
    	// TODO 임시 아이디를 IP로 사용
    	String ip = request.getHeader("X-FORWARDED-FOR");

        if(ip == null) {
    		ip = request.getRemoteAddr();
    	}

        memoDto.setCrmid(ip);
        memoDto.setUpmid(ip);
    	
    	Memo newMemo = memoService.createMemo(memoDto);
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
