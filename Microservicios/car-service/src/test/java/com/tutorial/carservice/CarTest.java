package com.tutorial.carservice;

import com.tutorial.carservice.entity.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    Car car;
    Car car2;

    @BeforeEach
    public void startMethod(){
        System.out.println("start");
        car = new Car(1,"Toyota","2022",5);
        car2 = new Car(2,"Nissan","2021",5);
    }

    @Test
    public void testEquals(){
        String brand = "Toyota";
        String modelReal = car.getBrand();
        Assertions.assertEquals(brand,modelReal);
    }

    @Test
    public void testNotNull(){
        Assertions.assertNotNull(car.getModel(),"Id´nt model");
    }

    @Test
    public void testNotEquals(){
        Assertions.assertNotEquals(car,car2);
    }
}
