package com.example.gymaths;

import android.content.Context;
import android.inputmethodservice.InputMethodService;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MyKeyboard_abc extends LinearLayout implements View.OnClickListener
{
    private Button buttonDelete, buttonOpenParenthesis, buttonCloseParenthesis, button7, button8,
            button9, buttonPlus, buttonSqrt, buttonPower, button4, button5, button6, buttonMinus,
            buttonABC, buttonX, button1, button2, button3, buttonMult, buttonValidate, button0,
            buttonComma, buttonDivide;

    private ImageButton buttonEquals;

    private SparseArray<String> keyValues = new SparseArray<>();
    private InputConnection inputConnection;
    private MyKeyboard simpleMathKdb;
    private int switchId;

    public MyKeyboard_abc(Context context)
    {
        this(context, null, 0);
    }

    public MyKeyboard_abc(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public MyKeyboard_abc(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs)
    {
        LayoutInflater.from(context).inflate(R.layout.keyboard_abc, this, true);

        //First Row:
        buttonDelete = (Button) findViewById(R.id.button_delete_kbdABC);
        buttonDelete.setOnClickListener(this);
        keyValues.put(R.id.button_delete_kbdABC, "Delete");

        //Second Row:
        buttonOpenParenthesis = (Button) findViewById(R.id.button_openParenthesis_kbdABC);
        buttonOpenParenthesis.setOnClickListener(this);
        keyValues.put(R.id.button_openParenthesis_kbdABC, "(");

        buttonCloseParenthesis = (Button) findViewById(R.id.button_closeParenthesis_kbdABC);
        buttonCloseParenthesis.setOnClickListener(this);
        keyValues.put(R.id.button_closeParenthesis_kbdABC, ")");

        button7 = (Button) findViewById(R.id.button_abc_kbdABC);
        button7.setOnClickListener(this);

        button8 = (Button) findViewById(R.id.button_def);
        button8.setOnClickListener(this);

        button9 = (Button) findViewById(R.id.button_ghi);
        button9.setOnClickListener(this);

        buttonPlus = (Button) findViewById(R.id.button_plus_kbdABC);
        buttonPlus.setOnClickListener(this);
        keyValues.put(R.id.button_plus_kbdABC, "+");

        //Third Row:
        buttonSqrt = (Button) findViewById(R.id.button_sqrt_kbdABC);
        buttonSqrt.setOnClickListener(this);
        keyValues.put(R.id.button_sqrt_kbdABC, "√()");

        buttonPower = (Button) findViewById(R.id.button_power_kbdABC);
        buttonPower.setOnClickListener(this);
        keyValues.put(R.id.button_power_kbdABC, "^()");

        button4 = (Button) findViewById(R.id.button_jkl);
        button4.setOnClickListener(this);

        button5 = (Button) findViewById(R.id.button_mno);
        button5.setOnClickListener(this);

        button6 = (Button) findViewById(R.id.button_pqr);
        button6.setOnClickListener(this);

        buttonMinus = (Button) findViewById(R.id.button_minus_kbdABC);
        buttonMinus.setOnClickListener(this);
        keyValues.put(R.id.button_minus_kbdABC, "-");

        //Fourth Row:
        buttonABC = (Button) findViewById(R.id.button_ABC_kbdABC);
        buttonABC.setOnClickListener(this);

        buttonX = (Button) findViewById(R.id.button_x_kbdABC);
        buttonX.setOnClickListener(this);
        keyValues.put(R.id.button_x_kbdABC, "x");

        button1 = (Button) findViewById(R.id.button_stu);
        button1.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.button_vwx);
        button2.setOnClickListener(this);

        button3 = (Button) findViewById(R.id.button_yz);
        button3.setOnClickListener(this);

        buttonMult = (Button) findViewById(R.id.button_mult_kbdABC);
        buttonMult.setOnClickListener(this);
        keyValues.put(R.id.button_mult_kbdABC, "*");

        //Fifth Row:
        buttonValidate = (Button) findViewById(R.id.button_validate_kbdABC);
        buttonValidate .setOnClickListener(this);
        keyValues.put(R.id.button_validate_kbdABC, "Valider");

        /*button0 = (Button) findViewById(R.id.button_0_kbdABC);
        button0.setOnClickListener(this);
        keyValues.put(R.id.button_0_kbdABC, "0");*/

        buttonComma = (Button) findViewById(R.id.button_comma_kbdABC);
        buttonComma.setOnClickListener(this);
        keyValues.put(R.id.button_comma_kbdABC, ".");

        buttonEquals = (ImageButton) findViewById(R.id.button_space_kbdABC);
        buttonEquals.setOnClickListener(this);
        keyValues.put(R.id.button_space_kbdABC, " ");

        buttonDivide = (Button) findViewById(R.id.button_divide_kbdABC);
        buttonDivide.setOnClickListener(this);
        keyValues.put(R.id.button_divide_kbdABC, "/");
    }

    @Override
    public void onClick(View view)
    {
        if(inputConnection == null)
            return;

        if(view.getId() == R.id.button_delete_kbdABC)
        {
            inputConnection.finishComposingText();
            CharSequence selectedText = inputConnection.getSelectedText(0);

            if(TextUtils.isEmpty(selectedText))
            {
                inputConnection.deleteSurroundingText(1, 0);
            }

            else
            {
                inputConnection.commitText("", 1);
            }
        }

        else if(view.getId() == R.id.button_ABC_kbdABC)
        {
            inputConnection.finishComposingText();
            this.setVisibility(View.INVISIBLE);
            simpleMathKdb.setVisibility(View.VISIBLE);
        }

        else if(view.getId() == R.id.button_abc_kbdABC)
        {
            switchLetters("a", "b", "c", 1);
        }

        else if(view.getId() == R.id.button_def)
        {
            switchLetters("d", "e", "f", 2);
        }

        else if(view.getId() == R.id.button_ghi)
        {
            switchLetters("g", "h", "i",3);
        }

        else if(view.getId() == R.id.button_jkl)
        {
            switchLetters("j", "k", "l",4);
        }

        else if(view.getId() == R.id.button_mno)
        {
            switchLetters("m", "n", "o",5);
        }

        else if(view.getId() == R.id.button_pqr)
        {
            switchLetters("p", "q", "r",6);
        }

        else if(view.getId() == R.id.button_stu)
        {
            switchLetters("s", "t", "u",7);
        }

        else if(view.getId() == R.id.button_vwx)
        {
            switchLetters("v", "w", "x",8);
        }

        else if(view.getId() == R.id.button_yz)
        {
            String previousLetter = inputConnection.getTextBeforeCursor(1, 0).toString();

            if(switchId != 0)
            {
                inputConnection.finishComposingText();
                switchId = 0;
            }

            if(inputConnection.getTextBeforeCursor(1, 0).toString().equals("y")) {
                inputConnection.setComposingText("z", 1);
            }

            else {
                inputConnection.setComposingText("y", 1);
            }
        }

        else
        {
            inputConnection.finishComposingText();
            String value = keyValues.get(view.getId());
            inputConnection.commitText(value, 1);
        }
    }

    public void setInputConnection(InputConnection ic, MyKeyboard simpleMathKdb)
    {
        this.inputConnection = ic;
        this.simpleMathKdb = simpleMathKdb;
    }

    private void switchLetters(String letter1, String letter2, String letter3, int switcherId)
    {
        String previousLetter = inputConnection.getTextBeforeCursor(1, 0).toString();

        if(switcherId != switchId)
        {
            inputConnection.finishComposingText();
            switchId = switcherId;
        }

        if(previousLetter.equals(letter1)) {
            inputConnection.setComposingText(letter2, 1);
        }

        else if(previousLetter.equals(letter2)) {
            inputConnection.setComposingText(letter3, 1);
        }

        else {
            inputConnection.setComposingText(letter1, 1);
        }
    }
}
