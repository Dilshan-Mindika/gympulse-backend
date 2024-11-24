package com.gympulse.gympulse.Controllers;


import com.gympulse.gympulse.model.person.Member;
import com.gympulse.gympulse.requests.MemberRequest;
import com.gympulse.gympulse.service.Interfaces.MemberServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.classfile.instruction.StackInstruction;

@RestController
@RequestMapping
public class MemberCotroller {

    private MemberServices memberServices;

    //Endpoint to retrieve all members
    @GetMapping
    public Member creteMember(@RequestBody MemberRequest memberRequest) {
        // Extracting member details from the request
        String fullName = memberRequest.getFullName();
        String email = memberRequest.getEmail();
        String address = memberRequest.getAddress();
        String phoneNumber = memberRequest.getPhoneNumber();
        String memberShipType = memberRequest.getMemberShipType();
        String startDate = memberRequest.getStartDate();
        String endDate = memberRequest.getEndDate();
        WourkoutPlan workoutPlan = memberRequest.getWorkoutPlan();

        //creating and returning the new member
        return memberServices.createMember(fullName, email, phoneNumber, memberShipType,
                startDate, endDate, workoutPlan);

    }

    //endpoint to retrieve a specific member by their ID
    @GetMapping("/{memberId}")
    public ResponseEntity<Optional<Member>> grtMemberById(@PathVariable String memberId) {
        return new ResponseEntity<Optional<Member>>(memberServices.memberById(memberId)HttpStatus,OK); //Return member by ID
    }

    //endpoint to update an existing member's details by their ID
    @PutMapping("/{memberId}")
    public Member updateMember(@PathVariable String memberId, @RequestBody MemberRequest memberRequest) {
        return memberServices.updateMember(memberId, memberRequest); //update and return the modified member
    }


    //endpoint to delete a member by their ID
    @DeleteMapping("/{memberId}")
    public ResponseEntity<void> deleteMember(@PathVariable String memberId) {
        memberServices.deleteByMemberId(memberId); //Delete the member
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); //return no content response
    }


}
