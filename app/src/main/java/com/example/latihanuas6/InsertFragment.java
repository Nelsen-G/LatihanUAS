package com.example.latihanuas6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsertFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InsertFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InsertFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InsertFragment newInstance(String param1, String param2) {
        InsertFragment fragment = new InsertFragment();
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

    private EditText txtName, txtNim, txtEmail, txtHp;
    private Button btnSave;

    private DBHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert, container, false);

        txtName = view.findViewById(R.id.txtName);
        txtNim = view.findViewById(R.id.txtNim);
        txtEmail = view.findViewById(R.id.txtEmail);
        txtHp = view.findViewById(R.id.txtHp);
        btnSave = view.findViewById(R.id.btnSave);

        dbHelper = new DBHelper(requireContext());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString();
                int nim = Integer.parseInt(txtNim.getText().toString());
                String email = txtEmail.getText().toString();
                int hp = Integer.parseInt(txtHp.getText().toString());

                long result = dbHelper.insertData(name, nim, email, hp);

                if(result > 0){
                    Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show();
                    txtName.getText().clear();
                    txtNim.getText().clear();
                    txtEmail.getText().clear();
                    txtHp.getText().clear();

                }
            }
        });

        return view;
    }
}