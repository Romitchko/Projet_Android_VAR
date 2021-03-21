package fr.epsi.tp_romainbaudet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fr.epsi.tp_romainbaudet.R;
import fr.epsi.tp_romainbaudet.entity.Product;

public class ProductsAdapter extends ArrayAdapter<Product> {

    public ProductsAdapter(@NonNull Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Product product = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.product_items, parent, false);
        }

        TextView productName = (TextView) convertView.findViewById(R.id.pName);
        TextView productDesc = (TextView) convertView.findViewById(R.id.pDesc);
        ImageView picture =  convertView.findViewById(R.id.pPic);

        productName.setText(product.getName());
        productDesc.setText(product.getDescription());
        Picasso.get().load(product.getPicture_url()).fit().centerCrop().into(picture);

        return convertView;
    }
}
