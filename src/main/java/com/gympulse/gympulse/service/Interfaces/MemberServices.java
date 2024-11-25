package com.gympulse.gympulse.service.Interfaces;


/** Service interface for managaing members. **/

public interface MemberServices {

    /**
     * Creates a new member.
     *
     * @param fullName       the full name of the member
     * @param email          the email address of the member
     * @param address        the address of the member
     * @param phoneNumber    the phone number of the member
     * @param memberShipType the type of membership
     * @param startDate      the start date of the membership
     * @param endDate        the end date of the membership
     * @param workoutPlan    the associated workout plan for the member
     * @return the created Member
     */
    Member createMember(String fullName, String email, String address, String phoneNumber,
                        String memberShipType, String startDate, String endDate, String workoutPlan);
    /**
     * Retrieves all members.
     *
     * @return a list of all Members
     */

    List<Member> allMembers();
    /**
     * Finds a member by their ID.
     *
     * @param memberId the ID of the member
     * @return an Optional containing the Member if found, or empty if not
     */

    Optional<Member> findMemberById(String memberId);

    Optional<Member> memberById(String memberId);


    /**
     * Updates an existing member's information.
     *
     * @param memberId the ID of the member to update
     * @param memberRequest the new data for the member
     * @return the updated Member
     */

    Member updateMember(String memberId, MemberRequest memberRequest);

    /**
     * Deletes a member by their ID.
     *
     * @param memberId the ID of the member to delete
     */

    void deleteByMemberId(String memberId);
}
