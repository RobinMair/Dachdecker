package init;

import entities.Baumaterial;
import entities.Auftrag;
import entities.Mitarbeiter;
import facades.BaumaterialFacade;
import facades.AuftragFacade;
import facades.MitarbeiterFacade;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class InitBean {

    @Inject
    BaumaterialFacade baumaterialFacade;

    @Inject
    AuftragFacade auftragFacade;

    @Inject
    MitarbeiterFacade mitarbeiterFacade;

    public InitBean(){

    }

    @PostConstruct
    private void init(){
        Baumaterial bm1 = new Baumaterial("Eichenholz", 20.0);
        Baumaterial bm2 = new Baumaterial("Nussholz", 50.0);
        baumaterialFacade.save(bm1);
        baumaterialFacade.save(bm2);

        Auftrag auftrag = new Auftrag("Lukas Riedl", "Alkoven 1");
        auftragFacade.save(auftrag);

        Mitarbeiter mitarbeiter1 = new Mitarbeiter("Robin", "Mair", "robin.mair@gmx.at", "Chef");
        Mitarbeiter mitarbeiter2 = new Mitarbeiter("Tobias", "Schicker", "tobias.schicker@gmx.at", "Bauarbeiter");
        Mitarbeiter mitarbeiter3 = new Mitarbeiter("Matthias", "Meier", "matthias.meier@gmx.at", "Projektleiter");
        mitarbeiterFacade.save(mitarbeiter1);
        mitarbeiterFacade.save(mitarbeiter2);
        mitarbeiterFacade.save(mitarbeiter3);
    }
}
