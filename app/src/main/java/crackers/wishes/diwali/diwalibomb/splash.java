package crackers.wishes.diwali.diwalibomb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash extends AppCompatActivity {
  Thread th;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        th=new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(2500);
                    Intent intent=new Intent(splash.this,Front.class);
                    startActivity(intent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        th.start();
    }
}
