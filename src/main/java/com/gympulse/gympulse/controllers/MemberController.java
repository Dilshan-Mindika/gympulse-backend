package com.gympulse.gympulse.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gympulse.gympulse.model.person.Member;
import com.gympulse.gympulse.model.workoutplan.WorkoutPlan;
import com.gympulse.gympulse.requests.MemberRequest;
import com.gympulse.gympulse.service.interfaces.MemberService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Members") // Base URL for member-related endpoints
public class MemberController {

    @Autowired
    private MemberService memberService; // Injecting the MemberService to handle business logic

    // Endpoint to retrieve all members
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        return new ResponseEntity<List<Member>>(memberService.allMembers(), HttpStatus.OK); // Return list of members with OK status
    }

    // Endpoint to create a new member
    @PostMapping
    public Member createMember(@RequestBody MemberRequest memberRequest) {
        // Extracting member details from the request
        String fullName = memberRequest.getFullName();
        String email = memberRequest.getEmail();
        String address = memberRequest.getAddress();
        String phoneNumber = memberRequest.getPhoneNumber();
        String memberShipType = memberRequest.getMemberShipType();
        String startDate = memberRequest.getStartDate();
        String endDate = memberRequest.getEndDate();
        WorkoutPlan workoutPlan = memberRequest.getWorkoutPlan();

        // Creating and returning the new member
        return memberService.createMember(fullName, email, address, phoneNumber, memberShipType, startDate, endDate, workoutPlan);
    }

    // Endpoint to retrieve a specific member by their ID
    @GetMapping("/{memberId}")
    public ResponseEntity<Optional<Member>> getMemberById(@PathVariable String memberId) {
        return new ResponseEntity<Optional<Member>>(memberService.memberById(memberId), HttpStatus.OK); // Return member by ID
    }

    // Endpoint to update an existing member's details by their ID
    @PutMapping("/{memberId}")
    public Member updateMember(@PathVariable String memberId, @RequestBody MemberRequest memberRequest) {
        return memberService.updateMember(memberId, memberRequest); // Update and return the modified member
    }

    // Endpoint to delete a member by their ID
    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable String memberId) {
        memberService.deleteByMemberId(memberId); // Delete the member
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return no content response
    }
}
