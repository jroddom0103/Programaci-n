package com.es.tema9.teoriaV.utils;

public class DBUtils {

    //CREDENCIALES DE LA BASE DE DATOS
    public static final String DB_NAME = "dbapp";
    public static final String USER = "root";
    public static final String PASS = "";

    //QUERYS DE LA APLICACIÓN
    public static String QUERY_LOGIN = "SELECT * FROM usuarios WHERE id=? AND pass = ?;";
    public static String QUERY_CHECK_USER_IN_ACCESOS = "SELECT * FROM accesos WHERE id = ?;";
    public static String QUERY_INSERT_USER_IN_ACCESOS = "INSERT INTO accesos VALUES(?, ?);";
    public static String QUERY_UPDATE_NACCESOS = "UPDATE accesos SET nAccesos = nAccesos+1 WHERE id = ?;";

}