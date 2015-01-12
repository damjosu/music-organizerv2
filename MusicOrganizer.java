import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * Prints all the saved songs.
     */
    public void listAllFiles()
    {
        int count = 1;
        for(String fileName : files)
        {
            System.out.println(count + ".-" +fileName);
            count++;
        }
    }

    /**
     * List the files with the same String you typed.
     */
    public void listMaching(String artist)
    {
        boolean onTheList = false;
        for (String filename : files)
        {
            if (filename.contains(artist))
            {
                onTheList = true;
                System.out.println(filename);
            }            
        } 
        
        if (onTheList = false)        
        {
            System.out.println("It isn't on the list");
        }
    } 
    
    /**
     * If the artist given is on the list, plays a sample of his songs.
     */    
    public void artistSample(String artist)
    {
        for(String search : files)
        {
            if (search.contains(artist))
            {
                player.playSample(search);
            }
        }        
    }
    
    /**
     * Finds the first match of the given text and returns its index.
     */
    public int findFirst(String search)
    {
        boolean found = false;
        int index = 0;
        int size = files.size();
        while (!found && index < size)
        {
            String filename = files.get(index);
            if (filename.contains(search))
            {
                found = true;
            }
            else
            {
                index++;
            }
            
        }
        
        if (found)
        {
            return index;
        }
        else
        {
            return -1;
        }
        
    }
}
