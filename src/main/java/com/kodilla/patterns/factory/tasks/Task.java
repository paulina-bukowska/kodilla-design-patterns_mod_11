package com.kodilla.patterns.factory.tasks;

public interface Task {
    //wykonuje zadanie
    String executeTask();

    //zwraca nazwę zadania do wykonania
    String getTaskName();

    //zwraca true lub false w zależności od tego czy zadanie jest już wykonane
    boolean isTaskExecuted();

}
