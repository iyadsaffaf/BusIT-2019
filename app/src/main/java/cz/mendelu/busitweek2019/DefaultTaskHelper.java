package cz.mendelu.busitweek2019;

import com.mapbox.mapboxsdk.geometry.LatLng;

import java.util.ArrayList;
import java.util.List;

import cz.mendelu.busItWeek.library.builder.PuzzleBuilder;
import cz.mendelu.busItWeek.library.builder.StoryLineBuilder;
import cz.mendelu.busItWeek.library.builder.TaskBuilder;

class DefaultTaskHelper {

    private final static int VICTORY_POINTS = 1;
    private final static int RADIUS = 5;

    private final StoryLineBuilder builder;
    private List<LatLng> locations;

    DefaultTaskHelper(StoryLineBuilder builder) {
        this.builder = builder;
        locations = new ArrayList<>();
    }

    /**
     * Register the next stage in the arraylist.
     * @param latitude Double representing the Latitude of the stage.
     * @param longitude Double representing the Longitude of the stage.
     */
    void addNextStage(double latitude, double longitude){
        locations.add(new LatLng(latitude, longitude));
    }

    /**
     * Register a basic GPS task.
     *
     * @param stage Stage of the task.
     * @param stepsBack Amount of steps of the task.
     * @return The builder.
     */
    StoryLineBuilder defaultGPSTask(int stage, int stepsBack, DefaultPuzzleBuilder defaultTaskBuilder){
        if(stage > locations.size()){
            throw new NullPointerException(String.format("Requesting stage %d, but only %d stages registered.", stage, stepsBack));
        }

        TaskBuilder taskBuilder =  builder.addGPSTask(Integer.toString(stage) + "-" + Integer.toString(stepsBack + 1))
                .location(locations.get(stage - 1).getLatitude(), locations.get(stage - 1).getLongitude())
                .radius(RADIUS)
                .victoryPoints(VICTORY_POINTS);

        PuzzleBuilder puzzleBuilder = defaultTaskBuilder.build(taskBuilder);
        puzzleBuilder = (PuzzleBuilder) puzzleBuilder.puzzleTime(30000);

        return ((TaskBuilder) puzzleBuilder.puzzleDone()).taskDone();
    }

    public interface DefaultPuzzleBuilder{
        PuzzleBuilder build(TaskBuilder builder);
    }

}
