package fr.benjichaz.tp5;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Exo2Activity extends AppCompatActivity {

    private ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo2);

        myListView = (ListView) findViewById(R.id.listView2);

        //Création de la ArrayList qui nous permettra de remplire la listView
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();

        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;

        map = new HashMap<String, String>();
        map.put("titre", "Mercure");
        map.put("description", "La plus excentrique");
        map.put("informations", "Mercure est la planète la plus proche du Soleil et la moins massive du Système solaire. Son éloignement au Soleil est compris entre 0,3075 et 0,4667 UA, ce qui correspond à une excentricité orbitale de 0,2056");
        map.put("img", String.valueOf(R.drawable.mercury_icon));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Vénus");
        map.put("description", "La plus chaude");
        map.put("informations", "Vénus est une des quatre planètes telluriques du Système solaire. Elle est la deuxième planète par ordre d'éloignement au Soleil, et la sixième par masse ou par taille décroissantes.");
        map.put("img", String.valueOf(R.drawable.venus_icon));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Terre");
        map.put("description", "La planète bleu");
        map.put("informations", "La Terre est une planète du Système solaire, la troisième au regard de la distance au Soleil. Il s'agit de la cinquième planète la plus grande, tant en taille qu'en masse, dans le Système solaire et la plus massive des planètes telluriques de ce système planétaire.");
        map.put("img", String.valueOf(R.drawable.earth_icon));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Mars");
        map.put("description", "La planète rouge");
        map.put("informations", "Mars est la quatrième planète par ordre de distance croissante au Soleil et la deuxième par masse et par taille croissantes sur les huit planètes que compte le Système solaire.");
        map.put("img", String.valueOf(R.drawable.mars_icon));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Jupiter");
        map.put("description", "La plus grosse");
        map.put("informations", "Jupiter est une planète géante gazeuse. Il s'agit de la plus grosse planète du Système solaire, plus volumineuse et massive que toutes les autres planètes réunies, et la cinquième planète par sa distance au Soleil (après Mercure, Vénus, la Terre et Mars).");
        map.put("img", String.valueOf(R.drawable.jupiter_icon));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Saturne");
        map.put("description", "La plus belle");
        map.put("informations", "Saturne est la sixième planète du Système solaire par ordre de distance au Soleil et la deuxième après Jupiter tant par sa taille que par sa masse.");
        map.put("img", String.valueOf(R.drawable.saturn_icon));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Uranus");
        map.put("description", "L'autrea planète bleu");
        map.put("informations", "Uranus est une planète géante de glaces de type Neptune froid. Il s'agit de la 7e planète du Système solaire par sa distance au Soleil, de la 3e par la taille et de la 4e par la masse.");
        map.put("img", String.valueOf(R.drawable.uranus_icon));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Neptune");
        map.put("description", "Encore l'autre planète bleu");
        map.put("informations", "Neptune est la huitième et dernière planète du Système solaire par distance croissante au Soleil.");
        map.put("img", String.valueOf(R.drawable.neptune_icon));
        listItem.add(map);

        map = new HashMap<String, String>();
        map.put("titre", "Pluton");
        map.put("description", "Loin, loin, loin...");
        map.put("informations", "Pluton, officiellement désignée par (134340) Pluton (désignation internationale (134340) Pluto)note 1, est la planète naine la plus volumineuse (2 370 km de diamètre, contre 2 326 km pour (136199) Éris) connue du Système solaire et la deuxième au niveau de la masse (après Éris).");
        map.put("img", String.valueOf(R.drawable.pluto_icon));
        listItem.add(map);

        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.item_exo2,
                new String[] {"img", "titre", "description"}, new int[] {R.id.img, R.id.title, R.id.description});

        //On attribut à notre listView l'adapter que l'on vient de créer
        myListView.setAdapter(mSchedule);

        //Enfin on met un écouteur d'évènement sur notre listView
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                //on récupère la HashMap contenant les infos de notre item (titre, description, img)
                HashMap<String, String> map = (HashMap<String, String>) myListView.getItemAtPosition(position);
                //on créer une boite de dialogue
                AlertDialog.Builder adb = new AlertDialog.Builder(Exo2Activity.this);
                //on attribut un titre à notre boite de dialogue
                adb.setTitle(map.get("titre"));
                //on insère un message à notre boite de dialogue, et ici on affiche le titre de l'item cliqué
                adb.setMessage(map.get("informations"));
                //on indique que l'on veut le bouton ok à notre boite de dialogue
                adb.setPositiveButton("Ok", null);
                //on affiche la boite de dialogue
                adb.show();
            }
        });
    }
}
