package es.iesnervion.afernandez.ejemplolistadapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import es.iesnervion.afernandez.ejemplolistadapters.Clases.Gato;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TextView text;
    ListView lv;
    Gato[] content = {new Gato(R.drawable.img,"Gato"),new Gato(R.drawable.pop,"POP"),new Gato(R.drawable.img,"Gato2"),
            new Gato(R.drawable.pop,"POP POP"),new Gato(R.drawable.img,"Gatete"), new Gato(R.drawable.pop,"POPOPOP"),
            new Gato(R.drawable.img_1,"HitHub")};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv= findViewById(R.id.listView);
        MyAdapter<Gato> adapter=new MyAdapter<>(this, R.layout.custom_list_layout,R.id.list_item,content);
        lv.setAdapter(adapter);
        text=findViewById(R.id.text);
        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        text.setText(content[i].toString());
    }

    public class MyAdapter<T> extends ArrayAdapter<T> {

        public MyAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Object[] objects) {
            super(context, resource, textViewResourceId, (T[]) objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View v=super.getView(position, convertView,parent);
            ImageView image= findViewById(R.id.image);

            if(position==1)
            {
                image.setImageResource(content[position].getImageId());
            }
            return v;
        }
}
}
