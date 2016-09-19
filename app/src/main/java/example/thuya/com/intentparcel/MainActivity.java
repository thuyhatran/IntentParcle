package example.thuya.com.intentparcel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String FriendRequest = "Request from Main";
    public final static int requestCode_FriendName = 0;

    private Button getFriend = null;

    private EditText friendName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFriend = (Button) findViewById(R.id.getFriend);

        getFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                EditText editTextName = (EditText) findViewById(R.id.editTextName);
                EditText editTextAge = (EditText) findViewById(R.id.editTextAge);

                editTextName.setTextSize(30);


                String name = editTextName.getText().toString();
                int age = Integer.parseInt(editTextAge.getText().toString());

                Person person = new Person(name, age);

                intent.putExtra(FriendRequest, person);

                startActivityForResult(intent,requestCode_FriendName);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if (requestCode == requestCode_FriendName){

            if (resultCode == RESULT_OK){

                //Set visibitily for Friend's info
                TextView textViewFriend = (TextView) findViewById(R.id.textView4);
                textViewFriend.setVisibility(View.VISIBLE);

                friendName = (EditText) findViewById(R.id.editTextFriend);
                friendName.setVisibility(View.VISIBLE);

                //Set data get form SecondActivity and set to EditText friendName
                String friendName_fromSecond = data.getStringExtra(SecondActivity.sendingName_formSecond);
                friendName.setText(friendName_fromSecond);

            }
        }



    }

}
