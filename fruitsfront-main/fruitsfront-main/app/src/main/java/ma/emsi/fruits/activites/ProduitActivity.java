package ma.emsi.fruits.activites;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import ma.emsi.fruits.R;
import ma.emsi.fruits.api.RetrofitClient;
import ma.emsi.fruits.model.ApiResponse;
import ma.emsi.fruits.model.ProduitResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProduitActivity extends AppCompatActivity{

    private EditText id;
    private EditText Reference;
    private EditText Designation;
    private EditText quantite;
    private EditText prixUnitaire;
    private EditText description;


    ImageView img ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);

        id = findViewById(R.id.id);
        Reference = findViewById(R.id.Reference);
        Designation = findViewById(R.id.Designation);
        quantite = findViewById(R.id.quantite);
        img = findViewById(R.id.imageView);
        prixUnitaire = findViewById(R.id.prix);
        description = findViewById(R.id.description);

        Button btnedit = findViewById(R.id.editbtn);
        Button btngoback = findViewById(R.id.gobackbtn);
        Button btndelete = findViewById(R.id.deletebtn);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){

            img.setImageResource(R.drawable.prod);
            id.setText(bundle.getString("id"));
            Reference.setText(bundle.getString("Reference"));
            Designation.setText(bundle.getString("Designation"));
            quantite.setText(bundle.getString("quantite"));
            prixUnitaire.setText(bundle.getString("prix"));
            description.setText(bundle.getString("description"));

        }

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateproduit();
            }
        });




        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //deleteproduit();

                AlertDialog.Builder builder = new AlertDialog.Builder( ProduitActivity.this );
                builder.setTitle("Est ce que vous etes sure ?");
                builder.setMessage(" action  irreversible !");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteproduit();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog ad = builder.create();
                ad.show();
            }
        });


        btngoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProduitActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

    }

    private void updateproduit() {
        final Long Id = Long.valueOf(id.getId());
        final String Ref = Reference.getText().toString().trim();
        final String Desin = Designation.getText().toString().trim();
        final int quantity = Integer.parseInt(quantite.getText().toString().trim());
        final float prix = Float.parseFloat(prixUnitaire.getText().toString().trim());
        final String des = description.getText().toString().trim();



        Call<ProduitResponse> call = RetrofitClient.getInstance().getApi().updateprod(Id,Ref,Desin,prix,quantity,1,"",des);
        call.enqueue(new Callback<ProduitResponse>() {
            @Override
            public void onResponse(Call<ProduitResponse> call, Response<ProduitResponse> response) {
                Intent intent = new Intent(ProduitActivity.this,HomeActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ProduitResponse> call, Throwable t) {
                Toast.makeText(ProduitActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }

    private void deleteproduit() {
        final String idd = id.getText().toString().trim();

        Call<ApiResponse> call = RetrofitClient.getInstance().getApi().deleteprod(idd);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                //if(!response.body().isErr()){
                    Intent intent = new Intent(ProduitActivity.this,HomeActivity.class);
                    startActivity(intent);
               // }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });
    }


}
