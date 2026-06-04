package Hashes.FrequencyCount;

import java.util.HashMap;

public class Leetcode2053 {
    public static void main(String[] args) {
        String[] arr = {"c","exjk","nbmg","kgnas","s","oydx","ghpao","c","r","ohdm","fq","ashgg","mm","cc","mymy","w","t","neb","grjdb","cukk","ujyhn","dq","hhuo","qu","seslw","ybulz","iug","rs","kyfu","krz","nw","txnn","r","zpuao","sh","rfc","c","hgr","jfia","egm","gmuuv","gh","x","nfvgv","ibo","al","wn","o","dyu","zgkk","gdzrf","m","ui","xwsj","zeld","muowr","d","xgiu","yfu"};
        String ans = kthDistinct(arr, 2);
        System.out.println(ans);
    }

    public static String kthDistinct(String[] arr, int k) {
        HashMap<String , Integer> map = new HashMap<>();

        for(String str : arr) {
            map.put(str , map.getOrDefault(str, 0) + 1);
        }
        int count = 0;
        for(String str : arr) {
            if(map.get(str) ==1)  {
                count ++;
                if(count == k) {
                    return str;
                }
            }
        }

        return "";
    }

}
