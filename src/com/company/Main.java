package com.company;

public class Main {

    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook("CSE 124.5");
        gradeBook.displayMessage();
        gradeBook.inputGrades();
        gradeBook.maximumGrade();
        gradeBook.minimumGrade();
        gradeBook.standardDeviation();
        gradeBook.displayGradeReport();
    }
}
