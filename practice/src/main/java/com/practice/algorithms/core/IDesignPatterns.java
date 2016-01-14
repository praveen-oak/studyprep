package com.practice.algorithms.core;


/*
    In software engineering, a design pattern is a general repeatable solution to a commonly occurring problem
    in software design. A design pattern isn't a finished design that can be transformed directly into code.
    It is a description or template for how to solve a problem that can be used in many different situations.

    There are 23 Design patterns which will help in re-usability, modularity of the software. It will also speed up the
    development process. These patterns will also help in increasing cohesion and reducing coupling of the software.

    Design patterns can be categorised in following categories:

    - Creational Design Patterns:
        These design patterns are all about class instantiation. This pattern can be
        further divided into class-creation patterns and object-creational patterns. While class-creation patterns use
        inheritance effectively in the instantiation process, object-creation patterns use delegation effectively to
        get the job done.
        In software engineering, creational design patterns are design patterns that deal with object creation
        mechanisms, trying to create objects in a manner suitable to the situation. The basic form of object creation
        could result in design problems or added complexity to the design. Creational design patterns solve this problem
        by somehow controlling this object creation.

        Below are the patterns which falls under Creational Design Patterns:
            - Singleton Pattern
            - Factory Pattern
            - Abstract Factory Pattern
            - Builder Pattern
            - Prototype Pattern


    - Structural Design Patterns:
        These design patterns are all about Class and Object composition. Structural class-creation patterns use
        inheritance to compose interfaces. Structural object-patterns define ways to compose objects to obtain new
        functionality.

        Below are the patterns which falls under Structural Design Patterns:
            - Adapter Pattern
            - Composite Pattern
            - Proxy Pattern
            - Flyweight Pattern
            - Facade Pattern
            - Bridge Pattern
            - Decorator Pattern


    - Behavioral Design Patterns:
        These design patterns are all about Class's objects communication. Behavioral patterns are those patterns that
        are most specifically concerned with communication between objects.

        Below are the patterns which falls under Behavioral Design Patterns:
            - Template Method Pattern
            - Mediator Pattern
            - Chain of Responsibility Pattern
            - Observer Pattern
            - Strategy Pattern
            - Command Pattern
            - State Pattern
            - Visitor Pattern
            - Iterator Pattern
            - Memento Pattern


    References:
    https://sourcemaking.com/design_patterns
    http://www.tutorialspoint.com/design_pattern/design_pattern_resources.htm
    http://www.avajava.com/tutorials/categories/design-patterns

 */

import org.codehaus.jettison.json.JSONObject;

public interface IDesignPatterns
{

    public String run(JSONObject input);

    public void setInput(JSONObject input);

}
