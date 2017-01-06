package com.example.gistree.db_con;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.gistree.db_con.lib.classes.Helper;
import com.example.gistree.db_con.lib.classes.repositories.ArvoresRepository;
import com.example.gistree.db_con.lib.classes.records.ArvoreRecord;

import com.example.gistree.db_con.application.controllers.ButtonControllers;
import com.example.gistree.db_con.lib.database.DataFactory;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<ArvoreRecord> adapter;
    private DataFactory db;
    private ArrayList<ArvoreRecord> values;
    private Bundle bd;
    private ArvoreRecord tree;
    public static final int UPDATEACTIVITY = 1;
    public static final int RESULT_UPDATE_OK = 2;
    public static final int RESULT_DELETE_OK = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Helper.setupUI(findViewById(R.id.activity_main), MainActivity.this);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        /*
        db = new DataFactory(this);
        try {
            db.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

        ButtonControllers btc = new ButtonControllers(getApplicationContext());
        Button btEcho = (Button) findViewById(R.id.btEcho);
        Button btSync = (Button) findViewById(R.id.btEnviar);
        btEcho.setOnClickListener(btc);
        btSync.setOnClickListener(btc);

//        LogRepository tlog = new LogRepository(db);
//        LogRecord tree = new LogRecord();
//        tree.setId(1);
//        tree.setSpecies("Teste");
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Date date = new Date();
//        tree.setTimestamp(dateFormat.format(date));
//        tree.setAction('I');

        Context x = getApplicationContext();
        ArvoreRecord arv = new ArvoreRecord();
        arv.setId(3);
        arv.setSpecies("TesteSpecies");
        arv.setTimestamp("This is a Timestamp");
        ArvoresRepository adf = new ArvoresRepository(getApplicationContext());
        adf.saveArvore(arv);
        Log.d("YES", "Yes");

//        ListView listView = (ListView) findViewById(android.R.id.list);
//        values = db.arvoresToShow(db.getAllArvores(), db.getAllLogs());
//        adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, values);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ArvoreRecord updateArvoreTemp = values.get(position);
//                Bundle bd = new Bundle();
//                bd.putSerializable("tree", updateArvoreTemp);
//                bd.putInt("position", position);
//                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
//                intent.putExtra("tree", bd);
//                startActivityForResult(intent,UPDATEACTIVITY);
//            }
//        });
//
//        new SendPostRequest().execute();

    }

//    protected void buttonSendClicked (View v){
//        EditText editText_id_tree = (EditText) findViewById(R.id.editText_inserir_id_tree);
//        EditText editText_species = (EditText) findViewById(R.id.editText_inserir_species);
//        LogRecord arvoreTemp = new LogRecord();
//        if(!(editText_id_tree.getText().toString().equals("")) &&
//                !(editText_species.getText().toString().equals(""))){
//            arvoreTemp.setId_tree(Long.valueOf(editText_id_tree.getText().toString()));
//            arvoreTemp.setSpecies(editText_species.getText().toString());
//            arvoreTemp = db.addArvore(arvoreTemp);
//            if(arvoreTemp != null){
//                adapter.add(arvoreTemp);
//                adapter.notifyDataSetChanged();
//            }
//        }
//        editText_id_tree.setText("");
//        editText_species.setText("");
//
//    }
//
//    protected void truncateTableLog (View v) {
//        db.truncateLogs();
//        adapter.clear();
//        adapter.addAll(db.arvoresToShow(db.getAllArvores(), db.getAllLogs()));
//        adapter.notifyDataSetChanged();
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == UPDATEACTIVITY) {
//                switch (resultCode){
//                    case (RESULT_UPDATE_OK):
//                        bd = data.getBundleExtra("Tree");
//                        tree = (ArvoreRecord) bd.getSerializable("Tree");
//                        adapter.getItem(bd.getInt("position")).replaceTree(tree);
//                        adapter.notifyDataSetChanged();
//                        break;
//                    case (RESULT_DELETE_OK):
//                        bd = data.getBundleExtra("Tree");
//                        tree = (ArvoreRecord) bd.getSerializable("Tree");
//                        adapter.remove(adapter.getItem(bd.getInt("position")));
//                        adapter.notifyDataSetChanged();
//                        break;
//                    default:
//                        break;
//            }
//        }
//    }
}

