package com.example.ednel.bongoone;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.R.attr.delay;
import static android.R.attr.fragmentAllowReturnTransitionOverlap;
import static com.example.ednel.bongoone.R.drawable.abood;
import static com.example.ednel.bongoone.R.drawable.afm;
import static com.example.ednel.bongoone.R.drawable.alnoorfm;
import static com.example.ednel.bongoone.R.drawable.bantu;
import static com.example.ednel.bongoone.R.drawable.capitalradio;
import static com.example.ednel.bongoone.R.drawable.cgfm;
import static com.example.ednel.bongoone.R.drawable.choicefm;
import static com.example.ednel.bongoone.R.drawable.chuchufm;
import static com.example.ednel.bongoone.R.drawable.cloudsfm;
import static com.example.ednel.bongoone.R.drawable.countryfm;
import static com.example.ednel.bongoone.R.drawable.dreamfm;
import static com.example.ednel.bongoone.R.drawable.eastafricaradio;
import static com.example.ednel.bongoone.R.drawable.ebonyfm;
import static com.example.ednel.bongoone.R.drawable.efm;
import static com.example.ednel.bongoone.R.drawable.imaanfm;
import static com.example.ednel.bongoone.R.drawable.jembe;
import static com.example.ednel.bongoone.R.drawable.kingsfm;
import static com.example.ednel.bongoone.R.drawable.kissfm;
import static com.example.ednel.bongoone.R.drawable.magicfm;
import static com.example.ednel.bongoone.R.drawable.morningstarfm;
import static com.example.ednel.bongoone.R.drawable.mwangaza;
import static com.example.ednel.bongoone.R.drawable.pamojafm;
import static com.example.ednel.bongoone.R.drawable.passionfm;
import static com.example.ednel.bongoone.R.drawable.planet;
import static com.example.ednel.bongoone.R.drawable.praisepower;
import static com.example.ednel.bongoone.R.drawable.pridefm;
import static com.example.ednel.bongoone.R.drawable.radioadhana;
import static com.example.ednel.bongoone.R.drawable.radiokwizera;
import static com.example.ednel.bongoone.R.drawable.radiomaarifa;
import static com.example.ednel.bongoone.R.drawable.radiomaria;
import static com.example.ednel.bongoone.R.drawable.radionuur;
import static com.example.ednel.bongoone.R.drawable.radioone;
import static com.example.ednel.bongoone.R.drawable.radioqiblaten;
import static com.example.ednel.bongoone.R.drawable.radiosafina;
import static com.example.ednel.bongoone.R.drawable.radiotumaini;
import static com.example.ednel.bongoone.R.drawable.rfa;
import static com.example.ednel.bongoone.R.drawable.safariradio;
import static com.example.ednel.bongoone.R.drawable.salvatioradiofm;
import static com.example.ednel.bongoone.R.drawable.sauti;
import static com.example.ednel.bongoone.R.drawable.sibukafm;
import static com.example.ednel.bongoone.R.drawable.standard;
import static com.example.ednel.bongoone.R.drawable.starter;
import static com.example.ednel.bongoone.R.drawable.tbcfm;
import static com.example.ednel.bongoone.R.drawable.tbctaifa;
import static com.example.ednel.bongoone.R.drawable.timesfm;
import static com.example.ednel.bongoone.R.drawable.tkfm;
import static com.example.ednel.bongoone.R.drawable.uhuru;
import static com.example.ednel.bongoone.R.drawable.upendo;
import static com.example.ednel.bongoone.R.drawable.vot;
import static com.example.ednel.bongoone.R.drawable.waporadio;

public class MainActivity extends AppCompatActivity {
    private List<movie> movieList = new ArrayList<>();
    private List<top> topList = new ArrayList<>();
    private List<mikoan> mikoanList = new ArrayList<>();
    private topadapter mAdapter1;
    private ProgressBar loading;
    private mikoanadapter mAdapter2;
    private RecyclerView recyclerView,recyclerView1,recyclerView2;
    private movieadapter mAdapter;
    ImageButton play,pause;
    TextView status;
    MediaPlayer mediaPlayer;
    private AdView  mAdView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TabHost host=(TabHost)findViewById(R.id.tabHost);
        host.setup();

        TabHost.TabSpec spec=host.newTabSpec("TOP");
        spec.setContent(R.id.tab1);
        spec.setIndicator("TOP");
        host.addTab(spec);


        spec = host.newTabSpec("GOSPEL");
        spec.setContent(R.id.tab2);
        spec.setIndicator("DINI");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("LOCAL");
        spec.setContent(R.id.tab3);
        spec.setIndicator("MIKOANI");
        host.addTab(spec);



        play=(ImageButton)findViewById(R.id.play);
        loading=(ProgressBar)findViewById(R.id.loading) ;

