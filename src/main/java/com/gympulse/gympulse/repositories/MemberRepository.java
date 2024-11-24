package com.gympulse.gympulse.repositories;

import com.gympulse.gympulse.model.person.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MemberRepository extends MongoRepository <Member , ObjectId> {
    //find a member by their unique member ID
    Optional<Member> find ByMemberId(String memberID);
}
