package ConstructionTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dreaminteam on 7.8.14.
 */
public class Node {

    @Override
    public String toString() {
        String a = "";
        String b = "";
        a += numberList.toString();
        if (childList.size() != 0) {
            for (Node n : childList) {
                b += n.toString();
            }
        }
        return a+"" + b + '\n';
    }

    public void sumNumber() {
        Integer sum = 0;
        String str = "";
        for (Integer i : numberList) {
            sum += i;
        }
        if (childList.size() != 0) {
            for (Node n : childList) {
                n.sumNumber();
            }
        }
        str = "sum" + numberList.toString() + "=" + sum;
        sN.add(str);
    }
    
  public ArrayList<String> getsN(){
      return sN;
  }

  public void setsN(){
      sN=new ArrayList<String>();
  }


    static ArrayList<String> sN=new ArrayList<String>();
    public List<Node> childList;        // для записи дочерних узлов
    public List<Integer>  numberList;   //числа, входящие в узел
}