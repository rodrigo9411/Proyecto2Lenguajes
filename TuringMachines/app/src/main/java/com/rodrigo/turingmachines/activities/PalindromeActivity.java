package com.rodrigo.turingmachines.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import com.jakewharton.rxbinding2.view.RxView;
import com.rodrigo.turingmachines.R;
import com.rodrigo.turingmachines.adapters.BeltAdapter;
import com.rodrigo.turingmachines.databinding.ActivityTuringMachineBinding;
import com.rodrigo.turingmachines.objects.BeltItem;

import java.util.ArrayList;
import java.util.List;

public class PalindromeActivity extends AppCompatActivity{

    private ActivityTuringMachineBinding binding;

    //States
    private static final String Q0 = "q0";
    private static final String Q1 = "q1";
    private static final String Q2 = "q2";
    private static final String Q3 = "q3";
    private static final String Q4 = "q4";
    private static final String Q5 = "q5";
    private static final String Q6 = "q6";
    private static final String Q7 = "q7";
    private static final String Q8 = "q8";
    private static final String Q9 = "q9";
    private static final String Q10 = "q10";
    private static final String Q11 = "q11";
    
    //Alphabet
    private static final String A = "a";
    private static final String B = "b";
    private static final String C = "c";
    private static final String BLANK = "B";
    private static final String REJECTED = "no";
    private static final String ACCEPTED = "yes";

    //Directions

    private static final String RIGHT = "R";
    private static final String LEFT = "L";
    
    private String status, direction;

    private BeltAdapter adapter;
    private List<BeltItem> belt;

