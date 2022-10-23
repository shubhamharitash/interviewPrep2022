package ch5.questions;

public class Ch5_Q15_AsciiCharacterTable {
    public static void main(String[] args) {
        for(int i = '!',cnt=1; i <= '~' ;i++,cnt++){
            if(cnt%10 == 0){
                System.out.println((char) i);
            } else {
                System.out.print((char) i + " ");
            }
        }
    }
}
