// Last updated: 6/30/2026, 7:15:14 PM
class Solution {

    //two directional bfs technique

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord))
            return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        // prevent revisiting
        wordSet.remove(beginWord);
        wordSet.remove(endWord);

        int sequence = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            // Always expand the smaller frontier
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<>();

            for (String word : beginSet) {

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char original = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == original)
                            continue;

                        arr[i] = c;

                        String neighbor = new String(arr);

                        // Two searches meet
                        if (endSet.contains(neighbor))
                            return sequence + 1;

                        if (wordSet.contains(neighbor)) {
                            nextLevel.add(neighbor);
                            wordSet.remove(neighbor);
                        }
                    }

                    arr[i] = original;
                }
            }

            beginSet = nextLevel;
            sequence++;
        }

        return 0;
    }

    //one directional bfs technique
    // public int ladderLength(String beginWord, String endWord, List<String> wordList) {

    //     Set<String> wordSet = new HashSet<>();

    //     for(String word : wordList) {
    //         wordSet.add(word);
    //     }

    //     if(!wordSet.contains(endWord)) return 0;

    //     Deque<String> queue = new ArrayDeque<>();

    //     queue.offer(beginWord);

    //     int sequence = 1;

    //     while(!queue.isEmpty()) {

    //         int size = queue.size();

    //         while(size-- > 0) {

    //             String node = queue.poll();

    //             for(int i=0; i<node.length(); i++) {

    //                 for(int j=0; j<26;j++) {

    //                     char[] arr = node.toCharArray();

    //                     arr[i] = (char)('a' + j);

    //                     String str = new String(arr);

    //                     if(node.equals(str)) continue;


    //                     if(str.equals(endWord)) return sequence+1;

    //                     if(wordSet.contains(str)) {
    //                         queue.offer(str);
    //                         wordSet.remove(str);
    //                     }
                        

    //                 }

                    
    //             }
    //         }

    //         sequence++;
    //     }

    //     return 0;

        
    // }
}