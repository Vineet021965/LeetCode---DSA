class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" +");
        StringBuilder sb = new StringBuilder();
        int i = 0, j = str.length - 1;
        while(i < j){
            String tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            i++;
            j--;
        }
        for( String ss: str)
            sb.append(ss+" ");
        return sb.toString().trim();
    }
}