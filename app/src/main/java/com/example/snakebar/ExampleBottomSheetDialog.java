package com.example.snakebar;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ExampleBottomSheetDialog extends BottomSheetDialogFragment {
    private BottomListener mListener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vi= inflater.inflate(R.layout.bottom_sheet_layout, container, false);
        Button button1= vi.findViewById(R.id.button);
        Button button2= vi.findViewById(R.id.button2);
        //send message interface
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked("Button 1 cliked");
                dismiss();
            }
        });
        // send use interface
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked("Button 2 cliked");
                dismiss();
            }
        });
        return vi;
    }
    public interface BottomListener{
        void onButtonClicked(String text);
        ;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (BottomListener) activity;
        }
        catch (ClassCastException e){
            throw  new ClassCastException(activity.toString()+"must implement ");
        }
    }
}
