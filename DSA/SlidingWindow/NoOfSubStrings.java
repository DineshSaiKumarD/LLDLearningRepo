package SlidingWindow;


import java.util.HashMap;

class NoOfSubStrings {
    public int numberOfSubstrings(String s) {
        //your code goes here



        int l=0;
        int r= 0;
        int n = s.length();
        int cnt = 0;
        HashMap<Character, Integer> objectObjectHashMap = new HashMap<>();


       /* while(r<n){

            if(objectObjectHashMap.containsKey(s.charAt(r))){
                objectObjectHashMap.put(s.charAt(r), objectObjectHashMap.get(s.charAt(r))+1);
            }else{
                objectObjectHashMap.put(s.charAt(r), 1);
            }

           if(objectObjectHashMap.size()==3){
               if(objectObjectHashMap.get('a')>0 && objectObjectHashMap.get('b')>0 && objectObjectHashMap.get('c')>0){
                   cnt++;
               }
           }

           r++;

}


        while(objectObjectHashMap.size()==3){

            objectObjectHashMap.put(s.charAt(l), objectObjectHashMap.get(s.charAt(l))-1);
            l++;


            if(objectObjectHashMap.get('a')>0 && objectObjectHashMap.get('b')>0 && objectObjectHashMap.get('c')>0){
                cnt++;
            }



        }

        return cnt;



    }*/

        while (r < n) {
            // expand window
            objectObjectHashMap.put(s.charAt(r), objectObjectHashMap.getOrDefault(s.charAt(r), 0) + 1);

            // shrink while valid
            while (objectObjectHashMap.getOrDefault('a', 0) > 0 &&
                    objectObjectHashMap.getOrDefault('b', 0) > 0 &&
                    objectObjectHashMap.getOrDefault('c', 0) > 0) {
                cnt += (n - r);
                objectObjectHashMap.put(s.charAt(l), objectObjectHashMap.get(s.charAt(l)) - 1);
                l++;
            }
            r++;
        }
        return cnt;
    }


    //this is wrong because i am fixing l at first place and checking all possible
    //and also while shrinking i am fixing r at last place and checking all possible
    //with this i am missing middle ones



}
