package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SqlServer {

    private static Connection cn = null;
    private static PreparedStatement pr = null;
    private static ResultSet rs = null;

    public static String[][] leerCategoriaMysql() {
        String[][]  datos = null;
        int numeroFila = 0;
        try {
            //TODO
            cn = obtenerConexion();
            pr = cn.prepareStatement("SELECT * FROM categoria");
            rs = pr.executeQuery();

            datos = new String[numeroFilas(rs)][4];

            while( rs.next() ) {

                datos[numeroFila][0] = rs.getString("usuario");
                datos[numeroFila][1] = rs.getString("clave");
                datos[numeroFila][2] = rs.getString("nombre");
                datos[numeroFila][3] = rs.getString("valorEsperado");

                numeroFila++;
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                pr.close();
            } catch (Exception e) {
            }
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return datos;
    }

    public static ArrayList<Object[]> leerTablaSql(String nombreTabla) {

        ArrayList<Object[]> myData = new ArrayList<Object[]>();

        try {
            //TODO
            cn = obtenerConexion();

            /***
             * Se obtiene por parametro del metodo el nombre de la tabla que sera leida.
             * Este devolvera los datos de cada fila para el test de casos de pruebas.
             */

            pr = cn.prepareStatement("SELECT * FROM " + nombreTabla.toString());
            rs = pr.executeQuery();

            switch (nombreTabla){

                case "usuariorol":

                    while( rs.next() ) {

                        String usuario = rs.getString("usuario");
                        String password = rs.getString("password");
                        String sistema = rs.getString("sistema");
                        String crud = rs.getString("crud");
                        String documento = rs.getString("documento");
                        String rol = rs.getString("rol");
                        String tiposede = rs.getString("tiposede");
                        String sede = rs.getString("sede");
                        String accion = rs.getString("accion");
                        String existe = rs.getString("existe");
                        String valoresperado = rs.getString("valoresperado");

                        myData.add(new Object[] { usuario, password,  sistema, crud, documento, rol, tiposede, sede, accion, existe, valoresperado });

                    }

                    break;

                case "usuarios":

                    while( rs.next() ) {

                        String usuario = rs.getString("usuario");
                        String password = rs.getString("password");
                        String sistema = rs.getString("sistema");
                        String crud = rs.getString("crud");
                        String tipodoc = rs.getString("tipodoc");
                        String numerodoc = rs.getString("numerodoc");
                        String validar = rs.getString("validar");
                        String nombres = rs.getString("nombres");
                        String paterno = rs.getString("paterno");
                        String materno = rs.getString("materno");
                        String estado = rs.getString("estado");
                        String autoriz = rs.getString("autoriz");
                        String correo = rs.getString("correo");
                        String sincroniza = rs.getString("sincroniza");
                        String accion = rs.getString("accion");
                        String existe = rs.getString("existe");
                        String valoresperado = rs.getString("valoresperado");

                        myData.add(new Object[] { usuario, password, sistema, crud, tipodoc, numerodoc, validar, nombres, paterno, materno, estado, autoriz, correo, sincroniza, accion, existe, valoresperado });

                    }

                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                pr.close();
            } catch (Exception e) {
            }
            try {
                cn.close();
            } catch (Exception e) {
            }
        }

        return myData;
    }

    private static Connection obtenerConexion() throws Exception {

        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return (DriverManager.getConnection("jdbc:sqlserver://PCPOGCUCSI0004:1433;databaseName=QAPruebas;integratedSecurity=false;","userQA","Hgs09764724"));

    }

    private static int numeroFilas(ResultSet resultSet){
        int totalFilas = 0;
        try {
            resultSet.last();
            totalFilas = resultSet.getRow();
            resultSet.beforeFirst();
        }
        catch(Exception ex)  {
            return 0;
        }
        return totalFilas ;
    }


}