    private String input;
    private int position;
    private int movements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_turing_machine);

        RxView.clicks(binding.btnStart)
                .subscribe(aVoid -> {

                    try {
                        InputMethodManager imm = (InputMethodManager) this.getSystemService(INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
                    } catch (Exception e) {
                        Log.i("Keyboard","Keyboard was closed");
                    }

                    input = binding.etInput.getText().toString().trim();
                    operate();
                });


    }

    private void operate(){
        status = Q0;
        movements = 0;
        binding.tvMovements.setText(String.valueOf(movements));
        belt = new ArrayList<>();

        belt.add(new BeltItem("B",""));
        char[] characters = input.toCharArray();
        for(int i=0;i<characters.length;i++){
            if(i==0){
                belt.add(new BeltItem(String.valueOf(characters[i]),Q0));
            }else{
                belt.add(new BeltItem(String.valueOf(characters[i]),""));
            }

        }
        belt.add(new BeltItem("B",""));


        adapter = new BeltAdapter(this,belt);
        binding.rvBelt.setAdapter(adapter);
        binding.rvBelt.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        position = 1;
        direction = RIGHT;
        shuffle();
    }

    private void shuffle(){

        new CountDownTimer(1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                // do something after 1s
            }

            @Override
            public void onFinish() {
                // do something end times 5s
                if(!status.equals(Q11) && !status.equals(REJECTED)){



                    if(direction.equals(RIGHT)){
                        if(position!=0){
                            belt.get(position).setCurrentStatus("");
                        }
                        belt.get(position).setText(machine(belt.get(position).getText()));

                        if(direction.equals(RIGHT)){
                            position++;
                        }else{
                            position--;
                        }
                        belt.get(position).setCurrentStatus(status);
                    }else if(direction.equals(LEFT)){
                        if(position!=0){
                            belt.get(position).setCurrentStatus("");
                        }
                        belt.get(position).setText(machine(belt.get(position).getText()));

                        if(direction.equals(RIGHT)){
                            position++;
                        }else{
                            position--;
                            if(position<0){
                                position = 0;
                            }
                        }
                        belt.get(position).setCurrentStatus(status);

                    }
                    movements++;
                    binding.tvMovements.setText(String.valueOf(movements));
                    adapter.notifyDataSetChanged();

                    shuffle();
                }
                else if(status.equals(Q11)){
                    belt.get(position).setCurrentStatus(ACCEPTED);
                    adapter.notifyDataSetChanged();
                }else if (status.equals(REJECTED)){
                    belt.get(position).setCurrentStatus(REJECTED);
                    adapter.notifyDataSetChanged();
                }

            }

        }.start();
    }
    
    private String machine(String text){
        switch (status){
            case Q0:
                switch (text){
                    case A:
                        status = Q1;
                        direction = RIGHT;
                        return BLANK;
                        
                    case B:
                        status = Q2;
                        direction = RIGHT;
                        return BLANK;
                        
                    case C:
                        status = Q3;
                        direction = RIGHT;
                        return BLANK;
                        
                    case BLANK:
                        status = Q11;
                        direction = RIGHT;
                        return BLANK;
                        
                    default:
                        status = REJECTED;
                        return REJECTED;

                }


            case Q1:
                switch (text){
                    case A:
                        status = Q4;
                        direction = RIGHT;
                        return A;

                    case B:
                        status = Q4;
                        direction = RIGHT;
                        return B;

                    case C:
                        status = Q4;
                        direction = RIGHT;
                        return C;

                    case BLANK:
                        status = Q11;
                        direction = RIGHT;
                        return BLANK;

                    default:
                        status = REJECTED;
                        return REJECTED;

                }

            case Q2:
                switch (text){
                    case A:
                        status = Q5;
                        direction = RIGHT;
                        return A;

                    case B:
                        status = Q5;
                        direction = RIGHT;
                        return B;

                    case C:
                        status = Q5;
                        direction = RIGHT;
                        return C;

                    case BLANK:
                        status = Q11;
                        direction = RIGHT;
                        return BLANK;

                    default:
                        status = REJECTED;
                        return REJECTED;

                }

            case Q3:
                switch (text){
                    case A:
                        status = Q6;
                        direction = RIGHT;
                        return A;

                    case B:
                        status = Q6;
                        direction = RIGHT;
                        return B;

                    case C:
                        status = Q6;
                        direction = RIGHT;
                        return C;

                    case BLANK:
                        status = Q11;
                        direction = RIGHT;
                        return BLANK;

                    default:
                        status = REJECTED;
                        return REJECTED;

                }

            case Q4:
                switch (text){
                    case A:
                        status = Q4;
                        direction = RIGHT;
                        return A;

                    case B:
                        status = Q4;
                        direction = RIGHT;
                        return B;

                    case C:
                        status = Q4;
                        direction = RIGHT;
                        return C;

                    case BLANK:
                        status = Q7;
                        direction = LEFT;
                        return BLANK;

                    default:
                        status = REJECTED;
                        return REJECTED;

                }

            case Q5:
                switch (text){
                    case A:
                        status = Q5;
                        direction = RIGHT;
                        return A;

                    case B:
                        status = Q5;
                        direction = RIGHT;
                        return B;

                    case C:
                        status = Q5;
                        direction = RIGHT;
                        return C;

                    case BLANK:
                        status = Q8;
                        direction = LEFT;
                        return BLANK;

                    default:
                        status = REJECTED;
                        return REJECTED;

                }

            case Q6:
                switch (text){
                    case A:
                        status = Q6;
                        direction = RIGHT;
                        return A;

                    case B:
                        status = Q6;
                        direction = RIGHT;
                        return B;

                    case C:
                        status = Q6;
                        direction = RIGHT;
                        return C;

                    case BLANK:
                        status = Q9;
                        direction = LEFT;
                        return BLANK;

                    default:
                        status = REJECTED;
                        return REJECTED;

                }

            case Q7:
                switch (text){
                    case A:
                        status = Q10;
                        direction = LEFT;
                        return BLANK;

                    case B:
                        status = REJECTED;
                        return B;

                    case C:
                        status = REJECTED;
                        return C;

                    case BLANK:
                        status = REJECTED;
                        return BLANK;

                    default:
                        status = REJECTED;
                        return REJECTED;

                }

            case Q8:
                switch (text){
                    case A:
                        status = REJECTED;
                        return A;

                    case B:
                        status = Q10;
                        direction = LEFT;
                        return BLANK;

                    case C:
                        status = REJECTED;
                        return C;

                    case BLANK:
                        status = REJECTED;
                        return BLANK;

                    default:
                        status = REJECTED;
                        return REJECTED;

                }

            case Q9:
                switch (text){
                    case A:
                        status = REJECTED;
                        return A;

                    case B:
                        status = REJECTED;
                        return B;

                    case C:
                        status = Q10;
                        direction = LEFT;
                        return BLANK;

                    case BLANK:
                        status = REJECTED;
                        return BLANK;

                    default:
                        status = REJECTED;
                        return REJECTED;

                }

            case Q10:
                switch (text){
                    case A:
                        status = Q10;
                        direction = LEFT;
                        return A;

                    case B:
                        status = Q10;
                        direction = LEFT;
                        return B;

                    case C:
                        status = Q10;
                        direction = LEFT;
                        return C;

                    case BLANK:
                        status = Q0;
                        direction = RIGHT;
                        return BLANK;

                    default:
                        status = REJECTED;
                        return REJECTED;

                }

            case Q11:
                switch (text){
                    case A:
                        return ACCEPTED;

                    case B:
                        return ACCEPTED;

                    case C:
                        return ACCEPTED;

                    case BLANK:
                        return ACCEPTED;

                    default:
                        status = REJECTED;
                        return REJECTED;

                }


            default:
                status = REJECTED;
                return REJECTED;
                
        }
    }

}
