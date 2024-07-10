package com.toy.memo.controller;

import com.toy.memo.model.dto.AppliesReq;
import com.toy.memo.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    // url : api/member/apply
    @PostMapping("/apply")
    public ResponseEntity<Boolean> applyJop(@RequestBody AppliesReq appliesReq) {
        return ResponseEntity.ok(memberService.applyJop(appliesReq));
    }
}
