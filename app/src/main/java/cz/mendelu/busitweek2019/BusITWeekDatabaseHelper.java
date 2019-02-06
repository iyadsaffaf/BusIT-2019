package cz.mendelu.busitweek2019;

import cz.mendelu.busItWeek.library.StoryLineDatabaseHelper;
import cz.mendelu.busItWeek.library.builder.StoryLineBuilder;

public class BusITWeekDatabaseHelper extends StoryLineDatabaseHelper{


    public BusITWeekDatabaseHelper() {
        super(15);
    }

    @Override
    protected void onCreate(StoryLineBuilder builder) {
        builder.addGPSTask("1")
                .location(49.212126, 16.617280)
                .radius(100)
                .victoryPoints(10)
                .hint("Hint")
                .simplePuzzle()
                .question("What is the best Bus IT Week?")
                .answer("Brno")
                .hint("Question hint")
                .puzzleTime(30000)
                .puzzleDone()
                .taskDone();

        builder.addGPSTask("2")
                .location(0,0).
                radius(100000)
                .choicePuzzle()
                .addChoice("Fdsfs",false)
                .addChoice("Dfsdfasf",false)
                .addChoice("Fsdfdfsd",true)
                .addChoice("Fdfasfdds",false)
                .question("Really")
                 .puzzleDone()
        .taskDone();

        builder.addBeaconTask("3")
                .beacon(1,1)
                .imageSelectPuzzle()
                .addImage(R.drawable.brn,false)
                .addImage(R.drawable.cropped,false)
                .addImage(R.drawable.dalsi,true)
                .addImage(R.drawable.main,false)
                .question("Best drink ever")
                .puzzleDone()
                .location(1.0,1.0)
                .taskDone();




    }

}
