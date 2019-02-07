package cz.mendelu.busitweek2019;

import cz.mendelu.busItWeek.library.StoryLineDatabaseHelper;
import cz.mendelu.busItWeek.library.builder.StoryLineBuilder;

public class BusITWeekDatabaseHelper extends StoryLineDatabaseHelper{


    public BusITWeekDatabaseHelper() {
        super(20);
    }

    @Override
    protected void onCreate(StoryLineBuilder builder) {

        builder.addCodeTask("1")
                .location(0,0)
                .qr("QR")
                .taskDone();

        builder.addGPSTask("2")
                .location(49.212126, 16.617280)
                .radius(100)
                .victoryPoints(10)
                .hint("Hint")
                .simplePuzzle()
                .question("What is the best Bus IT Week?")
                .answer("Br")
                .hint("Question hint")
                .puzzleTime(30000)
                .puzzleDone()
                .taskDone();


        builder.addBeaconTask("3")
                .beacon(29028,54274)
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
