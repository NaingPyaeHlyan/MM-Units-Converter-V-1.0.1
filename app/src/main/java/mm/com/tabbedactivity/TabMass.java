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

public class TabMass extends Fragment {


    Spinner spinnerMassInput,spinnerMassOutput;
    EditText etMassInput, etMassOutput;
    TextView tvMassInput, tvMassOutput, tvspinnerInput2, tvspinnerOutput2;
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

        spinnerMassInput =(Spinner)root.findViewById(R.id.spinnerInput);
        spinnerMassOutput = (Spinner)root.findViewById(R.id.spinnerOutput);

        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(getContext(),0,
                Arrays.asList(getResources().getStringArray(R.array.mass_array_MM)));


        spinnerMassInput.setAdapter(spinnerAdapter);
        spinnerMassOutput.setAdapter(spinnerAdapter);


        spinnerMassInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (etMassInput.getText().length() > 0){

                    tvspinnerInput2=(TextView) root.findViewById(R.id.textViewspinnerInput2);

                    String item = adapterView.getItemAtPosition(i).toString();
                    tvspinnerInput2.setText(item);
                    calculate();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerMassOutput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (etMassInput.getText().length() > 0){

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

        etMassInput = (EditText)root.findViewById(R.id.editTextInput);

        etMassInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0){
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

        etMassOutput = (EditText)root.findViewById(R.id.editTextOutput);
        tvMassInput = (TextView)root.findViewById(R.id.textViewInput);
        tvMassOutput=(TextView)root.findViewById(R.id.textViewOutput);


        etMassOutput.setText(calcLength.convert(Double.parseDouble(etMassInput.getText().toString()),spinnerMassInput.getSelectedItemPosition(),spinnerMassOutput.getSelectedItemPosition()));

        tvMassInput.setText(etMassInput.getText().toString());
        tvMassOutput.setText(etMassOutput.getText().toString());
    }
}
