package com.bms.com.seenittest.model;

/**
 * Created by Raju Sah
 */
public class ItemsModel
{
    private String name;
    private int numOfSongs;
    private int thumbnail;

    public ItemsModel()
    {
    }

    public ItemsModel(String name, int thumbnail)
    {
        this.name = name;
        this.numOfSongs = numOfSongs;
        this.thumbnail = thumbnail;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getNumOfSongs()
    {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs)
    {
        this.numOfSongs = numOfSongs;
    }

    public int getThumbnail()
    {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail)
    {
        this.thumbnail = thumbnail;
    }
}
