/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tresenraya;

/**
 *
 * @author zaval
 */
public class Tree<E> {
    private NodeTree<E> root;
    
    public Tree(){
        root=null;
    }

    public NodeTree<E> getRoot() {
        return root;
    }

    public void setRoot(NodeTree<E> root) {
        this.root = root;
    }
    
    public Tree(E content){
        root=new NodeTree(content);
    }
    
    
}
