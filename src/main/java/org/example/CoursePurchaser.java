package org.example;

public class CoursePurchaser {
    private final JavaCourse javaCourse;

    public CoursePurchaser(JavaCourse javaCourse) {
        this.javaCourse = javaCourse;
    }
    public void giveMePriceOfCourse(){
       javaCourse.purchaseCourse();
    }
}
