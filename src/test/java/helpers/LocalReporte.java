package helpers;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LocalReporte {

    public  static void  main (String[] args) {

        //String ruta = "C:\\Users\\TESTING_UCSI07\\Desktop\\Proyectos\\Siagie-Cucumber\\build\\reports\\cucumber\\";
        String ruta = System.getProperty("user.dir") + "\\build\\reports\\cucumber\\";
        File report = new File(ruta+"SiagieReport");

        List<String> jsonFiles= new ArrayList<>();
        jsonFiles.add(ruta+"report.json");

        Configuration configuration = new Configuration(report,"Siagie Traslados");
        configuration.setBuildNumber("1.0");
        configuration.addClassifications("Owner","Humberto Guadalupe S.");
        configuration.addClassifications("Env","Web");
        configuration.addClassifications("Tipo","Local");
        configuration.addClassifications("Branch","master-traslados");

        ReportBuilder reportBuilder= new ReportBuilder(jsonFiles,configuration);
        reportBuilder.generateReports();

    }

}
