package com.kosa.gallerygather.repository;

import com.kosa.gallerygather.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
