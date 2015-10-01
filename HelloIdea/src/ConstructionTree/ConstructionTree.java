package ConstructionTree;

import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by dreaminteam on 7.8.14.
 */
public class ConstructionTree {

    public static void main(String[] args) {

        Logger.global.setLevel(Level.OFF);

        String[] treeStr = {"[", "1", "[", "2", "3", "]", "4", "[", "5", "[", "6", "7", "[", "1", "]", "]", "]", "[", "8", "]", "]"};
        ArrayList<String> treeList = arrayToList(treeStr);

        ConstructionTree cTree = new ConstructionTree();
        System.out.println(treeList.toString());

        Node node = cTree.constructor(treeList, 0);
        System.out.println(node.toString());
        node.sumNumber();
        System.out.println(node.getsN().size());
        Logger.global.info("Program the emd");


    }


    public static ArrayList<String> arrayToList(String[] array) {
        if ((array.length == 0) | (new ConstructionTree().balanceTest(array) == false)) {
            new OutputTreeExeption();
        }
        ArrayList listStr = new ArrayList<String>();
        for (String str : array) {
            listStr.add(str);
        }
        return listStr;
    }

    /**
     * @param list
     * @return Для заданной подстроки возвращает объект NodeAndIndexNextLevel(numberList,indexNextLevel)
     */
    public NodeAndIndexNextLevel allocationNode(ArrayList<String> list) {

        ArrayList numberList = new ArrayList<Integer>();
        ArrayList indexNextLevel = new ArrayList<Integer>();
        int i = 0;
        while ((i < list.size())) {
            if ((!list.get(i).equals("["))) {
                numberList.add(Integer.valueOf(list.get(i)));
                i++;
            } else {
                indexNextLevel.add(i);
                i = endSublist(list, i);
            }
        }
        return new NodeAndIndexNextLevel(numberList, indexNextLevel);
    }


    public Node constructor(ArrayList<String> str, int index) {

        ArrayList<String> s = searсhAndClearSublist(str, index);

        NodeAndIndexNextLevel nInd = allocationNode(s);
        Node a = new Node();
        a.numberList = nInd.numberList;
        a.childList = new ArrayList<Node>();
        ArrayList<Integer> indNLvl = nInd.indexNextLevel;
        if (indNLvl.size() != 0) {
            for (int i = indNLvl.size() - 1; 0 <= i; i--) {
                a.childList.add(constructor(s, indNLvl.get(i)));
            }
        }
        return a;
    }

    /**
     * @param lStr     - List
     * @param numInput -starting index brackets
     * @return outList ; removes the matched substring from a string supplied to the inlet
     * При заданном индексе открывающейся скобки "[" находит подстроку [...] и удалеет ее.
     * Возвращается удаленная подстрока
     */
    public static ArrayList<String> searсhAndClearSublist(ArrayList<String> lStr, int numInput) {

        ArrayList outList = new ArrayList<String>();
        int start = numInput;
        int i = numInput + 1;
        int number = 1;

        while (number != 0) {
            String sEl = lStr.get(i);
            if (sEl.equals("[")) {
                number++;
                outList.add(sEl);
                i++;
            } else {
                if (sEl.equals("]")) {
                    number--;
                    if (number != 0) {
                        outList.add(sEl);
                    }
                    i++;
                } else {
                    outList.add(sEl);
                    i++;
                }
            }
        }
        lStr.subList(start, i).clear();
        return outList;
    }

    /**
     * @param lStr
     * @param numInput
     * @return зная индекс numInput начала подстроки, возвращает индекс конца подстроки
     */
    public static int endSublist(ArrayList<String> lStr, int numInput) {

        ArrayList outList = new ArrayList<String>();
        int start = numInput;
        int i = numInput + 1;
        int number = 1;

        while (number != 0) {
            String sEl = lStr.get(i);
            if (sEl.equals("[")) {
                number++;
                i++;
            } else {
                if (sEl.equals("]")) {
                    number--;
                    i++;
                } else {
                    i++;
                }
            }
        }
        return i;
    }


    private class NodeAndIndexNextLevel {

        /**
         * @param numberList     - список чисел, входящий в узел
         * @param indexNextLevel - список индексов начала подстрок, характеризующих следующий уровень узла
         */
        private NodeAndIndexNextLevel(ArrayList<Integer> numberList, ArrayList<Integer> indexNextLevel) {
            this.numberList = numberList;
            this.indexNextLevel = indexNextLevel;
        }

        @Override
        public String toString() {
            return "NodeAndIndexNextLevel {" +
                    "numberList=" + numberList.toString() +
                    ", indexNextLevel=" + indexNextLevel.toString() +
                    '}';
        }

        ArrayList<Integer> numberList = null;
        ArrayList<Integer> indexNextLevel = null;
    }


    public boolean balanceTest(String[] str) {

        Stack<Character> staff = new Stack<Character>();
        for (int i = 0; i < str.length; i++) {
            char br = str[i].charAt(0);
            if (br == '[') {
                staff.push(br);
            } else if (br == ']') {
                if (!staff.empty()) {
                    staff.pop();
                } else {
                    return false;
                }
            }
        }
        if (!staff.empty()) {
            return false;
        } else {
            return true;
        }
    }

}

class OutputTreeExeption extends IOException {

    public OutputTreeExeption() {
        super();

        System.out.println(getMessage());
        System.out.println("Не верно задана структура дерева");
        System.exit(0);

    }
}

