package com.seme.school;

/*
* The program accepts a list of teachers , students and courses as many as the user wants
* then it gives a choice to show the lists of student, teachers or courses
* finally it displays the lists you requested with their behaviors
* */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainSchoolApp {

    public static void main(String[] args) {

       Scanner input = new Scanner(System.in);
       Random rand =new Random();

        ArrayList<Teacher> listTeacher = new ArrayList<>();
        ArrayList<Student> listStudent = new ArrayList<>();
        ArrayList<Course> listCourse= new ArrayList<>();





        //****************** adding teachers  *********************
        System.out.println("Adding teacher: ");
        String addTeacher;
        do{
            Teacher teacher = new Teacher();
            System.out.println("Enter the first name of the teacher: ");
            String fName = input.nextLine();
            teacher.setFirstName(fName);
            System.out.println("Enter the last name of the teacher: ");
            String lName = input.nextLine();
            teacher.setLastName(lName);
            System.out.println("Enter the email address of the teacher: ");
            String email= input.nextLine();
            teacher.setEmail(email);
            System.out.println("Enter the id number of the teacher: ");
            long id = input.nextLong();
            teacher.setId(id);
            input.nextLine();
            System.out.println("do you want to add more teachers to school ? yes/no");
            addTeacher=input.nextLine();
            listTeacher.add(teacher);
        }while(addTeacher.equalsIgnoreCase("yes"));


// *******************  adding students ********************************

        System.out.println("Adding Student: ");
        String addStudent;
        do{
        Student student= new Student();
        System.out.println("Enter the first name of the student: ");
        String fName = input.nextLine();
        student.setFirstName(fName);
        System.out.println("Enter the last name of the student: ");
        String lName = input.nextLine();
        student.setLastName(lName);
        System.out.println("Enter the email address of the student: ");
        String email= input.nextLine();
        student.setEmail(email);
        System.out.println("Enter the id number of the student: ");
        long id = input.nextInt();
        student.setId(id);
        input.nextLine();
        System.out.println("do you want to add more students to school ? yes/no");
        addStudent=input.nextLine();
        listStudent.add(student);
    }while(addStudent.equalsIgnoreCase("yes"));


// **************adding courses ***********************
        System.out.println("Adding Courses: ");
        String addCourse;
        do{
            Course course = new Course();
            System.out.println("Enter the id number of the course !");
            long courseId = input.nextLong();
            input.nextLine();
            course.setId(courseId);
            System.out.println("Enter the course name ");
            String cName=input.nextLine();
            course.setName(cName);
            System.out.println("Do you want to add more courses ? yes/no");
            addCourse=input.nextLine();
            listCourse.add(course);
           // input.nextLine();
        }while(addCourse.equalsIgnoreCase("yes"));


    //**** providing options for listing students, teachers or courses **************

        System.out.println("Which list do you want to see: \n1. Students : \n2.Courses \n3.Teachers ");
        int choice = input.nextInt();
        switch (choice){
            case 1:{
                System.out.println("Students:");
                for(Student stud: listStudent){
                    System.out.println("ID Number: "+ stud.getId()+"\nFirst Name: "+stud.getFirstName()+"\nLast Name: "+ stud.getLastName()+"\nE-mail Address: "+
                    stud.getEmail()+"\nTakes: "+listCourse.get(0).getName()+" "+ listCourse.get(0).getId()+"\n");
                }
                break;
            }
            case 2: {
                System.out.println("Courses: ");
                for(Course courses: listCourse){
                    System.out.println("ID Number :"+ courses.getId()+"\nCourse Name : "+courses.getName() +"\n");
                }
                break;
            }
            case 3:{
                System.out.println("Teachers: ");
                for(Teacher teach: listTeacher){
                    System.out.println("ID Number: "+ teach.getId()+"\nFirst Name: "+teach.getFirstName()+"\nLast Name: "+ teach.getLastName()+"\nE-mail Address: "+
                            teach.getEmail()+"\nTeaches: "+listCourse.get(0).getName()+" "+listCourse.get(0).getId()+"\n");
                }
                break;
            }
            default:
                System.out.println("you have entered a wrong Selection ");
                break;
        }

    }

}
