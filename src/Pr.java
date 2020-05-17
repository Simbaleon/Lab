import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.out;
import java.util.Scanner;
import java.util.Stack;

public class Pr {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String a=in.nextLine();
        a+="|";
        int ch;
        String b="";
        String c="";
        String e="";
        String h;
        int check=0;
        Stack <Double> num= new Stack<>();
        for (int i = 0; i < a.length(); i++){
            if (a.charAt(i)!='+' && a.charAt(i)!='*' && a.charAt(i)!='-' && a.charAt(i)!='/' && a.charAt(i)!='^' && a.charAt(i)!='(' && a.charAt(i)!=')' ){
                if (a.charAt(i) == '|'){
                    b += c + " ";
                    c = "";
                }
                else{
                    c = c + a.charAt(i);
                }
            }
            else{
                if (!c.equals("")){
                    b += c + " ";
                    c = "";
                }
                if (e.equals("") || e.charAt(e.length()-1)=='(' || a.charAt(i)=='('){
                    e+=" " + a.charAt(i);
                }else{
                    if (a.charAt(i)==')'){
                        ch = e.lastIndexOf('(');
                        h = e.substring(ch+1,e.length());
                        h = new StringBuffer(h).reverse().toString();
                        b += h;
                        e = e.substring(0,ch-1);
                    }
                    else if (a.charAt(i) == '+' || a.charAt(i) == '-'){
                        if (e.charAt(e.length()-1) == '('){
                            e += " " + a.charAt(i);
                        }
                        else{
                            ch=Math.max(e.lastIndexOf('-'), Math.max(e.lastIndexOf('+'),e.lastIndexOf('(')));
                            h=e.substring(ch+1,e.length());
                            h = new StringBuffer(h).reverse().toString();
                            b+=h;
                            e=e.substring(0,ch+1);
                            e+=" "+a.charAt(i);
                        }
                    }
                    else if(a.charAt(i)=='^'){
                        if (e.charAt(e.length()-1)!='^'){
                            e+=" "+a.charAt(i);
                        }else{
                            ch=Math.max(Math.max(Math.max(e.lastIndexOf('-'),e.lastIndexOf('/')),e.lastIndexOf('*')), Math.max(e.lastIndexOf('+'),e.lastIndexOf('(')));
                            h=e.substring(ch+1,e.length());
                            h = new StringBuffer(h).reverse().toString();
                            b+=h;
                            e=e.substring(0,ch+1);
                            e+=" "+a.charAt(i);
                        }
                    }else if(a.charAt(i)=='/' || a.charAt(i)=='*'){
                        if (e.charAt(e.length()-1)!='*' && e.charAt(e.length()-1)!='/' && e.charAt(e.length()-1)!='^'){
                            e+=" "+a.charAt(i);
                        }else{
                            ch=Math.max(e.lastIndexOf('-'), Math.max(e.lastIndexOf('+'),e.lastIndexOf('(')));
                            h=e.substring(ch+1,e.length());
                            h = new StringBuffer(h).reverse().toString();
                            b+=h;
                            e=e.substring(0,ch+1);
                            e+=" "+a.charAt(i);
                        }
                    }
                }
            }
        }
        e = new StringBuffer(e).reverse().toString();
        b+=e;
        for (int i=0;i<b.length()-1;i++){
            if (b.charAt(i)==' ' && b.charAt(i+1)==' '){
                b=b.substring(0,i)+b.substring(i+1,b.length()-1);
            }
        }
        out.println(b);
        c="";
        double n1;
        double n2;
        for (int i=0;i<b.length()-1;i++){
            if (b.charAt(i)!=' ' && b.charAt(i)!='^' && b.charAt(i)!='*' && b.charAt(i)!='+' && b.charAt(i)!='-' && b.charAt(i)!='/'){
                c+=b.charAt(i);
            }
            else{
                if (!c.equals("")){
                    num.push(Double.valueOf(c));
                }
                c="";
                if (b.charAt(i)=='+'){
                    n1=num.peek();
                    num.pop();
                    n2=num.peek();
                    num.pop();
                    num.push(n1+n2);
                }
                else if (b.charAt(i)=='-'){
                    n1=num.peek();
                    num.pop();
                    n2=num.peek();
                    num.pop();
                    num.push(n2-n1);
                }else if (b.charAt(i)=='*'){
                    n1=num.peek();
                    num.pop();
                    n2=num.peek();
                    num.pop();
                    num.push(n2*n1);
                }else if (b.charAt(i)=='/'){
                    n1=num.peek();
                    num.pop();
                    n2=num.peek();
                    num.pop();
                    num.push(n2/n1);
                }else if (b.charAt(i)=='^'){
                    n1=num.peek();
                    num.pop();
                    n2=num.peek();
                    num.pop();
                    num.push(Math.pow(n2,n1));
                }
            }
        }
        out.print(num.peek());
    }
}