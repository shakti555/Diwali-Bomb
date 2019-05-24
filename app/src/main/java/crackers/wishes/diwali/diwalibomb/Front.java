package crackers.wishes.diwali.diwalibomb;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Front extends AppCompatActivity {
     ImageView bomb1,bomb2,bomb3,bomb4,cent;
     MediaPlayer mg,mg2,mg3,mg4;
     Button more;
    AdView mAdView;
    private InterstitialAd mInterstitialAd;
     int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        bomb1=(ImageView)findViewById(R.id.bomb1);
        bomb2=(ImageView)findViewById(R.id.bomb2);
        bomb3=(ImageView)findViewById(R.id.bomb3);
        bomb4=(ImageView)findViewById(R.id.bomb4);
        cent=(ImageView)findViewById(R.id.cent);
        more=(Button)findViewById(R.id.more);
        MobileAds.initialize(this, "ca-app-pub-7789329977567615~6620137766");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-7789329977567615/5101932147");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7789329977567615/8834127744");
        mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());
        mInterstitialAd.setAdListener(new AdListener(){


            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());

            }
        });



        mg=MediaPlayer.create(Front.this,R.raw.bam);
        mg2=MediaPlayer.create(Front.this,R.raw.roket);
        mg3=MediaPlayer.create(Front.this,R.raw.chatai);
        mg4=MediaPlayer.create(Front.this,R.raw.chatar);



        bomb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cent.setBackgroundResource(R.drawable.bomb);
                a=1;
                }
        });


        bomb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    cent.setBackgroundResource(R.drawable.rocke);
                    a=2;



            }
        });
        bomb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cent.setBackgroundResource(R.drawable.chatai);
             a=3;
            }
        });
        bomb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                else {
                    cent.setBackgroundResource(R.drawable.itom);
                    a = 4;
                }
            }
        })
        ;
        cent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             switch (a) {
                 case 1: {
                     mg.start();


                     break;
                 }
                 case 2: {
                     mg2.start();



                     break;
                 }
                 case 3: {
                     mg3.start();

                     break;
                 }
                 case 4:

                 {
                     mg4.start();

                     break;

                 }
             }

             }


        })
        ;
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mbuilder=new AlertDialog.Builder(Front.this);
                mbuilder.setTitle("A Diwali Massage For You");
                mbuilder.setMessage("More Carckers Genrates more pollution in our air so please use less crakers and save the Enviorment! Share This this message on this diwali to all of your Freinds");
                mbuilder.setPositiveButton("Share Now", new DialogInterface.OnClickListener() {


                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        try {
                            Intent obj = new Intent(Intent.ACTION_SEND);
                            obj.setType("text/plain");
                            obj.putExtra(Intent.EXTRA_TEXT, "Wish you a very happy diwali a specail gift for you https://play.google.com/store/apps/details?id=crackers.wishes.diwali.diwalibomb");
                            obj.setPackage("com.whatsapp");
                            startActivity(obj);
                        }
                        catch (ActivityNotFoundException e)
                        {
                            Toast.makeText(Front.this, "Please Install the whatsapp", Toast.LENGTH_SHORT).show();
                        }
                    }




                });
                AlertDialog  alert=mbuilder.create();
                alert.show();



            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.maina,menu); //your file name
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {

        switch (item.getItemId()) {
            case R.id.help:
try {
    Intent obj = new Intent(Intent.ACTION_SEND);
    obj.setType("text/plain");
    obj.putExtra(Intent.EXTRA_TEXT, "Wish you a very happy diwali a special gift for you https://play.google.com/store/apps/details?id=crackers.wishes.diwali.diwalibomb");
    obj.setPackage("com.whatsapp");
    startActivity(obj);
}
catch (ActivityNotFoundException e)
{
    Toast.makeText(this, "Please Install the Whatsaap", Toast.LENGTH_SHORT).show();
}


                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mg.release();
        mg2.release();

        mg3.release();

        mg4.release();


    }

}

