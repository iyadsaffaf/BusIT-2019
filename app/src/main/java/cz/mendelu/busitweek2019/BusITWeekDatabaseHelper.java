package cz.mendelu.busitweek2019;

import cz.mendelu.busItWeek.library.StoryLineDatabaseHelper;
import cz.mendelu.busItWeek.library.builder.StoryLineBuilder;

public class BusITWeekDatabaseHelper extends StoryLineDatabaseHelper {

    private DefaultTaskHelper taskHelper;

    public BusITWeekDatabaseHelper() {
        super(25);
    }

    @Override
    protected void onCreate(StoryLineBuilder builder) {


        taskHelper = new DefaultTaskHelper(builder);

        firstStage(49.209790, 16.615008);
        secondStage(49.210025, 16.614832);
        thirdStage(49.210083, 16.614406);
        fourthStage(29028 ,54274);
        fifthStage(29028 ,54274);
    }

    /**
     * Register the [first] stage of the app.
     *
     * @param latitude  latitude of the stage.
     * @param longitude longitude of the stage.
     */
    private void firstStage(double latitude, double longitude) {
        taskHelper.addNextStage(latitude, longitude);

        taskHelper.defaultGPSTask(1, 0, (builder) -> builder.choicePuzzle()
                .puzzleTime(20000)
                .question("What is the Czech currency?")
                .addChoice("Euro", false)
                .addChoice("Dollar", false)
                .addChoice("Kron", true));

        // Question 1 stays at the same location with a wrong answer.
        taskHelper.defaultGPSTask(1, 1, (builder) -> builder.simplePuzzle()
                .puzzleTime(20000)
                .question("At what building at Mendel University can we get lunch? (One letter)")
                .answer("X"));
    }

    /**
     * Register the [second] stage of the app.
     *
     * @param latitude  latitude of the stage.
     * @param longitude longitude of the stage.
     */
    private void secondStage(double latitude, double longitude) {
        taskHelper.addNextStage(latitude, longitude);

        taskHelper.defaultGPSTask(2, 0, (builder) -> builder.imageSelectPuzzle()
                .puzzleTime(30000)
                .question("We were at the church of S James during the city your. Which church is this?")
                .addImage(R.drawable.q1_1, false)
                .addImage(R.drawable.q1_2, false)
                .addImage(R.drawable.q1_3, true));

        // Question 2 and all following will move down.
        taskHelper.defaultGPSTask(2, 1, (builder) -> builder.simplePuzzle()
                .puzzleTime(20000)
                .question("Does the city of Brno have an official football team? Answer with yes or no.")
                .answer("yes"));
    }

    /**
     * Register the [third] stage of the app.
     *
     * @param latitude  latitude of the stage.
     * @param longitude longitude of the stage.
     */
    private void thirdStage(double latitude, double longitude) {
        taskHelper.addNextStage(latitude, longitude);

        taskHelper.defaultGPSTask(3, 0, (builder) -> builder.choicePuzzle()
                .puzzleTime(30000)
                .question("Who occupied the Czech Republic in World War II?")
                .addChoice("Germany", true)
                .addChoice("Netherlands", false)
                .addChoice("Sweden", false));
        taskHelper.defaultGPSTask(3, 1, (builder) -> builder.choicePuzzle()
                .puzzleTime(40000)
                .question("What are the colors of the Czech flag in the good order? (type in order, with commas and without spaces)")
                .addChoice("red,white,blue", true)
                .addChoice("red,blue,white", false)
                .addChoice("blue,white,red", false));
        taskHelper.defaultGPSTask(3, 2, (builder) -> builder.choicePuzzle()
                .puzzleTime(40000)
                .question("Who is the president of the Czech Republic?")
                .addChoice("Miloš Zeman", true)
                .addChoice("Andrej Babiš", false)
                .addChoice("Václav Klaus", false));
        taskHelper.defaultGPSTask(3, 3, (builder) -> builder.choicePuzzle()
                .puzzleTime(40000)
                .question("Which countries border to The Czech Republic?")
                .addChoice("Austria, Germany, Poland, Slovakia", true)
                .addChoice("Germany, Croatia, Bulgaria", false)
                .addChoice("Germany, Ukraine, Serbia, White Russia", false));
    }

    /**
     * Register the [fourth] stage of the app.
     *
     * @param major  major of the stage.
     * @param minor minor of the stage.
     */
    private void fourthStage(double major, double minor) {
        taskHelper.addNextStage(major, minor);

        taskHelper.defaultBeaconTask(4, 0, (builder) -> builder.choicePuzzle()
                .puzzleTime(40000)
                .question("What is the name of the nearest university bus stop?")
                .addChoice("Sportovní", false)
                .addChoice("Erbenova", true)
                .addChoice("Zimní Stadion", false));

        taskHelper.defaultBeaconTask(4, 1, (builder) -> builder.choicePuzzle()
                .puzzleTime(40000)
                .question("At the city tour a legend was told about a creature. Which animal was this?")
                .addChoice("Crocodile", true)
                .addChoice("Dragon", false)
                .addChoice("Whale", false));

        taskHelper.defaultBeaconTask(4, 2, (builder) -> builder.choicePuzzle()
                .puzzleTime(30000)
                .question("How old is the Mendel University?")
                .addChoice("50 years", false)
                .addChoice("90 years", false)
                .addChoice("100 years", true));

        taskHelper.defaultBeaconTask(4, 3, (builder) -> builder.imageSelectPuzzle()
                .puzzleTime(40000)
                .question("Who was the most famous player of the Czech Republic?")
                .addImage(R.drawable.q12_1, false)
                .addImage(R.drawable.q12_2, false)
                .addImage(R.drawable.q12_3, true));
    }

    /**
     * Register the [fifth] stage of the app.
     *
     * @param minor  minor of the stage.
     * @param major major of the stage.
     */
    private void fifthStage(double minor, double major) {
        taskHelper.addNextStage(minor, major);

        taskHelper.defaultBeaconTask(5, 0, (builder) -> builder.choicePuzzle()
                .puzzleTime(40000)
                .question("During the city tour, we world told about an old map of the city. Which century was the map made?")
                .addChoice("19th", false)
                .addChoice("18th", false)
                .addChoice("17th", true));

        taskHelper.defaultBeaconTask(5, 1, (builder) -> builder.choicePuzzle()
                .puzzleTime(40000)
                .question("What is the most famous sport in Brno?")
                .addChoice("Ice hockey", true)
                .addChoice("Tennis", false)
                .addChoice("Basketball", false));

        taskHelper.defaultBeaconTask(5, 2, (builder) -> builder.choicePuzzle()
                .puzzleTime(40000)
                .question("What is the most popular beer in the Czech Republic?")
                .addChoice("IPA", false)
                .addChoice("Pills", true)
                .addChoice("Weisen", false));


    }

}
