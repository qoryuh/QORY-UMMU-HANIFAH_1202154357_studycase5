package com.example.hnf.qoryummuhanifah_1202154357_modul5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddToDoActivity extends AppCompatActivity {

    //deklarasi komponen yang akan digunakan
    EditText ToDo, Description, Priority;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        //set judul aplikasi menjadi add to do
        setTitle("Add To Do");

        ToDo = findViewById(R.id.editTodo);
        Description = findViewById(R.id.editDesc);
        Priority =  findViewById(R.id.editPriority);
        db = new Database(this);
    }

    @Override
    public void onBackPressed() {

        //intent dari add to do menuju list to do
        Intent intent = new Intent(AddToDoActivity.this, ToDoListActivity.class);

        //start intent
        startActivity(intent);

        //menutup aktivitas setelah intent dijalankan
        this.finish();
    }

    //method yang dijalanan ketika tombol tambah to do di klik
    public void tambah(View view) {

        //apabila data todoname, deskripsi dan prioritas di isi,
        if (db.inputdata(new AddData(ToDo.getText().toString(), Description.getText().toString(), Priority.getText().toString()))){

            //maka akan menampilkan toast bawha data berhasil di tambahkan ke dalam list
            Toast.makeText(this, "To Do List added", Toast.LENGTH_SHORT).show();

            //berpindah dari add to do ke list to do
            startActivity(new Intent(AddToDoActivity.this, ToDoListActivity.class));

            //menutup aktivitas agar tidak kembali ke activity yang dijalankan setelah intent
            this.finish();

        }else {

            //apabila edit text kosong maka akan muncul toast bahwa tidak bisa menambah ke dalam list
            Toast.makeText(this, "Cannot add the list", Toast.LENGTH_SHORT).show();

            //reset EditText menjadi kosong
            ToDo.setText(null);
            Description.setText(null);
            Priority.setText(null);
        }
    }
}
