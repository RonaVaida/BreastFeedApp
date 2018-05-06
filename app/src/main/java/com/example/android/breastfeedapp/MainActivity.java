package com.example.android.breastfeedapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;

/**
 * This APP is a quiz about breastfeeding
 */

public class MainActivity extends AppCompatActivity {
    int score;

    {
        score = 0;
    }

// global integer score

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


/**
 * Question 1 RadioButton
 *
 */

public void onRadioButtonQuestion1(View view){
    //Is it checked?
    boolean checked = ((RadioButton) view).isChecked();
    //Which one is checked?
    switch (view.getId()){
        case R.id.Q1A1:
            if (checked)
                score = score;
            // Wrong answer
            break;
        case R.id.Q1A2:
            if (checked)
                score = score;
            // Wrong answer
            break;
        case R.id.Q1A3:
            if (checked)
                score = score + 1;
            // Correct answer adds +1 to score
            break;
    }
}
    /**
     * Question 2 RadioButton
     *
     */
    public void onRadioButtonQuestion2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Q2A1:
                if (checked)
                    score = score;
                // Right answer
                break;
            case R.id.Q2A2:
                if (checked)
                    score = score;
                // Wrong answer
                break;
            case R.id.Q2A3:
                if (checked)
                    score = score;
                // Wrong answer
                break;
            case R.id.Q2A4:
                if (checked)
                    score = score + 1;
                // Correct answer adds +1 to score
                break;
        }
    }
    /**
     * Question 3 RadioButton
     *
     */
    public void onRadioButtonQuestion3 (View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Q3A1:
                if (checked)
                    score = score;
                // Wrong answer
                break;
            case R.id.Q3A2:
                if (checked)
                    score = score + 1;
                // Correct answer adds +1 to score
                break;
            case R.id.Q3A3:
                if (checked)
                    score = score;
                // Wrong answer
                break;
            case R.id.Q3A4:
                if (checked)
                    score = score;
                // Wrong answer
                break;
        }
    }
    /**
     * Question 4 RadioButton
     *
     */
    public void onRadioButtonQuestion4 (View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Q4A1:
                if (checked)
                    score = score;
                // Wrong answer
                break;
            case R.id.Q4A2:
                if (checked)
                    score = score + 1;
                // Correct answer adds +1 to score
                break;
        }
    }

    /**
     * This method is called when submitAnswers button is clicked
     */
        //boolean variables for checkbox bonus question

    public void submitAnswers(View view){
        boolean hasOneBunosAnswer;
        boolean hasTwoBunosAnswers;
        boolean hasThreeBunosAnswers;
        boolean hasWrongAnswer;


        // Question 5 checkbox - needs 3 right answers
        CheckBox CheckBoxWrong = (CheckBox) findViewById(R.id.Q5A1);
        CheckBox CheckBoxRightOne = (CheckBox) findViewById(R.id.Q5A2);
        CheckBox CheckBoxRightTwo = (CheckBox) findViewById(R.id.Q5A3);
        CheckBox CheckBoxRightThree = (CheckBox) findViewById(R.id.Q5A4);
        if (!(!(hasOneBunosAnswer = CheckBoxRightOne.isChecked()) || !(hasTwoBunosAnswers = CheckBoxRightTwo.isChecked() || !(hasThreeBunosAnswers = CheckBoxRightThree.isChecked() && (hasWrongAnswer = CheckBoxWrong.isChecked() == false))))) {
            score = score + 1;
        } else {
            score = score;
        }
        {
            score = score;
        }
        // CheckBoxes in question 5 (Bonus) . If the three right CheckBoxes are clicked and the wrong CheckBox is not clicked, it means one point more to the score
        Toast.makeText(this, "Your score is " + score, Toast.LENGTH_SHORT).show();
        // Toast that shows the score achieved on the screen
        displayScore(createScoreMessage(score));
        // We call this method to show the score and a message on the screen
    }

    /**
     * Creates and gives the score message
     *
     * @param score
     */
    private String createScoreMessage(int score) {
        String scoremessage;
        EditText playerNameField = (EditText) findViewById(R.id.name_field);
        String nameOfPlayer = playerNameField.getText().toString();
        if (score >= 5) {
            scoremessage = "Wow! looks like " + nameOfPlayer + " is a PRO! \nYour score is: " + this.score;
            return scoremessage;
        }
        if (score >= 3) {
            scoremessage = "Not bad " + nameOfPlayer + "! \nYour score is: " + this.score;
            return scoremessage;
        } else {
            scoremessage = "Oh no! " + nameOfPlayer + "! \nPractice and try again \nYour score is: " + this.score;
            return scoremessage;
        }
    }

    /**
     * This method displays the score value and message on the screen.
     */
    private void displayScore(String message) {
        TextView scoreTextView = (TextView) findViewById(R.id.your_score);
        scoreTextView.setText(message);
    }

    /**
     * This method "reset" score
     */
    public void resetButton(View view) {
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    /**
     * This is a link for extra material regarding breastfeeding
     */
    public void clickLink(View view) {
        TextView textView = (TextView) findViewById(R.id.laleche);
        textView.setText("https://www.llli.org/");
        Linkify.addLinks(textView, Linkify.WEB_URLS);
    }
}000