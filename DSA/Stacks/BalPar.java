package Stacks;


import java.util.HashMap;
import java.util.Map;

class BalPar {
    public boolean isValid(String str) {

        HashMap<Character,Integer> map =  new HashMap<Character,Integer>();

        //check for balanced paranthesi {,(,[
        //while traversing check closed paranthesis and open paranthesis
       for(Character ch : str.toCharArray()){
           if(ch == '{' || ch == '(' || ch == '['){

               map.put(ch,map.getOrDefault(ch,0)+1);
               System.out.println("ch " + ch + " map.getOrDefault(ch,0) " + map.get(ch));
           }else if(ch == '}' && map.containsKey('{')) {

               map.put('{',map.getOrDefault('{',0)-1);
               System.out.println("ch " + ch + " map.getOrDefault(ch,0) " + map.get(ch));

           }
           else if( ch == ')' && map.containsKey('(') ){

               map.put('(',map.getOrDefault('(',0)-1);
               System.out.println("ch " + ch + " map.getOrDefault(ch,0) " + map.get(ch));

           }
           else if( ch == ']' && map.containsKey('[')) {

               map.put('[',map.getOrDefault('[',0)-1);
               System.out.println("ch " + ch + " map.getOrDefault(ch,0) " + map.get(ch));

           }
           else {
               return false;
           }
       }

       for(Map.Entry<Character,Integer> entry : map.entrySet()){
           System.out.println(entry.getKey() + " " + entry.getValue());
           if(entry.getValue() != 0){
               return false;
           }
       }
       return true;



    }

    public static void main(String[] args) {

        BalPar obj = new BalPar();
        System.out.println(obj.isValid("[]({][)}{}"));
    }
}
