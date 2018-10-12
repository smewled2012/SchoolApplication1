package com.seme.school;

/*
* The program accepts a list of students, teachers and courses as many as the user wants
* it also accepts the courses that the student take and the teacher that teaches
* then it gives a choice to show the lists of student, teachers or courses
* finally it displays the lists you requested with their behaviors including the courses students taka and teachers teach
*
* */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainSchoolApp {
  static  Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


       Random rand =new Random();

        ArrayList<Teacher> listTeacher = new ArrayList<>();
        ArrayList<Student> listStudent = new ArrayList<>();
        ArrayList<Course> listCourse= new ArrayList<>();
        ArrayList<Course> courseAssign = new ArrayList<>();

        System.out.println("Welcome to our School ! \n Enter the Student, the teacher and the courses to school !");

        // *******************  adding students ********************************

        System.out.println("Adding Student to the school: ");
        //a method that adds students to the school
        listStudent=addStudents();
        //****************** adding teachers  *********************************

        System.out.println("Adding teacher to the school: ");
        // a method that adds teacher to the scool
       listTeacher= addTeachers();

        // **************adding courses ********************************************
        System.out.println("Adding Courses to the school : ");
        listCourse=addCourses();

      //**** providing options for listing students, teachers or courses **************

        String seeOption;
        do {
            System.out.println("Which list do you want to see: \n1.Students: \n2.Courses:  \n3.Teachers: ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1: {
                    System.out.println("Students:");
                    for (Student stud : listStudent) {

                        System.out.println("ID Number: " + stud.getId() + "\nFirst Name: " + stud.getFirstName() + "\nLast Name: " + stud.getLastName() + "\nE-mail Address: " +
                                stud.getEmail());
                        System.out.print("Takes: ");
                        for (int i = 0; i < stud.getCourses().size(); i++)
                            System.out.print(stud.getCourses().get(i).getName() + " " + stud.getCourses().get(i).getId() + ",");
                        System.out.println("\n");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Courses: ");
                    for (Course courses : listCourse) {
                        System.out.println("ID Number :" + courses.getId() + "\nCourse Name : " + courses.getName() + "\n");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Teachers: ");
                    for (Teacher teach : listTeacher) {
                        System.out.println("ID Number: " + teach.getId() + "\nFirst Name: " + teach.getFirstName() + "\nLast Name: " + teach.getLastName() + "\nE-mail Address: " +
                                teach.getEmail());
                        System.out.print("Teaches: ");
                        for (int i = 0; i < teach.getCourses().size(); i++)
                            System.out.print(teach.getCourses().get(i).getName() + " " + teach.getCourses().get(i).getId() + ",");
                        System.out.println("\n");
                    }
                    break;
                }
                default:
                    System.out.println("you have entered a wrong Selection ");
                    break;
            }

            System.out.println("\nDo you want to see the list again ? yes/no");
            seeOption= input.nextLine();

        }while(seeOption.equalsIgnoreCase("yes"));

        //******************listing of the courses  ******************************

        System.out.println("The listing of the courses ");
        for(Course course:listCourse){
            System.out.print("ID Number: "+ course.getId()+"\nName: "+ course.getName());
            for(int i=0;i<listTeacher.size();i++) {
                if (course.getName().equals(listTeacher.get(i).getCourses().get(i).getName()))
                    System.out.print("\nTaught By: " + listTeacher.get(i).getFirstName() + " " + listTeacher.get(i).getLastName());
                else
                    System.out.print("\nTaught By: No one ");
            }
            for(int j=0;j<listStudent.size();j++) {
                if (course.getName().equals(listStudent.get(j).getCourses().get(j).getName()))
                    System.out.print("\nTaken by: "+ listStudent.get(j).getFirstName()+" "+listStudent.get(j).getLastName());
                else
                    System.out.print("\nTaken By: No one ");

            }
            System.out.println("\n");

        }


        System.out.println("Thank you for your Information ! Good Bye ");
    }


    //a method that adds courses to the school
    private static ArrayList<Course> addCourses() {
        ArrayList<Course> listCourse= new ArrayList<>();

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

        return  listCourse;

    }

    //a method that adds students to the school

    private static ArrayList<Student> addStudents() {

        ArrayList<Course> courseAssign = new ArrayList<>();
        ArrayList<Student> listStudent = new ArrayList<>();
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
            // the methods adds the course the student can take
            System.out.println("Assign courses to the student that takes : ");
            courseAssign= takeTeachCourses();
            student.setCourses(courseAssign);
            System.out.println("Enter the id number of the student: ");
            long id = input.nextInt();
            student.setId(id);
            input.nextLine();
            System.out.println("do you want to add more students to school ? yes/no");
            addStudent=input.nextLine();
            listStudent.add(student);
        }while(addStudent.equalsIgnoreCase("yes"));

        return listStudent;

    }

    //a method that adds teachers to the school

    private static ArrayList<Teacher> addTeachers() {
        String addTeacher;
        ArrayList<Course> courseAssign = new ArrayList<>();
        ArrayList<Teacher> listTeacher = new ArrayList<>();


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

            // this methods asign for the teacher the courses he teaches
            System.out.println("Assign courses to the teacher that teaches it: ");
            courseAssign= takeTeachCourses();
            teacher.setCourses(courseAssign);

            System.out.println("Enter the id number of the teacher: ");
            long id = input.nextLong();
            teacher.setId(id);
            input.nextLine();
            System.out.println("do you want to add more teachers to school ? yes/no");
            addTeacher=input.nextLine();

            listTeacher.add(teacher);
        }while(addTeacher.equalsIgnoreCase("yes"));

        return listTeacher;

    }

    //a method that adds courses to each student that takes and to each teacher that teaches
    private static ArrayList<Course> takeTeachCourses() {

        ArrayList<Course> courseAssign = new ArrayList<>();

        String addMore;

        do{
            System.out.println("Enter the course ID: ");
            long ccr = input.nextLong();
            input.nextLine();
            Course course1 = new Course();
            course1.setId(ccr);
            System.out.println("Enter the course Name : ");
            String cname = input.nextLine();
            course1.setName(cname);
            System.out.println("do you want to add more course ? yes/no");
            addMore=input.nextLine();
            courseAssign.add(course1);
        }while(addMore.equalsIgnoreCase("yes"));
        return courseAssign;

    }


}
