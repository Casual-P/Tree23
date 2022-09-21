package com.example.tree23.bootstrap;

import com.example.tree23.Data;
import com.example.tree23.Tree23;


public class TreeBootstrap {

    private final Tree23 tree;

    public TreeBootstrap(Tree23 tree) {
        this.tree = tree;
    }

    public void insert1000Elements() {
        int n = 1000;
        for (int i = 0; i < n; i++) {
            int rnd = (int) (Math.random() * n);
            tree.insert(new Data(rnd));
        }
    }
}
