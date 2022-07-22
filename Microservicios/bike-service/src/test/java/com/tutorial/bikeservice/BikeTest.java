package com.tutorial.bikeservice;

import com.tutorial.bikeservice.entity.Bike;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BikeTest {
    Bike bike;
    Bike bike2;

    @BeforeEach
    public void startMethod(){
        System.out.println("start");
        bike = new Bike(1,"Mitsubishi","2022",5);
        bike2 = new Bike(2,"Chevrolet","2021",12);
    }

    @Test
    public void testEquals(){
        String brand = "Mitsubishi";
        String modelReal = bike.getBrand();
        Assertions.assertEquals(brand,modelReal);
    }

    @Test
    public void testNotNull(){
        Assertions.assertNotNull(bike.getModel(),"Id´nt model");
    }

    @Test
    public void testNotEquals(){
        Assertions.assertNotEquals(bike,bike2);
    }

}
