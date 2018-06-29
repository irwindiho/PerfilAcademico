package com.irvinmarin.apps.miperfilacademico;

import android.util.Log;

import com.irvinmarin.apps.miperfilacademico.cursos.ui.entities.CursosDetalleUI;
import com.irvinmarin.apps.miperfilacademico.plan_academico.ui.entities.CiclosUI;
import com.irvinmarin.apps.miperfilacademico.plan_academico.ui.entities.CursosUI;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irvinmarin on 31/05/2018.
 */

public class UtilsApp {
    public static List<CiclosUI> populateCiclosUI() {
        List<CiclosUI> ciclosUIList;
        List<CursosUI> cursosUIList;
        //ciclo 1
        ciclosUIList = new ArrayList<>();
        cursosUIList = new ArrayList<>();
        cursosUIList.add(new CursosUI(1, "Cultura Fisica I", "1", "1", "1", "2", "15"));
        cursosUIList.add(new CursosUI(2, "Educaición para la Salud", "2", "2", "2", "4", "15"));
        cursosUIList.add(new CursosUI(3, "Introduccion a las tecnologias de informacion", "4", "4", "4", "2", "15"));
        cursosUIList.add(new CursosUI(4, "Matematica", "4", "4", "4", "8", "15"));
        cursosUIList.add(new CursosUI(5, "Técnicas de Estudio e Investigacion", "3", "4", "2", "6", "15"));
        cursosUIList.add(new CursosUI(6, "Introducción a la santa Biblia", "1", "1", "1", "2", "15"));
        cursosUIList.add(new CursosUI(7, "Capacidades Cuminicaivas", "4", "4", "4", "8", "15"));

        ciclosUIList.add(new CiclosUI(1, "Ciclo 1", true, cursosUIList));

        //ciclo 2

        cursosUIList = new ArrayList<>();
        cursosUIList.add(new CursosUI(8, "Algebra Superior y Lineal", "4", "4", "3", "7", "15"));
        cursosUIList.add(new CursosUI(9, "Algoritmos y estructiras de Datos", "2", "2", "2", "4", "15"));
        cursosUIList.add(new CursosUI(10, "Antropología Biblica", "4", "4", "4", "2", "15"));
        cursosUIList.add(new CursosUI(11, "Cultura Física II", "4", "4", "4", "8", "15"));
        cursosUIList.add(new CursosUI(12, "Cálculo I", "3", "4", "2", "6", "15"));
        cursosUIList.add(new CursosUI(13, "Dibujo de Ingenieria", "3", "3", "1", "2", "15"));
        cursosUIList.add(new CursosUI(14, "Fundamentos de Liderazgo", "4", "4", "4", "8", "15"));

        ciclosUIList.add(new CiclosUI(2, "Ciclo 2", true, cursosUIList));

        //ciclo 3
        cursosUIList = new ArrayList<>();
        cursosUIList.add(new CursosUI(8, "Algebra Superior y Lineal", "4", "4", "3", "7", "15"));
        cursosUIList.add(new CursosUI(9, "Algoritmos y estructiras de Datos", "2", "2", "2", "4", "15"));
        cursosUIList.add(new CursosUI(10, "Antropología Biblica", "4", "4", "4", "2", "15"));
        cursosUIList.add(new CursosUI(11, "Cultura Física II", "4", "4", "4", "8", "15"));
        cursosUIList.add(new CursosUI(12, "Cálculo I", "3", "4", "2", "6", "15"));
        cursosUIList.add(new CursosUI(13, "Dibujo de Ingenieria", "3", "3", "1", "2", "15"));
        cursosUIList.add(new CursosUI(14, "Fundamentos de Liderazgo", "4", "4", "4", "8", "15"));

        ciclosUIList.add(new CiclosUI(2, "Ciclo 3", true, cursosUIList));

        //ciclo 4
        cursosUIList = new ArrayList<>();
        cursosUIList.add(new CursosUI(8, "Algebra Superior y Lineal", "4", "4", "3", "7", "15"));
        cursosUIList.add(new CursosUI(9, "Algoritmos y estructiras de Datos", "2", "2", "2", "4", "15"));
        cursosUIList.add(new CursosUI(10, "Antropología Biblica", "4", "4", "4", "2", "15"));
        cursosUIList.add(new CursosUI(11, "Cultura Física II", "4", "4", "4", "8", "15"));
        cursosUIList.add(new CursosUI(12, "Cálculo I", "3", "4", "2", "6", "15"));
        cursosUIList.add(new CursosUI(13, "Dibujo de Ingenieria", "3", "3", "1", "2", "15"));
        cursosUIList.add(new CursosUI(14, "Fundamentos de Liderazgo", "4", "4", "4", "8", "15"));

        ciclosUIList.add(new CiclosUI(2, "Ciclo 4", true, cursosUIList));

        //ciclo 5
        cursosUIList = new ArrayList<>();
        cursosUIList.add(new CursosUI(8, "Algebra Superior y Lineal", "4", "4", "3", "7", "15"));
        cursosUIList.add(new CursosUI(9, "Algoritmos y estructiras de Datos", "2", "2", "2", "4", "15"));
        cursosUIList.add(new CursosUI(10, "Antropología Biblica", "4", "4", "4", "2", "15"));
        cursosUIList.add(new CursosUI(11, "Cultura Física II", "4", "4", "4", "8", "15"));
        cursosUIList.add(new CursosUI(12, "Cálculo I", "3", "4", "2", "6", "15"));
        cursosUIList.add(new CursosUI(13, "Dibujo de Ingenieria", "3", "3", "1", "2", "15"));
        cursosUIList.add(new CursosUI(14, "Fundamentos de Liderazgo", "4", "4", "4", "8", "15"));

        ciclosUIList.add(new CiclosUI(2, "Ciclo 5", true, cursosUIList));

        //ciclo 6
        cursosUIList = new ArrayList<>();
        cursosUIList.add(new CursosUI(8, "Algebra Superior y Lineal", "4", "4", "3", "7", "15"));
        cursosUIList.add(new CursosUI(9, "Algoritmos y estructiras de Datos", "2", "2", "2", "4", "15"));
        cursosUIList.add(new CursosUI(10, "Antropología Biblica", "4", "4", "4", "2", "15"));
        cursosUIList.add(new CursosUI(11, "Cultura Física II", "4", "4", "4", "8", "15"));
        cursosUIList.add(new CursosUI(12, "Cálculo I", "3", "4", "2", "6", "15"));
        cursosUIList.add(new CursosUI(13, "Dibujo de Ingenieria", "3", "3", "1", "2", "15"));
        cursosUIList.add(new CursosUI(14, "Fundamentos de Liderazgo", "4", "4", "4", "8", "15"));

        ciclosUIList.add(new CiclosUI(2, "Ciclo 6", true, cursosUIList));

        //ciclo 7
        cursosUIList = new ArrayList<>();
        cursosUIList.add(new CursosUI(8, "Algebra Superior y Lineal", "4", "4", "3", "7", "15"));
        cursosUIList.add(new CursosUI(9, "Algoritmos y estructiras de Datos", "2", "2", "2", "4", "15"));
        cursosUIList.add(new CursosUI(10, "Antropología Biblica", "4", "4", "4", "2", "15"));
        cursosUIList.add(new CursosUI(11, "Cultura Física II", "4", "4", "4", "8", "15"));
        cursosUIList.add(new CursosUI(12, "Cálculo I", "3", "4", "2", "6", "15"));
        cursosUIList.add(new CursosUI(13, "Dibujo de Ingenieria", "3", "3", "1", "2", "15"));
        cursosUIList.add(new CursosUI(14, "Fundamentos de Liderazgo", "4", "4", "4", "8", "15"));

        ciclosUIList.add(new CiclosUI(2, "Ciclo 7", true, cursosUIList));

        //ciclo 8
        cursosUIList = new ArrayList<>();
        cursosUIList.add(new CursosUI(8, "Algebra Superior y Lineal", "4", "4", "3", "7", "15"));
        cursosUIList.add(new CursosUI(9, "Algoritmos y estructiras de Datos", "2", "2", "2", "4", "15"));
        cursosUIList.add(new CursosUI(10, "Antropología Biblica", "4", "4", "4", "2", "15"));
        cursosUIList.add(new CursosUI(11, "Cultura Física II", "4", "4", "4", "8", "15"));
        cursosUIList.add(new CursosUI(12, "Cálculo I", "3", "4", "2", "6", "15"));
        cursosUIList.add(new CursosUI(13, "Dibujo de Ingenieria", "3", "3", "1", "2", "15"));
        cursosUIList.add(new CursosUI(14, "Fundamentos de Liderazgo", "4", "4", "4", "8", "15"));

        ciclosUIList.add(new CiclosUI(2, "Ciclo 8", true, cursosUIList));

        //ciclo 9
        cursosUIList = new ArrayList<>();
        cursosUIList.add(new CursosUI(8, "Algebra Superior y Lineal", "4", "4", "3", "7", "15"));
        cursosUIList.add(new CursosUI(9, "Algoritmos y estructiras de Datos", "2", "2", "2", "4", "15"));
        cursosUIList.add(new CursosUI(10, "Antropología Biblica", "4", "4", "4", "2", "15"));
        cursosUIList.add(new CursosUI(11, "Cultura Física II", "4", "4", "4", "8", "15"));
        cursosUIList.add(new CursosUI(12, "Cálculo I", "3", "4", "2", "6", "15"));
        cursosUIList.add(new CursosUI(13, "Dibujo de Ingenieria", "3", "3", "1", "2", "15"));
        cursosUIList.add(new CursosUI(14, "Fundamentos de Liderazgo", "4", "4", "4", "8", "15"));

        ciclosUIList.add(new CiclosUI(2, "Ciclo 9", true, cursosUIList));

        //ciclo 10
        cursosUIList = new ArrayList<>();
        cursosUIList.add(new CursosUI(8, "Algebra Superior y Lineal", "4", "4", "3", "7", "15"));
        cursosUIList.add(new CursosUI(9, "Algoritmos y estructiras de Datos", "2", "2", "2", "4", "15"));
        cursosUIList.add(new CursosUI(10, "Antropología Biblica", "4", "4", "4", "2", "15"));
        cursosUIList.add(new CursosUI(11, "Cultura Física II", "4", "4", "4", "8", "15"));
        cursosUIList.add(new CursosUI(12, "Cálculo I", "3", "4", "2", "6", "15"));
        cursosUIList.add(new CursosUI(13, "Dibujo de Ingenieria", "3", "3", "1", "2", "15"));
        cursosUIList.add(new CursosUI(14, "Fundamentos de Liderazgo", "4", "4", "4", "8", "15"));

        ciclosUIList.add(new CiclosUI(2, "Ciclo 10", true, cursosUIList));

        return ciclosUIList;
    }

