package com.gympulse.gympulse.service.Implimentation;


import com.gympulse.gympulse.model.person.Member;
import com.gympulse.gympulse.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    private GymLogger logger = GymLogger.getInstance();

    @Autowired
    private MemberRepository memberRepository;


    @Override
    public Member createMember(String fullName, String email, String address, String phoneNumber,
                               String memberShipType, String startdate, String endDate,WorkoutPlan workoutPlan) {

        //Generate a unique member ID
        String memberId = generateNextMemberId();
        if (memberId =! null ) {
            //Create and save the new Member
            Member menber = memberRepository.insert(new Member(fullName, email, address, phoneNumber,memberId, memberShipType, startDate,endDate, workoutPlan));
            logger.log("New Member added, Member ID :" + memberId);
            return member;
        } else {
            throw new IllegalStateException("Member limit reached. Connot creat more members.")
        }
    }

    @Override
    public List <Member> allMembers(){
        //Retrieve all members from the repository
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> memberById
}
