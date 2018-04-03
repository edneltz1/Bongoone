package com.example.ednel.bongoone;
import android.media.MediaPlayer;
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

public class topadapter extends RecyclerView.Adapter<topadapter.MyViewHolder> {

    private List<top> topsList;
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
                            mediaPlayer=new MediaPlayer();
                            try {
                                mediaPlayer.setDataSource("http://uk4-vn.mixstream.net:8076/;listen.mp3");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            mediaPlayer.start();
                        }
                    }
            );

        }




    }
    public topadapter(List<top> topsList) {
        this.topsList = topsList;
    }

    @Override
    public topadapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.top, parent, false);


        return new topadapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(topadapter.MyViewHolder holder, int position) {
        top top = topsList.get(position);
        //  final MediaPlayer mediaPlayer = MediaPlayer.create(holder.itemView.getContext(),movie.getStream());
        holder.Tittle.setText(top.getTittle());
        holder.picha.setImageResource(top.getPicha());
        // holder.picha.(movie.getPicha());
    }





    @Override
    public int getItemCount() {
        return topsList.size();
    }

}
