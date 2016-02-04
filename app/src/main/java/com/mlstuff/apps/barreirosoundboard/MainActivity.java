package com.mlstuff.apps.barreirosoundboard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Sound> mSounds = null;

    private SoundAdapter mAdapter = null;

    static MediaPlayer mMediaPlayer = null;

    static int _indexNumber = 1;

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get all Files Data
        String[] _tempFilesArray = getResources().getStringArray(R.array.soundStringArray);
        mSounds = new ArrayList<Sound>();
        String _fileName= "";
        for(int i=0; i< _tempFilesArray.length; i++){

            _fileName = _tempFilesArray[i].split("\\|")[0];

            Sound s = new Sound();
            s.setDescription(_tempFilesArray[i].split("\\|")[1]);
            s.setSoundResourceId(getResources().getIdentifier(_fileName, "raw", getPackageName()));
            s.setSoundIndex(i);
            s.setFileName(_fileName);
            s.setPlayIconResourceId(R.drawable.play);
            s.setStopIconResourceId(R.drawable.stop);
            s.setShareIconResourceId(R.drawable.share);
            mSounds.add(s);
        }

        mAdapter = new SoundAdapter(this, R.layout.list_row, mSounds);
        ListView myList = (ListView) findViewById(android.R.id.list);
        myList.setAdapter(mAdapter);
    }

    public void PlaySound(View v)
    {
        Sound s = (Sound) mSounds.get((int) v.getTag());
        mp = MediaPlayer.create(this, s.getSoundResourceId());
        mp.start();
    }

    public void StopSound(View v)
    {
        mp.stop();
    }

    public void ShareSound(View v)
    {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        Uri _SoundToShare = Uri.parse("android.resource://com.mlstuff.apps.barreirosoundboard/raw/" + ((Sound)mSounds.get((int)v.getTag())).getFileName());

        sharingIntent.setType("audio/mp3");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, _SoundToShare);
        startActivity(Intent.createChooser(sharingIntent, "Compartir es bueno..."));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            try {
                mp = MediaPlayer.create(this, R.raw.flan);
                mp.start();
                AlertDialog.Builder alertadd = new AlertDialog.Builder(this);
                LayoutInflater factory = LayoutInflater.from(this);
                final View view = factory.inflate(R.layout.splash, null);
                alertadd.setView(view);
                alertadd.setNeutralButton("Flaaaaanders!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {

                    }
                });

                alertadd.show();
            }
            catch (Exception ex)
            {
                int asdasd = 0;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
