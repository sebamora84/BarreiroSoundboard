package com.mlstuff.apps.barreirosoundboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Diego on 12/1/2015.
 */
public class SoundAdapter extends ArrayAdapter<Sound> {

    private ArrayList<Sound> items;

    private Context c = null;

    public SoundAdapter(Context context, int textViewResourceId, ArrayList<Sound> items) {

        super(context, textViewResourceId, items);

        this.items = items;

        this.c = context;

    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {

            LayoutInflater vi = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            v = vi.inflate(R.layout.list_row, null);

        }

        Sound s = items.get(position);

        if (s != null) {

            TextView description = (TextView) v.findViewById(R.id.description);

            if (description != null) {

                description.setText(s.getDescription());

            }

            /*ImageView icon = (ImageView) v.findViewById(R.id.icon);
            icon.setImageResource(s.getIconResourceId());*/

            ImageView _playIcon = (ImageView) v.findViewById(R.id.playIcon);
            _playIcon.setImageResource(s.getPlayIconResourceId());
            _playIcon.setTag(s.getSoundIndex());

            ImageView _stopIcon = (ImageView) v.findViewById(R.id.stopIcon);
            _stopIcon.setImageResource(s.getStopIconResourceId());
            _stopIcon.setTag(s.getSoundIndex());

            ImageView _shareIcon = (ImageView) v.findViewById(R.id.shareIcon);
            _shareIcon.setImageResource(s.getShareIconResourceId());
            _shareIcon.setTag(s.getSoundIndex());


        }

        return v;

    }

}