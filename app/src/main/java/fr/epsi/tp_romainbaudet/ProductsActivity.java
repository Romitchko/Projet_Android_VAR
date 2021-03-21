package fr.epsi.tp_romainbaudet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fr.epsi.tp_romainbaudet.adapter.ProductsAdapter;
import fr.epsi.tp_romainbaudet.entity.Product;

public class ProductsActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        setContentView(R.layout.activity_products);

        listView = findViewById(R.id.productsList);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = bundle.getString("ProductsUrl");
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show();

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        createList(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ProductsActivity.this, error.toString(), Toast.LENGTH_LONG).show();
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private void createList(String response){

        try {
            JSONObject jObject = new JSONObject(response);
            String sItems = jObject.get("items").toString();
            JSONArray jArray = new JSONArray(sItems);

            ArrayList<Product> items = new ArrayList<Product>();

            for (int i=0;i<jArray.length();i++){
                items.add(new Product(jArray.getJSONObject(i).getString("name"), jArray.getJSONObject(i).getString("description"),jArray.getJSONObject(i).getString("picture_url")));
            }

            ListAdapter adapter = new ProductsAdapter(this, items);
            listView.setAdapter(adapter);
            listView.setDividerHeight(20);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(ProductsActivity.this, ProductActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Name", items.get(position).getName());
                    bundle.putString("Description", items.get(position).getDescription());
                    bundle.putString("Picture_url", items.get(position).getPicture_url());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }catch (JSONException e){
            System.out.println("Erreur :"+e);
        }
    }
}