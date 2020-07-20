package edu.pucmm.eict;

import edu.pucmm.eict.controladores.*;
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;

public class Main {


    public static void main(String[] args) {
        //Ejemplo hola mundo
        String mensaje = "Si tu' supieras cuantas veces he sognado con que regreses, seguro que estuvieras aqui'. [ChocQuibTown - Pa Olvidarte]";
        System.out.println(mensaje);

        //Creando la instancia del servidor.
        Javalin app = Javalin.create(config ->{
            config.addStaticFiles("/publico"); //desde la carpeta de resources
            config.registerPlugin(new RouteOverviewPlugin("/rutas")); //aplicando plugins de las rutas
        }).start(getHerokuAssignedPort());

        // Javalin app = Javalin.create().start(7000);

        //creando el manejador
        app.get("/", ctx -> ctx.result("Si tu' supieras cuantas veces he sognado con que regreses, seguro que estuvieras aqui'. [ChocQuibTown - Pa Olvidarte]"));

        //aplicando los diferentes conceptos.
        new ConceptoBasicosControlador(app).aplicarRutas();
        //aplicando las rutas para el procesamiento de los datos.
        new RecibirDatosControlador(app).aplicarRutas();
        //ejemplos de cookies y sesiones.
        new CookiesSesionesControlador(app).aplicarRutas();
        //ejemplo de manejo de sesiones y seguridad clasica.
        new ZonaAdminClasica(app).aplicarRutas();
        //manejo de codigo de errores y excepciones
        new ExcepcionesControlador(app).aplicarRutas();
        //Manejo de plantillas.
        new PlantillasControlador(app).aplicarRutas();
        //Manejo de Api.
        new ApiControlador(app).aplicarRutas();
        //Concepto de seguridad con roles.
        new ZonaAdminConRoles(app).aplicarRutas();
        //
        new CrudTradicionalControlador(app).aplicarRutas();
    }

    /**
     * Metodo para indicar el puerto en Heroku
     * @return
     */
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 8000; //Retorna un puerto asignado en caso de no estar en Heroku.
    }

}
