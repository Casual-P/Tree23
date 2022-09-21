package com.example.tree23;

import java.util.Arrays;

public class Node {
    private static final int ORDER = 7;
    private int numElems = 0;
    private final Node[] childArray = new Node[ORDER + 1];
    private final Data[] dataArray = new Data[ORDER];
    private Node parent;

    public static int getORDER() {
        return ORDER;
    }

    public Node getBrother(Node current) {
        for (int i = 0; i < childArray.length; i++) {
            if (childArray[i] == current)
                return childArray[i + 1];
        }
        return null;
    }


    public int indexChild(Node current) {
        for (int i = 0; i < childArray.length; i++) {
            if (childArray[i] == current)
                return i;
        }
        return -1;
    }


    public void clean() {
        numElems = 0;
        Arrays.fill(dataArray, null);
    }

    public boolean isFull() {
        return dataArray[ORDER - 2] != null;
    }

    public boolean isLeaf() {
        return childArray[0] == null;
    }

    public int insertData(Data newData) {
        int key = newData.getId();
        numElems++;
        for (int i = numElems - 1; i >= 0; i--) {
            if (dataArray[i] != null) {
                if (key < dataArray[i].getId())
                    dataArray[i + 1] = dataArray[i];
                else {
                    dataArray[i + 1] = newData;
                    return i + 1;
                }
            }
        }
        dataArray[0] = newData;
        return 0;
    }

    public Data find(int key) {
        for (Data data : dataArray) {
            if (data == null)
                break;
            else {
                if (data.getId() == key)
                    return data;
            }
        }
        return null;
    }

    public void dispNode() {
        for (Data data : dataArray) {
            if (data != null)
                data.disp();
        }
        System.out.println();
    }

    public Data removeLast() {
        Data temp = dataArray[numElems - 1];
        dataArray[numElems - 1] = null;
        numElems--;
        return temp;
    }

    public Data[] removeData() {
        Data[] removedData = Arrays.copyOfRange(dataArray, dataArray.length / 2 + 1, dataArray.length);
        for (int i = 4; i < dataArray.length; i++) {
            dataArray[i] = null;
            numElems--;
        }
        return removedData;
    }


    public Node disconnectChild(int childNum) {
        return childArray[childNum];
    }

    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null)
            child.setParent(this);
    }

    public Node getChild(int childNum) {
        return childArray[childNum];
    }
    public Data getData(int index) {
        return dataArray[index];
    }
    public int getNumElems() {
        return numElems;
    }
    public void setNumElems(int numElems) {
        this.numElems = numElems;
    }
    public Node getParent() {
        return parent;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
}
