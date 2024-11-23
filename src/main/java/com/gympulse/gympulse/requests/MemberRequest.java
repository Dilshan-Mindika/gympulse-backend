package com.gympulse.gympulse.requests;

import lombok.Data;


//Request object for creating or updating a Member
@Data
public class MemberRequest {

    private String memberId; //Unique identifier for th member
    private String memberShipType;//Type of membership (E.g. ,basic.premium)
    private String startDate;// Membership satrt date
    private String endDate;//Membershio end date
    private String workoutPlan;// accoiated workout plan for the member
    private String fullName;//member full name
    private String email;//member email address
    private String address;//member current address
    private String phoneNumber;//contact phone nubmbe
}
