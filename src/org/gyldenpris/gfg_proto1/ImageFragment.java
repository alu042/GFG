package org.gyldenpris.gfg_proto1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class ImageFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    		super.onCreate(savedInstanceState);
    		View v = (RelativeLayout) inflater.inflate(R.layout.image_layout, container, false);
    		return v;
    }
    
}