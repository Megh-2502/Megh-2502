import java.util.*;

class MusicPlayer {
    class MusicNode{
        String song;
        MusicNode next;
        MusicNode prev;
        MusicNode(String song){
            this.song=song;
            next=null;
            prev=null;
        }
    }
    MusicNode firstSong=null;
    void AddSongAtTop(String song){
        MusicNode current=new MusicNode(song);
        if(firstSong==null){
            firstSong=current;
        }
        else{
            current.next=firstSong;
            firstSong.prev=current;
            firstSong=current;
        }
    }
    void AddSongAtEnd(String song){
        MusicNode current=new MusicNode(song);
        if(firstSong==null){
            firstSong=current;
        }
        else{
            MusicNode temp=firstSong;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=current;
            current.prev=temp;
        }
    }
    void InsertBeforeSong(String newSong, String song) {
        if (firstSong == null) {
            System.out.println("Music queue is empty");
            return;
        }
    
        if (firstSong.song.equals(newSong)) {
            MusicNode current = new MusicNode(song);
            current.next = firstSong;
            firstSong.prev = current;
            firstSong = current;
            return;
        }
    
        MusicNode temp = firstSong;
        while (temp != null) {
            if (temp.song.equals(newSong)) {
                MusicNode current = new MusicNode(song);
                current.prev = temp.prev;
                current.next = temp;
                temp.prev.next = current;
                temp.prev = current;
                return;
            }
            temp = temp.next;
        }
    
        System.out.println("Song '" + newSong + "' not found in the playlist.");
    }   

    void InsertAfterSong(String newSong, String song) {
        if (firstSong == null) {
            System.out.println("Music queue is empty");
            return;
        }
    
        MusicNode temp = firstSong;
        while (temp != null) {
            if (temp.song.equals(newSong)) {
                MusicNode current = new MusicNode(song);
                current.next = temp.next;
                current.prev = temp;
                if (temp.next != null) {
                    temp.next.prev = current;
                }
                temp.next = current;
                return;
            }
            temp = temp.next;
        }
    
        System.out.println("Song '" + newSong + "' not found in the playlist.");
    }    
    void DeleteFirstSong(){
        if(firstSong==null){
            System.out.println("Music queue is empty");
        }
        else if(firstSong.next==null&&firstSong.prev==null){
            firstSong=null;
        }
        else{
            MusicNode temp=firstSong;
            firstSong=firstSong.next;
            firstSong.prev=null;
            temp=null;
        }
    }
    void DeleteLastSong(){
        if(firstSong==null){
           System.out.println("Music queue is empty");
        }
        else if(firstSong.next==null&&firstSong.prev==null){
           firstSong=null;
        }
        else{
           MusicNode temp=firstSong;
           while(temp.next!=null){
               temp=temp.next;
           }
           temp.prev.next=null;
           temp.prev=null;
        }
    }
    void DeleteparticularSong(String delSong) {
        if (firstSong == null) {
            System.out.println("Music queue is empty");
            return;
        }
    
        if (firstSong.song.equals(delSong)) {
            firstSong = firstSong.next;
            if (firstSong != null) {
                firstSong.prev = null;
            }
            return;
        }
    
        MusicNode temp = firstSong;
        while (temp != null) {
            if (temp.song.equals(delSong)) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                }
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    
        System.out.println("Song '" + delSong + "' not found in the playlist.");
    }
    void playNextSong() {
        if (temp == null) {
            temp = firstSong;
            if (temp == null) {
                System.out.println("No songs in the playlist.");
            } else {
                System.out.println("Playing first song: " + temp.next.song);
            }
        } else if (temp.next.next == null) {
            System.out.println("End of playlist. No next song to play.");
        } else {
            temp = temp.next;
            System.out.println("Playing next song: " + temp.next.song);
        }
    }
    
    void playPreviousSong() {
        if (temp == null) {
            temp = firstSong;
            if (temp == null) {
                System.out.println("No songs in the playlist.");
            } else {
                System.out.println("End of playlist. No next song to play.");
            }
        } else if (temp.prev == null) {            
            System.out.println("Start of playlist. Playing first song: " + temp.song);
            temp = temp.prev;
        } else {
            temp = temp.prev;
            System.out.println("check1");
            System.out.println("Playing previous song: " + temp.next.song);
        }
    }
    
    void displaySongs(){
        if(firstSong==(null)){
            System.out.println("Music queue is empty");
        }else{
            MusicNode temp=firstSong;
            while(temp!=null){
                System.out.print(temp.song+"-->");
                temp=temp.next;
            }
            System.out.println("NULL");
        
        }
    }
    void reverseDisplaySongs()
    {
        if(firstSong==null){
            System.out.println("Music queue is empty");
        }
        else{
            MusicNode temp = firstSong;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            while(temp!=null)
            {
                System.out.print(temp.song+"-->");
                temp=temp.prev;
            }
            System.out.println("NULL");
        }
        
    }

    MusicNode searchSong(String songName) {
        MusicNode temp = firstSong;
        while (temp != null) {
            if (temp.song.equals(songName)) {
                return temp; 
            }
            temp = temp.next;
        }
        return null; 
    }
    MusicNode temp;

    // Add a new node to the end of the doubly linked list
    public void add(String song) {
        MusicNode newNode = new MusicNode(song);
        if (firstSong == null) {
            firstSong = newNode;
            temp = newNode;
        } else {
            temp.next = newNode;
            newNode.prev = temp;
            temp = newNode;
        }
    }

