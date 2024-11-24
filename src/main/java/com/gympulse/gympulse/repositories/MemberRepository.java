package com.gympulse.gympulse.repositories;

import com.gympulse.gympulse.model.person.Member;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MemberRepository extends MongoRepository <Member , ObjectId> {
    //find a member by their unique member ID
    Optional<Member> findByMemberId(String memberID);
}
