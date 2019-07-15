package leduc.com.sample1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listViewMonHoc;
    private EditText edtMonHoc;
    private Button btnThem;
    private Button btnSua;
    private Button btnXoa;
    private List<String> listMonHoc;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_listview);

        listViewMonHoc   = (ListView) findViewById(R.id.listViewMonHoc);
        edtMonHoc         = (EditText) findViewById(R.id.edtMonHoc);
        btnThem          = (Button) findViewById(R.id.btnThem);
        btnSua           = (Button) findViewById(R.id.btnSua);
        btnXoa           = (Button) findViewById(R.id.btnXoa);
        listMonHoc       = new ArrayList<String>();

        listMonHoc.add("php");
        listMonHoc.add("java");
        listMonHoc.add("android");
        listMonHoc.add("python");

        final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_activated_1,
                listMonHoc
        );
        listViewMonHoc.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monHoc = edtMonHoc.getText().toString();
                listMonHoc.add(monHoc);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Added "+ edtMonHoc.getText(), Toast.LENGTH_SHORT).show();
                edtMonHoc.setText("");
            }
        });

        listViewMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtMonHoc.setText(listMonHoc.get(i));
                position = i;
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listMonHoc.set(position, edtMonHoc.getText().toString());
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Updated "+ edtMonHoc.getText(), Toast.LENGTH_SHORT).show();
                edtMonHoc.setText("");
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listMonHoc.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Deleted "+ edtMonHoc.getText(), Toast.LENGTH_SHORT).show();
                edtMonHoc.setText("");
            }
        });
    }


}
