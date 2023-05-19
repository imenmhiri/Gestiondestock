package ma.emsi.fruits.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ma.emsi.fruits.R;
import ma.emsi.fruits.api.RetrofitClient;
import ma.emsi.fruits.model.Produit;
import ma.emsi.fruits.model.ProduitResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity{
    ListView list;
    private List<ProduitResponse> prodget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        list = findViewById(R.id.list);
        final ArrayList<Produit> produits = new ArrayList<Produit>();


        Call<ProduitResponse[]> call = RetrofitClient.getInstance().getApi().produits();
        call.enqueue(new Callback<ProduitResponse[]>() {
            @Override
            public void onResponse(Call<ProduitResponse[]> call, Response<ProduitResponse[]> response) {
                prodget = Arrays.asList(response.body());
                class customAdapter extends BaseAdapter {
                    Context context;

                    public customAdapter(Context context) {
                        this.context = context;
                    }

                    @Override
                    public int getCount() {
                        return prodget.size();
                    }

                    @Override
                    public Object getItem(int position) {
                        return null;
                    }

                    @Override
                    public long getItemId(int position) {
                        return 0;
                    }

                    @Override
                    public View getView(int position, View row, ViewGroup parent) {

                        LayoutInflater inflater=getLayoutInflater();
                        row = inflater.inflate(R.layout.row,null,true);
                        ImageView img = row.findViewById(R.id.imgprod);
                        TextView reference = row.findViewById(R.id.reference);
                        TextView designation = row.findViewById(R.id.designation);
                        TextView quantite = row.findViewById(R.id.quantite);
                        TextView prix = row.findViewById(R.id.prix);

                         img.setImageResource(R.drawable.prod);
                         reference.setText("Reference :"+ prodget.get(position).getReference());
                         designation.setText("Designation :"+ prodget.get(position).getDesignation());
                         quantite.setText("quantite :"+Integer.toString(prodget.get(position).getQuantite()));

                        return row;
                    }
                }
                customAdapter Adapter = new customAdapter(getApplicationContext());
                list.setAdapter(Adapter);

            }

            @Override
            public void onFailure(Call<ProduitResponse[]> call, Throwable t) {
                Toast.makeText(HomeActivity.this,"server 404",Toast.LENGTH_LONG).show();

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeActivity.this,ProduitActivity.class);
                intent.putExtra("id",Long.toString(prodget.get(position).getId()));
                intent.putExtra("prix",Float.toString(prodget.get(position).getPrixUnitaire()));
                intent.putExtra("Reference", prodget.get(position).getReference());
                intent.putExtra("Designation", prodget.get(position).getDesignation());
                intent.putExtra("quantite",Integer.toString(prodget.get(position).getQuantite()));
                intent.putExtra("Image",(prodget.get(position).getImage()));
                intent.putExtra("description",(prodget.get(position).getDescription()));

                startActivity(intent);
            }
        });

        Button btnadd = findViewById(R.id.buttonAdd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,NewProductActivity.class);
                startActivity(intent);
            }
        });
    }


}
