package cz.mendelu.busitweek2019;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

class ResultatAdaptor extends RecyclerView.Adapter<ResultatAdaptor.MyViewHolder> {
    private List<Player> names;
    private Context context;
    private int x = 1;

    public ResultatAdaptor(List<Player> names, Context context) {
        this.names = names;
        this.context = context;


    }

    @NonNull
    @Override
    public ResultatAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_results_puzzle, viewGroup, false);
        return new ResultatAdaptor.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ResultatAdaptor.MyViewHolder myViewHolder, int position) {
        Player p = names.get(position);
        myViewHolder.nameOfTheTeam.setText(p.getName());
        myViewHolder.ratingBar.setRating(p.getStars());
        myViewHolder.time.setText("" + p.getTime());
        myViewHolder.rankNumber.setText(""+x);
        x++;


    }

    @Override
    public int getItemCount() {
        int arr = 0;

        try {
            if (names.size() == 0) {

                arr = 0;

            } else {

                arr = names.size();
            }


        } catch (Exception e) {


        }

        return arr;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameOfTheTeam;
        public TextView time;
        public RatingBar ratingBar;
        public TextView rankNumber;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameOfTheTeam = itemView.findViewById(R.id.name);
            time = itemView.findViewById(R.id.time);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            rankNumber = itemView.findViewById(R.id.number);

        }
    }
}
