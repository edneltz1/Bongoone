package com.example.ednel.bongoone;

import android.app.NotificationManager;
import android.media.MediaPlayer;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

/**
 * Created by EdNel on 3/20/2018.
 */

public class mikoanadapter extends RecyclerView.Adapter<mikoanadapter.MyViewHolder> {

    private List<mikoan> mikoansList;

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView Tittle;
        ImageView picha;
        movie stream;
        //String stream;
        MediaPlayer mediaPlayer;
        ImageButton play;

        public void setStream(movie stream) {
            this.stream = stream;
        }

        public MyViewHolder(View view) {
            super(view);
            Tittle = (TextView) view.findViewById(R.id.Tittle);
            picha = (ImageView) view.findViewById(R.id.picha);
            Tittle.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                        }
                    }
            );

        }





    }
    public mikoanadapter(List<mikoan> mikoansList) {
        this.mikoansList = mikoansList;
    }

    @Override
    public mikoanadapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mikoan, parent, false);


        return new mikoanadapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(mikoanadapter.MyViewHolder holder, int position) {
        mikoan mikoan = mikoansList.get(position);
        //  final MediaPlayer mediaPlayer = MediaPlayer.create(holder.itemView.getContext(),movie.getStream());
        holder.Tittle.setText(mikoan.getTittle());
        holder.picha.setImageResource(mikoan.getPicha());
        // holder.picha.(movie.getPicha());
    }





    @Override
    public int getItemCount() {
        return mikoansList.size();
    }

}


