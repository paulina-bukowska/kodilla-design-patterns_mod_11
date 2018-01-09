package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {
    private String taskName;
    private String color;
    private String whatToPaint;
    private boolean taskDone = false;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public String executeTask() {
        taskDone = true;
        return "Paint " + whatToPaint + " in " + color;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return taskDone;
    }
}
