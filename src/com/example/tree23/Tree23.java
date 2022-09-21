package com.example.tree23;

public class Tree23 {
    private Node root;

    public Tree23() {
        this.root = new Node();
    }

    public void insert(Data newData) {
        Node current = root;
        while (true) {
            if (current.isLeaf()) {
                break;
            } else {
                current = getNextChild(newData.getId(), current);
            }
        }
        if (current.isFull()) {
            split(current, newData);
        } else
            current.insertData(newData);
    }

    private void split(Node current, Data newdata) {
        Node parent, newRight, child;
        Data[] dataC;
        Data dataB;

        current.insertData(newdata);
        dataC = current.removeData();
        dataB = current.removeLast();

        newRight = new Node();

        for (Data data : dataC) {
            if (data != null)
                newRight.insertData(data);
        }

        if (current == root) {
            parent = new Node();
            root = parent;
            parent.connectChild(0, current);
        } else {
            parent = current.getParent();
        }

        if (parent.isFull()) {
            int index = parent.indexChild(current);
            for (int i = 6; i > index; i--) {
                child = parent.disconnectChild(i);
                parent.connectChild(i + 1, child);
            }
            parent.connectChild(index + 1, newRight);
            split(parent, dataB);
        } else {
            int indexB = parent.insertData(dataB);
            int num = parent.getNumElems();
            for (int i = num - 1; i > indexB; i--) {
                Node temp = parent.disconnectChild(i);
                parent.connectChild(i + 1, temp);
            }
            parent.connectChild(indexB + 1, newRight);
        }
        int ch = 0;
        for (int i = 4; i < 8; i++) {
            child = current.disconnectChild(i);
            newRight.connectChild(ch, child);
            ch++;
        }
    }

    public void displayTree(DisplayFormat displayFormat) {
        switch (displayFormat) {
            case NODE -> displayByNodes(root, 0, 0);
            case ORDER -> recDisplay(root);
        }
    }

    private void displayByNodes(Node localroot, int level, int childNum) {
        System.out.print("level = " + level + ", child = " + childNum + ", data : ");
        localroot.dispNode();

        int num = localroot.getNumElems();

        for (int j = 0; j < num + 1; j++) {
            Node next = localroot.getChild(j);
            if (next != null) {
                displayByNodes(next, level + 1, j);
            } else
                return;
        }
    }

    private void recDisplay(Node localroot) {
        if (localroot != null) {
            int num = localroot.getNumElems();
            for (int i = 0; i <= num; i++) {
                Node next = localroot.getChild(i);
                recDisplay(next);
                if (i < num) {
                    localroot.getData(i).disp();
                }
            }
        }
    }

    private Node getNextChild(int id, Node current) {
        int i;
        int num = current.getNumElems();
        for (i = 0; i < num; i++) {
            if (id < current.getData(i).getId())
                return current.getChild(i);
        }
        return current.getChild(i);
    }
}
