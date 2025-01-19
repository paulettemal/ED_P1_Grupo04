/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tresenraya;

import java.util.LinkedList;

/**
 *
 * @author zaval
 */
public class NodeTree<E> {
    private E content;
    private LinkedList<Tree<E>> hijos;
    
    public NodeTree(E content){
        this.content=content;
        this.hijos= new LinkedList();
    }
    
    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public void setHijos(LinkedList<Tree<E>> hijos) {
        this.hijos = hijos;
    }

    public LinkedList<Tree<E>> getHijos() {
        return hijos;
    }
}
