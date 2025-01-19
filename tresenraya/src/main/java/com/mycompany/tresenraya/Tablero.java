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

public static char[] minimax(){
        Tree<char[]> arbol=crearArbol();
        LinkedList<Tree<char[]>> listaNivel2= arbol.getRoot().getHijos();
        LinkedList<Integer> minimos=new LinkedList();
        for(int i=0;i<listaNivel2.size();i++){
            Tree<char[]> nodoNivel2=listaNivel2.get(i);
            if(analizarSiHayGanador(nodoNivel2.getRoot().getContent(),maquina)==1){
                    return nodoNivel2.getRoot().getContent();
            }
            LinkedList<Tree<char[]>> listaNivel3= nodoNivel2.getRoot().getHijos();
            if(listaNivel3.isEmpty()){
                return nodoNivel2.getRoot().getContent();
            }
            LinkedList<Integer> lista_utilidades=new LinkedList<>();
            boolean ban=true;
            for(int e=0;e<listaNivel3.size();e++){
                Tree<char[]> nodoNivel3=listaNivel3.get(e);
                char[] contentNodo= nodoNivel3.getRoot().getContent();
                System.out.println(Arrays.toString(contentNodo));
                //System.out.println(analizarGanador(contentNodo,false));
                if(analizarSiHayGanador(contentNodo,jugador)==1){
                    ban=false;
                    minimos.add(Integer.MIN_VALUE);
                    System.out.println(Integer.MIN_VALUE);
                    break;
                }
                int Pmaquina=0;
                int Pjugador=0;
                int utilidad; 
                for(int a=0;a<combinaciones.length;a++){
                    int[] combinacion=combinaciones[a];
                    boolean maquinaDisponibilidad=true;
                    boolean jugadorDisponibilidad=true;
                    for(int o=0;o<combinacion.length;o++){
                        int indice=combinacion[o];
                        if (contentNodo[indice] == jugador) {
                            maquinaDisponibilidad = false;
                        }if (contentNodo[indice] == maquina) {
                            jugadorDisponibilidad =false;
                        }
                         
                    }
                    if(maquinaDisponibilidad) Pmaquina++;
                    if(jugadorDisponibilidad) Pjugador++;
                }
                
                utilidad=Pmaquina;
                lista_utilidades.add(utilidad);
               
            }
            if(ban){
                minimos.add(Collections.min(lista_utilidades));
            }
            
            
            
        }
        
        System.out.println(minimos);
 
        int indiceMaxUtilidad= minimos.lastIndexOf(Collections.max(minimos));
        char[] tableroGanador  = listaNivel2.get(indiceMaxUtilidad).getRoot().getContent();
        return tableroGanador;
    }


public static int indiceMovimientoMaquina(){
        char[] tableroGanador= minimax();
        for(int i=0;i<tablero.length;i++){
            if(tablero[i]!=tableroGanador[i]){
                return i;
            }
        }
        
        return -1;   
    }
	


    
     
    
}
    

