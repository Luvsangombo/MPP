package lab2.prob2;

import java.time.LocalDate;

import lab2.prob2.prob2C.*;
import lab2.prob2.prob2B.*;


public class Main {
    public static void main(String[] args) {
        Student student = new Student("ali", "12");
        System.out.println(student.getName());
        System.out.println(student.getGradeReport().getGrade());

        Order order = new Order("ORD123", LocalDate.now());

        OrderLine line1 = new OrderLine(2, 50.0, 1);
        OrderLine line2 = new OrderLine(1, 150.0, 2);

        order.addOrderLine(line1);
        order.addOrderLine(line2);

        System.out.println(order.getOrderLines());
    }

}
