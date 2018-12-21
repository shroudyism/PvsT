package my.app.shroudyism.pvst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    /*

    git init
git remote add origin https://github.com/xxx/yyy.git
git add .
git commit -m "first commit"
git push -u origin master

     */

        static TextView bannerT;
        static TextView bannerP;

        static TextView tvTitleP;
        static TextView tvTitleT;

        static TextView tvSubP;
        static TextView tvSubT;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(my.app.shroudyism.pvst.R.layout.activity_main);

            tvTitleP=findViewById(my.app.shroudyism.pvst.R.id.tvTitlep);
            tvTitleT=findViewById(my.app.shroudyism.pvst.R.id.tvTitleT);
            tvSubP=findViewById(my.app.shroudyism.pvst.R.id.tvSubP);
            tvSubT=findViewById(my.app.shroudyism.pvst.R.id.tvSubT);



            //https://www.googleapis.com/youtube/v3/channels?part=brandingSettings&id={CHANNEL_ID}&key={GOOGLE_API_KEY}

            //    https://www.googleapis.com/youtube/v3/channels?part=statistics&id=channel_id&key=your_key

            Timer t = new Timer();
//Set the schedule function and rate
            t.scheduleAtFixedRate(new TimerTask() {

                                      @Override
                                      public void run() {
                                          //Called each time when 1000 milliseconds (1 second) (the period parameter)
                                          new DownloadTask().execute();
                                      }

                                  },
//Set how long before to start calling the TimerTask (in milliseconds)
                    10,
//Set the amount of time between each execution (in milliseconds)
                    1000);
        }



    }


