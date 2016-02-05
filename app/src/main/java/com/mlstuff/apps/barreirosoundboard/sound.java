package com.mlstuff.apps.barreirosoundboard;

/**
 * Created by Diego on 12/1/2015.
 */

public class Sound {

    private String mDescription = "";
    private String mFileName = "";
    private int mSoundResourceId = -1;
    private int mIconResourceId = -1;
    private int mPlayIconResourceId = -1;
    private int mStopIconResourceId = -1;
    private int mShareIconResourceId = -1;
    private int mSoundIndex = -1;


    public void setDescription(String description) { mDescription = description; }
    public String getDescription() { return mDescription; }

    public void setFileName(String FileName) { mFileName = FileName; }
    public String getFileName() { return mFileName; }

    public void setSoundResourceId(int id) { mSoundResourceId = id; }
    public int getSoundResourceId() { return mSoundResourceId; }

    public void setIconResourceId(int id) { mIconResourceId = id; }
    public int getIconResourceId() { return mIconResourceId; }

    public void setPlayIconResourceId(int id) { mPlayIconResourceId = id; }
    public int getPlayIconResourceId() { return mPlayIconResourceId; }

    public void setStopIconResourceId(int id) { mStopIconResourceId = id; }
    public int getStopIconResourceId() { return mStopIconResourceId; }

    public void setShareIconResourceId(int id) { mShareIconResourceId = id; }
    public int getShareIconResourceId() { return mShareIconResourceId; }

    public void setSoundIndex(int id) { mSoundIndex = id; }
    public int getSoundIndex() { return mSoundIndex; }

}
