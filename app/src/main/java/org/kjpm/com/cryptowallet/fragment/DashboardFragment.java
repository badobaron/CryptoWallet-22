package org.kjpm.com.cryptowallet.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;

import org.kjpm.com.cryptowallet.activity.QrScanner;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DashboardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText sendAddrs;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TabHost tabhost;

    private OnFragmentInteractionListener mListener;
    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(org.kjpm.com.cryptowallet.R.layout.fragment_dashboard, container, false);
        ImageView image = (ImageView) view.findViewById(org.kjpm.com.cryptowallet.R.id.imageView2);
        TextView myAddress = (TextView) view.findViewById(org.kjpm.com.cryptowallet.R.id.txtAddress);
        sendAddrs = (EditText) view.findViewById(org.kjpm.com.cryptowallet.R.id.sendAddress);
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Button btnScan = (Button) view.findViewById(org.kjpm.com.cryptowallet.R.id.scan);
        tabhost = (TabHost) view.findViewById(org.kjpm.com.cryptowallet.R.id.tabHost);
        tabhost.setup();

        TabHost.TabSpec spec = tabhost.newTabSpec("Receive");
        spec.setContent(org.kjpm.com.cryptowallet.R.id.tab1);
        spec.setIndicator("Receive");
        tabhost.addTab(spec);
        myAddress.setText("36Qz28SnRECqKmfaDSwwzhv4TfiY74Sc8R");
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode("36Qz28SnRECqKmfaDSwwzhv4TfiY74Sc8R", BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            image.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        //Tab 2
        spec = tabhost.newTabSpec("History");
        spec.setContent(org.kjpm.com.cryptowallet.R.id.tab2);
        spec.setIndicator("History");
        tabhost.addTab(spec);

        //Tab 3
        spec = tabhost.newTabSpec("Send");
        spec.setContent(org.kjpm.com.cryptowallet.R.id.tab3);
        spec.setIndicator("Send");
        tabhost.addTab(spec);

        btnScan.setOnClickListener(this);
// NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
// ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("");
        }
// Here we will can create click listners etc for all the gui elements on the fragment.
// For eg: Button btn1= (Button) view.findViewById(R.id.frag1_btn1);
// btn1.setOnclickListener(...
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String title) {
        if (mListener != null) {
            mListener.onFragmentInteraction(title);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
                Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
                Intent x = new Intent(getActivity(), QrScanner.class);
        startActivityForResult(x, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                sendAddrs.setText(data.getStringExtra("res"));
                Toast.makeText(getContext(), data.getStringExtra("res"), Toast.LENGTH_SHORT).show();
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.

                // Do something with the contact here (bigger example below)
            }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // NOTE : We changed the Uri to String.
        void onFragmentInteraction(String title);
    }
}
