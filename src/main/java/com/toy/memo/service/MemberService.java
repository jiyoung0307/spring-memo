package com.toy.memo.service;

import com.toy.memo.model.Applies;
import com.toy.memo.model.JopPost;
import com.toy.memo.model.Member;
import com.toy.memo.model.dto.AppliesReq;
import com.toy.memo.repository.AppliesRepository;
import com.toy.memo.repository.JopPostRepository;
import com.toy.memo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final JopPostRepository jopPostRepository;
    private final AppliesRepository appliesRepository;

    // 채용공고 지원
    public Boolean applyJop(AppliesReq appliesReq) {
        Optional<Member> optMem = memberRepository.findById(appliesReq.getMemberNo());
        Optional<JopPost> optJop = jopPostRepository.findById(appliesReq.getJopPostNo());

        if(optMem.isPresent() && optJop.isPresent()) {
            appliesRepository.save(
                    Applies.toEntity(optMem.get(), optJop.get())
            );

        }
        else if(optMem.isEmpty())
            throw new IllegalArgumentException("not found member : " + appliesReq.getMemberNo());
        else
            throw new IllegalArgumentException("not found jopPost : " + appliesReq.getJopPostNo());

        return true;
    }
}
