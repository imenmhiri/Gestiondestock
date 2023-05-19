package ma.emsi.fruits.api;

import ma.emsi.fruits.model.ApiResponse;
import ma.emsi.fruits.model.ProduitResponse;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {

    @GET("userapp/?format=json")
    Call<LoginResponse[]> userLogin();


    @GET("Produits/afficher/?format=json")
    Call<ProduitResponse[]> produits();

    @FormUrlEncoded
    @PUT("Produits/update/")
    Call<ProduitResponse> updateprod(
            @Path("id") Long id,
            @Field("reference") String reference,
            @Field("designation") String designation,
            @Field("prixUnitaire") float prixU,
            @Field("quantite") int quantite,
            @Field("fournisseur") String fournisseur,
            @Field("Image") String Image,
            @Field("description") String description

    );

    @DELETE("Produits/{id}/")
    Call<ApiResponse> deleteprod(
            @Path("id") String id
    );


    @FormUrlEncoded
    @POST("Produits/create/")
    Call<ApiResponse> createProd(
            @Field("reference") String reference,
            @Field("designation") String designation,
            @Field("prixUnitaire") float prixU,
            @Field("quantite") int quantite,
            @Field("fournisseur") String fournisseur,
            @Field("Image") String Image,
            @Field("description") String description
    );


}
