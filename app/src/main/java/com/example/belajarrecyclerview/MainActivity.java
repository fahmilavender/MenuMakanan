package com.example.belajarrecyclerview;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemAdapter.OnItemCLickListener {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inisialisasi itemList
        itemList = new ArrayList<>();
        itemList.add(new Item("Ayam Goreng", "Deskripsi", "Rp 15.000", R.drawable.ayam_goreng));
        itemList.add(new Item("Ayam Bakar", "Deskripsi", "Rp 14.000", R.drawable.ayam_bakar));
        itemList.add(new Item("Nasi Goreng", "Deskripsi", "Rp 13.000", R.drawable.nasi_goreng));
        itemList.add(new Item("Mie Goreng", "Deskripsi", "Rp 13.000", R.drawable.mie_goreng));
        itemList.add(new Item("Nasi Cumi Goreng", "Deskripsi", "Rp 14.000", R.drawable.nasi_cumi_goreng));

        // Set Adapter
        adapter = new ItemAdapter(itemList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Item makananModel) {
        Toast.makeText(this, makananModel.getTitle() + " , " + makananModel.getPrice(), Toast.LENGTH_SHORT).show();
        Intent in = new Intent(MainActivity.this, DetailMakanan.class);
        in.putExtra("namaMakanan",makananModel.getTitle());
        in.putExtra("deskripsiMakanan",makananModel.getDescription());
        in.putExtra("hargaMakanan",makananModel.getPrice());
        in.putExtra("gambarMakanan",makananModel.getItemiImageView());
        startActivity(in);
    }
}

