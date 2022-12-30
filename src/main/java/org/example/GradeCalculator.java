package org.example;

import java.util.List;

public class GradeCalculator {
    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }
 
    public List<Course> getCourses() {
        return courses;
    }

    // 일급 컬렉션 사용
    public double calculateGrade() {
        // 학점수 * 교과목 평점 합계
        double multipliedCreditAndCourseGrade = 0.0;
        for (Course course : courses) {
            multipliedCreditAndCourseGrade += course.getCredit() * course.getGradeToNumber();
        }
        // 수강신청 총 학점 수
        int totalCompletedCredit = courses
                .stream() // mapToInt int stream 으로 변화시킴
                .mapToInt(Course::getCredit)  //method reference, 메서드의 인자와 리턴값을 알고 있어야 함
                .sum();
        return multipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
