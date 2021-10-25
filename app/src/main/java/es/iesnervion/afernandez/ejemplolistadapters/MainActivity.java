package es.iesnervion.afernandez.ejemplolistadapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import es.iesnervion.afernandez.ejemplolistadapters.Clases.Gato;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TextView text;
    ListView lv;
    Gato[] content = {new Gato(R.drawable.img, "Gato"), new Gato(R.drawable.pop, "POP"), new Gato(R.drawable.img, "Gato2"),
            new Gato(R.drawable.pop, "POP POP"), new Gato(R.drawable.img, "Gatete"), new Gato(R.drawable.pop, "POPOPOP"),
            new Gato(R.drawable.img_1, "HitHub"), new Gato(R.drawable.img, "Gatete"), new Gato(R.drawable.pop, "POPOPOP"),
            new Gato(R.drawable.img_1, "HitHub")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listView);
        MyAdapter<Gato> adapter = new MyAdapter<>(this, R.layout.custom_list_layout, R.id.list_item, content);
        lv.setAdapter(adapter);
        text = findViewById(R.id.text);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        text.setText(content[i].toString());
    }

    public class ViewHolder
    {
        private TextView tv;
        private ImageView img;

        public TextView getTv() {
            return tv;
        }

        public void setTv(TextView tv) {
            this.tv = tv;
        }

        public ImageView getImg() {
            return img;
        }

        public void setImg(ImageView img) {
            this.img = img;
        }

        public ViewHolder(TextView tv, ImageView img) {
            this.tv = tv;
            this.img = img;
        }
    }
    public class MyAdapter<T> extends ArrayAdapter<T> {

        public MyAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Object[] objects) {
            super(context, resource, textViewResourceId, (T[]) objects);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = super.getView(position, convertView, parent);

            View row=convertView;

            ViewHolder holder;
            if(row==null)
            {
                LayoutInflater inflater= getLayoutInflater();
                inflater.inflate(R.layout.custom_list_layout, parent, false);
                TextView text= findViewById(R.id.list_item);
                ImageView iv=findViewById(R.id.image);
                holder = new ViewHolder(text,iv);
            }

            ImageView image = view.findViewById(R.id.image);
            TextView item = view.findViewById(R.id.list_item);
            item.setText(content[position].toString());
            image.setImageResource(content[position].getImageId());
            return view;
        }
    }
}
