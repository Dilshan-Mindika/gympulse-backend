package com.gympulse.gympulse.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository  extends MongoRepository<Member,ObjectId> {
    // finds a menber by thier unique member ID
    Optional<Member> findByMemberId(String memberId);
}