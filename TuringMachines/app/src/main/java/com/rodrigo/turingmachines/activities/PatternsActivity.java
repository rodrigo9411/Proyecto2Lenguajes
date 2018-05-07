package com.rodrigo.turingmachines.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rodrigo.turingmachines.R;
import com.rodrigo.turingmachines.databinding.ActivityTuringMachineBinding;

public class PatternsActivity extends AppCompatActivity{

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
    private static final String Q12 = "q12";
    private static final String Q13 = "q13";
    private static final String Q14 = "q14";
    private static final String Q15 = "q15";
    private static final String Q16 = "q16";
    private static final String Q17 = "q17";

    //Alphabet
    private static final String A = "a";
    private static final String B = "b";
    private static final String C = "c";
    private static final String X = "X";
    private static final String Y = "Y";
    private static final String BLANK = "B";
    private static final String REJECTED = "no";
    private static final String ACCEPTED = "yes";

    //Directions

    private static final String RIGHT = "R";
    private static final String LEFT = "L";

    private String status, direction;
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_turing_machine);
    }

//    private String machine(String text){
//        switch (status){
//            case Q0:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return REJECTED;
//                        break;
//
//
//                }
//
//                break;
//            case Q1:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return REJECTED;
//                        break;
//                }
//                break;
//            case Q2:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return REJECTED;
//                        break;
//                }
//                break;
//            case Q3:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return REJECTED;
//                        break;
//                }
//                break;
//            case Q4:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return REJECTED;
//                        break;
//                }
//                break;
//            case Q5:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return REJECTED;
//                        break;
//                }
//                break;
//            case Q6:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return REJECTED;
//                        break;
//                }
//                break;
//            case Q7:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return REJECTED;
//                        break;
//                }
//                break;
//            case Q8:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return REJECTED;
//                        break;
//                }
//                break;
//            case Q9:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return REJECTED;
//                        break;
//                }
//                break;
//            case Q10:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return REJECTED;
//                        break;
//                }
//                break;
//            case Q11:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return REJECTED;
//                        break;
//                }
//                break;
//            case Q12:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return REJECTED;
//                        break;
//                }
//                break;
//            case Q13:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return REJECTED;
//                        break;
//                }
//                break;
//            case Q14:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return REJECTED;
//                        break;
//                }
//                break;
//            case Q15:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return REJECTED;
//                        break;
//                }
//                break;
//            case Q16:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return REJECTED;
//                        break;
//                }
//                break;
//            case Q17:
//                switch (text){
//                    case A:
//
//                        break;
//                    case B:
//
//                        break;
//                    case C:
//
//                        break;
//                    case X:
//
//                        break;
//                    case Y:
//
//                        break;
//                    case BLANK:
//
//                        break;
//                    default:
//                        return ACCEPTED;
//                        break;
//                }
//                break;
//        }
//    }
    
    

}
