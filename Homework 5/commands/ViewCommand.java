package org.example.commands;
import org.example.CatalogException;
import org.example.Resource;
import java.awt.Desktop;
import java.io.File;
import java.net.URI;

public class ViewCommand implements Command {
    private Resource resource;
    public ViewCommand(Resource resource) { this.resource = resource; }

    @Override
    public void execute() throws CatalogException {
        try {
            Desktop desktop = Desktop.getDesktop();
            String loc = resource.getLocation();
            if (loc.startsWith("http")) {
                desktop.browse(new URI(loc));
            } else {
                desktop.open(new File(loc));
            }
        } catch (Exception e) {
            throw new CatalogException("Eroare la deschiderea resursei: " + resource.getTitle(), e);
        }
    }
}