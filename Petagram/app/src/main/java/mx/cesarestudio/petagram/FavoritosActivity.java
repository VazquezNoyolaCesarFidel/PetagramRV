package mx.cesarestudio.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    private RecyclerView lista;
    private ArrayList<Mascota> listaMascotas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        Toolbar bar = (Toolbar) findViewById(R.id.barraFavoritos);
        setSupportActionBar(bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lista = (RecyclerView)findViewById(R.id.listaM);
        llenarListaMascotas();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lista.setLayoutManager(llm);

        inicializarAdaptador();

    }
    public void llenarListaMascotas(){
        listaMascotas = new ArrayList<>();
        listaMascotas.add(new Mascota(R.drawable.perro1,"Beetovhen",10));
        listaMascotas.add(new Mascota(R.drawable.perro4,"Pongo",25));
        listaMascotas.add(new Mascota(R.drawable.perro6,"Pluto",7));
        listaMascotas.add(new Mascota(R.drawable.perro8,"Snoopy",6));
        listaMascotas.add(new Mascota(R.drawable.perro9,"Niebla",15));


    }
    public void inicializarAdaptador(){
        MascotaAdaptador ma = new MascotaAdaptador(this,listaMascotas);
        lista.setAdapter(ma);
    }
}
