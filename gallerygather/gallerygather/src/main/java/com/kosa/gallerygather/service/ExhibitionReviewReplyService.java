package com.kosa.gallerygather.service;

import com.kosa.gallerygather.dto.ExhibitionReviewReplyDto;
import com.kosa.gallerygather.entity.Exhibition;
import com.kosa.gallerygather.entity.ExhibitionReview;
import com.kosa.gallerygather.entity.ExhibitionReviewReply;
import com.kosa.gallerygather.entity.Member;
import com.kosa.gallerygather.repository.ExhibitionRepository;
import com.kosa.gallerygather.repository.ExhibitionReviewReplyRepository;
import com.kosa.gallerygather.repository.ExhibitionReviewRepository;
import com.kosa.gallerygather.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExhibitionReviewReplyService {
    private final ExhibitionReviewReplyRepository reviewReplyRepository;
    private final MemberRepository memberRepository;
    private final ExhibitionReviewRepository exhibitionReviewRepository;
    private final ExhibitionRepository exhibitionRepository;

    @Transactional
    public Page<ExhibitionReviewReplyDto.ExhibitionReviewReplyResponseDto> addCommentToReview(String email, Long reviewId, Long exhibitionId,
                                                                                              ExhibitionReviewReplyDto.ExhibitionReviewRequestDto replyDto) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        ExhibitionReview exhibitionReview = exhibitionReviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 리뷰입니다."));
        Exhibition exhibition = exhibitionRepository.findById(exhibitionId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 전시 정보입니다."));

        ExhibitionReviewReply reply = reviewReplyRepository
                .save(ExhibitionReviewReply.ofNewReply(member, exhibitionReview, replyDto.getReply()));

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("regDate").descending());

        return reviewReplyRepository.findByExhibitionReviewWithMember(exhibitionReview, pageRequest)
                .map(ExhibitionReviewReplyDto.ExhibitionReviewReplyResponseDto::new);
    }
}
