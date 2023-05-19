package ma.emsi.fruits.activites;

import androidx.appcompat.app.AppCompatActivity;

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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewProductActivity extends AppCompatActivity {

    private EditText Reference;
    private EditText Designation;
    private EditText quantite;
    private EditText prixUnitaire;

    private EditText fournisseur;
    private EditText description;
    ImageView img ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);

        img = findViewById(R.id.imageViewadd);
        img.setImageResource(R.drawable.prod);

        Button btngoback = findViewById(R.id.gobackbtn);
        Button btnadd = findViewById(R.id.addbtnn);

        Reference = findViewById(R.id.Referenceadd);
        Designation = findViewById(R.id.Designationadd);
        quantite = findViewById(R.id.quantiteadd);
        prixUnitaire = findViewById(R.id.prixadd);
        description = findViewById(R.id.descriptionadd);


        btngoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewProductActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Ref = Reference.getText().toString().trim();
                final String Des = Designation.getText().toString().trim();
                final int quantity = Integer.parseInt(quantite.getText().toString().trim());
                final String fourniss = fournisseur.getText().toString().trim();
                final float pri = Float.parseFloat(prixUnitaire.getText().toString().trim());
                final String des =description.getText().toString().trim();
                Call<ApiResponse> call = RetrofitClient.getInstance().getApi().createProd(Ref,Des,pri,quantity,fourniss,"",des);
                call.enqueue(new Callback<ApiResponse>() {
                    @Override
                    public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                        Intent intent = new Intent(NewProductActivity.this,HomeActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<ApiResponse> call, Throwable t) {
                        Toast.makeText(NewProductActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}
