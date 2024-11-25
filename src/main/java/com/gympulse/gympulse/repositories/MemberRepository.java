package com.nexus.GYMPULSE.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nexus.GYMPULSE.model.person.Member;

// Repository interface for managing Member entities in MongoDB
@Repository
public interface MemberRepository extends MongoRepository<Member, ObjectId> {
    // Finds a Member by their unique member ID
    Optional<Member> findByMemberId(String memberId);
}
