package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPhysics {
    Physics physics=new Physics();
    private double delta=1e-3;
    @Before
    public void setUp() {
        Physics physics = new Physics();
    }
    @Test
    public void shouldCalculatePositiveForce(){
        assertEquals(12, physics.calculateForce(3, 4),delta);
    }
    @Test
    public void shouldCalculateNegativeForce(){
        assertEquals(-12, physics.calculateForce(3, -4),delta);
    }
    @Test
    public void shouldCalculateZeroForce(){
        assertEquals(0, physics.calculateForce(3, 0),delta);
    }
    @Test
    public void shouldCalculatePositiveVelocity(){
        assertEquals(3, physics.calculateVelocity(3,6,1,2),delta);
    }
    @Test
    public void shouldCalculateNegativeVelocity(){
        assertEquals(-3, physics.calculateVelocity(6,3,1,2),delta);
    }
    @Test
    public void shouldCalculateZeroVelocity(){
        assertEquals(0, physics.calculateVelocity(6,6,1,2),delta);
    }
    @Test
    public void shouldCalculatePositiveMass(){
        assertEquals(10, physics.calculateMass(100, 10),delta);
    }
    @Test
    public void shouldCalculateZeroMass(){
        assertEquals(0, physics.calculateMass(0, 10),delta);
    }
    @Test
    public void shouldReturnInfiniteMassInZeroGravity(){
        assertEquals(Double.POSITIVE_INFINITY, physics.calculateMass(100, 0),delta);
    }
    @Test
    public void shouldCalculatePositiveAcceleration(){
        assertEquals(1, physics.calculateAcceleration(1, 2,1,2),delta);
    }
    @Test
    public void shouldCalculateNegativeAcceleration(){
        assertEquals(-1, physics.calculateAcceleration(2,1,1,2),delta);
    }
    @Test
    public void shouldCalculateZeroAcceleration(){
        assertEquals(0, physics.calculateAcceleration(2,2,1,2),delta);
    }
    @Test
    public void shouldReturnInfiniteAccelerationWhenDividingByZero(){
        assertEquals(Double.POSITIVE_INFINITY, physics.calculateAcceleration(1,2,1,1),delta);
        assertEquals(Double.NEGATIVE_INFINITY, physics.calculateAcceleration(2,1,1,1),delta);
    }
    @Test
    public void shouldReturnInfiniteVelocityWhenDividingByZero(){
        assertEquals(Double.POSITIVE_INFINITY, physics.calculateVelocity(1,2,1,1),delta);
        assertEquals(Double.NEGATIVE_INFINITY, physics.calculateVelocity(2,1,1,1),delta);
    }
    @Test
    public void shouldCalculatePositiveDistance(){
        assertEquals(12, physics.calculateDistance(3, 4),delta);
    }
    @Test
    public void shouldHandleZeroDistance(){
        assertEquals(0, physics.calculateDistance(0, 4),delta);
        assertEquals(0, physics.calculateDistance(4, 0),delta);
    }


}
