package com.example.bookishmemo1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.bookishmemo1.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private BukuViewAdapter bukuViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        getAllInput();
        
        bukuViewAdapter = new BukuViewAdapter();
        binding.rvBuku.setLayoutManager(new LinearLayoutManager(this));
        binding.rvBuku.setAdapter(bukuViewAdapter);
        
        bukuViewAdapter.setOnItemClickCallback(this::dataClick);
        bukuViewAdapter.setOnItemLongClickListener(new BukuViewAdapter.OnItemLongClickListener() {
            public void onItemLongClick(View v, BookisMemoItem input, int position) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.inflate(R.menu.menu_popup);
                popupMenu.setGravity(Gravity.RIGHT);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int idMenu = item.getItemId();
                        if (idMenu == R.id.action_edit) {
                            Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                            intent.putExtra("EXTRA_DATA", input);
                            startActivity(intent);
                            return true;
                        } else if (idMenu == R.id.action_edit) {
                            if (input != null) {
                                String id = input.getId();
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                builder.setTitle("Konfirmasi");
                                builder.setMessage("Yakin ingin Menghapus Konser '" + input.getNamaBuku() + "' ?");
                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        deleteInput(id);
                                    }
                                });
                                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();
                            } else {
                                // Tampilkan pesan atau lakukan tindakan jika input null
                            }
                            return true;
                        } else {
                            return false;
                        }
                    }

                });
                popupMenu.show();
            }
        });
        binding.fabInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputActivity.class);
                startActivity(intent);

            }
        });
    }

    private void dataClick(BookisMemoItem item) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("EXTRA_DATA", item);
        startActivity(intent);
    }

    private void deleteInput(String id) {
        APIService api = Util.getRetrofit().create(APIService.class);
        Call<BookisMemoItem> call = api.deleteKonser(id);
        call.enqueue(new Callback<BookisMemoItem>() {
            @Override
            public void onResponse(Call<BookisMemoItem> call, Response<BookisMemoItem> response) {
                Log.e("MainActivity", "Get Delete Response Code: " + response.code());
                if(response.code()==200){
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success==1){
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        getAllInput();
                    }else{
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Response " + response.code(),Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<BookisMemoItem> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Retrofit Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }

        });
    }

    protected void onResume() {
        super.onResume();
        getAllInput();
    }


    private void getAllInput() {
        Log.e("MainActivity", "Main GetAllInput()");
        binding.progressbar.setVisibility(View.VISIBLE);
        APIService api = Util.getRetrofit().create(APIService.class);
        Call<Buku> call = api.getBuku();
        call.enqueue(new Callback<Buku>() {
            @Override
            public void onResponse(Call<Buku> call, Response<Buku> response) {
                binding.progressbar.setVisibility(View.GONE);
                if (response.code()==200){
                    int success = response.body().getSuccess();
                    String message = String.valueOf(response.body().getMessage());

                    if (success == 1){
                        List<DataBuku> dataBuku = response.body().getBookisMemo();

                        Toast.makeText(MainActivity.this, message,Toast.LENGTH_SHORT).show();
                        BukuViewAdapter.setData
                    }

                }

            }

            @Override
            public void onFailure(Call<Buku> call, Throwable t) {

            }
        });


    }
}


