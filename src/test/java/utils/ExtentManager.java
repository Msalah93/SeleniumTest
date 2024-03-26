package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;

	public static ExtentReports createInstance(String filePath) {

		Date date = new Date();
        // Formatter la date selon le format désiré (par exemple, "yyyyMMdd_HHmmss")
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
        String formattedDate = dateFormat.format(date);
        // Ajouter la date formatée au nom du fichier de rapport
        String finalFilePath = filePath + "Rapport_du_" + formattedDate + ".html";
		
        ExtentSparkReporter rapport = new ExtentSparkReporter(finalFilePath);
       
        extent = new ExtentReports();
        extent.attachReporter(rapport);

        // Configuration des options du rapport
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));

        
        rapport.config().setDocumentTitle("Rapport de Test");
        rapport.config().setReportName("Rapport d'exécution des tests");
        rapport.config().setTheme(Theme.DARK);

        return extent;
    }
}
