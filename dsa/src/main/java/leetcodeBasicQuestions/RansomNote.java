package leetcodeBasicQuestions;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cntArr = new int[26];
        magazine.chars().forEach(e -> cntArr[e - 'a']++);
        ransomNote.chars().forEach(e -> cntArr[e - 'a']--);
        for (int i = 0; i < 26; i++) {
            if(cntArr[i] != 0)
                return false;
        }
        return true;
    }
}
