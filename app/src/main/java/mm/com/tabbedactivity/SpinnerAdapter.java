package mm.com.tabbedactivity;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<String> {

    Context context;

    public SpinnerAdapter(Context context, int resource, List<String> items) {
        super(context, android.R.layout.simple_spinner_dropdown_item, items);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = super.getView(position, convertView, parent);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "zawgyione.ttf");
        ((TextView) view).setTypeface(typeface);

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent){
        View view = super.getView(position, convertView, parent);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "zawgyione.ttf");
        ((TextView) view).setTypeface(typeface);

        return view;
    }

}
