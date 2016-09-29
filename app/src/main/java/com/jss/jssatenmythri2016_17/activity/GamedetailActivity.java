package com.jss.jssatenmythri2016_17.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jss.jssatenmythri2016_17.R;

public class GamedetailActivity extends AppCompatActivity {
    String data;

    LinearLayout studentCoordinatorOne,studentCoordinatorTwo,studentCoordinatorThree,facualtyCoordinatorOne,facualtyCoordinatorTwo;

    TextView studentOneName,studentTwoName,studentThreeName,facultyName,facultyName2;
    TextView studentOneContact,studentTwoContact,studentThreeContact,type,rules,venue;

    TextView itemTitle;
    ImageView studentOneImage,studentTwoImage,studentThreeImage,facultyImage,facultyImage2;

    int numberOfCoordinators;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dummylayout);

        itemTitle = (TextView)findViewById(R.id.item_title);
        data=getIntent().getExtras().getString("title");
        numberOfCoordinators = getIntent().getExtras().getInt("Nos");
        //linking components
        studentOneContact = (TextView)findViewById(R.id.studentnumber1);
        studentTwoContact = (TextView)findViewById(R.id.studentnumber2);
        studentThreeContact = (TextView)findViewById(R.id.studentnumber3);
        facultyName= (TextView) findViewById(R.id.name1);
        facultyName2= (TextView) findViewById(R.id.name2);
        type= (TextView) findViewById(R.id.type_detail);
        rules= (TextView) findViewById(R.id.detail_rules);
        venue= (TextView) findViewById(R.id.detail_v_d);


        studentOneName = (TextView)findViewById(R.id.studentname1);
        studentTwoName = (TextView)findViewById(R.id.studentname2);
        studentThreeName = (TextView)findViewById(R.id.studentname3);

        studentOneImage = (ImageView)findViewById(R.id.imagestudent1);
        studentTwoImage = (ImageView)findViewById(R.id.imagestudent2);
        studentThreeImage = (ImageView)findViewById(R.id.imagestudent3);
        facultyImage = (ImageView)findViewById(R.id.facultyimage);
        facultyImage2= (ImageView)findViewById(R.id.facultyimage2);

        studentCoordinatorOne =  (LinearLayout)findViewById(R.id.studentcoordinator0ne);
        studentCoordinatorTwo =  (LinearLayout)findViewById(R.id.studentcoordinatortwo);
        studentCoordinatorThree =  (LinearLayout)findViewById(R.id.studentcoordinatorthree);
        facualtyCoordinatorOne= (LinearLayout) findViewById(R.id.facultycoordinator0ne);
        facualtyCoordinatorTwo = (LinearLayout) findViewById(R.id.facultycoordinatorTwo);



        switch (data){
            case "Badminton": {
                itemTitle.setText("Badminton");
                studentOneName.setText("Prashant Verma(IT/4th yr)");
                studentTwoName.setText("Abhigyan (CS/4th yr)");
                studentThreeName.setText("Aiswarya Choudhary(CE/4th yr)");
                facultyName.setText("Mr. Vikas Singhal-AP");
                facualtyCoordinatorTwo.setVisibility(View.GONE);
                studentOneContact.setText("8588813026");
                studentTwoContact.setText("8860547493");
                studentThreeContact.setText("8130959701");
                type.setText("Singles , Doubles , Mixed");
                venue.setText("MPH BADMINTON HALL");
                rules.setText("SCORING SYSTEM\n" +
                        "\n" +
                        "o A match consists of the best of 3 games of 21 points.\n" +
                        "\n" +
                        "o Every time there is a serve – there is a point scored.\n" +
                        "\n" +
                        "o The side winning a rally adds a point to its score.\n" +
                        "\n" +
                        "o At 20 all, the side which gains a 2-point lead first, wins that game.\n" +
                        "\n" +
                        "o At 29 all, the side scoring the 30th point, wins that game.\n" +
                        "\n" +
                        "o The side winning a game serves first in the next game.\n" +
                        "\n" +
                        "SINGLES\n" +
                        "\n" +
                        "o At the beginning of the game (0-0) and when the server’s score is even, the server serves from the\n" +
                        "\n" +
                        "right service court. When the server’s score is odd, the server serves from the left service court.\n" +
                        "\n" +
                        "o If the server wins a rally, the server scores a point and then serves again from the alternate service\n" +
                        "\n" +
                        "court.\n" +
                        "\n" +
                        "o If the receiver wins a rally, the receiver scores a point and becomes the new server. They serve\n" +
                        "\n" +
                        "from the appropriate service court – left if their score is odd, and right if it is even.\n" +
                        "\n" +
                        "DOUBLES\n" +
                        "\n" +
                        "o A side has only one ‘service’.\n" +
                        "\n" +
                        "o The service passes consecutively to the players as shown in the diagram.\n" +
                        "\n" +
                        "o At the beginning of the game and when the score is even, the server serves from the right service\n" +
                        "\n" +
                        "court. When it is odd, the server serves from the left court.\n" +
                        "\n" +
                        "o If the serving side wins a rally, the serving side scores a point and the same server serves again\n" +
                        "\n" +
                        "from the alternate service court.\n" +
                        "\n" +
                        "o If the receiving side wins a rally, the receiving side scores a point. The receiving side becomes the\n" +
                        "\n" +
                        "new serving side.\n" +
                        "\n" +
                        "o The players do not change their respective service courts until they win a point when their side is\n" +
                        "\n" +
                        "serving.");
            }break;
            case "Table Tennis":{
                itemTitle.setText("Table Tennis");
                studentOneName.setText("Sachin(EE/4th yr)");
                studentCoordinatorTwo.setVisibility(View.GONE);
                studentCoordinatorThree.setVisibility(View.GONE);
                facualtyCoordinatorTwo.setVisibility(View.GONE);
                facultyName.setText("Mr. Shashi Kumar.R-AP");
                studentOneContact.setText("7503079626");

                type.setText("Singles , Doubles , Mixed");
                venue.setText("MPH Table Tennis HALL");

            }break;
            case "Chess":{
                itemTitle.setText("Chess");
                studentCoordinatorTwo.setVisibility(View.GONE);
                studentCoordinatorThree.setVisibility(View.GONE);
                facualtyCoordinatorTwo.setVisibility(View.GONE);
                studentOneName.setText("Deepesh Verma(CS/4th yr)");
                facultyName.setText("Mr. Sadashiva.T-AP");
                studentOneContact.setText("7836823674");

                type.setText("None");
                venue.setText("MPH Chess Room");

            }break;
            case "Carrom":{
                itemTitle.setText("Carrom");
                studentOneName.setText("Pulkit Batra(CS/4th yr)");
                studentTwoName.setText("Amit Shulka(CE/4th yr)");
                facultyName.setText("Mr. Nirmal Kumar Agarwal-AP");
                facultyName2.setText("Mr. Amit kumar Roy-AP");
                studentOneContact.setText("9412190056");
                studentTwoContact.setText("956074831");
                type.setText("Singles , Doubles , Mixed");
                venue.setText("MPH Carrom Room");

            }break;
            case "Tug Of War":{
                studentOneName.setText("Rajat Sachan(EC/4th yr)");
                studentTwoName.setText("Gaurav Kumar(Mca/2nd yr)");
                studentThreeName.setText("Akrita Verma(IC/4th yr)");
                facultyName.setText("Mr. Girish.B.E-PED");
                studentOneContact.setText("7834855635");
                studentTwoContact.setText("8081077326");
                studentThreeContact.setText("8447362527");
                facualtyCoordinatorTwo.setVisibility(View.GONE);
                type.setText("None");
                venue.setText("Outdoor");

            }break;
            case "Cricket":{
                studentOneName.setText("Saurabh Singh(EE/4th yr)");
                studentTwoName.setText("Vasu Choudhary(CS/4th yr)");
                facultyName.setText("Mr. Vikas Kumar Singla-AP");
                studentOneContact.setText("8882382568");
                studentTwoContact.setText("9555639181");
                type.setText("None");
                venue.setText("Outdoor");
                studentCoordinatorThree.setVisibility(View.GONE);
                facualtyCoordinatorTwo.setVisibility(View.GONE);

            }break;
            case "Football":{
                studentOneName.setText("Abhishek (EE/4th yr)");
                facultyName.setText("Mr.Harsh Vardhan Pundir-AP");
                studentOneContact.setText("9650188604");
                type.setText("None");
                venue.setText("Outdoor");
                studentCoordinatorThree.setVisibility(View.GONE);
                studentCoordinatorThree.setVisibility(View.GONE);
                facualtyCoordinatorTwo.setVisibility(View.GONE);
            }break;
            case "Volleyball":{
                studentOneName.setText("Hari Govind Singh(CS/4th yr)");
                studentTwoName.setText("Simran Chawla(IT/4th yr)");
                facultyName.setText("Mr.Birendra Kumar Verma-IT");
                studentOneContact.setText("9015835358");
                studentTwoContact.setText("7838267666");
                type.setText("None");
                venue.setText("Outdoor");
                studentCoordinatorThree.setVisibility(View.GONE);
                facualtyCoordinatorTwo.setVisibility(View.GONE);

            }break;

            case "basketball":{
                studentOneName.setText("Sarthak Dutta(IC/4th yr)");
                studentTwoName.setText("Shraddha (EC/4th yr)");
                facultyName.setText("Mr. Grish B.E-PED");
                facultyName2.setText("Nikunj Agarwal-AP");
                studentOneContact.setText("9650872778");
                studentTwoContact.setText("9711876556");
                type.setText("None");
                venue.setText("Outdoor");
                studentCoordinatorThree.setVisibility(View.GONE);

            }break;
            case "Athelitics":{
                /*Intent intent=new Intent(getApplicationContext(),Athelics_Listview.class);
                startActivity(intent);*/

            }break;

            case "Shot Put":{
                studentOneName.setText("Ruchir Verma(CS/4th yr)");
                studentTwoName.setText("Aman Sharma (CS/4th yr)");
                facultyName.setText("Mr.Virendara Kumar Verma-AP");
                facultyName2.setText("Mrs.Shafali Bhakshi-AP");
                studentOneContact.setText("9454847294");
                studentTwoContact.setText("9015936544");
                type.setText("None");
                studentCoordinatorThree.setVisibility(View.GONE);
                venue.setText("Outdoor");

            }break;

            case "Kabaddi":{
                studentOneName.setText("Manish Kumar Singh(CS/4th yr)");
                facultyName.setText("Mr.Yogesh.K.S-AP");
                facultyName2.setText("Mr.Bharath Kumar-AP");
                studentOneContact.setText("8527967273");
                type.setText("None");
                venue.setText("Outdoor");

            }break;

            case "Fun Games":{
                studentOneName.setText("Jugal Kishore(IT/4th yr)");
                studentTwoName.setText("Girish Purushwani(CE/4th yr)");
                facultyName.setText("Mr.Mehboobs Alam-AP");
                facultyName2.setText("Mrs.Preeti Jaidka-AP");
                studentOneContact.setText("8505850131");
                studentTwoContact.setText("8957050493");
                type.setText("Blind Shoot,Dart,3 Shots,Basket Shoot,Ball Bounce");
                venue.setText("Next To Canteen");

            }break;
        }

    }
}
