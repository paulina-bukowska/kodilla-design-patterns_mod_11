package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task makeShape(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Breakfast", "milk", 2);
            case PAINTING:
                return new PaintingTask("Attic", "blue", "side walls");
            case DRIVING:
                return new DrivingTask("Nephew", "main station", "car");
            default:
                return null;
        }
    }
}
