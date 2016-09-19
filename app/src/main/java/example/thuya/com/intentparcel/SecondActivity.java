package example.thuya.com.intentparcel;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public final static String sendingName_formSecond = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Get Data from MainActivity
        Intent intent = getIntent();

        Person friend = intent.getParcelableExtra(MainActivity.FriendRequest);

        String name = friend.getName();
        int age = friend.getAge();

        String friendInfo = "Hi, my name is " + name + ", age: " + age + " would like to get know you." ;

        TextView greeting = (TextView) findViewById(R.id.mainInfo);
        greeting.setText(friendInfo);

        //Return MainActivity with name's information
        Button bAcceptFriend = (Button) findViewById(R.id.acceptFriend);

        bAcceptFriend.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                EditText sendingName = (EditText) findViewById(R.id.editTextSencondName);
                String myName_FromSecond = sendingName.getText().toString();
                intent1.putExtra(sendingName_formSecond,myName_FromSecond);
                setResult(RESULT_OK,intent1);
                finish();
            }
        });


        //Return MainActivity without any information
        Button returnMain = (Button) findViewById(R.id.button);

        returnMain.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                //Intent intent1 = new Intent(SecondActivity.this, MainActivity.class);
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("https://google.com"));
                startActivity(intent1);
            }
        });

    }
}
