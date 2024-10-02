import java.time.LocalDate;

import prob2B.*;
import prob2C.*;

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
