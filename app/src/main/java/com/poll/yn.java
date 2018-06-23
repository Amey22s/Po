package com.poll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;




public class yn extends AppCompatActivity {
    variables x = new variables();
    int ydata = x.getyc();
    int ndata=x.getnc();
    Globals g = (Globals)getApplication();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yn);

        Button y = (Button)findViewById(R.id.y);
        Button y1 = (Button)findViewById(R.id.y1);
        Button n = (Button) findViewById(R.id.n);
        Button n1 = (Button) findViewById(R.id.n1);
        final EditText tv =(EditText) findViewById(R.id.tv);
        final EditText tv1 =(EditText) findViewById(R.id.tv1);


        tv1.setText("Lionel Messi is the greatest of all time?");
        tv1.setEnabled(false);



        final DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();


        String ques = g.getData2();

        tv.setText(ques);
        tv.setEnabled(false);





        y.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ydata++;
                x.setname("count");
                x.setyc(ydata);
                rootRef.child("count").setValue(x);

                Intent yr= new Intent(yn.this,ynresult.class);
                startActivity(yr);

            }


        });

        n.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ndata++;
                x.setname("count");
                x.setnc(ndata);
                rootRef.child("count").setValue(x);
                Intent yr1= new Intent(yn.this,ynresult.class);
                startActivity(yr1);

            }



        });



        y1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ydata++;
                x.setname("GOAT");
                x.setyc(ydata);
                rootRef.child("GOAT").setValue(x);
                g.setData2("Lionel Messi is the greatest of all time");

                Intent yr= new Intent(yn.this,ynresult.class);
                startActivity(yr);

            }


        });

        n1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ndata++;
                x.setname("GOAT");
                x.setnc(ndata);
                rootRef.child("GOAT").setValue(x);
                g.setData2("Lionel Messi is the greatest of all time");
                Intent yr1= new Intent(yn.this,ynresult.class);
                startActivity(yr1);

            }



        });





    }
}
