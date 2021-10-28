package es.iesnervion.afernandez.ejemplolistadapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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
    ListView vista;
    Gato[] content = {new Gato(R.drawable.img, "Gato"), new Gato(R.drawable.pop, "POP"), new Gato(R.drawable.img, "Gato2"),
            new Gato(R.drawable.pop, "POP POP"), new Gato(R.drawable.img, "Gatete"), new Gato(R.drawable.pop, "POPOPOP"),
            new Gato(R.drawable.img_1, "HitHub"), new Gato(R.drawable.img, "Gatete"), new Gato(R.drawable.pop, "POPOPOP"),
            new Gato(R.drawable.img_1, "HitHub")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.listView);
        MyAdapter<Gato> adapter = new MyAdapter<>(this, R.id.list_item, content);
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
    public class NewViewHolder extends ViewHolder
    {
        ImageView secondImage;
        public NewViewHolder(TextView tv, ImageView img, ImageView secondImage) {
            super(tv, img);
            this.secondImage=secondImage;
        }

        public ImageView getSecondImage() {
            return secondImage;
        }

        public void setSecondImage(ImageView secondImage) {
            this.secondImage = secondImage;
        }
        public void setSecondImageSrc(int secondImage) {
            this.secondImage.setImageResource(secondImage);
        }
    }
    class MyAdapter<T> extends ArrayAdapter<T> {

        Context context;
        T[] objects;
        public MyAdapter(@NonNull Context context, int resource) {
            super(context, resource);
        }

        public MyAdapter(@NonNull Context context, int resource, @NonNull T[] objects) {
            super(context, resource, objects);
        }

        public MyAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull Object[] objects) {
            super(context, resource, textViewResourceId, (T[]) objects);
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            int i=1;
            if(position==2|| position==3) {
                i=0;
            }
            return i;
        }



        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View row = convertView;

            LayoutInflater inflater=getLayoutInflater();


            if(getItemViewType(position)==0)
            {
                ViewHolder holder;
                if (row==null)
                {
                    row = inflater.inflate(R.layout.custom_list_layout, parent, false);
                    TextView lab    = row.findViewById(R.id.list_item);
                    ImageView imgV = row.findViewById(R.id.icon);
                    holder=new ViewHolder(lab, imgV);

                }else
                    {
                        holder = (ViewHolder) row.getTag();
                    }
            }else
                {
                    NewViewHolder nvh;
                    if (row==null)
                    {
                        row = inflater.inflate(R.layout.list_layout2, parent, false);
                        TextView lab    = row.findViewById(R.id.list_item);
                        ImageView imgV  = row.findViewById(R.id.icon);
                        ImageView imgV2 = row.findViewById(R.id.simg);
                        nvh=new NewViewHolder(lab,imgV,imgV2);
                    }else
                        {
                            nvh = (NewViewHolder) row.getTag();
                        }
                }

            return(row);
//            View row=convertView;
//            LayoutInflater inflater= getLayoutInflater();
//
//
//            if( getItemViewType(position)==0)
//            {
//                row=inflater.inflate(R.layout.custom_list_layout, parent, false);
//                TextView text= findViewById(R.id.list_item);
//                ImageView iv=findViewById(R.id.image);
//                ViewHolder holder = new ViewHolder(text,iv);
//                ImageView image = row.findViewById(R.id.image);
//                TextView item = row.findViewById(R.id.list_item);
//                item.setText(content[position].toString());
//                image.setImageResource(content[position].getImageId());
//            }else
//            if( getItemViewType(position)==1)
//            {
//                row=inflater.inflate(R.layout.list_layout2, parent, false);
//                TextView txt=findViewById(R.id.item);
//                ImageView imageView=findViewById(R.id.img);
//                ImageView scnd=findViewById(R.id.simg);
//
//                NewViewHolder holderN = new NewViewHolder(txt, imageView, scnd);
//
//                ImageView image = row.findViewById(R.id.image);
//                TextView item = row.findViewById(R.id.list_item);
//                ImageView imgTwo= row.findViewById(R.id.simg);
//                item.setText(content[position].toString());
//                image.setImageResource(content[position].getImageId());
//                imgTwo.setImageResource(R.drawable.gatostada);
//            }
//            else
//                {
//
//                }
//
//            return row;
        }
    }
}
