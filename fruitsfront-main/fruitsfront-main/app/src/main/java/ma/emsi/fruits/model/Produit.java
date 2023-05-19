package ma.emsi.fruits.model;

public class Produit {

    private Long id;
    int quantite;
    private float prixUnitaire;
    private String reference, designation,fournisseur, Image ,description;


    public Produit(Long id, int quantite, float prixUnitaire, String reference, String designation, String fournisseur,
                   String Image,String description) {
        this.id = id;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.reference = reference;
        this.designation = designation;
        this.fournisseur = fournisseur;
        this.Image = Image;
        this.description = description;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setfournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getReference() {
        return reference;
    }

    public String getDesignation() {
        return designation;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public String getImage() {return Image;}

    public String getDescription() {
        return description;
    }



}
