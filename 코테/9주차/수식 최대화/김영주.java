import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
   
    static Long max;
    static char[] prior = {'+', '-', '*'};
    static boolean[] check = new boolean[3];
    static ArrayList<Long> num;
    static ArrayList<Character> operator;
    public long solution(String expression) {
        
        max = Long.MIN_VALUE;
        
        num = new ArrayList<>();
        operator = new ArrayList<>();
        
        String number = "";
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'){
                num.add(Long.valueOf(number));
                number="";
                operator.add(expression.charAt(i));
            }else{
                number+=expression.charAt(i);
            }
        }
        num.add(Long.valueOf(number)); // 마지막 숫자 추가

        dfs(0,new char[3]);
        
        return max;
    }
    
    static void dfs(int count, char[] op){
        
            if(count == 3){
                ArrayList<Long> cNums = new ArrayList<>(num);
                ArrayList<Character> cOps = new ArrayList<Character>(operator);

                for(int i=0;i<op.length;i++){
                    for(int j=0; j< cOps.size(); j++){
                        if(op[i] == cOps.get(j)){
                            Long res = calc(cNums.remove(j), cNums.remove(j), op[i]);
                            cNums.add(j, res);
                            cOps.remove(j);
                            j--;
                        }
                    }
                }
                max = Math.max(max, Math.abs(cNums.get(0)));
                return;

            }

            for(int i=0; i< 3; i++){
                if(!check[i]){
                    check[i] = true;
                    op[count] = prior[i];
                    dfs(count+1,op);
                    check[i] = false;
                }
            }
        }
    
        static Long calc(Long number1, Long number2, char op ){

            long sum= 0;

            if(op == '+') sum = number1+number2; 
            else if(op == '-') sum = number1-number2; 
            else if(op == '*') sum = number1*number2; 

            return sum;
        }
    }

