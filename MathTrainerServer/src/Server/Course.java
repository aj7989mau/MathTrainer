package Server;

/**
 * This Course class is going to act as a parent to three different courses of a primary school, 7, 8 and 9.
 * Each course is going to have a bunch of questions in a list and its correct answers
 * in another list.
 *
 * The class will be responsible to show up the question for the user in a random type style
 * and will be also responsible to figure out the right answer in order to save the points under
 * achievements.
 *
 * @author abdulsamisahil
 * @version 1.0
 * @since 2020-03-20
 *
 */
public abstract class Course {

    public abstract Questions[] getStastisticQuestion();
    public abstract  Questions[] getgeometryQuestions();
    public abstract  Questions[] getfourCountQuestions();

}