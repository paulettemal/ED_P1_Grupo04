/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zaval
 */
package com.mycompany.tresenraya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author zaval
 */
public class Tablero {
    
    public static char jugador;
    public static char maquina;
    public static char[] tablero= new char[9];
    
    public static int[][] combinaciones = {
        {0, 1, 2}, // Fila 1
        {3, 4, 5}, // Fila 2
        {6, 7, 8}, // Fila 3
        {0, 3, 6}, // Columna 1
        {1, 4, 7}, // Columna 2
        {2, 5, 8}, // Columna 3
        {0, 4, 8}, // Diagonal principal
        {2, 4, 6}  // Diagonal secundaria
    };
    
    public static LinkedList<char[]> generarEstados(char[] tablero, char ficha){
        LinkedList<char[]> listaEstados =new LinkedList();
        for(int i=0;i<tablero.length;i++){
            if (tablero[i]=='\u0000'){
                char[] estado=tablero.clone();
                estado[i]=ficha;
                listaEstados.add(estado);
            }
        }
        
        return listaEstados;
    }
    
    
    public static Tree<char[]> crearArbol(){
        Tree<char[]> arbol=new Tree(tablero);
        LinkedList<char[]> estadosNivel2= generarEstados(tablero,maquina);
        
        for(int i=0;i<estadosNivel2.size();i++){
            Tree<char[]> nodoNivel2=new Tree(estadosNivel2.get(i));
            LinkedList<char[]> estadosNivel3= generarEstados(nodoNivel2.getRoot().getContent(),jugador);
            for(int e=0;e<estadosNivel3.size();e++){
                Tree<char[]> nodoNivel3=new Tree(estadosNivel3.get(e));
                nodoNivel2.getRoot().getHijos().add(nodoNivel3);
                
            }
            
            arbol.getRoot().getHijos().add(nodoNivel2);
            
        }
        
        return arbol;
    }


public static int analizarSiHayGanador(char[] tablero,char ficha){
        for(int i=0;i<combinaciones.length;i++){
            int[] combinacion =combinaciones[i];
            boolean bandera=true;
            for(int e=0;e<combinacion.length;e++){
                int indice=combinacion[e];
                if(tablero[indice]!=ficha){
                    bandera=false;
                }     
            }
            if(bandera==true){
                return 1;
            }      
  
        }
        
        return 0;
    }
	


    
     
    
}
    

