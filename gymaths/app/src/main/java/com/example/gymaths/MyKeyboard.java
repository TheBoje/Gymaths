package com.example.gymaths;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyKeyboard extends LinearLayout implements View.OnClickListener
{
    private Button buttonDelete, buttonOpenParenthesis, buttonCloseParenthesis, button7, button8,
            button9, buttonPlus, buttonSqrt, buttonPower, button4, button5, button6, buttonMinus,
            buttonABC, buttonX, button1, button2, button3, buttonMult, buttonValidate, button0,
            buttonComma, buttonEquals, buttonDivide;

    private SparseArray<String> keyValues = new SparseArray<>();
    private InputConnection inputConnection;
    private MyKeyboard_abc alphaKdb;

    public MyKeyboard(Context context)
    {
        this(context, null, 0);
    }

    public MyKeyboard(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public MyKeyboard(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs)
    {
        LayoutInflater.from(context).inflate(R.layout.keyboard, this, true);
        //LayoutInflater.from(context).inflate(R.layout.keyboard_abc, this, true);

        //First Row:
        buttonDelete = (Button) findViewById(R.id.button_delete);
        buttonDelete.setOnClickListener(this);
        keyValues.put(R.id.button_delete, "Delete");

        //Second Row:
        buttonOpenParenthesis = (Button) findViewById(R.id.button_openParenthesis);
        buttonOpenParenthesis.setOnClickListener(this);
        keyValues.put(R.id.button_openParenthesis, "(");

        buttonCloseParenthesis = (Button) findViewById(R.id.button_closeParenthesis);
        buttonCloseParenthesis.setOnClickListener(this);
        keyValues.put(R.id.button_closeParenthesis, ")");

        button7 = (Button) findViewById(R.id.button_7);
        button7.setOnClickListener(this);
        keyValues.put(R.id.button_7, "7");

        button8 = (Button) findViewById(R.id.button_8);
        button8.setOnClickListener(this);
        keyValues.put(R.id.button_8, "8");

        button9 = (Button) findViewById(R.id.button_9);
        button9.setOnClickListener(this);
        keyValues.put(R.id.button_9, "9");

        buttonPlus = (Button) findViewById(R.id.button_plus);
        buttonPlus.setOnClickListener(this);
        keyValues.put(R.id.button_plus, "+");

        //Third Row:
        buttonSqrt = (Button) findViewById(R.id.button_sqrt);
        buttonSqrt.setOnClickListener(this);
        keyValues.put(R.id.button_sqrt, "√()");

        buttonPower = (Button) findViewById(R.id.button_power);
        buttonPower.setOnClickListener(this);
        keyValues.put(R.id.button_power, "^()");

        button4 = (Button) findViewById(R.id.button_4);
        button4.setOnClickListener(this);
        keyValues.put(R.id.button_4, "4");

        button5 = (Button) findViewById(R.id.button_5);
        button5.setOnClickListener(this);
        keyValues.put(R.id.button_5, "5");

        button6 = (Button) findViewById(R.id.button_6);
        button6.setOnClickListener(this);
        keyValues.put(R.id.button_6, "6");

        buttonMinus = (Button) findViewById(R.id.button_minus);
        buttonMinus.setOnClickListener(this);
        keyValues.put(R.id.button_minus, "-");

        //Fourth Row:
        buttonABC = (Button) findViewById(R.id.button_ABC);
        buttonABC.setOnClickListener(this);
        /*buttonABC.setOnClickListener(v -> {
            this.setVisibility(View.INVISIBLE);

            //View keyboard_abc = v.findViewById(R.id.keyboard_abc);
            //keyboard_abc.setVisibility(View.VISIBLE);
        });*/
        //keyValues.put(R.id.button_ABC, "ABC");

        buttonX = (Button) findViewById(R.id.button_x);
        buttonX.setOnClickListener(this);
        keyValues.put(R.id.button_x, "x");

        button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(this);
        keyValues.put(R.id.button_1, "1");

        button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(this);
        keyValues.put(R.id.button_2, "2");

        button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(this);
        keyValues.put(R.id.button_3, "3");

        buttonMult = (Button) findViewById(R.id.button_mult);
        buttonMult.setOnClickListener(this);
        keyValues.put(R.id.button_mult, "*");

        //Fifth Row:
        buttonValidate = (Button) findViewById(R.id.button_validate);
        buttonValidate .setOnClickListener(this);
        keyValues.put(R.id.button_validate, "Valider");

        button0 = (Button) findViewById(R.id.button_0);
        button0.setOnClickListener(this);
        keyValues.put(R.id.button_0, "0");

        buttonComma = (Button) findViewById(R.id.button_comma);
        buttonComma.setOnClickListener(this);
        keyValues.put(R.id.button_comma, ".");

        buttonEquals = (Button) findViewById(R.id.button_space);
        buttonEquals.setOnClickListener(this);
        keyValues.put(R.id.button_space, " ");

        buttonDivide = (Button) findViewById(R.id.button_divide);
        buttonDivide.setOnClickListener(this);
        keyValues.put(R.id.button_divide, "/");
    }

    @Override
    public void onClick(View view)
    {
        if(inputConnection == null)
            return;

        if(view.getId() == R.id.button_delete)
        {
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

        else if(view.getId() == R.id.button_ABC)
        {
            this.setVisibility(View.INVISIBLE);
            alphaKdb.setVisibility(View.VISIBLE);
        }

        else
        {
            String value = keyValues.get(view.getId());
            inputConnection.commitText(value, 1);
        }
    }

    public void setInputConnection(InputConnection ic, MyKeyboard_abc alphaKdb) {
        this.inputConnection = ic;
        this.alphaKdb = alphaKdb;
    }
}
