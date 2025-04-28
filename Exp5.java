-	MainActivity.java
package com.ad.exp9;
import android.content.ClipData;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<com.example.recyclerapp.Item> itemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Sample data
        itemList = new ArrayList<>();
        itemList.add(new com.example.recyclerapp.Item("Arijit Singh"));
        itemList.add(new com.example.recyclerapp.Item("Lata Mangeshkar"));
        itemList.add(new com.example.recyclerapp.Item("Shreya Ghoshal"));
        itemList.add(new com.example.recyclerapp.Item("KK"));
        itemList.add(new com.example.recyclerapp.Item("Sonu Nigam"));
        itemList.add(new com.example.recyclerapp.Item("Mohit Chauhan"));
        itemList.add(new com.example.recyclerapp.Item("Armaan Malik"));
        itemList.add(new com.example.recyclerapp.Item("Neha Kakkar"));

        adapter = new ItemAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }
}
-	Item.java
package com.ad.exp9;
public class Item {
    private String title;
    public Item(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}
-	ItemAdapter.java
package com.ad.exp9;
import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<com.example.recyclerapp.Item> itemList;

    public ItemAdapter(List<com.example.recyclerapp.Item> itemList) {
        this.itemList = itemList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
        }
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder holder, int position) {
        com.example.recyclerapp.Item item = itemList.get(position);
        holder.textViewTitle.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}

-	Item_layput.xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.cardview.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="8dp"
    android:elevation="4dp"
    android:padding="16dp">

    <TextView
        android:id="@+id/textViewTitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Sample Item"
        android:textSize="18sp"
        android:textColor="#000" />
</androidx.cardview.widget.CardView>


