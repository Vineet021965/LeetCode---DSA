class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        
        int i = 0;
        int j = 0;

        int currSize = 0;
        while (j < words.length) {
            int numOfWords = j - i;
            int numOfSpaces = numOfWords - 1;
            if (currSize + numOfSpaces + 1 + words[j].length() <= maxWidth) {
                currSize += words[j].length();
                j++;
            } else {
                
                StringBuilder line = new StringBuilder();
                int totalSpaces = (maxWidth - currSize);
                
                if (numOfWords > 1) {
                    int minSpaces = totalSpaces / (numOfWords - 1);
                    int addSpaces = totalSpaces % (numOfWords - 1);
                    
                    for (int k = i; k < j; k++) {
                        line.append(words[k]);
                        if (k < j - 1) {
                            
                            line.append(" ".repeat(minSpaces));
                            if (addSpaces-- > 0) { 
                                line.append(" ");
                            }
                        }
                    }
                } else { 
                    line.append(words[i] + " ".repeat(totalSpaces));
                }
                ans.add(line.toString());
                
                i = j;
                currSize = 0;
            }
        }

        StringBuilder lastLine = new StringBuilder();
        for (int k = i; k < j; k++) {
            lastLine.append(words[k]);
            if (k < j - 1) {
                lastLine.append(" ");
            }
        }
        int trailingSpaces = maxWidth - lastLine.length();
        if (trailingSpaces > 0) {
            lastLine.append(" ".repeat(trailingSpaces));
        }
        ans.add(lastLine.toString());

        return ans;
    }
}