        pause=(ImageButton)findViewById(R.id.pause);
        status=(TextView)findViewById(R.id.status);
        play.setVisibility(View.VISIBLE);
        loading.setVisibility(View.INVISIBLE);


        final MediaPlayer[] mediaPlayer = new MediaPlayer[1];
        mediaPlayer[0] =new MediaPlayer();




        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView1= (RecyclerView) findViewById(R.id.recycler_view1);
        recyclerView2 = (RecyclerView) findViewById(R.id.recycler_view2);

        mAdapter = new movieadapter(movieList);
        mAdapter1 = new topadapter(topList);
        mAdapter2 = new mikoanadapter(mikoanList);

        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView1.setLayoutManager(mLayoutManager1);
        recyclerView2.setLayoutManager(mLayoutManager2);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView1.setAdapter(mAdapter1);
        recyclerView2.setAdapter(mAdapter2);


        play=(ImageButton)findViewById(R.id.play);
        play.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }
        );
        pause=(ImageButton)findViewById(R.id.pause);
        pause.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        status.setText("SELECT STATION");
                        mediaPlayer[0].reset();
                       pause.setVisibility(View.INVISIBLE);
                        play.setVisibility(View.VISIBLE);
                    }
                }
        );




        recyclerView.addOnItemTouchListener(new ontouch(getApplicationContext(),recyclerView,new MainActivity.ClickListener(){
            @Override
            public void onClick(View view, int position) {

                if (mediaPlayer[0] != null) {
                    mediaPlayer[0].stop();
                    mediaPlayer[0].release();
                    mediaPlayer[0] = null;
                    pause.setVisibility(View.INVISIBLE);
                    play.setVisibility(View.VISIBLE);
                }

                loading.setVisibility(View.VISIBLE);
                play.setVisibility(View.INVISIBLE);

                mediaPlayer[0] =new MediaPlayer();
                final movie movie = movieList.get(position);
                try {
                    mediaPlayer[0].setDataSource(movie.getStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer[0].prepareAsync();
                status.setText("PLEASE WAIT..");
                mediaPlayer[0].setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mediaPlayer[0].start();
                        play.setVisibility(View.INVISIBLE);
                        status.setText(movie.getTittle());
                        loading.setVisibility(View.INVISIBLE);
                        pause.setVisibility(View.VISIBLE);

                    }

                });


                Toast.makeText(getApplicationContext(), movie.getTittle() + " is selected!", Toast.LENGTH_SHORT).show();






            }

            @Override
            public void onLongClick(View view, int position) {


            }

        }));
        recyclerView1.addOnItemTouchListener(new ontouch1(getApplicationContext(),recyclerView,new MainActivity.ClickListener(){
            @Override
            public void onClick(View view, int position) {
                if (mediaPlayer[0] != null) {
                    mediaPlayer[0].stop();
                    mediaPlayer[0].release();
                    mediaPlayer[0] = null;
                    pause.setVisibility(View.INVISIBLE);
                    play.setVisibility(View.VISIBLE);
                }

                loading.setVisibility(View.VISIBLE);
                play.setVisibility(View.INVISIBLE);


                mediaPlayer[0]=new MediaPlayer();
               final top top= topList.get(position);
                Toast.makeText(getApplicationContext(), top.getTittle() + " is selected!", Toast.LENGTH_SHORT).show();

                try {
                    mediaPlayer[0].setDataSource(top.getStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer[0].prepareAsync();
                status.setText("PLEASE WAIT..");
                mediaPlayer[0].setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mediaPlayer[0].start();
                        play.setVisibility(View.INVISIBLE);
                        status.setText(top.getTittle());
                        loading.setVisibility(View.INVISIBLE);
                        pause.setVisibility(View.VISIBLE);

                    }

                });






            }

            @Override
            public void onLongClick(View view, int position) {


            }

        }));

        recyclerView2.addOnItemTouchListener(new ontouch2(getApplicationContext(),recyclerView,new MainActivity.ClickListener(){
            @Override
            public void onClick(View view, int position) {

                if (mediaPlayer[0] != null) {
                    mediaPlayer[0].stop();
                    mediaPlayer[0].release();
                    mediaPlayer[0] = null;
                    pause.setVisibility(View.INVISIBLE);
                    play.setVisibility(View.VISIBLE);
                }

                loading.setVisibility(View.VISIBLE);
                play.setVisibility(View.INVISIBLE);
                mediaPlayer[0]=new MediaPlayer();
                final mikoan mikoan = mikoanList.get(position);
                Toast.makeText(getApplicationContext(), mikoan.getTittle() + " is selected!", Toast.LENGTH_SHORT).show();
                try {
                    mediaPlayer[0].setDataSource(mikoan.getStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer[0].prepareAsync();
                status.setText("PLEASE WAIT..");
                mediaPlayer[0].setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mediaPlayer[0].start();
                        play.setVisibility(View.INVISIBLE);
                        status.setText(mikoan.getTittle());
                        loading.setVisibility(View.INVISIBLE);
                        pause.setVisibility(View.VISIBLE);

                    }



                });





            }

            @Override
            public void onLongClick(View view, int position) {


            }


        }));
        topData();
        mikoandata();
        dinidata();
       // not();
        Ads();
        muda();
        toobar();





    }

    private void topData() {
        movie movie = new movie(cloudsfm, "CLOUDS FM","http://eu6.fastcast4u.com:5306/;");
        movieList.add(movie);
        movie movie2 = new movie(choicefm, "CHOICE FM","http://51.255.235.165:5362/;");
        movieList.add(movie2);
        movie movie3 = new movie(radioone, "RADIO ONE","http://78.129.232.226:8085/;");
        movieList.add(movie3);
        movie movie4 = new movie(eastafricaradio, "EA RADIO","http://173.192.70.138:8270/;");
        movieList.add(movie4);
        movie movie5 = new movie(abood, "ABOOD FM","http://38.107.243.99:8020/stream?.wma");
        movieList.add(movie5);
        movie movie6 = new movie(rfa, "RFA","http://noasrv.caster.fm:10183/stream");
        movieList.add(movie6);
        movie movie7 = new movie(tbcfm, "TBC FM","http://s12.myradiostream.com:4574/;");
        movieList.add(movie7);
        movie movie8 = new movie(efm, "E FM 93.7","http://107.182.231.73:7127/efm");
        movieList.add(movie8);
        movie ed=new movie(tbctaifa,"TBC TAIFA","http://usa9-vn.mixstream.net:8080/;");
        movieList.add(ed);
        movie movie9 = new movie(timesfm, "TIMES FM","http://154.66.224.11:8000/Timesfm");
        movieList.add(movie9);
        movie movie10 = new movie(capitalradio, "CAPITAL RADIO","http://78.129.232.226:8079/;");
        movieList.add(movie10);
        movie movie11 = new movie(radiokwizera, "KWIZERA","http://uk4-vn.mixstream.net:8052/;listen.mp3/;");
        movieList.add(movie11);
        movie movie12 = new movie(magicfm, "MAGIC FM","http://192.240.102.133:7690/magicfm");
        movieList.add(movie12);
        movie movie13 = new movie(uhuru, "UHURU FM","http://s40.myradiostream.com:16326/;");
        movieList.add(movie13);
        movie movie14 = new movie(sibukafm, "SIBUKA FM","http://38.107.243.99:8028/stream?.wma");
        movieList.add(movie14);
        movie movie15 = new movie(kissfm, "KISS FM","http://noasrv.caster.fm:10184/stream");
        movieList.add(movie15);





        mAdapter.notifyDataSetChanged();
    }


    private void dinidata() {
        top top=new top(morningstarfm,"MORNING STAR","http://ample-03.radiojar.com/qpgu3a299rmtv?rj-ttl=5&amp;");
        topList.add(top);
        //top top1=new top(salvatioradiofm,"SALVATION FM","http://eu6.fastcast4u.com:5306/;");
       // topList.add(top1);
        top top2=new top(radioadhana,"RADIO ADHANA","http://38.107.243.99:8021/stream");
       topList.add(top2);
        //top top3=new top(praisepower,"PRAISE POWER","url");
       // topList.add(top3);
        top top4=new top(radiomaarifa,"RADIO MAARIFA","http://87.117.205.22:8050/;stream.mp3");
        topList.add(top4);
       // top top5=new top(alnoorfm,"RADIO ALNOOR","url");
      //  topList.add(top5);
        top top6=new top(radiomaria,"BETHEL RADIO","http://gemini.shoutca.st:8197/stream");
       topList.add(top6);
        //top top7=new top(radionuur,"RADIO NUUR","url");
       // topList.add(top7);
        top top8=new top(radiosafina,"RADIO SAFINA","http://s14.myradiostream.com:7838/;");
        topList.add(top8);
       // top top9=new top(imaanfm,"RADIO IMAAN","url");
       // topList.add(top9);
        top top10=new top(radioqiblaten,"RADIO QUIBLATEN","http://38.107.243.99:8006/stream");
        topList.add(top10);
       // top top11=new top(radiotumaini,"RADIO TUMAINI","url");
       // topList.add(top11);
        top top12=new top(sauti,"SAUTI YA INJILI","http://sautiyainjili.de:6801/;stream.nsv");
        topList.add(top12);
        top top13=new top(mwangaza,"RADIO MWANGAZA","http://noasrv.caster.fm:10183/stream");
        topList.add(top13);
        top top14=new top(upendo,"UPENDO FM","http://38.107.243.99:8014/stream?.wma");
        topList.add(top14);
        top top15=new top(waporadio,"WAPO RADIO","http://38.107.243.99:8014/stream?.wma");
        topList.add(top15);




        mAdapter1.notifyDataSetChanged();
    }



    private void mikoandata() {
        mikoan mikoan = new mikoan(jembe, "JEMBE FM","https://streaming.shoutcast.com/JembeFM");
        mikoanList.add(mikoan);
        mikoan mikoan1 = new mikoan(standard, "STANDARD FM","http://uk4-vn.mixstream.net:8076/;listen.mp3");
        mikoanList.add(mikoan1);
       mikoan mikoan2 = new mikoan(kingsfm, "KINGS FM","http://41.59.44.210:8000/stream");
        mikoanList.add(mikoan2);
       mikoan mikoan3 = new mikoan(planet, "PLANET FM","http://eu6.fastcast4u.com:5306/;");
        mikoanList.add(mikoan3);
       // mikoan mikoan4 = new mikoan(countryfm, "COUNTRY FM","http://eu6.fastcast4u.com:5306/;");
      //  mikoanList.add(mikoan4);
        mikoan mikoan5= new mikoan(bantu, "BANTU FM","http://eu6.fastcast4u.com:5306/;");
        mikoanList.add(mikoan5);
        mikoan mikoan6 = new mikoan(afm, "A FM 92.2","http://78.129.159.25:8010/stream?type=.mp3/;stream.mp3");
        mikoanList.add(mikoan6);
        mikoan mikoan7 = new mikoan(vot, "VOICE OF TABORA","http://50.7.99.163:16454/stream/;");
        mikoanList.add(mikoan7);
        mikoan mikoan8 = new mikoan(pridefm, "PRIDE FM","http://38.107.243.99:8001/stream");
        mikoanList.add(mikoan8);
        mikoan mikoan9 = new mikoan(cgfm, "CG FM","http://38.107.243.99:8002/stream");
        mikoanList.add(mikoan9);
        mikoan mikoan10 = new mikoan(safariradio, "SAFARI RADIO","http://78.129.232.162:14359/stream");
        mikoanList.add(mikoan10);
        mikoan mikoan11 = new mikoan(dreamfm, "DREAM FM","http://95.154.193.6:8010/stream");
        mikoanList.add(mikoan11);
        mikoan mikoan12= new mikoan(starter, "STARTER FM","http://s46.myradiostream.com:7716/;");
        mikoanList.add(mikoan12);
        mikoan mikoan13= new mikoan(pamojafm, "PAMOJA FM","http://162.244.80.52:4182/listen.mp3");
        mikoanList.add(mikoan13);
        mikoan mikoan14 = new mikoan(tkfm, "TK FM","http://78.129.234.163:5470/;stream.mp3");
        mikoanList.add(mikoan14);
        mikoan mikoan15 = new mikoan(chuchufm, "CHUCHU FM","http://streaming.shoutcast.com/chuchufm");
        mikoanList.add(mikoan15);
        // mikoan mikoan2 = new mikoan(ebonyfm, "EBONY FM","http://eu6.fastcast4u.com:5306/;");
        // mikoanList.add(mikoan2);



        mAdapter2.notifyDataSetChanged();
    }
    public void not(){

        android.support.v4.app.NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.radios)
                .setContentTitle("BONGO RADIOS")
                .setLargeIcon(((BitmapDrawable) getApplicationContext().getResources().getDrawable(R.drawable.radios)).getBitmap())
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentText("Liten Now Amaizing shows")
                ;
        NotificationManager manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(9,builder.build());

    }
