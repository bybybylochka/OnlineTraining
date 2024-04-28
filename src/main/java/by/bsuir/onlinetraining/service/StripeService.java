package by.bsuir.onlinetraining.service;

import by.bsuir.onlinetraining.models.Course;

public interface StripeService {
    String createPaymentLinkForCourse(Course course);
}
