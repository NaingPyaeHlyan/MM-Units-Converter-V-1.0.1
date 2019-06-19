package mm.com.tabbedactivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.Arrays;


public class TabLength extends Fragment {

    Spinner spinnerLengthInput,spinnerLengthOutput;
    EditText etLengthInput, etLengthOutput;
    TextView tvLengthInput, tvLengthOutput, tvspinnerInput2, tvspinnerOutput2;
    View root;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_main, container, false);

        init();

        return root;
    }

//--------------------------------------------------------------------------------------------------
//-------------------------Selected form Spinner ---------------------------------------------------

    private void init() {

        spinnerLengthInput =(Spinner)root.findViewById(R.id.spinnerInput);
        spinnerLengthOutput = (Spinner)root.findViewById(R.id.spinnerOutput);

/*
       ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getContext(),R.array.length_array_MM, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLengthInput.setAdapter(arrayAdapter);
       spinnerLengthOutput.setAdapter(arrayAdapter);*/

        //----------------------------- For Spinner Adapter ----------------------------

        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(getContext(),0,
                Arrays.asList(getResources().getStringArray(R.array.length_array_MM)));

        spinnerLengthInput.setAdapter(spinnerAdapter);
        spinnerLengthOutput.setAdapter(spinnerAdapter);
        //------------------------------------------------------------------------------

        spinnerLengthInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (etLengthInput.getText().length() > 0){
                    //TODO
                    tvspinnerInput2=(TextView) root.findViewById(R.id.textViewspinnerInput2);

                    String item = adapterView.getItemAtPosition(i).toString();
                    tvspinnerInput2.setText(item);

// ----------------------------- OR ------------------------------------------------------

//                    String i = spinnerLengthInput.getSelectedItem().toString();
//                    tvspinnerInput2.setText(i);
                    calculate();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerLengthOutput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (etLengthInput.getText().length() > 0){
                    //TODO
                    tvspinnerOutput2=(TextView)root.findViewById(R.id.textViewspinnerOutput2);
                    String item = adapterView.getItemAtPosition(i).toString();
                    tvspinnerOutput2.setText(item);

                    calculate();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//--------------------------------------------------------------------------------------------------
//-----------------------------------User Input Data(Number)----------------------------------------

        etLengthInput = (EditText)root.findViewById(R.id.editTextInput);

        etLengthInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0){
                    //TODO
                    calculate();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

//--------------------------------------------------------------------------------------------------

    private void calculate(){
        CalcLength calcLength = new CalcLength();

        etLengthOutput = (EditText)root.findViewById(R.id.editTextOutput);
        tvLengthInput = (TextView)root.findViewById(R.id.textViewInput);
        tvLengthOutput=(TextView)root.findViewById(R.id.textViewOutput);

        etLengthOutput.setText(calcLength.convert(Double.parseDouble(etLengthInput.getText().toString()),spinnerLengthInput.getSelectedItemPosition(),spinnerLengthOutput.getSelectedItemPosition()));

        tvLengthInput.setText(etLengthInput.getText().toString());
        tvLengthOutput.setText(etLengthOutput.getText().toString());
    }
}