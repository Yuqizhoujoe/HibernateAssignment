package com.joe;

public class MainForInstructor {

    public static void main(String args[]) {
        // Instructor
        System.out.println("Instructor and Instructor Detail");
        InstructorApplication iapp = new InstructorApplication();
        // create Instructor and InstructorDetails
        iapp.createInstructor("yang", "YYYYYYQQQQQ", "yangs@itlize.com",
        "http://www.youtube.com", "Swiming");
        iapp.getInstructorDetails(1);
        System.out.println("Update Instructor with id 1");
        // find the Instructor
        Instructor instructor = iapp.findInstructor(1);
        // set the Instructor
        instructor.setFirstName("Celestial");
        instructor.setLastName("Dragons");
        instructor.setEmail("TonyTonyChopper@gmail.com");
        // get the Instructor Details
        InstructorDetails instructorDetails = instructor.getInstructorDetail();
        // set the InstructorDetails
        instructorDetails.setYoutubeChannel("OnePieceYoutubeChannel");
        instructorDetails.setHobby("Anime");
        System.out.println(iapp.update(instructor));

        // get the Instructor Details
        iapp.getInstructorDetails(1);

    }

}