    // Get size of the doubly linked list
    public int size() {
        int size = 0;
        MusicNode current = firstSong;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    // Retrieve song at a given index
    public String get(int index) {
        int counter = 0;
        MusicNode current = firstSong;
        while (current != null) {
            if (counter == index) {
                System.out.println("Track name:"+current.song+"----");
                return current.song;
            }
            counter++;
            current = current.next;
        }
        return null; // index out of bounds
    }

    // Check if the doubly linked list contains a given song
    public boolean contains(String song) {
        MusicNode current = firstSong;
        while (current != null) {
            if (current.song.equals(song)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private long seed;
    private static final long a = 1664525;
    private static final long c = 1013904223;
    private static final long m = (long) Math.pow(2, 32);

    public MusicPlayer(long seed) {
        this.seed = seed;
    }

    MusicPlayer(){

    }
    public long nextInt(int bound) {
        seed = (a * seed + c) % m;
        return (seed % bound);
    }
}

class RunMusicPlayer
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("-----------------------MUSIC PLAYER----------------------");
        int ch;
        String newSong;
        String curSong;
        MusicPlayer playSong=new MusicPlayer();
        MusicPlayer tracks=new MusicPlayer();
        do {
            System.out.println();
            System.out.println("MENU");
            System.out.println("1. Add song to my Playlist");
            System.out.println("2. Delete song from my Playlist");
            System.out.println("3. Play next song");
            System.out.println("4. Play previous song");
            System.out.println("5. Shuffle my Playlist");
            System.out.println("6. Search particular song from my Playlist");
            System.out.println("7. Show my Playlist");
            System.out.println("8. Reverse my Playlist");
            System.out.println("9. Exit");
            System.out.println("Enter your choice");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1: 
                int a;
                do {
                    System.out.println("1. Add song at the top of my Playlist");
                    System.out.println("2. Add song at the end of my Playlist");
                    System.out.println("3. Add song before a particular song in my Playlist");
                    System.out.println("4. Add song after a particular song in my Playlist");
                    System.out.println("5. Exit");
                    a=sc.nextInt();
                    switch(a)
                    {
                        case 1: 
                        System.out.println("Enter Song: ");
                        newSong=sc.next();
                        playSong.AddSongAtTop(newSong);
                        tracks.add(newSong);
                        break;

                        case 2:
                        System.out.println("Enter Song: ");
                        newSong=sc.next();
                        playSong.AddSongAtEnd(newSong);
                        tracks.add(newSong);
                        break;

                        case 3:
                        System.out.println("Enter Song: ");
                        newSong=sc.next();
                        System.out.println("Enter Song before which you want to add: ");
                        curSong=sc.next();
                        playSong.InsertBeforeSong(curSong,newSong);
                        tracks.add(newSong);
                        break;

                        case 4:
                        System.out.println("Enter Song: ");
                        newSong=sc.next();
                        System.out.println("Enter Song after which you want to add: ");
                        curSong=sc.next();
                        playSong.InsertAfterSong(curSong,newSong);
                        tracks.add(newSong);
                        break;

                        case 5:
                        break;

                        default:
                        System.out.println("Invalid Choice");
                    }
                }while(a!=5);
                break;

                case 2:
                int b;
                do {
                    System.out.println("1. Delete first song of my Playlist");
                    System.out.println("2. Delete last song of my Playlist");
                    System.out.println("3. Delete particular song of my Playlist");
                    System.out.println("4. Exit");
                    b=sc.nextInt();
                    switch(b)
                    {
                        case 1:
                        playSong.DeleteFirstSong();
                        break;

                        case 2:
                        playSong.DeleteLastSong();
                        break;

                        case 3:
                        System.out.println("Enter song to be deleted: ");
                        String delSong=sc.next();
                        playSong.DeleteparticularSong(delSong);
                        break;

                        case 4:
                        break;

                        default:
                        System.out.println("Invalid Choice");
                    }
                    
                }while(b!=4);
                break;

                case 3:
                playSong.playNextSong();
                break;

                case 4:
                playSong.playPreviousSong();
                break;

                case 5:
                int playedCount = 0;
                MusicPlayer rand = new MusicPlayer(System.currentTimeMillis());
                boolean[] played = new boolean[tracks.size()];

                while (playedCount < tracks.size()) {
                int randomIndex = (int) rand.nextInt(tracks.size());

                    if (!played[randomIndex]) {
                        tracks.get(randomIndex);
                        played[randomIndex] = true;
                        playedCount++;
                    }
                }
                break;

                case 6:
                System.out.println("Enter song to search: ");
                String searchSong = sc.next();
                MusicPlayer.MusicNode foundNode = playSong.searchSong(searchSong);
                if (foundNode != null) {
                    System.out.println("Song '" + searchSong + "' found in the playlist.");
                } else {
                    System.out.println("Song '" + searchSong + "' not found in the playlist.");
                    System.out.println("Do you want to add it to the playlist? (yes/no)");
                    String addToPlaylist = sc.next();
                    if (addToPlaylist.equalsIgnoreCase("yes")) {
                        playSong.AddSongAtEnd(searchSong);
                        System.out.println("Song '" + searchSong + "' added to the playlist.");
                    }
                }
                break;

                case 7:
                playSong.displaySongs();
                break;

                case 8:
                playSong.reverseDisplaySongs();
                break;

                case 9:
                break;
            }
        }while(ch!=9);
    }
}