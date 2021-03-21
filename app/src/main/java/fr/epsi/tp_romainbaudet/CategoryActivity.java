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
import java.util.Locale;

public class CategoryActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        listView = findViewById(R.id.listView);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://djemam.com/epsi/categories";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(CategoryActivity.this, response, Toast.LENGTH_LONG).show();
                        createList(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CategoryActivity.this, error.toString(), Toast.LENGTH_LONG).show();
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

            ArrayList<String> items = new ArrayList<String>();

            for (int i=0;i<jArray.length();i++){
                items.add(jArray.getJSONObject(i).getString("title"));
            }

            ListAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
            listView.setAdapter(adapter);
            listView.setDividerHeight(20);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    try {
                        String url = jArray.getJSONObject(position).getString("products_url");
                        String name = jArray.getJSONObject(position).getString("title");

                        Intent intent = new Intent(CategoryActivity.this, ProductsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("ProductsUrl", url);
                        bundle.putString("ProductsName", name);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }catch (JSONException e){
            System.out.println("Erreur :"+e);
        }
    }


}