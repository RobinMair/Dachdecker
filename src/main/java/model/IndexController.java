package model;

import entities.Auftrag;
import entities.Auftragsstatus;
import entities.Baumaterial;
import entities.Mitarbeiter;
import facades.BaumaterialFacade;
import facades.AuftragFacade;
import facades.MitarbeiterFacade;
import org.primefaces.event.SelectEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.Registration;
import java.util.LinkedList;
import java.util.List;

@Model
@ApplicationScoped
public class IndexController {

    @Inject
    BaumaterialFacade baumaterialFacade;

    @Inject
    AuftragFacade auftragFacade;

    @Inject
    MitarbeiterFacade mitarbeiterFacade;

    String status = "Kein Auftrag ausgewählt!";

    List<Auftrag> aufträge = new LinkedList<Auftrag>();
    List<Mitarbeiter> mitarbeiter = new LinkedList<Mitarbeiter>();
    List<Baumaterial> bms = new LinkedList<Baumaterial>();
    Auftrag selectedAuftrag;
    Mitarbeiter selectedMitarbeiter = new Mitarbeiter();
    Auftrag newAuftrag = new Auftrag();
    Mitarbeiter newMitarbeiter = new Mitarbeiter();
    Baumaterial newBaumaterial = new Baumaterial();
    Auftragsstatus auftragsstatus;
    boolean aufträgesichtbar;
    boolean mitarbeitersichtbar;
    boolean bmsichtbar;
    boolean beschaeftigt;

    public void onRowSelect(SelectEvent e){
        auftragsstatus = selectedAuftrag.getAuftragsstatus();
    }

    public void statuschanged(){
        selectedAuftrag.setAuftragsstatus(auftragsstatus);
        auftragFacade.update(selectedAuftrag);
        aufträge = auftragFacade.getAllAssignments();
    }

    public void switchToAufträge(){
        aufträgesichtbar = true;
        mitarbeitersichtbar = false;
        bmsichtbar = false;
    }

    public void switchToMitarbeiter(){
        aufträgesichtbar = false;
        mitarbeitersichtbar = true;
        bmsichtbar = false;
    }

    public void switchToBM(){
        aufträgesichtbar = false;
        mitarbeitersichtbar = false;
        bmsichtbar = true;
    }

    public void saveAuftrag(){
        if(!newAuftrag.getKundenName().isEmpty() && !newAuftrag.getAdresse().isEmpty()){
            newAuftrag.setAuftragsstatus(Auftragsstatus.ANGEFRAGT);
            auftragFacade.save(newAuftrag);
            newAuftrag = new Auftrag();
        }
    }

    public void saveMitarbeiter(){
        if(!newMitarbeiter.getFirstName().isEmpty() && !newMitarbeiter.getLastName().isEmpty() && !newMitarbeiter.getEmail().isEmpty() && !newMitarbeiter.getPosition().isEmpty()){
            newMitarbeiter.setBeschaeftigt(false);
            mitarbeiterFacade.save(newMitarbeiter);
            newMitarbeiter = new Mitarbeiter();
        }
    }

    public void saveBM(){
        if(!newBaumaterial.getMaterial().isEmpty() && Double.valueOf(newBaumaterial.getPreisprokilo()) != null){
            baumaterialFacade.save(newBaumaterial);
        }
    }

    public void onMitarbeiterSelect(){
        beschaeftigt = selectedMitarbeiter.getBeschaeftigt();
    }

    public void updateEmp(Mitarbeiter emp){
        mitarbeiterFacade.update(emp);
    }

    public void fireEmp(Mitarbeiter mitarbeiter){
        mitarbeiterFacade.delete(mitarbeiter);
    }

    public Auftrag getNewAuftrag() {
        return newAuftrag;
    }

    public void setNewAuftrag(Auftrag newAuftrag) {
        this.newAuftrag = newAuftrag;
    }

    public Auftragsstatus getAuftragsstatus() {
        return auftragsstatus;
    }

    public void setAuftragsstatus(Auftragsstatus auftragsstatus) {
        this.auftragsstatus = auftragsstatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Auftrag getSelectedAuftrag() {
        return selectedAuftrag;
    }

    public void setSelectedAuftrag(Auftrag selectedAuftrag) {
        this.selectedAuftrag = selectedAuftrag;
    }

    public List<Auftrag> getAufträge() {
        return auftragFacade.getAllAssignments();
    }

    public void setAufträge(List<Auftrag> aufträge) {
        this.aufträge = aufträge;
    }

    public boolean isAufträgesichtbar() {
        return aufträgesichtbar;
    }

    public void setAufträgesichtbar(boolean aufträgesichtbar) {
        this.aufträgesichtbar = aufträgesichtbar;
    }

    public boolean isMitarbeitersichtbar() {
        return mitarbeitersichtbar;
    }

    public void setMitarbeitersichtbar(boolean mitarbeitersichtbar) {
        this.mitarbeitersichtbar = mitarbeitersichtbar;
    }

    public boolean isBmsichtbar() {
        return bmsichtbar;
    }

    public void setBmsichtbar(boolean bmsichtbar) {
        this.bmsichtbar = bmsichtbar;
    }

    public List<Mitarbeiter> getMitarbeiter() {
        return mitarbeiterFacade.getAllEmployees();
    }

    public void setMitarbeiter(List<Mitarbeiter> mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    public Mitarbeiter getSelectedMitarbeiter() {
        return selectedMitarbeiter;
    }

    public void setSelectedMitarbeiter(Mitarbeiter selectedMitarbeiter) {
        this.selectedMitarbeiter = selectedMitarbeiter;
    }

    public boolean isBeschaeftigt() {
        return beschaeftigt;
    }

    public void setBeschaeftigt(boolean beschaeftigt) {
        this.beschaeftigt = beschaeftigt;
    }

    public Mitarbeiter getNewMitarbeiter() {
        return newMitarbeiter;
    }

    public void setNewMitarbeiter(Mitarbeiter newMitarbeiter) {
        this.newMitarbeiter = newMitarbeiter;
    }

    public List<Baumaterial> getBms() {
        return baumaterialFacade.getAllBM();
    }

    public void setBms(List<Baumaterial> bms) {
        this.bms = bms;
    }

    public Baumaterial getNewBaumaterial() {
        return newBaumaterial;
    }

    public void setNewBaumaterial(Baumaterial newBaumaterial) {
        this.newBaumaterial = newBaumaterial;
    }
}
