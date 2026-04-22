package org.example.commands;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.example.Catalog;
import org.example.CatalogException;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand implements Command {
    private Catalog catalog;

    public ReportCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() throws CatalogException {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
            cfg.setClassForTemplateLoading(this.getClass(), "/");
            Template template = cfg.getTemplate("report.ftl");

            Map<String, Object> data = new HashMap<>();
            data.put("catalog", catalog);

            File reportFile = new File("report.html");
            try (Writer out = new FileWriter(reportFile)) {
                template.process(data, out);
            }

            System.out.println("Raport HTML generat.");
            Desktop.getDesktop().open(reportFile);
        } catch (Exception e) {
            throw new CatalogException("Eroare la generarea raportului HTML.", e);
        }
    }
}