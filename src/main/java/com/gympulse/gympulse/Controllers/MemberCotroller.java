package com.gympulse.gympulse.Controllers;


import com.gympulse.gympulse.requests.MemberRequest;
import com.gympulse.gympulse.service.Interfaces.MemberServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.classfile.instruction.StackInstruction;

@RestController
@RequestMapping
public class MemberCotroller {

    private MemberServices memberServices;

    //Endpoint to retrieve all members
    @GetMapping
    public Member creteMember(@RequestBody MemberRequest memberRequest){
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
}
