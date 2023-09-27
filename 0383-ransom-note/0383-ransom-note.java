class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character, Integer> charMap = new HashMap<>();
        
        //record each letter in magazine, so we can check ransomNote
        //must covert String to charArray to loop chars
        for(char c : magazine.toCharArray()){
            charMap.put(c,charMap.getOrDefault(c,0)+1);
        }
        
        //canceling from ransomNote
        for(char c: ransomNote.toCharArray()){
            
            if(!charMap.containsKey(c) || charMap.get(c)==0){
                return false;
            }
            charMap.put(c,charMap.get(c)-1);
        }
        //did not return false means true
        return true;
    }
}