public  void muda(){

     PendingIntent pendingIntent;

    Intent alarmIntent = new Intent(MainActivity.this, Alarmrecever.class);
    pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, alarmIntent, 0);

    AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    int interval = 1000 * 60 * 8400;


    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(System.currentTimeMillis());
    calendar.set(Calendar.HOUR_OF_DAY, 19);
    calendar.set(Calendar.MINUTE, 0);

     //hii ni kwa saa 24
    manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
            1000 * 60 *8400, pendingIntent);




}
public void toobar(){
   toolbar=(Toolbar)findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
   // getSupportActionBar().setLogo(R.drawable.radiosresized);
    TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
    getSupportActionBar().setDisplayUseLogoEnabled(true);
    getSupportActionBar().setDisplayShowTitleEnabled(false);


}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // hii itaweka action bars.
        getMenuInflater().inflate(R.menu.navigation,menu);
        return true;
    }








    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);


    }
    public void stopPlaying() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            pause.setVisibility(View.INVISIBLE);
            play.setVisibility(View.VISIBLE);
        }













    }






    public void Ads(){

        mAdView = (AdView) findViewById(R.id.adView);
        //mAdView.setAdSize(AdSize.SMART_BANNER);
                AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();

    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }






    }
//created by edneltz 2018...................................................