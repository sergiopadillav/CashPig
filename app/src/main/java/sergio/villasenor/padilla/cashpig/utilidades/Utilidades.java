package sergio.villasenor.padilla.cashpig.utilidades;

import java.io.Serializable;

public class Utilidades implements Serializable {

    // CONSTANTES DE LA TABLA USUARIOS
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_CORREO="correo";
    public static final String CAMPO_CONTRASENIA="contrasenia";
    public static final String CAMPO_CAPITAL= "capital";

    public static final String CREAR_TABLA_USUARIOS = "CREATE TABLE " +TABLA_USUARIO+"("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_CORREO+" TEXT, "+CAMPO_CONTRASENIA+" TEXT, "+CAMPO_CAPITAL+" FLOAT)";

    // CONSTANTES DE LA TABLA GASTOS
    public static final String TABLA_GASTO="gasto";
    public static final String CAMPO_ID_GASTO="idGastos";
    public static final String CAMPO_ID_USUARIO="idUsuario";
    public static final String CAMPO_CANTIDAD="cantidad";
    public static final String CAMPO_CATEGORIA="categoria";
    public static final String CAMPO_TIPO="tipo";
    public static final String CAMPO_FECHA="fecha";


    public static final String CREAR_TABLA_GASTOS = "CREATE TABLE " +TABLA_GASTO+"("+CAMPO_ID_GASTO+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_ID_USUARIO+" INTEGER,"+CAMPO_CANTIDAD+" FLOAT,"+CAMPO_CATEGORIA+" TEXT, "+CAMPO_TIPO+" BOOLEAN, "+CAMPO_FECHA+" TEXT)";
}



