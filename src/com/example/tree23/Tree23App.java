package com.example.tree23;

import com.example.tree23.bootstrap.TreeBootstrap;


public class Tree23App {
    public static void main(String[] args) {
        Tree23 tree23 = new Tree23();
        TreeBootstrap bootstrap = new TreeBootstrap(tree23);

        bootstrap.insert1000Elements();
        tree23.displayTree(DisplayFormat.NODE);
    }
}



