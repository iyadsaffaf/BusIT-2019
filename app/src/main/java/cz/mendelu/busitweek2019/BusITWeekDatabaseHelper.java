package cz.mendelu.busitweek2019;

import cz.mendelu.busItWeek.library.StoryLineDatabaseHelper;
import cz.mendelu.busItWeek.library.builder.StoryLineBuilder;

public class BusITWeekDatabaseHelper extends StoryLineDatabaseHelper {

    private DefaultTaskHelper taskHelper;

    public BusITWeekDatabaseHelper() {
        super(21);
    }

    @Override
    protected void onCreate(StoryLineBuilder builder) {

        // Start QR code without a question.
        builder.addCodeTask("0")
                .location(0,0)
                .qr("QR")
                .taskDone();

        taskHelper = new DefaultTaskHelper(builder);

        firstStage(49.212126, 16.617280);
        secondStage(49.212126, 16.617280);
        thirdStage(49.212126, 16.617280);
        fourthStage(49.212126, 16.617280);
        fifthStage(49.212126, 16.617280);
    }

    /**
     * Register the [first] stage of the app.
     *
     * @param latitude  latitude of the stage.
     * @param longitude longitude of the stage.
     */
    private void firstStage(double latitude, double longitude) {
        taskHelper.addNextStage(latitude, longitude);

        taskHelper.defaultGPSTask(1, 0, (builder) -> builder.simplePuzzle()
                .question("Answer Yes") // todo real questions
                .answer("Yes"));

        // Question 1 stays at the same location with a wrong answer.
        taskHelper.defaultGPSTask(1, 1, (builder) -> builder.simplePuzzle()
                .question("Answer Yes") // todo real questions
                .answer("Yes"));
    }

    /**
     * Register the [second] stage of the app.
     *
     * @param latitude  latitude of the stage.
     * @param longitude longitude of the stage.
     */
    private void secondStage(double latitude, double longitude) {
        taskHelper.addNextStage(latitude, longitude);

        taskHelper.defaultGPSTask(2, 0, (builder) -> builder.simplePuzzle()
                .question("Answer Yes") // todo real questions
                .answer("Yes"));

        // Question 2 and all following will move down.
        taskHelper.defaultGPSTask(2, 1, (builder) -> builder.simplePuzzle()
                .question("Answer Yes") // todo real questions
                .answer("Yes"));
    }

    /**
     * Register the [third] stage of the app.
     *
     * @param latitude  latitude of the stage.
     * @param longitude longitude of the stage.
     */
    private void thirdStage(double latitude, double longitude) {
        taskHelper.addNextStage(latitude, longitude);

        taskHelper.defaultGPSTask(3, 0, (builder) -> builder.simplePuzzle()
                .question("Answer Yes") // todo real questions
                .answer("Yes"));
        taskHelper.defaultGPSTask(3, 1, (builder) -> builder.simplePuzzle()
                .question("Answer Yes") // todo real questions
                .answer("Yes"));
        taskHelper.defaultGPSTask(3, 2, (builder) -> builder.simplePuzzle()
                .question("Answer Yes") // todo real questions
                .answer("Yes"));
    }

    /**
     * Register the [fourth] stage of the app.
     *
     * @param latitude  latitude of the stage.
     * @param longitude longitude of the stage.
     */
    private void fourthStage(double latitude, double longitude) {
        taskHelper.addNextStage(latitude, longitude);

        taskHelper.defaultGPSTask(4, 0, (builder) -> builder.simplePuzzle()
                .question("Answer Yes") // todo real questions
                .answer("Yes"));
        taskHelper.defaultGPSTask(4, 1, (builder) -> builder.simplePuzzle()
                .question("Answer Yes") // todo real questions
                .answer("Yes"));
        taskHelper.defaultGPSTask(4, 2, (builder) -> builder.simplePuzzle()
                .question("Answer Yes") // todo real questions
                .answer("Yes"));
    }

    /**
     * Register the [fifth] stage of the app.
     *
     * @param latitude  latitude of the stage.
     * @param longitude longitude of the stage.
     */
    private void fifthStage(double latitude, double longitude) {
        taskHelper.addNextStage(latitude, longitude);

        taskHelper.defaultGPSTask(5, 0, (builder) -> builder.simplePuzzle()
                .question("Answer Yes") // todo real questions
                .answer("Yes"));
        taskHelper.defaultGPSTask(5, 1, (builder) -> builder.simplePuzzle()
                .question("Answer Yes") // todo real questions
                .answer("Yes"));
        taskHelper.defaultGPSTask(5, 2, (builder) -> builder.simplePuzzle()
                .question("Answer Yes") // todo real questions
                .answer("Yes"));
    }

}
