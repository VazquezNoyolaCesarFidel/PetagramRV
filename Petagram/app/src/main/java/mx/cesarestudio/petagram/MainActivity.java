package mx.cesarestudio.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.content.Intent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private ImageView imgEstrella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar bar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(bar);
        llenarListaMascotas();
        listaMascotas = (RecyclerView)findViewById(R.id.listaMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarAdaptador();
        imgEstrella =(ImageView)findViewById(R.id.btnEstrella);
        imgEstrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento =new Intent(MainActivity.this,FavoritosActivity.class);
                startActivity(intento);
            }
        });


    }
    public void llenarListaMascotas(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.perro1,"Beetovhen",10));
        mascotas.add(new Mascota(R.drawable.perro2,"Hachiko",5));
        mascotas.add(new Mascota(R.drawable.perro3,"Laika",10));
        mascotas.add(new Mascota(R.drawable.perro4,"Pongo",25));
        mascotas.add(new Mascota(R.drawable.perro5,"Rex",2));
        mascotas.add(new Mascota(R.drawable.perro6,"Pluto",7));
        mascotas.add(new Mascota(R.drawable.perro7,"Odie",5));
        mascotas.add(new Mascota(R.drawable.perro8,"Snoopy",6));
        mascotas.add(new Mascota(R.drawable.perro9,"Niebla",15));
        mascotas.add(new Mascota(R.drawable.perro10,"Lassie",12));
        mascotas.add(new Mascota(R.drawable.perro11,"Goofy",0));

    }
    public void inicializarAdaptador(){
        MascotaAdaptador ma = new MascotaAdaptador(this,mascotas);
        listaMascotas.setAdapter(ma);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
