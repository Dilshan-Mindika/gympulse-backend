package com.gympulse.gympulse.service.Implimentation;


import com.gympulse.gympulse.model.person.Member;
import com.gympulse.gympulse.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
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
    public Optional<Member> findByMemberId(String memberId){
        return Optional.empty();
    }

    @Override
    public Optional<Member> memberById(String memberId){
        //Find a member by their member ID
        return memberRepository.findByMemberId(memberId);
    }

    @Override
    public Member updateMember(String MemberId, MemberRequest memberRequest) {
        //Update an existing Member's details
        Optional<Member> optionalMember = memberRepository.findByMemberId(memberId);
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            member.setAddress(memberRequest.getAddress());
            member.setEmail(memberRequest.getEmail());
            member.setEndData(memberRequest.getEndData());
            member.setFullNmame(memberRequest.getFullName());
            member.setMemberShipType(memberRequest.getMemberShipType());
            member.setPhoneNumber(memberRequest.getPhoneNumber());
            member.setStartData(memberRequest.getStartData());
            logger.log("Member updated,Id: " + memberId);
            return memberRepository.save(member);
        }else{
            throw new NoSuchElementException("Member not found for ID: " +memberId);
        }
    @Override
    public void deleteByMemberId(String memberId){
            //Delete a member by their member ID
            Optional<Member> member = memberRepository.findByMemberId(memberId);
            if (member.isPresent()){
                logger.log("Member deleted ,ID:" + memberId);
                memberRepository.delete(member.get());
            }else {
                throw new NoSuchElementException("Member not found for ID: " +memberId);
            }
        }

        private Sting generateNextMemberId(){
            //Generate the next unique ID
        List<Member> members = allMembers();
        Set<String> userIds = members.stream().map(Member:: getMemberId).collect(Collectors.toSet());

        for(int i = 1; i<= 9999; i++){
            String candidatedId = String.format("%4d",i);

            if (!userIds.contains(candidatedId)){
                return candidatedId; // return the first unused Id
            }
        }
        return null; //no availble ID found
        }

    }
}
