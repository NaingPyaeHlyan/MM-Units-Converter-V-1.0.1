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

public class TabVolume extends Fragment {

    Spinner spinnerVolumeInput,spinnerVolumeOutput;
    EditText etVolumeInput, etVolumeOutput;
    TextView tvVolumeInput, tvVolumeOutput, tvspinnerInput2, tvspinnerOutput2;
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

    private void init(){
        spinnerVolumeInput = (Spinner)root.findViewById(R.id.spinnerInput);
        spinnerVolumeOutput = (Spinner)root.findViewById(R.id.spinnerOutput);

        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(getContext(),0,
                Arrays.asList(getResources().getStringArray(R.array.volume_array_MM)));


        spinnerVolumeInput.setAdapter(spinnerAdapter);
        spinnerVolumeOutput.setAdapter(spinnerAdapter);



        spinnerVolumeInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (etVolumeInput.getText().length() > 0){
                    tvspinnerInput2 = (TextView) root.findViewById(R.id.textViewspinnerInput2);

                    String item = adapterView.getItemAtPosition(i).toString();
                    tvspinnerInput2.setText(item);

                    calculate();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerVolumeOutput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (etVolumeInput.getText().length() > 0){
                    tvspinnerOutput2 = (TextView) root.findViewById(R.id.textViewspinnerOutput2);
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

        etVolumeInput = (EditText) root.findViewById(R.id.editTextInput);
        etVolumeInput.addTextChangedListener(new TextWatcher() {
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
//-----------------------------------Calculate from CalcVolume----------------------------------------

    private void calculate(){
        CalcVolume calcVolume = new CalcVolume();

        etVolumeOutput = (EditText) root.findViewById(R.id.editTextOutput);

        tvVolumeInput = (TextView) root.findViewById(R.id.textViewInput);
        tvVolumeOutput = (TextView) root.findViewById(R.id.textViewOutput);

        etVolumeOutput.setText(calcVolume.convert(Double.parseDouble(etVolumeInput.getText().toString()), spinnerVolumeInput.getSelectedItemPosition(), spinnerVolumeOutput.getSelectedItemPosition()));

        tvVolumeInput.setText(etVolumeInput.getText().toString());
        tvVolumeOutput.setText(etVolumeOutput.getText().toString());
    }
}
