package Project2;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SubstitutionCipher extends Cipher {
    //creating the Random object using the key given
    Random rand = new Random(this.getKey());

    //now that we have the key, we can make linked arraylists to hold the corresponding values of each array
    private List<Character> encryptKey = new LinkedList<Character>();
    private List<Character> decryptKey = new LinkedList<Character>();

    public void assignChars() {
        for(int i = 0; i < 256; i++) {
            encryptKey.add((char) i);
        }
        while(true) {
            int addMe = rand.nextInt(256);
            if(!decryptKey.contains((char) addMe)) {
                decryptKey.add((char) addMe);
            }
            if(decryptKey.size() == 256) {
                break;
            }
        }
    }


    //constructor
    public SubstitutionCipher(long key){
        super(key);
    }

    //doing some encryption
    public List<Character> encrypt (List<Character> cleartext) {
        //we need to get some values fired up
        this.assignChars();

        //creating what will be returned
        List<Character> ciphertext = new LinkedList<Character>();

        //lets get some changed values, shall we?
        for(char c: cleartext) {
            for(int i = 0; i < 256; i++) {
                if(encryptKey.get(i) == c) {
                    ciphertext.add(decryptKey.get(i));
                }
            }
        }

        //lets get this list out of here!
        return ciphertext;

    }

    //doing some decryption
    public List<Character> decrypt (List<Character> ciphertext) {
        //having some problems, lets fire up some values again...?
        this.assignChars();
        //of course that worked, I knew that


        //creating what will be returned
        List<Character> cleartext = new LinkedList<Character>();

        //lets get this thing back, shall we?
        for(char c: ciphertext) {
            for(int i = 0; i < 256; i++) {
                if(decryptKey.get(i) == c) {
                    cleartext.add(encryptKey.get(i));
                }
            }
        }

        //get it out of there!
        return cleartext;
    }
}