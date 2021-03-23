package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeBook {

    private String courseName;
    private double total;
    private int student;
    private int aCount;
    private int aMinusCount;
    private int bPlusCount;
    private int bCount;
    private int bMinusCount;
    private int cPlusCount;
    private int cCount;
    private int cMinusCount;
    private int dPlusCount;
    private int dCount;
    private int fCount;

    private int max;
    private int min;
    private double sumOfSquares;
    private double standardDeviation;

    //Declaring Array List
    ArrayList<Integer> gradeBook = new ArrayList<>(); // gradeBook is the name of ArrayList

    Scanner scanner = new Scanner(System.in);

    public GradeBook(String name)
    {
        courseName = name;
    }

    public void displayMessage()
    {
        System.out.println("Welcome to the Grade Book for " + courseName);
    }

    public void inputGrades()
    {
        System.out.println("Enter Grades or 0 to Exit: ");

        int grade = scanner.nextInt();

        while (grade != 0)
        {
            gradeBook.add(grade);

            if(grade>=93 && grade<=100)
            {
                aCount++;
            }
            else if(grade>=89 && grade<93)
            {
                aMinusCount++;
            }
            else if(grade>=86 && grade<89)
            {
                bPlusCount++;
            }
            else if(grade>=82 && grade<86)
            {
                bCount++;
            }
            else if(grade>=79 && grade<82)
            {
                bMinusCount++;
            }
            else if(grade>=75 && grade<79)
            {
                cPlusCount++;
            }
            else if(grade>=72 && grade<75)
            {
                cCount++;
            }
            else if(grade>=69 && grade<72)
            {
                cMinusCount++;
            }
            else if(grade>=65 && grade<69)
            {
                dPlusCount++;
            }
            else if(grade>=60 && grade<65)
            {
                dCount++;
            }
            else
            {
                fCount++;
            }

            total+=grade;
            student++;

            grade = scanner.nextInt();
        }

        if(student==0)
        {
            System.out.println("No Grades Were Entered");
            System.out.println("Exiting...");
            System.exit(0);
        }
    }

    public void maximumGrade()
    {
        max = gradeBook.get(0);
        for(int i=1; i<gradeBook.size(); i++)
        {
            if(gradeBook.get(i)>max)
            {
                max = gradeBook.get(i);
            }
        }
    }

    public void minimumGrade()
    {
        min = gradeBook.get(0);
        for(int i=1; i<gradeBook.size(); i++)
        {
            if(gradeBook.get(i)<min)
            {
                min = gradeBook.get(i);
            }
        }
    }

    public void standardDeviation()
    {
        double mean = total/student;
        for(int i: gradeBook)
        {
            double squaredDeviationFromMean = Math.pow((i - mean), 2);
            sumOfSquares += squaredDeviationFromMean;
        }
        double variance = sumOfSquares / (student - 1);
        standardDeviation = Math.sqrt(variance);
    }

    public void displayGradeReport()
    {
        while (true)
        {
            System.out.print("\n");
            System.out.println("1: Show All The Grades");
            System.out.println("2: Show Grade Report");
            System.out.println("0: Exit");

            int choice = scanner.nextInt();

            if(choice==1)
            {
                System.out.print("\n");
                System.out.println("All The Grades: ");
                for(int i: gradeBook)
                {
                    System.out.println(i);
                }
            }
            else if(choice==2)
            {
                System.out.print("\n");
                System.out.println("Grade Report: \n");

                double average = total/student;

                System.out.println("The sum of " + student + " students is " + total);
                System.out.printf("The average of %d students is %.2f\n", student, average);
                System.out.println("Highest Mark: "+ max);
                System.out.println("Lowest Mark: "+ min);
                System.out.printf("Standard Deviation: %.2f\n", standardDeviation);
                System.out.println("\nNumber of students who received each grade: ");
                System.out.println("A: " + aCount);
                System.out.println("A-: " + aMinusCount);
                System.out.println("B+: " + bPlusCount);
                System.out.println("B: " + bCount);
                System.out.println("B-: " + bMinusCount);
                System.out.println("C+: " + cPlusCount);
                System.out.println("C: " + cCount);
                System.out.println("C-: " + cMinusCount);
                System.out.println("D+: " + dPlusCount);
                System.out.println("D: " + dCount);
                System.out.println("F: " + fCount);
            }
            else if(choice==0)
            {
                System.out.println("Exiting...");
                System.exit(0);
            }
        }
    }
}