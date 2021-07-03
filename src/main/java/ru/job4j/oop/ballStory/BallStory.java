package ru.job4j.oop.ballStory;

public class BallStory {

    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare =  new Hare();
        Fox fox = new Fox();
        Wolf wolf = new Wolf();
        hare.tryEat(ball);
        ball.runAway(hare);
        wolf.tryEat(ball);
        ball.runAway(wolf);
        fox.tryEat(ball);
    }
}