    public static List<CursosDetalleUI> populateContratoCursosUI() {
//        List<CiclosUI> ciclosUIList;
        List<CursosDetalleUI> cursosUIList;


        //ciclo 2

        cursosUIList = new ArrayList<>();
        cursosUIList.add(new CursosDetalleUI(8, "Algebra Superior y Lineal", "4", "Ing. Sis.", "Enrrique Vega", "Ciclo 2", "4", "2", "1", "7", "15"));
        cursosUIList.add(new CursosDetalleUI(9, "Algoritmos y estructiras de Datos", "2", "Ing. Sis.", "Omar Loiza Vega", "Ciclo 2", "4", "2", "1", "7", "15"));
        cursosUIList.add(new CursosDetalleUI(10, "Antropología Biblica", "4", "Ing. Sis.", "Jose Solorzano", "Ciclo 2", "4", "2", "1", "7", "15"));
        cursosUIList.add(new CursosDetalleUI(11, "Cultura Física II", "4", "Ing. Sis.", "Oscar Lopez", "Ciclo 2", "4", "2", "1", "7", "15"));
        cursosUIList.add(new CursosDetalleUI(12, "Cálculo I", "3", "Ing. Sis.", "Enrrique Vega", "Ciclo 2", "4", "2", "1", "7", "15"));
        cursosUIList.add(new CursosDetalleUI(13, "Dibujo de Ingenieria", "3", "Ing. Sis.", "Melina Oscanoa", "Ciclo 2", "4", "2", "1", "7", "15"));
        cursosUIList.add(new CursosDetalleUI(14, "Fundamentos de Liderazgo", "4", "Ing. Sis.", "Chico Vega", "Ciclo 2", "4", "2", "1", "7", "15"));

//        ciclosUIList.add(new CiclosUI(2, "Ciclo 2", true, cursosUIList));

        return cursosUIList;
    }

    public static boolean isOnlineNet() {
        try {
            Process p = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.com");
            int val = p.waitFor();
            return (val == 0);
        } catch (Exception e) {
            Log.e("isOnlineNet", e.toString());
        }
        return false;
    }

    public static boolean isSuccess(JSONObject jsonObject) {
        boolean estado;
        try {
            estado = jsonObject.getBoolean("Successful");
        } catch (JSONException e) {
            e.printStackTrace();
            estado = false;
        }
        return estado;
    }


    public static String getJsonObResult(JSONObject jsonObject) {
        String s = "";
        try {
            s = jsonObject.getJSONObject("Value").toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static String getJsonObResultArray(JSONObject jsonObject) {
        String s = "";
        try {
            s = jsonObject.getJSONArray("Value").toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return s;
    }
}
