package com.example.android.scorekeeper;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    private int teamOne = 0;
    private int teamTwo = 0;
    int goalPlayers_1,goalPlayers_2,penaltyPlayers_1,penaltyPlayers_2,redCardPlayers_1,redCardPlayers_2,yellowCardPlayers_1,yellowCardPlayers_2;
    Button goal_1, goal_2, penalty_1, penalty_2, redcard_1, redcard_2, yellowcard_1, yellowcard_2,  reset;
    TextView tShowTeamOne,tShowTeamTwo,tGoalTeamOne,tGoalTeamTwo,tPenaltyTeamOne,tPenaltyTeamTwo,tRedCardTeamOne,tRedCardTeamTwo, tYellowCardTeamOne, tYellowCardTeamTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        goal_1 =  findViewById(R.id.goal_button_team_1);
        goal_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (teamOne >= 10) {
                    Toast.makeText(MainActivity.this, "for one match does not really score 10 goals !", Toast.LENGTH_SHORT).show();
                    return;
                }
                showScoreTeamOne(teamOne += 1);


                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Who scored a goal?");
                dialog.setMessage("Enter player number");
                final EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                dialog.setView(input);

                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        ArrayList<Integer>  array = new ArrayList<>();
                            String data = input.getText().toString();
                          if (data.isEmpty()){
                            Toast.makeText(MainActivity.this, "the player must have a number!", Toast.LENGTH_SHORT).show();
                              return;
                          }

                            goalPlayers_1 = Integer.parseInt(data);
                            array.add(goalPlayers_1);
                            showGoalValueTeamOne(array);


                    }
                });



                dialog.show();
            }
        });


        goal_2 =  findViewById(R.id.goal_button_team_2);
        goal_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (teamTwo >= 10) {
                    Toast.makeText(MainActivity.this, "for one match does not really score 10 goals !", Toast.LENGTH_SHORT).show();
                    return;
                }
                showScoreTeamTwo(teamTwo += 1);

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Who scored a goal?");
                dialog.setMessage("Enter player number");
                final EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                dialog.setView(input);

                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        ArrayList<Integer>  array = new ArrayList<>();
                        String data = input.getText().toString();
                        if (data.isEmpty()){
                            Toast.makeText(MainActivity.this, "the player must have a number!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        goalPlayers_2 = Integer.parseInt(data);
                        array.add(goalPlayers_2);
                        showGoalValueTeamTwo(array);


                    }
                });



                dialog.show();
            }
        });

            penalty_1 = findViewById(R.id.penalty_button_team_1);
            penalty_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (teamOne >= 10) {
                        Toast.makeText(MainActivity.this, "for one match does not really score 10 goals !", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    showScoreTeamOne(teamOne += 1);


                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Who scored a penalty?");
                    dialog.setMessage("Enter player number");
                    final EditText input = new EditText(MainActivity.this);
                    input.setInputType(InputType.TYPE_CLASS_NUMBER);
                    dialog.setView(input);

                    dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            ArrayList<Integer>  array = new ArrayList<>();
                            String data = input.getText().toString();
                            if (data.isEmpty()){
                                Toast.makeText(MainActivity.this, "the player must have a number!", Toast.LENGTH_SHORT).show();
                                return;
                            }

                            penaltyPlayers_1 = Integer.parseInt(data);
                            array.add(penaltyPlayers_1);
                            showPenaltyValueTeamOne(array);


                        }
                    });



                    dialog.show();

                }
            });

            penalty_2 = findViewById(R.id.penalty_button_team_2);
            penalty_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (teamTwo >= 10) {
                        Toast.makeText(MainActivity.this, "for one match does not really score 10 goals !", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    showScoreTeamTwo(teamTwo += 1);


                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Who scored a penalty?");
                    dialog.setMessage("Enter player number");
                    final EditText input = new EditText(MainActivity.this);
                    input.setInputType(InputType.TYPE_CLASS_NUMBER);
                    dialog.setView(input);

                    dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            ArrayList<Integer>  array = new ArrayList<>();
                            String data = input.getText().toString();
                            if (data.isEmpty()){
                                Toast.makeText(MainActivity.this, "the player must have a number!", Toast.LENGTH_SHORT).show();
                                return;
                            }

                            penaltyPlayers_2 = Integer.parseInt(data);
                            array.add(penaltyPlayers_2);
                            showPenaltyValueTeamTwo(array);


                        }
                    });



                    dialog.show();

                }
            });

            redcard_1 = findViewById(R.id.red_card_button_team_1);
            redcard_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Who received a red card?");
                    dialog.setMessage("Enter player number");
                    final EditText input = new EditText(MainActivity.this);
                    input.setInputType(InputType.TYPE_CLASS_NUMBER);
                    dialog.setView(input);

                    dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            ArrayList<Integer>  array = new ArrayList<>();
                            String data = input.getText().toString();
                            if (data.isEmpty()){
                                Toast.makeText(MainActivity.this, "the player must have a number!", Toast.LENGTH_SHORT).show();
                                return;
                            }

                            redCardPlayers_1 = Integer.parseInt(data);
                            array.add(redCardPlayers_1);
                            showRedCardValueTeamOne(array);


                        }
                    });



                    dialog.show();

                }
            });

            redcard_2 = findViewById(R.id.red_card_button_team_2);
             redcard_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Who received a red card?");
                dialog.setMessage("Enter player number");
                final EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                dialog.setView(input);

                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        ArrayList<Integer>  array = new ArrayList<>();
                        String data = input.getText().toString();
                        if (data.isEmpty()){
                            Toast.makeText(MainActivity.this, "the player must have a number!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        redCardPlayers_2 = Integer.parseInt(data);
                        array.add(redCardPlayers_2);
                        showRedCardValueTeamTwo(array);


                    }
                });



                dialog.show();

            }
          });

             yellowcard_1 = findViewById(R.id.yellow_card_button_team_1);
             yellowcard_1.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

                     AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                     dialog.setTitle("Who received a yellow card?");
                     dialog.setMessage("Enter player number");
                     final EditText input = new EditText(MainActivity.this);
                     input.setInputType(InputType.TYPE_CLASS_NUMBER);
                     dialog.setView(input);

                     dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                         public void onClick(DialogInterface dialog, int whichButton) {
                             ArrayList<Integer>  array = new ArrayList<>();
                             String data = input.getText().toString();
                             if (data.isEmpty()){
                                 Toast.makeText(MainActivity.this, "the player must have a number!", Toast.LENGTH_SHORT).show();
                                 return;
                             }

                             yellowCardPlayers_1 = Integer.parseInt(data);
                             array.add(yellowCardPlayers_1);
                             showYellowCardValueTeamOne(array);


                         }
                     });
                     dialog.show();
                 }
             });

        yellowcard_2 = findViewById(R.id.yellow_card_button_team_2);
        yellowcard_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Who received a yellow card?");
                dialog.setMessage("Enter player number");
                final EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                dialog.setView(input);

                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        ArrayList<Integer>  array = new ArrayList<>();
                        String data = input.getText().toString();
                        if (data.isEmpty()){
                            Toast.makeText(MainActivity.this, "the player must have a number!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        yellowCardPlayers_2 = Integer.parseInt(data);
                        array.add(yellowCardPlayers_2);
                        showYellowCardValueTeamTwo(array);


                    }
                });
                dialog.show();

            }
        });

        reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              teamOne = 0;
              teamTwo = 0;
              showScoreTeamOne(teamOne);
              showScoreTeamTwo(teamTwo);

                showGoalValueTeamOne(null);
                showGoalValueTeamTwo(null);
                showPenaltyValueTeamOne(null);
                showPenaltyValueTeamTwo(null);
                showRedCardValueTeamOne(null);
                showRedCardValueTeamTwo(null);
                showYellowCardValueTeamOne(null);
                showYellowCardValueTeamTwo(null);
            }
        });
    }














    public  void  showScoreTeamOne(int points){
        tShowTeamOne = findViewById(R.id.team_1_score);
        tShowTeamOne.setText(String.valueOf(points));
    }

    public  void  showScoreTeamTwo(int points){
        tShowTeamTwo = findViewById(R.id.team_2_score);
        tShowTeamTwo.setText(String.valueOf(points));
    }


  public void  showGoalValueTeamOne(List<Integer> list) {
        if(list == null){
            tGoalTeamOne.setText("");
            return;
        }

      for (int i = 0; i < list.size(); i++) {
          tGoalTeamOne = findViewById(R.id.goal_value_team_1);

          tGoalTeamOne.append(String.valueOf(" " + list.get(i)));
      }
  }

    public void  showGoalValueTeamTwo(List<Integer> list) {
        if(list == null){
            tGoalTeamTwo.setText("");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            tGoalTeamTwo = findViewById(R.id.goal_value_team_2);

            tGoalTeamTwo.append(String.valueOf(" " + list.get(i)));
        }
    }


    public void  showPenaltyValueTeamOne(List<Integer> list) {
        if(list == null){
            tPenaltyTeamOne.setText("");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            tPenaltyTeamOne = findViewById(R.id.penalty_value_team_1);

            tPenaltyTeamOne.append(String.valueOf(" " + list.get(i)));
        }
    }

    public void  showPenaltyValueTeamTwo(List<Integer> list) {
        if(list == null){
            tPenaltyTeamTwo.setText("");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            tPenaltyTeamTwo = findViewById(R.id.penalty_value_team_2);

            tPenaltyTeamTwo.append(String.valueOf(" " + list.get(i)));
        }
    }

    public void  showRedCardValueTeamOne(List<Integer> list) {
        if(list == null){
            tRedCardTeamOne.setText("");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            tRedCardTeamOne = findViewById(R.id.red_card_value_team_1);

            tRedCardTeamOne.append(String.valueOf(" " + list.get(i)));
        }
    }

    public void  showRedCardValueTeamTwo(List<Integer> list) {
        if(list == null){
            tRedCardTeamTwo.setText("");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            tRedCardTeamTwo = findViewById(R.id.red_card_value_team_2);

            tRedCardTeamTwo.append(String.valueOf(" " + list.get(i)));
        }
    }

    public void  showYellowCardValueTeamOne(List<Integer> list) {
        if(list == null){
            tYellowCardTeamOne.setText("");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            tYellowCardTeamOne = findViewById(R.id.yellow_card_value_team_1);

            tYellowCardTeamOne.append(String.valueOf(" " + list.get(i)));
        }
    }

    public void  showYellowCardValueTeamTwo(List<Integer> list) {
        if(list == null){
            tYellowCardTeamTwo.setText("");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            tYellowCardTeamTwo = findViewById(R.id.yellow_card_value_team_2);

            tYellowCardTeamTwo.append(String.valueOf(" " + list.get(i)));
        }
    }



}
