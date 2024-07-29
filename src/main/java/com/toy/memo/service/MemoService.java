package com.toy.memo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.toy.memo.model.Memo;
import com.toy.memo.repository.MemoLogRepository;
import com.toy.memo.repository.MemoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;
    private final MemoLogRepository memoLogRepository;
    

    // 메모 등록 Create
    @Transactional
    public Memo createMemo(Memo memo) {
    	Optional<Memo> optMemo = memoRepository.findBySerial(memo.getSerial());
    	
    	if(optMemo.isPresent()) {
    		Memo oldMemo = optMemo.get();
    		memoLogRepository.save(oldMemo.toLog());
    		
    		// 기존 메모 업데이트 및 dirty checking으로 저장
    		Memo newMemo = oldMemo.update(memo);
    		return newMemo;
    	} else {
    		
    		return memoRepository.save(memo);
    	}
    }

    // 메모 수정 Update TODO
    public Boolean updateMemo(Memo updateReq) {
        return true;
    }

    // 메모 삭제 Delete TODO
    public Boolean deleteMemo(int seq) {
        return true;
    }

    // 메모 전체 목록 ReadAll
    public List<Memo> getAllMemo() {
        return memoRepository.findByOrderByCrdteDesc();
    }

    // 메모 상세 내용 Detail
    public Memo getMemo(String serial) {
        Optional<Memo> optMemo = memoRepository.findBySerial(serial);

        if(optMemo.isEmpty()) {
        	throw new IllegalArgumentException("not found Memo");
        }
        
        return optMemo.get();
    }

    // 메모 수정 로그 TODO
    public List<Memo> getMemoHistory(String keyword) {
        return null;
    }
    
    // 메모 검색 Search
    public List<Memo> searchMemo(String keyword) {
        return memoRepository.getListOfMemo(keyword);
    }

}
